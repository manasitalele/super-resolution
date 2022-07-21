/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package enhancer;
import Jama.Matrix;
import de.lmu.ifi.dbs.jfeaturelib.Progress;
import de.lmu.ifi.dbs.jfeaturelib.features.AbstractFeatureDescriptor;
import de.lmu.ifi.dbs.utilities.Arrays2;
import ij.plugin.filter.PlugInFilter;
import ij.process.ByteProcessor;
import ij.process.ImageProcessor;
import java.util.Arrays;
import java.util.EnumSet;



public class Englcm extends AbstractFeatureDescriptor {

    /**
     * The number of gray values for the textures
     */
    private final int NUM_GRAY_VALUES = 32;
    /**
     * p_(x+y) statistics
     */
    private double[] p_x_plus_y = new double[2 * NUM_GRAY_VALUES - 1];
    /**
     * p_(x-y) statistics
     */
    private double[] p_x_minus_y = new double[NUM_GRAY_VALUES];
    /**
     * row mean value
     */
    private double mu_x = 0;
    /**
     * column mean value
     */
    private double mu_y = 0;
    /**
     * row variance
     */
    private double var_x = 0;
    /**
     * column variance
     */
    private double var_y = 0;
    /**
     * HXY1 statistics
     */
    private double hx = 0;
    /**
     * HXY2 statistics
     */
    private double hy = 0;
    /**
     * HXY1 statistics
     */
    private double hxy1 = 0;
    /**
     * HXY2 statistics
     */
    private double hxy2 = 0;
    /**
     * p_x statistics
     */
    private double[] p_x = new double[NUM_GRAY_VALUES];
    /**
     * p_y statistics
     */
    private double[] p_y = new double[NUM_GRAY_VALUES];
    // -
    private int glcmDist;
    double[] features = null;
    
    private double [] data = new double[4];
    private int size = data.length;

    public Englcm() {
        this.glcmDist = 1;
    }


    public Englcm(int glcmDist) {
        this.glcmDist = glcmDist;
    }

    /**
     * Defines the capability of the algorithm.
     *
     * @see PlugInFilter
     * @see #supports()
     */
    @Override
    public EnumSet<Supports> supports() {
        EnumSet set = EnumSet.of(
                Supports.NoChanges,
                Supports.DOES_8C,
                Supports.DOES_8G,
                Supports.DOES_RGB);
        return set;
    }

    /**
     * Starts the glcm detection.
     *
     * @param ip ImageProcessor of the source image
     */
    @Override
    public void run(ImageProcessor ip) {
        if (!ByteProcessor.class.isAssignableFrom(ip.getClass())) {
            ip = ip.convertToByte(true);            
        }
        firePropertyChange(Progress.START);
        process((ByteProcessor) ip);
        addData(features);
        firePropertyChange(Progress.END);
    }

    /**
     * Returns information about the getFeature
     */
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("features: \n");
        sb.append("0-> Angular 2nd moment, \n");
        sb.append("1-> Contrast, \n");
        sb.append("2-> Correlation, \n");
        sb.append("3-> variance, \n");
        sb.append("4-> Inverse Difference Moment, \n");
        sb.append("5-> Sum Average, \n");
        sb.append("6-> Sum Variance, \n");
        sb.append("7-> Sum Entropy, \n");
        sb.append("8-> Entropy, \n");
        sb.append("9-> Difference Variance, \n");
        sb.append("10-> Difference Entropy, \n");
        sb.append("11-> Information Measures of Correlation, \n");
        sb.append("12-> Information Measures of Correlation, \n");
        sb.append("13-> Maximum Correlation COefficient");
        return sb.toString();
    }

    private void process(ByteProcessor image) {        
        
            /*for(int i=0;i<image.getHeight();i++)
            {
                for(int j=0;j<image.getWidth();j++)
                {
                    pixel[i][j] = image.getPixel(i,j);
                }
            }
            imageh = image.getHeight();
            imagew = image.getWidth();
            /*for(int i=0;i<100;i++)
            {
                System.out.println(pixel[i]+"\n");
            }*/
            
        features = new double[14]; 

        firePropertyChange(new Progress(1, "creating coocurrence matrix"));
        Coocurrence coocurrence = new Coocurrence(image, NUM_GRAY_VALUES, this.glcmDist);
        double[][] cooccurrenceMatrix = coocurrence.getCooccurrenceMatrix();
                
        double meanGrayValue = coocurrence.getMeanGrayValue();

        firePropertyChange(new Progress(25, "normalizing"));
        normalize(cooccurrenceMatrix, coocurrence.getCooccurenceSums());
        

        firePropertyChange(new Progress(50, "computing statistics"));
        calculateStatistics(cooccurrenceMatrix);       
        
        
        firePropertyChange(new Progress(75, "computing features"));

        double[][] p = cooccurrenceMatrix;
        double[][] Q = new double[NUM_GRAY_VALUES][NUM_GRAY_VALUES];
        for (int i = 0; i < NUM_GRAY_VALUES; i++) {
             double sum_j_p_x_minus_y = 0;
             for (int j = 0; j < NUM_GRAY_VALUES; j++) {
                 double p_ij = p[i][j];
            
                 sum_j_p_x_minus_y += j * p_x_minus_y[j]; 
                 
                             
                 features[0] += p_ij * p_ij;                 
                 features[2] += i * j * p_ij - mu_x * mu_y;
                 features[3] += (i - meanGrayValue) * (i - meanGrayValue) * p_ij;
                 features[4] += p_ij / (1 + (i - j) * (i - j));
                 features[8] += p_ij * log(p_ij);

                 // feature 13
                 if (p_ij != 0 && p_x[i] != 0) { // would result in 0
                    for (int k = 0; k < NUM_GRAY_VALUES; k++) {
                         if (p_y[k] != 0 && p[j][k] != 0) { // would result in NaN
                             Q[i][j] += (p_ij * p[j][k]) / (p_x[i] * p_y[k]);
                         }
                    }
                }
            }

            features[1] += i * i * p_x_minus_y[i];
            features[9] += (i - sum_j_p_x_minus_y) * (i - sum_j_p_x_minus_y) * p_x_minus_y[i];
            features[10] += p_x_minus_y[i] * log(p_x_minus_y[i]);
        }


        // feature 13: Max Correlation Coefficient
        double[] realEigenvaluesOfQ = new Matrix(Q).eig().getRealEigenvalues();
        Arrays2.abs(realEigenvaluesOfQ);
        Arrays.sort(realEigenvaluesOfQ);
        features[13] = Math.sqrt(realEigenvaluesOfQ[realEigenvaluesOfQ.length - 2]);

        features[2] /= Math.sqrt(var_x * var_y);
        features[8] *= -1;
        features[10] *= -1;
        double maxhxhy = Math.max(hx, hy);
        if (Math.signum(maxhxhy) == 0) {
            features[11] = 0;
        } else {
            features[11] = (features[8] - hxy1) / maxhxhy;
        }
        features[12] = Math.sqrt(1 - Math.exp(-2 * (hxy2 - features[8])));

        for (int i = 0; i < 2 * NUM_GRAY_VALUES - 1; i++) {
            features[5] += i * p_x_plus_y[i];
            features[7] += p_x_plus_y[i] * log(p_x_plus_y[i]);

            double sum_j_p_x_plus_y = 0;
            for (int j = 0; j < 2 * NUM_GRAY_VALUES - 1; j++) {
                sum_j_p_x_plus_y += j * p_x_plus_y[j];
            }
            features[6] += (i - sum_j_p_x_plus_y) * (i - sum_j_p_x_plus_y) * p_x_plus_y[i];
        }

        features[7] *= -1;
        
        
        /*data[0]=features[0];
        data[1]=features[1];
        data[2]=features[2];
        data[3]=features[3];
        data[4]=features[4];
        data[5]=features[8];*/

    }

    /**
     * Calculates the statistical properties.
     */
    private void calculateStatistics(double[][] cooccurrenceMatrix) {
        // p_x, p_y, p_x+y, p_x-y
        for (int i = 0; i < NUM_GRAY_VALUES; i++) {
            for (int j = 0; j < NUM_GRAY_VALUES; j++) {
                double p_ij = cooccurrenceMatrix[i][j];

                p_x[i] += p_ij;
                p_y[j] += p_ij;

                p_x_plus_y[i + j] += p_ij;
                p_x_minus_y[Math.abs(i - j)] += p_ij;
            }
        }

        // mean and variance values
        double[] meanVar;
        meanVar = meanVar(p_x);
        mu_x = meanVar[0];
        var_x = meanVar[1];
        meanVar = meanVar(p_y);
        mu_y = meanVar[0];
        var_y = meanVar[1];

        for (int i = 0; i < NUM_GRAY_VALUES; i++) {
            // hx and hy
            hx += p_x[i] * log(p_x[i]);
            hy += p_y[i] * log(p_y[i]);

            // hxy1 and hxy2
            for (int j = 0; j < NUM_GRAY_VALUES; j++) {
                double p_ij = cooccurrenceMatrix[i][j];
                hxy1 += p_ij * log(p_x[i] * p_y[j]);
                hxy2 += p_x[i] * p_y[j] * log(p_x[i] * p_y[j]);
            }
        }
        hx *= -1;
        hy *= -1;
        hxy1 *= -1;
        hxy2 *= -1;
    }

    /**
     * Compute mean and variance of the given array
     *
     * @param a input values
     * @return array{mean, variance}
     */
    private double[] meanVar(double[] a) {
        // VAR(X) = E(X^2) - E(X)^2
        double ex = 0, ex2 = 0; // E(X), E(X^2)
        for (int i = 0; i < NUM_GRAY_VALUES; i++) {
            ex += a[i];
            ex2 += a[i] * a[i];
        }
        ex /= a.length;
        ex2 /= a.length;
        double var = ex2 - ex * ex;

        return new double[]{ex, var};
    }

    /**
     * Returns the logarithm of the specified value.
     *
     * @param value the value for which the logarithm should be returned
     * @return the logarithm of the specified value
     */
    private double log(double value) {
        double log = Math.log(value);
        if (log == Double.NEGATIVE_INFINITY) {
            log = 0;
        }
        return log;
    }

    private void normalize(double[][] A, double sum) {
        for (int i = 0; i < A.length; i++) {
            Arrays2.div(A[i], sum);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="getter/Setter">
    /**
     * Getter for glcm distributions
     *
     * @return glcm distributions
     */
    public int getHaralickDist() {
        return glcmDist;
    }

    /**
     * Setter for glcm distributions
     *
     * @param glcmDist int for glcm distributions
     */
    public void setHaralickDist(int glcmDist) {
        this.glcmDist = glcmDist;
    }
    //</editor-fold>
    
    
        
    public double getMean()
    {
        data[0]=features[1];
        data[1]=features[2];
        data[2]=features[3];
        data[3]=features[8];
    
        double sum = 0.0;
        for(double a : data)
            sum += a;
        return sum/size;
    }

    public double getVariance()
    {
        double mean = getMean();
        double temp = 0;
        for(double a :data)
            temp += (a-mean)*(a-mean);
        return temp/size;
    }

    public double getStdDev()
    {
        return Math.sqrt(getVariance());
    }
}
/**
 * http://makseq.com/materials/lib/Articles-Books/Filters/Texture/Co-occurence/glcm73.pdf
 */
class Coocurrence {

    /**
     * The number of gray values for the textures
     */
    private final int NUM_GRAY_VALUES;
    /**
     * The number of gray levels in an image
     */
    private final int GRAY_RANGES = 256;
    /**
     * The scale for the gray values for conversion rgb to gray values.
     */
    private final double GRAY_SCALE;
    /**
     * gray histogram of the image.
     */
    private final double[] grayHistogram;
    /**
     * quantized gray values of each pixel of the image.
     */
    private final byte[] grayValue;
    /**
     * mean gray value
     */
    private double meanGrayValue = 0;
    /**
     * The cooccurrence matrix
     */
    private final double[][] cooccurrenceMatrices;
    /**
     * The value for one increment in the gray/color histograms.
     */
    private final int GLCM_DIST;
    private final ByteProcessor image;

    public Coocurrence(ByteProcessor b, int numGrayValues, int glcmDist) {
        this.NUM_GRAY_VALUES = numGrayValues;
        this.image = b;
        this.GRAY_SCALE = (double) GRAY_RANGES / (double) NUM_GRAY_VALUES;
        this.cooccurrenceMatrices = new double[NUM_GRAY_VALUES][NUM_GRAY_VALUES];
        this.grayValue = new byte[image.getPixelCount()];
        this.grayHistogram = new double[GRAY_RANGES];
        this.GLCM_DIST = glcmDist;
        calculate();
    }

    public double getMeanGrayValue() {
        return this.meanGrayValue;
    }

    public double[][] getCooccurrenceMatrix() {
        return this.cooccurrenceMatrices;
    }

    public double getCooccurenceSums() {
        return image.getPixelCount() * 8;
    }

    private void calculate() {
        calculateGreyValues();

        final int imageWidth = image.getWidth();
        final int imageHeight = image.getHeight();
        final int d = GLCM_DIST;
        int i, j, pos;

        // image is not empty per default
        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {
                pos = imageWidth * y + x;

                // horizontal neighbor: 0 degrees
                i = x - d;
//                j = y;
                if (!(i < 0)) {
                    increment(grayValue[pos], grayValue[pos - d]);
                }

                // vertical neighbor: 90 degree
//                i = x;
                j = y - d;
                if (!(j < 0)) {
                    increment(grayValue[pos], grayValue[pos - d * imageWidth]);
                }

                // 45 degree diagonal neigbor
                i = x + d;
                j = y - d;
                if (i < imageWidth && !(j < 0)) {
                    increment(grayValue[pos], grayValue[pos + d - d * imageWidth]);
                }

                // 135 vertical neighbor
                i = x - d;
                j = y - d;
                if (!(i < 0) && !(j < 0)) {
                    increment(grayValue[pos], grayValue[pos - d - d * imageWidth]);
                }
            }
        }
        meanGrayValue = Arrays2.sum(grayValue);
    }

    private void calculateGreyValues() {
        int size = image.getPixelCount();
        int gray;
        for (int pos = 0; pos < size; pos++) {
            gray = image.get(pos);
            grayValue[pos] = (byte) (gray / GRAY_SCALE);  // quantized for texture analysis
            grayHistogram[gray]++;
        }
        Arrays2.div(grayHistogram, size);
    }

    /**
     * Incremets the coocurrence matrix at the specified positions (g1,g2) and
     * (g2,g1).
     *
     * @param g1 the gray value of the first pixel
     * @param g2 the gray value of the second pixel
     */
    private void increment(int g1, int g2) {
        cooccurrenceMatrices[g1][g2]++;
        cooccurrenceMatrices[g2][g1]++;
    }
    
    
}


package enhancer;

import ij.process.ColorProcessor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//Weka Packages Necessary for Connectivity
import javax.swing.table.DefaultTableModel;

import weka.core.Instances;

public class Enpositive extends javax.swing.JFrame {
    //MatlabProxy proxy;

    JFileChooser fc;
    String dcode, dpath, directory, filename;
    File[] listOfFiles;
    File file;
    double f, f1, f2, f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f00;
   //String f3;
    DefaultTableModel model;

    /**
     * Creates new form Enpositive
     */
    public Enpositive() {
        initComponents();
        this.setSize(1200, 620);
        this.setTitle("IMAGE ENHANCER");
        Dimension sd = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(sd.width / 2 - this.getWidth() / 2, sd.height / 2 - this.getHeight() / 2);
        model = new DefaultTableModel();
        model.addColumn("Name");
        //model.addColumn("Angular 2nd moment");
        model.addColumn("Contrast");
        model.addColumn("Correlation");
        model.addColumn("variance");
        //model.addColumn("Inverse Difference Moment, ");
        /*model.addColumn("Sum Average");
        model.addColumn("Sum Variance");

        model.addColumn("Sum Entropy");*/

        model.addColumn("Entropy");

        /*model.addColumn("Difference Variance");

        model.addColumn("Difference Entropy");

        model.addColumn("Information Measures of Correlation1");
        model.addColumn("Information Measures of Correlation2");
        model.addColumn("Maximum Correlation COefficient");*/
        table.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bfile = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tpath = new javax.swing.JTextField();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        bstart = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLayeredPane2.setBackground(new java.awt.Color(255, 0, 0));
        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        table.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(table);

        jLayeredPane2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 1090, 280);

        bfile.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        bfile.setText("Get Image Folder For LR Images");
        bfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfileActionPerformed(evt);
            }
        });
        jLayeredPane2.add(bfile);
        bfile.setBounds(480, 20, 510, 31);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Folder Name :-");
        jLayeredPane2.add(jLabel10);
        jLabel10.setBounds(20, 20, 180, 30);

        tpath.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLayeredPane2.add(tpath);
        tpath.setBounds(210, 20, 260, 30);

        getContentPane().add(jLayeredPane2);
        jLayeredPane2.setBounds(10, 70, 1140, 380);

        jLayeredPane3.setBackground(new java.awt.Color(255, 0, 0));
        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bstart.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        bstart.setText("GENERATE A POSITIVE DATASET");
        bstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bstartActionPerformed(evt);
            }
        });
        jLayeredPane3.add(bstart);
        bstart.setBounds(430, 20, 270, 30);

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jLayeredPane3.add(Back);
        Back.setBounds(30, 20, 90, 23);

        getContentPane().add(jLayeredPane3);
        jLayeredPane3.setBounds(10, 470, 1140, 70);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 2, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("POSITIVE DATASET");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 20, 1140, 40);

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/photo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1180, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bstartActionPerformed

        long starttime = System.currentTimeMillis();
        long start = TimeUnit.MILLISECONDS.toSeconds(starttime);
       
        getOriginalFeatures();    //1
        getSubsetFeatures();      //2
        
        long stoptime = System.currentTimeMillis();
        long stop = TimeUnit.MILLISECONDS.toSeconds(stoptime);
            
        long TotalTimelong = stop-start;


        JOptionPane.showMessageDialog(new Enpreprocess(), "ENHANCER POSITIVE DATASET GENERATED" + "\nTime Taken: " + TotalTimelong + " seconds");
    }//GEN-LAST:event_bstartActionPerformed

    public void getOriginalFeatures()
    {
        double div = 10000000000000.0;
        try {
            File file = new File("C:/Users/Masoom/Desktop/pratham/files/featuresLR.arff");
            String Instance = "";
            
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw;
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("@relation Preprocess_Analysis");
            bw.newLine();
            bw.newLine();
            
            //bw.write("@ATTRIBUTE name STRING");
            //bw.newLine();
            //bw.write("@ATTRIBUTE energy REAL");
            //bw.newLine();
            bw.write("@ATTRIBUTE contrast REAL");
            bw.newLine();
            bw.write("@ATTRIBUTE correlation REAL");
            bw.newLine(); 
            bw.write("@ATTRIBUTE variance REAL");
            bw.newLine();
            //bw.write("@ATTRIBUTE homogeneity REAL");
            //bw.newLine();
            bw.write("@ATTRIBUTE entropy REAL");
            bw.newLine();
            bw.write("@ATTRIBUTE stdev REAL");
            bw.newLine();
            //bw.write("@ATTRIBUTE class {Positive, Negative}");
            //bw.newLine();
            bw.newLine();

            bw.write("@DATA");
            bw.newLine();
            
            //Englcm gl = new Englcm();
            //ActiveSampling as = new ActiveSamplingHR();
            
            int c=0;
            double[] temparray = new double[listOfFiles.length];
            
            for (File file1 : listOfFiles) {
                if (file1.isFile()) {

                    try {
                        System.out.println(file1.getName());
                        //proxy.eval("rgbImage = imread('" + tpath.getText() + "\\" + file1.getName() + "');");

                        BufferedImage image;
                        File input = new File(tpath.getText() + "\\" + file1.getName());
                        image = ImageIO.read(input);

                        ColorProcessor img = new ColorProcessor(image);
                        Englcm gl = new Englcm();
                        gl.run(img);
                        
                        DecimalFormat df = new DecimalFormat("##.0000");
                        //Instance = Instance + df.format(f) + ",";
                        
                        f00=gl.getStdDev();
                        f00=(f00/div);            
                        
                        f1=gl.features[1];
                        Instance = Instance + df.format(f1) + ",";
                        
                        f2=gl.features[2];
                        DecimalFormat df2 = new DecimalFormat("##.0000");
                        Instance = Instance + df2.format(f2) + ",";
                        
                        f3=gl.features[3];
                        DecimalFormat df3 = new DecimalFormat("##.0000");
                        Instance = Instance + df3.format(f3) + ",";
                        
                        //f4=gl.features[4];
                        //Instance = Instance + df.format(f4) + ",";
                        
                        /*f5=gl.features[5];
                        Instance = Instance + df.format(f5) + ",";
                        
                        f6=gl.features[6];
                        Instance = Instance + df.format(f6) + ",";
                        
                        f7=gl.features[7];
                        Instance = Instance + df.format(f7) + ",";*/
                        
                        f8=gl.features[8];
                        Instance = Instance + df.format(f8) + ",";
                        
                        /*f9=gl.features[9];
                        Instance = Instance + df.format(f9) + ",";
                        
                        f10=gl.features[10];
                        Instance = Instance + df.format(f10) + ",";
                        
                        f11=gl.features[11];
                        Instance = Instance + df.format(f11) + ",";
                        
                        f12=gl.features[12];
                        Instance = Instance + df.format(f12) + ",";*/
                        
                        //f00=gl.getStdDev();
                        Instance = Instance + df.format(f00);
                                            
                        //Instance = Instance + "Negative";
                        String[] request = {file1.getName(), /*df.format(f) , */df.format(f1), df2.format(f2),df3.format(f3),/*df.format(f4), df.format(f5),df.format(f6),df.format(f7),*/df.format(f8)/*,df.format(f9),df.format(f10),df.format(f11),df.format(f12)*/,df.format(f00)};

                        model.addRow(request);
                        bw.write(Instance);
                        bw.newLine();
                        Instance = "";
                        
                        //bw2.write(df.format(f00));
                        //bw2.newLine();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Enfeatures.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
            
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ennegative.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getSubsetFeatures()
    {
        double div = 10000000000000.0;
        try {
            File file = new File("C:/Users/Masoom/Desktop/pratham/files/subsetfeaturesLR.arff");
            String Instance = "";
            
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw;
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("@relation Preprocess_Analysis");
            bw.newLine();
            bw.newLine();
            
            //bw.write("@ATTRIBUTE name STRING");
            //bw.newLine();
            //bw.write("@ATTRIBUTE energy REAL");
            //bw.newLine();
            bw.write("@ATTRIBUTE contrast REAL");
            bw.newLine();
            bw.write("@ATTRIBUTE correlation REAL");
            bw.newLine(); 
            bw.write("@ATTRIBUTE variance REAL");
            bw.newLine();
            //bw.write("@ATTRIBUTE homogeneity REAL");
            //bw.newLine();
            bw.write("@ATTRIBUTE entropy REAL");
            bw.newLine();
            bw.write("@ATTRIBUTE stdev REAL");
            bw.newLine();
            //bw.write("@ATTRIBUTE class {Positive, Negative}");
            //bw.newLine();
            bw.newLine();

            bw.write("@DATA");
            bw.newLine();
            
            //Englcm gl = new Englcm();
            ActiveSamplingHR as = new ActiveSamplingHR();
            
            double[] range = new double[2];
            range = as.stats();
            DecimalFormat df = new DecimalFormat("##.0000");
            System.out.println(range[0]+" "+range[1]);
            
            for (File file1 : listOfFiles) {
                if (file1.isFile()) {

                    try {
                        System.out.println(file1.getName());
                        //proxy.eval("rgbImage = imread('" + tpath.getText() + "\\" + file1.getName() + "');");

                        BufferedImage image;
                        File input = new File(tpath.getText() + "\\" + file1.getName());
                        image = ImageIO.read(input);

                        ColorProcessor img = new ColorProcessor(image);
                        Englcm gl = new Englcm();
                        gl.run(img);
                        
                        //DecimalFormat df = new DecimalFormat("###0.0000");
                        //Instance = Instance + df.format(f) + ",";
                        
                        f00=gl.getStdDev();
                        f00=(f00/div);
                        //System.out.println(f00);
                        
                        //System.out.println(range[0]+" "+range[1]);                  
                        if(f00>Math.floor(range[0]) && f00<Math.ceil(range[1]))
                        {
                            f1=gl.features[1];
                            Instance = Instance + df.format(f1) + ",";

                            f2=gl.features[2];
                            DecimalFormat df2 = new DecimalFormat("##.0000");
                            Instance = Instance + df2.format(f2) + ",";

                            f3=gl.features[3];
                            DecimalFormat df3 = new DecimalFormat("##.0000");
                            Instance = Instance + df3.format(f3) + ",";

                            //f4=gl.features[4];
                            //Instance = Instance + df.format(f4) + ",";

                            /*f5=gl.features[5];
                            Instance = Instance + df.format(f5) + ",";

                            f6=gl.features[6];
                            Instance = Instance + df.format(f6) + ",";

                            f7=gl.features[7];
                            Instance = Instance + df.format(f7) + ",";*/

                            f8=gl.features[8];
                            Instance = Instance + df.format(f8) + ",";

                            /*f9=gl.features[9];
                            Instance = Instance + df.format(f9) + ",";

                            f10=gl.features[10];
                            Instance = Instance + df.format(f10) + ",";

                            f11=gl.features[11];
                            Instance = Instance + df.format(f11) + ",";

                            f12=gl.features[12];
                            Instance = Instance + df.format(f12) + ",";*/

                            //f00=gl.getStdDev();
                            Instance = Instance + df.format(f00);

                            //Instance = Instance + "Negative";
                            String[] request = {file1.getName(), /*df.format(f) , */df.format(f1), df2.format(f2),df3.format(f3),/*df.format(f4), df.format(f5),df.format(f6),df.format(f7),*/df.format(f8)/*,df.format(f9),df.format(f10),df.format(f11),df.format(f12)*/,df.format(f00)};

                            model.addRow(request);
                            bw.write(Instance);
                            bw.newLine();
                            Instance = "";

                            //bw2.write(df.format(f00));
                            //bw2.newLine();
                        }
                        else
                        {                          
                            System.out.println("Fails");
                            //break;
                        }                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Enfeatures.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
            
            bw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Ennegative.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private void bfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfileActionPerformed
        // TODO add your handling code here:
        fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(Enpositive.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getCurrentDirectory();
            tpath.setText(file.getPath());

            File folder = new File(tpath.getText());
            listOfFiles = folder.listFiles();

            for (File file1 : listOfFiles) {
                if (file1.isFile()) {
                    //System.out.println(file1.getName());
                }
            }

        }
    }//GEN-LAST:event_bfileActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Enpositive().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton bfile;
    private javax.swing.JButton bstart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tpath;
    // End of variables declaration//GEN-END:variables

}

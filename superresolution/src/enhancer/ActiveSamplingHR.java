package enhancer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ActiveSamplingHR {
    
    public static Scanner scan=null;    
    public double[] stdevarray={0};
    private String[] val=null;
    private int missed=0; 
    //public double range_lower, range_upper;
    public double[] range = new double[2];
    
    public double[] stats()
    {
        double div = 10000000000000.0;
        DecimalFormat df = new DecimalFormat("###0.0000");
        try {
            
            double[] arr = active();
            
            double sum = 0.0;
            for(double a : arr)
                sum += a;
            double mean =  (sum/arr.length);           
            //System.out.println(df.format(mean)+"\n");
            
            double temp = 0;
            for(double a : arr)
            {
                temp += (a-mean)*(a-mean);
            }
            double var = temp/arr.length;
            //System.out.println(df.format(var)+"\n");
            
            double sd = Math.sqrt(var);
            //System.out.println(df.format(sd)+"\n");
            
            
            //double range_lower=(mean-sd-(sd/2)); //86% area
            //double range_upper=(mean+sd+(sd/2));
            
            //range[0]=range_lower;
            //range[1]=range_upper;
            
            //double range_lower=((mean-sd)/div); //70% area
            //double range_upper=((mean+sd)/div);
            
            double range_lower=(mean-sd); //70% area
            double range_upper=(mean+sd);
            
            range[0]=range_lower;
            range[1]=range_upper;
            
            
            //System.out.println(df.format(range_lower) + " "+ df.format(range_upper));
            
        } catch (IOException ex) {
            Logger.getLogger(ActiveSamplingHR.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (range);
    }
    
    public double[] active() throws IOException
    {
        try 
        {            
            Pattern p = Pattern.compile("^(\\d+)(.*)");
            
            File file = new File("C:/Users/Masoom/Desktop/pratham/files/featuresHR.arff");
            scan = new Scanner(file);
            
            DecimalFormat df = new DecimalFormat("##.0000");            
            
            int no_of_entries = 0;
            
            while(scan.hasNextLine())
            { 
                String line = scan.nextLine();
                Matcher m = p.matcher(line);
                if (!m.find())
                {
                    missed++;
                }
                else
                {
                    no_of_entries++;
                }                
            }
            scan.close();
            
            stdevarray = new double[no_of_entries];
               
            scan = new Scanner(file);
            int i=0;           
            while(scan.hasNextLine())
            {
                String line = scan.nextLine();
                //System.out.println(line+"\n");
                Matcher m = p.matcher(line);
                if (m.find())
                {
                    String temp = m.group();
                    val = temp.split(",");
                    stdevarray[i] = Double.parseDouble(val[4]);                    
                    i++;
                }                             
            }
           
            //for(int j=0;j<(no_of_entries);j++)
            //  System.out.println(df.format(stdevarray[j]));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ActiveSamplingHR.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (stdevarray);
    }   
    
    
    public static void main(String[] args) throws IOException{
        
        ActiveSamplingHR AS = new ActiveSamplingHR();
        AS.stats();
    }
}

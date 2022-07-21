package enhancer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Stats {
    
    public static void main(String[] args){
            BufferedReader br = null;
            
            double c1 = 0,c2=0 ,c3=0 ,c4=0 ,c5=0 ,c6=0 ,c7=0 ,c8=0 ,c9=0 ,c10=0 ,c11=0 ,c12=0 ,c13=0;
            
        try {
            br = new BufferedReader(new FileReader("C:/Users/Public/Desktop/HRstdev.txt"));
            String currentline;
            
                    
            while((currentline = br.readLine()) != null)
            {
                //System.out.println(currentline);
                double edit = Double.parseDouble(currentline);
                //System.out.println(edit);
                edit = edit/1000000000000.0;
                //System.out.println(edit);
                
                //DecimalFormat df = new DecimalFormat("#.0000000000000000");
                
                if(edit>=0.0 && edit<=4.0)
                {
                    c1++;
                }
                else if(edit>4.0 && edit<=8.0)
                {
                    c2++;
                }
                else if(edit>8.0 && edit<=12.0)
                {
                    c3++;
                }
                else if(edit>12.0 && edit<=16.0)
                {
                    c4++;
                }
                else if(edit>16.0 && edit<=20.0)
                {
                    c5++;
                }
                else if(edit>20.0 && edit<=24.0)
                {
                    c6++;
                }
                else if(edit>24.0 && edit<=28.0)
                {
                    c7++;
                }
                else if(edit>28.0 && edit<=32.0) 
                {
                    c8++;
                }
                else if(edit>32.0 && edit<=36.0)
                {
                    c9++;
                }
                else if(edit>36.0 && edit<=40.0)
                {
                    c10++;
                }
                else if(edit>40.0 && edit<=44.0)
                {
                    c11++;
                }
                else if(edit>44.0 && edit<=48.0)
                {
                    c12++;
                }
                else
                {
                    c13++;
                }                
            }
            
            System.out.println(c1+"\n"+c2+"\n"+c3+"\n"+c4+"\n"+c5+"\n"+c6+
                        "\n"+c7+"\n"+c8+"\n"+c9+"\n"+c10+
                    "\n"+c11+"\n"+c12+"\n"+c13+"\n");
            
            
            System.out.println((c1/510)+"\n"+(c2/510)+"\n"+(c3/510)+"\n"+(c4/510)+"\n"+(c5/510)+"\n"+(c6/510)+
                        "\n"+(c7/510)+"\n"+(c8/510)+"\n"+(c9/510)+"\n"+(c10/510)+
                    "\n"+(c11/510)+"\n"+(c12/510)+"\n"+(c13/510)+"\n");
            
            //System.out.println(count1);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    
}

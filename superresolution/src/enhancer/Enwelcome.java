
package enhancer;

import java.awt.Dimension;
import java.awt.Toolkit;


public class Enwelcome extends javax.swing.JFrame {

    
    public Enwelcome() {
        initComponents();
        this.setSize(840, 420);
        this.setTitle("IMAGE ENHANCER");
        Dimension sd = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(sd.width / 2 - this.getWidth() / 2, sd.height / 2 - this.getHeight() / 2);
        progress ps = new progress();
        ps.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        pb = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("IMAGE ENHANCER");
        jLayeredPane1.add(jLabel2);
        jLabel2.setBounds(0, 20, 810, 40);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 102));
        jLabel3.setText("Project Developed By :-");
        jLayeredPane1.add(jLabel3);
        jLabel3.setBounds(10, 60, 220, 40);

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 102));
        jLabel5.setText("1> Masoom Jain");
        jLayeredPane1.add(jLabel5);
        jLabel5.setBounds(240, 60, 230, 40);

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 102));
        jLabel4.setText("2> Prathamesh Mahajan");
        jLayeredPane1.add(jLabel4);
        jLabel4.setBounds(240, 100, 260, 40);

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 102));
        jLabel6.setText("4> Manasi Talele");
        jLayeredPane1.add(jLabel6);
        jLabel6.setBounds(240, 180, 230, 40);

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 102));
        jLabel7.setText("3> Ananya Nandi");
        jLayeredPane1.add(jLabel7);
        jLabel7.setBounds(240, 140, 230, 40);

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(20, 20, 810, 300);

        jLayeredPane2.setBackground(new java.awt.Color(255, 0, 0));
        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        pb.setForeground(new java.awt.Color(255, 0, 255));
        pb.setBorder(new javax.swing.border.MatteBorder(null));
        jLayeredPane2.add(pb);
        pb.setBounds(20, 10, 760, 16);

        getContentPane().add(jLayeredPane2);
        jLayeredPane2.setBounds(20, 330, 810, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/im10.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 840, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Enwelcome().setVisible(true);
            }
        });
    }

     class progress extends Thread {

        int i = 0;


        public void run() {
            for (int j = 0; j <= 10; j++) {
                System.out.println("" + i);
                if (i < 100) {
                    i = i + 10;
                    pb.setValue(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                       System.out.println("Contact the developers of this project");
                    }
                } else {
                    Enmenu autehnticate = new Enmenu();
                    autehnticate.setVisible(true);
                    setVisible(false);
                }
            }
        }
    }

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JProgressBar pb;
    // End of variables declaration//GEN-END:variables
}

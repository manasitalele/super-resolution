
package enhancer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Enmenu extends javax.swing.JFrame {

    public Enmenu() {
        initComponents();
        this.setSize(1042, 768);
        this.setTitle("IMAGE ENHANCER");
        Dimension sd = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(sd.width / 2 - this.getWidth() / 2, sd.height / 2 - this.getHeight() / 2);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        m1 = new javax.swing.JMenuItem();
        m5 = new javax.swing.JMenuItem();
        m4 = new javax.swing.JMenuItem();
        m6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        m2 = new javax.swing.JMenuItem();
        m3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        m9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pccp1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1410, 960);

        jMenu1.setText("PREPROCESS");
        jMenu1.setFont(new java.awt.Font("Courier New", 3, 18)); // NOI18N

        m1.setBackground(new java.awt.Color(0, 0, 0));
        m1.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        m1.setForeground(new java.awt.Color(204, 204, 204));
        m1.setText("PREPROCESS IMAGES");
        m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m1ActionPerformed(evt);
            }
        });
        jMenu1.add(m1);

        m5.setBackground(new java.awt.Color(0, 0, 0));
        m5.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        m5.setForeground(new java.awt.Color(204, 204, 204));
        m5.setText("FEATURE EXTRACTION");
        m5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m5ActionPerformed(evt);
            }
        });
        jMenu1.add(m5);

        m4.setBackground(new java.awt.Color(0, 0, 0));
        m4.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        m4.setForeground(new java.awt.Color(204, 204, 204));
        m4.setText("GENERATE DATASET");
        m4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m4ActionPerformed(evt);
            }
        });
        jMenu1.add(m4);

        m6.setBackground(new java.awt.Color(0, 0, 0));
        m6.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        m6.setForeground(new java.awt.Color(204, 204, 204));
        m6.setText("PERFORM GAUSSIAN PROCESS");
        m6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m6ActionPerformed(evt);
            }
        });
        jMenu1.add(m6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("CREDITS");
        jMenu2.setFont(new java.awt.Font("Courier New", 3, 18)); // NOI18N

        m2.setBackground(new java.awt.Color(0, 0, 0));
        m2.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        m2.setForeground(new java.awt.Color(204, 204, 204));
        m2.setText("ABOUT US");
        m2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2ActionPerformed(evt);
            }
        });
        jMenu2.add(m2);

        m3.setBackground(new java.awt.Color(0, 0, 0));
        m3.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        m3.setForeground(new java.awt.Color(204, 204, 204));
        m3.setText("HELP ");
        m3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m3ActionPerformed(evt);
            }
        });
        jMenu2.add(m3);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("EXIT");
        jMenu5.setFont(new java.awt.Font("Courier New", 3, 18)); // NOI18N

        m9.setBackground(new java.awt.Color(0, 0, 0));
        m9.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        m9.setForeground(new java.awt.Color(204, 204, 204));
        m9.setText("END PROJECT");
        m9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m9ActionPerformed(evt);
            }
        });
        jMenu5.add(m9);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m1ActionPerformed
        Enpreprocess pre=new Enpreprocess();
        pre.setVisible(true);
}//GEN-LAST:event_m1ActionPerformed

    private void m5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m5ActionPerformed
        // TODO add your handling code here:
        Enfeatures fe=new Enfeatures();
        fe.setVisible(true);
}//GEN-LAST:event_m5ActionPerformed

    private void m2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2ActionPerformed
        // TODO add your handling code here:
        Endevelopers credits=new Endevelopers();
        credits.setVisible(true);
}//GEN-LAST:event_m2ActionPerformed

    private void m3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m3ActionPerformed
        // TODO add your handling code here:
        Enhelp help=new Enhelp();
        help.setVisible(true);
}//GEN-LAST:event_m3ActionPerformed

    private void m9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m9ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
}//GEN-LAST:event_m9ActionPerformed

    private void m4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m4ActionPerformed
        // TODO add your handling code here:
        Enpositive pos=new Enpositive();
        pos.setVisible(true);
    }//GEN-LAST:event_m4ActionPerformed

    private void m6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m6ActionPerformed
        // TODO add your handling code here:
        Ennegative neg=new Ennegative();
        neg.setVisible(true);
    }//GEN-LAST:event_m6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Enmenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem m1;
    private javax.swing.JMenuItem m2;
    private javax.swing.JMenuItem m3;
    private javax.swing.JMenuItem m4;
    private javax.swing.JMenuItem m5;
    private javax.swing.JMenuItem m6;
    private javax.swing.JMenuItem m9;
    // End of variables declaration//GEN-END:variables
}

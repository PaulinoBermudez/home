package Vista;

import Modelo.BorderLayoutModelo;
import javax.swing.JButton;

public class JDialogBorderLayout extends javax.swing.JDialog {

    BorderLayoutModelo border = new BorderLayoutModelo();

    public JDialogBorderLayout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBorderLayout1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBorderLayout2 = new javax.swing.JButton();
        btnBorderLayout3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnBorderLayout1.setText("BorderLayout1");
        btnBorderLayout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorderLayout1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Border Layout");

        btnBorderLayout2.setText("BorderLayout2");
        btnBorderLayout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorderLayout2ActionPerformed(evt);
            }
        });

        btnBorderLayout3.setText("BorderLayout3");
        btnBorderLayout3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorderLayout3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBorderLayout3)
                            .addComponent(btnBorderLayout2)
                            .addComponent(btnBorderLayout1))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(btnBorderLayout1)
                .addGap(18, 18, 18)
                .addComponent(btnBorderLayout2)
                .addGap(18, 18, 18)
                .addComponent(btnBorderLayout3)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorderLayout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorderLayout1ActionPerformed
        /*border.BorderLayout1();
        dispose();*/
    }//GEN-LAST:event_btnBorderLayout1ActionPerformed

    private void btnBorderLayout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorderLayout2ActionPerformed
        /*border.BorderLayout2();
        dispose();*/
    }//GEN-LAST:event_btnBorderLayout2ActionPerformed

    private void btnBorderLayout3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorderLayout3ActionPerformed
        /*border.BorderLayout3();
        dispose();*/
    }//GEN-LAST:event_btnBorderLayout3ActionPerformed

    public JButton getBtnBorderLayout1() {
        return btnBorderLayout1;
    }

    public JButton getBtnBorderLayout2() {
        return btnBorderLayout2;
    }

    public JButton getBtnBorderLayout3() {
        return btnBorderLayout3;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorderLayout1;
    private javax.swing.JButton btnBorderLayout2;
    private javax.swing.JButton btnBorderLayout3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

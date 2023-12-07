package Vista;

import Modelo.BoxLayoutModelo;
import javax.swing.JButton;

public class JDialogBoxLayout extends javax.swing.JDialog {
    
    BoxLayoutModelo box = new BoxLayoutModelo();


    public JDialogBoxLayout(java.awt.Frame parent, boolean modal) {
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

        jLabel1 = new javax.swing.JLabel();
        btnBoxLayout1 = new javax.swing.JButton();
        btnBoxLayout3 = new javax.swing.JButton();
        btnBoxLayout2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Box Layout");

        btnBoxLayout1.setText("BoxLayout1");
        btnBoxLayout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoxLayout1ActionPerformed(evt);
            }
        });

        btnBoxLayout3.setText("BoxLayout3");
        btnBoxLayout3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoxLayout3ActionPerformed(evt);
            }
        });

        btnBoxLayout2.setText("BoxLayout2");
        btnBoxLayout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoxLayout2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBoxLayout2)
                    .addComponent(btnBoxLayout3)
                    .addComponent(btnBoxLayout1)
                    .addComponent(jLabel1))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(btnBoxLayout1)
                .addGap(18, 18, 18)
                .addComponent(btnBoxLayout2)
                .addGap(18, 18, 18)
                .addComponent(btnBoxLayout3)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBoxLayout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoxLayout1ActionPerformed
     /*   box.BoxLayout1();
        dispose();*/
    }//GEN-LAST:event_btnBoxLayout1ActionPerformed

    private void btnBoxLayout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoxLayout2ActionPerformed
     /*   box.BoxLayout2();
        dispose();*/
    }//GEN-LAST:event_btnBoxLayout2ActionPerformed

    private void btnBoxLayout3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoxLayout3ActionPerformed
    /*    box.BoxLayout3();
        dispose();*/
    }//GEN-LAST:event_btnBoxLayout3ActionPerformed

    public JButton getBtnBoxLayout1() {
        return btnBoxLayout1;
    }

    public JButton getBtnBoxLayout2() {
        return btnBoxLayout2;
    }

    public JButton getBtnBoxLayout3() {
        return btnBoxLayout3;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoxLayout1;
    private javax.swing.JButton btnBoxLayout2;
    private javax.swing.JButton btnBoxLayout3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

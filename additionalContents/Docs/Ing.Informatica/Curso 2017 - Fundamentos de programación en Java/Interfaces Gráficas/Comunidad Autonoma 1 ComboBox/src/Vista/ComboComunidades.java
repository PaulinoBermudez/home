package Vista;

import Modelo.ComunidadAutonoma;
import Modelo.ComunidadAutonomaDAO;
import Modelo.Municipio;
import Modelo.MunicipioDAO;
import Modelo.Provincia;
import Modelo.ProvinciaDAO;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Toni
 */
public class ComboComunidades extends javax.swing.JFrame {

    /**
     * Creates new form ComboComunidades
     */
    public ComboComunidades() {
        initComponents();
        setLocationRelativeTo(null);
        ComunidadAutonomaDAO ccaadao = new ComunidadAutonomaDAO();
        DefaultComboBoxModel modelCCAA = new DefaultComboBoxModel(ccaadao.mostrarCCAA());
        cbxComunidad.setModel(modelCCAA);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxComunidad = new javax.swing.JComboBox<>();
        cbxMunicipio = new javax.swing.JComboBox<>();
        cbxProvincia = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDatos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comunidades Autónomas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Comunidad Autónoma:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Provincia:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Municipio:");

        cbxComunidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxComunidadItemStateChanged(evt);
            }
        });

        cbxMunicipio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMunicipioItemStateChanged(evt);
            }
        });

        cbxProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProvinciaItemStateChanged(evt);
            }
        });

        txtDatos.setColumns(20);
        txtDatos.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtDatos.setRows(5);
        jScrollPane1.setViewportView(txtDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxComunidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxComunidadItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComunidadAutonoma ccaa = (ComunidadAutonoma) cbxComunidad.getSelectedItem();
            ProvinciaDAO provinciadao = new ProvinciaDAO();
            DefaultComboBoxModel modelProvincia = new DefaultComboBoxModel(provinciadao.mostrarProvincia(ccaa.getId()));
            cbxProvincia.setModel(modelProvincia);
            cbxMunicipio.removeAllItems();
            txtDatos.setText("");
        }
    }//GEN-LAST:event_cbxComunidadItemStateChanged

    private void cbxProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProvinciaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Provincia provincia = (Provincia) cbxProvincia.getSelectedItem();
            MunicipioDAO municipiodao = new MunicipioDAO();
            DefaultComboBoxModel modelMunicipio = new DefaultComboBoxModel(municipiodao.mostrarMunicipio(provincia.getId()));
            cbxMunicipio.setModel(modelMunicipio);
        }
    }//GEN-LAST:event_cbxProvinciaItemStateChanged

    private void cbxMunicipioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMunicipioItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComunidadAutonoma ccaa = (ComunidadAutonoma) cbxComunidad.getSelectedItem();
            Provincia provincia = (Provincia) cbxProvincia.getSelectedItem();
            Municipio municipio = (Municipio) cbxMunicipio.getSelectedItem();
            txtDatos.setText("Comunidad Autonoma: " + ccaa.getNombre() + " \nProvincia: " + provincia.getNombre() + " \nMunicipio: " + municipio.getNombre());
        }      
    }//GEN-LAST:event_cbxMunicipioItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxComunidad;
    private javax.swing.JComboBox<String> cbxMunicipio;
    private javax.swing.JComboBox<String> cbxProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDatos;
    // End of variables declaration//GEN-END:variables
}

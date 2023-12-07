
package Controlador;

import Modelo.ComunidadAutonoma;
import Vista.ComboComunidades;
import Modelo.ComunidadAutonomaDAO;
import Modelo.Municipio;
import Modelo.MunicipioDAO;
import Modelo.Provincia;
import Modelo.ProvinciaDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Toni
 */
public class ControladorCB implements ItemListener{

    private ComboComunidades vistaCombo = new ComboComunidades();


    public ControladorCB(ComboComunidades vistaCombo, ComunidadAutonomaDAO ccaadao){
        this.vistaCombo = vistaCombo;
        this.vistaCombo.getCbxComunidad().addItemListener(this);
        this.vistaCombo.getCbxProvincia().addItemListener(this);
        this.vistaCombo.getCbxMunicipio().addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        // IF Combo de las Comunidades Autónomas
        if (e.getSource() == vistaCombo.getCbxComunidad()){
            ComunidadAutonoma ccaa = (ComunidadAutonoma) vistaCombo.getCbxComunidad().getSelectedItem();
            ProvinciaDAO provinciadao = new ProvinciaDAO();
            DefaultComboBoxModel modelProvincia = new DefaultComboBoxModel(provinciadao.mostrarProvincia(ccaa.getId()));
            vistaCombo.getCbxProvincia().setModel(modelProvincia);
            vistaCombo.getCbxMunicipio().removeAllItems();
            vistaCombo.getTxtDatos().setText("");
        }// FIN Combo de las Comunidades Autónomas

        // IF Combo de las Provincias
        if (e.getSource() == vistaCombo.getCbxProvincia()){
            Provincia provincia = (Provincia)  vistaCombo.getCbxProvincia().getSelectedItem();
            MunicipioDAO municipiodao = new MunicipioDAO();
            DefaultComboBoxModel modelMunicipio = new DefaultComboBoxModel(municipiodao.mostrarMunicipio(provincia.getId()));
            vistaCombo.getCbxMunicipio().setModel(modelMunicipio);
        }// FIN Combo de las Provincias

        // IF Combo de las Municipios
        if (e.getSource() == vistaCombo.getCbxMunicipio()){
            ComunidadAutonoma ccaa = (ComunidadAutonoma) vistaCombo.getCbxComunidad().getSelectedItem();
            Provincia provincia = (Provincia) vistaCombo.getCbxProvincia().getSelectedItem();
            Municipio municipio = (Municipio) vistaCombo.getCbxMunicipio().getSelectedItem();
            vistaCombo.getTxtDatos().setText("Comunidad Autonoma: " + ccaa.getNombre() + " \nProvincia: " + provincia.getNombre() + " \nMunicipio: " + municipio.getNombre());
        }// FIN Combo de las Municipios

    }// FIN itemStateChanged

}

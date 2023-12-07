
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import javax.swing.border.TitledBorder;

/**
 * @(#)PanelDatosCoche.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/11
 */
public class PanelDatosCoche extends JPanel {

    JTextField campoModelo;
    JTextField campoColor;
    JCheckBox esMetalizada;
    JTextField campoMatricula;
    JComboBox tipoCoche;
    JFormattedTextField campoanno;
    JRadioButton todoRiesgo;
    JRadioButton terceros;

    public PanelDatosCoche() {
        setLayout(new GridLayout(7, 2));
        JLabel modelo = new JLabel("Modelo: ", JLabel.RIGHT);
        campoModelo = new JTextField();
        add(modelo);
        add(campoModelo);

        JLabel color = new JLabel("Color: ", JLabel.RIGHT);
        campoColor = new JTextField();
        add(color);
        add(campoColor);

        JLabel matricula = new JLabel("Matricula: ", JLabel.RIGHT);
        campoMatricula = new JTextField();
        add(matricula);
        add(campoMatricula);

        ButtonGroup grupoBotones = new ButtonGroup();
        todoRiesgo = new JRadioButton("A todo riesgo", true);
        todoRiesgo.setMnemonic(KeyEvent.VK_R);
        terceros = new JRadioButton("A terceros");
        terceros.setMnemonic(KeyEvent.VK_T);
        grupoBotones.add(todoRiesgo);
        grupoBotones.add(terceros);
        add(todoRiesgo);
        add(terceros);

        JLabel anno = new JLabel("anno de fabricacion ", JLabel.RIGHT);
        MaskFormatter formato = null;
        try {
            formato = new MaskFormatter("####");
        } catch (ParseException e) {
            //se captura la excepci�n y no se hace nada
        }
        campoanno = new JFormattedTextField(formato);
        add(anno);
        add(campoanno);

        JLabel tipo = new JLabel("Tipo de coche: ", JLabel.RIGHT);
        tipoCoche = new JComboBox(TipoDeCoche.values());
        add(tipo);
        add(tipoCoche);

        JLabel pintura = new JLabel("Tipo de pintura: ", JLabel.RIGHT);
        esMetalizada = new JCheckBox("Metalizada", false);
        add(pintura);
        add(esMetalizada);

        TitledBorder titulo;
        titulo = BorderFactory.createTitledBorder("Datos del coche");
        setBorder(titulo);
    }
}

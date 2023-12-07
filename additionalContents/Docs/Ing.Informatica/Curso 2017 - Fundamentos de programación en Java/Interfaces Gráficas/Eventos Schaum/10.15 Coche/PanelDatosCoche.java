
import javax.swing.JPanel;
import javax.swing.JFrame;
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

public class PanelDatosCoche extends JPanel {

    JTextField campoModelo;
    JTextField campoColor;
    JCheckBox esMetalizada;
    JTextField campoMatricula;
    JComboBox tipoCoche;
    JFormattedTextField campoAño;
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

        JLabel matricula = new JLabel("Matr�cula: ", JLabel.RIGHT);
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

        JLabel año = new JLabel("Año de fabricacion ", JLabel.RIGHT);
        MaskFormatter formato = null;
        try {
            formato = new MaskFormatter("####");
        } catch (ParseException e) {
            //se captura la excepci�n y no se hace nada
        }
        campoAño = new JFormattedTextField(formato);
        add(año);
        add(campoAño);

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

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Panel de datos");
        ventana.add(new PanelDatosCoche());
        ventana.pack();
        ventana.setVisible(true);
    }
}

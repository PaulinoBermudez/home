package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;

/**
 * @(#)PanelDatosProfesor.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/25
 */
public class PanelDatosProfesor extends JPanel {

    private JTextField campoNombre;
    private JTextField campoApellidos;
    private JTextField campoDNI;
    private JRadioButton mañana;
    private JRadioButton tarde;

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JTextField getCampoApellidos() {
        return campoApellidos;
    }

    public JTextField getCampoDNI() {
        return campoDNI;
    }

    public JRadioButton getMañana() {
        return mañana;
    }

    public JRadioButton getTarde() {
        return tarde;
    }

    public PanelDatosProfesor() {

        setLayout(new GridLayout(4, 2));

        JLabel etiquetaNombre = new JLabel("Nombre: ", JLabel.RIGHT);
        campoNombre = new JTextField();
        add(etiquetaNombre);
        add(campoNombre);

        JLabel etiquetaApellidos = new JLabel(" Apellidos: ", JLabel.RIGHT);
        campoApellidos = new JTextField();
        add(etiquetaApellidos);
        add(campoApellidos);

        JLabel etiquetaDNI = new JLabel(" DNI: ", JLabel.RIGHT);
        campoDNI = new JTextField();
        add(etiquetaDNI);
        add(campoDNI);

        ButtonGroup grupoBotones = new ButtonGroup();

        mañana = new JRadioButton("Grupo Mañana", true);
        mañana.setMnemonic('M');

        tarde = new JRadioButton("Grupo Tarde");
        tarde.setMnemonic('T');

        grupoBotones.add(mañana);
        grupoBotones.add(tarde);
        add(mañana);
        add(tarde);
    }
}

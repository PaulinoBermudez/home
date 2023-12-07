package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;

/**
 * @(#)PanelDatosAlumno.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/25
 */
public class PanelDatosAlumno extends JPanel {

    private JTextField campoNombre;
    private JTextField campoApellidos;
    private JTextField campoAño;
    private JRadioButton mañana;
    private JRadioButton tarde;

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JTextField getCampoApellidos() {
        return campoApellidos;
    }

    public JTextField getCampoAño() {
        return campoAño;
    }

    public JRadioButton getMañana() {
        return mañana;
    }

    public JRadioButton getTarde() {
        return tarde;
    }

    public PanelDatosAlumno() {

        setLayout(new GridLayout(4, 2));

        JLabel etiquetaNombre = new JLabel("Nombre: ", JLabel.RIGHT);
        campoNombre = new JTextField();
        add(etiquetaNombre);
        add(campoNombre);

        JLabel etiquetaApellidos = new JLabel("Apellidos: ", JLabel.RIGHT);
        campoApellidos = new JTextField();
        add(etiquetaApellidos);
        add(campoApellidos);

        JLabel etiquetaAño = new JLabel("Año nacimiento: ", JLabel.RIGHT);
        campoAño = new JTextField();
        add(etiquetaAño);
        add(campoAño);

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

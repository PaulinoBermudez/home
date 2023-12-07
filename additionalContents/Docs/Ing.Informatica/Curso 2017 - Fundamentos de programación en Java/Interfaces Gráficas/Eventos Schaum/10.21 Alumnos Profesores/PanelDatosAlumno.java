
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

    JTextField campoNombre;
    JTextField campoApellidos;
    JTextField campoAño;
    JRadioButton mañana;
    JRadioButton tarde;

    PanelDatosAlumno() {

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

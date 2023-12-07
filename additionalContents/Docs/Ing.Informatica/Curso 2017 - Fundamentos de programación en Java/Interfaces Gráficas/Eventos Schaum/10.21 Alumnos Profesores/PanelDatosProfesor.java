
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

    JTextField campoNombre;
    JTextField campoApellidos;
    JTextField campoDNI;
    JRadioButton mañana;
    JRadioButton tarde;

    PanelDatosProfesor() {

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

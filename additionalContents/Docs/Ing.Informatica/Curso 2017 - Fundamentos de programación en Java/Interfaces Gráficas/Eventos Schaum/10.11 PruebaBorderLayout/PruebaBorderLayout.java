
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @(#)PruebaBorderLayout.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/13
 */
public class PruebaBorderLayout extends JFrame {

    private JPanel panelBotonesRegiones;
    private JPanel panelBotonesRelativos;
    private JTextField campoTexto;

    public PruebaBorderLayout() {
        add(crearPanelOrientacion(), BorderLayout.NORTH);
        panelBotonesRegiones = crearPanelRegiones();
        add(panelBotonesRegiones, BorderLayout.EAST);
        panelBotonesRelativos = crearPanelPosicionRelativa();
        add(panelBotonesRelativos, BorderLayout.WEST);
        campoTexto = new JTextField();
        add(campoTexto, BorderLayout.SOUTH);
    }

    private JPanel crearPanelRegiones() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        OyenteBoton oyente = new OyenteBoton();
        panel.add(crearBoton("Botón 1 (CENTER)", oyente), BorderLayout.CENTER);
        panel.add(crearBoton("Segundo Botón (NORTH)", oyente), BorderLayout.NORTH);
        panel.add(crearBoton("3 Botón (SOUTH)", oyente), BorderLayout.SOUTH);
        panel.add(crearBoton("Botón 4 (EAST)", oyente), BorderLayout.EAST);
        panel.add(crearBoton("Botón5 (WEST)", oyente), BorderLayout.WEST);
        return panel;
    }

    private JPanel crearPanelPosicionRelativa() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        OyenteBoton oyente = new OyenteBoton();
        panel.add(crearBoton("Botón 1 (CENTER)", oyente), BorderLayout.CENTER);
        panel.add(crearBoton("Segundo Botón (PAGE_START)", oyente), BorderLayout.PAGE_START);
        panel.add(crearBoton("3 Botón (PAGE_END)", oyente), BorderLayout.PAGE_END);
        panel.add(crearBoton("Botón 4 (LINE_END)", oyente), BorderLayout.LINE_END);
        panel.add(crearBoton("Botón 5 (LINE_START)", oyente), BorderLayout.LINE_START);
        return panel;
    }

    private JPanel crearPanelOrientacion() {
        JPanel panel = new JPanel();
        OyenteOrientacion oyente = new OyenteOrientacion();
        ButtonGroup grupoOrientacion = new ButtonGroup();
        panel.add(new JLabel("Orientación: "));
        panel.add(crearBotonRadio(grupoOrientacion, "LEFT_TO_RIGHT", oyente));
        panel.add(crearBotonRadio(grupoOrientacion, "RIGHT_TO_LEFT", oyente));
        return panel;
    }

    private JRadioButton crearBotonRadio(ButtonGroup grupo, String etiqueta, ActionListener oyente) {
        JRadioButton boton = new JRadioButton(etiqueta);
        boton.addActionListener(oyente);
        grupo.add(boton);
        return boton;
    }

    private JButton crearBoton(String etiqueta, ActionListener oyente) {
        JButton boton = new JButton(etiqueta);
        boton.addActionListener(oyente);
        return boton;
    }

    class OyenteBoton implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            JButton boton = (JButton) evento.getSource();
            campoTexto.setText("Se ha pulsado el Botón: " + boton.getText());
        }
    }

    class OyenteOrientacion implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            JRadioButton boton = (JRadioButton) evento.getSource();
            if ("LEFT_TO_RIGHT".equals(boton.getActionCommand())) {
                panelBotonesRegiones.setComponentOrientation(
                        ComponentOrientation.LEFT_TO_RIGHT);
                panelBotonesRelativos.setComponentOrientation(
                        ComponentOrientation.LEFT_TO_RIGHT);
            } else {
                panelBotonesRegiones.setComponentOrientation(
                        ComponentOrientation.RIGHT_TO_LEFT);
                panelBotonesRelativos.setComponentOrientation(
                        ComponentOrientation.RIGHT_TO_LEFT);
            }
            panelBotonesRegiones.doLayout();
            panelBotonesRelativos.doLayout();
        }
    }//OyenteOrientacion

    public static void main(String args[]) {
        PruebaBorderLayout ventana = new PruebaBorderLayout();
        ventana.setTitle("Administrador BorderLayout");
        ventana.setSize(900, 250);
        ventana.setVisible(true);
    }

}

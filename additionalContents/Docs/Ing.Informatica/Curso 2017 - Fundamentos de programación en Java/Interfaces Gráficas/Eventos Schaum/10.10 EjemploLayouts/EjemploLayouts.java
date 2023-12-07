
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @(#)EjemploLayouts.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/21
 */
public class EjemploLayouts extends JFrame {

    private JPanel panelBotones;

    public EjemploLayouts() {
        panelBotones = crearPanelBotones();
        add(panelBotones, BorderLayout.CENTER);
        JPanel panelOrientacion = crearPanelOrientacion();
        add(panelOrientacion, BorderLayout.PAGE_START);
        JPanel panelAlineacion = crearPanelAlineacion();
        add(panelAlineacion, BorderLayout.PAGE_END);
        setTitle("FlowLayout: orientacion y alineacion");
        setSize(500, 200);
        setVisible(true);
    }

    private JPanel crearPanelBotones() {
        JPanel panelBotones = new JPanel();
        JButton botones[] = new JButton[8];
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("Boton " + i);
            panelBotones.add(botones[i]);
        }
        return panelBotones;
    }// crearPanelBotones

    private JPanel crearPanelOrientacion() {

        JPanel panel = new JPanel();
        OyenteOrientacion oyente = new OyenteOrientacion();
        ButtonGroup grupoOrientacion = new ButtonGroup();
        panel.add(new JLabel("Orientación"));
        panel.add(crearBotonRadio(grupoOrientacion, "LEFT_TO_RIGHT", oyente));
        panel.add(crearBotonRadio(grupoOrientacion, "RIGHT_TO_LEFT", oyente));
        return panel;
    }//crearPanel0rientacion

    private JPanel crearPanelAlineacion() {
        JPanel panel = new JPanel();
        OyenteAlineacion oyente = new OyenteAlineacion();
        ButtonGroup grupoAlineacion = new ButtonGroup();
        panel.add(new JLabel("Alineación: "));
        panel.add(crearBotonRadio(grupoAlineacion, "LEFT", oyente));
        panel.add(crearBotonRadio(grupoAlineacion, "CENTER", oyente));
        panel.add(crearBotonRadio(grupoAlineacion, "RIGHT", oyente));
        panel.add(crearBotonRadio(grupoAlineacion, "LEADING", oyente));
        panel.add(crearBotonRadio(grupoAlineacion, "TRAILING", oyente));
        return panel;
    }//crearPanelAlineacion

    private JRadioButton crearBotonRadio(ButtonGroup grupo,
            String etiqueta, ActionListener oyente) {
        JRadioButton boton = new JRadioButton(etiqueta);
        boton.addActionListener(oyente);
        grupo.add(boton);
        return boton;
    }//crearBotonRadio

    class OyenteOrientacion implements ActionListener {

        public void actionPerformed(ActionEvent evento) {

            JRadioButton boton = (JRadioButton) evento.getSource();
            if ("LEFT_TO_RIGHT".equals(boton.getActionCommand())) {
                panelBotones.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            } else {
                panelBotones.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            }
            panelBotones.doLayout();
        }
    }// OyenteOrientacion

    class OyenteAlineacion implements ActionListener {

        public void actionPerformed(ActionEvent evento) {

            JRadioButton boton = (JRadioButton) evento.getSource();
            FlowLayout layout = (FlowLayout) panelBotones.getLayout();
            if ("LEFT".equals(boton.getActionCommand())) {
                layout.setAlignment(FlowLayout.LEFT);
            } else if ("CENTER".equals(boton.getActionCommand())) {
                layout.setAlignment(FlowLayout.CENTER);
            } else if ("RIGHT".equals(boton.getActionCommand())) {
                layout.setAlignment(FlowLayout.RIGHT);
            } else if ("LEADING".equals(boton.getActionCommand())) {
                layout.setAlignment(FlowLayout.LEADING);
            } else {
                layout.setAlignment(FlowLayout.TRAILING);
            }
            panelBotones.doLayout();
        }
    }

    public static void main(String[] args) {

        EjemploLayouts ventana = new EjemploLayouts();
    }
}

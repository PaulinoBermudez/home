package Controlador;

import Modelo.FlowLayoutModelo;
import Vista.JDialogFlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFlowLayout implements ActionListener {

    private JDialogFlowLayout vistaFlowLayout;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorFlowLayout(JDialogFlowLayout vistaFlowLayout) {
        this.vistaFlowLayout = vistaFlowLayout;
        this.vistaFlowLayout.getBtnFlowLayout1().addActionListener(this);
        this.vistaFlowLayout.getBtnFlowLayout2().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // IF getBtnBorderLayout1
        if (e.getSource() == vistaFlowLayout.getBtnFlowLayout1()) {
            System.out.println("getBtnBoxLayout1 JDialogBoxLayout FUNCIONA");
            FlowLayoutModelo flow = new FlowLayoutModelo();
            flow.FlowLayout1();
            vistaFlowLayout.dispose();
        }// FIN IF getBtnBorderLayout1

        // IF getBtnBorderLayout2
        if (e.getSource() == vistaFlowLayout.getBtnFlowLayout2()) {
            System.out.println("getBtnBoxLayout2 JDialogBoxLayout FUNCIONA");
            FlowLayoutModelo flow = new FlowLayoutModelo();
            flow.FlowLayout2();
            vistaFlowLayout.dispose();
        }// FIN IF getBtnBorderLayout2

    }// FIN ACTION PERFORMED
}

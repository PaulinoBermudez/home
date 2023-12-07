package Controlador;

import Modelo.BoxLayoutModelo;
import Vista.JDialogBoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBoxLayout implements ActionListener {

    private JDialogBoxLayout vistaBoxLayout;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorBoxLayout(JDialogBoxLayout vistaBoxLayout ) {
        this.vistaBoxLayout = vistaBoxLayout;
        this.vistaBoxLayout.getBtnBoxLayout1().addActionListener(this);
        this.vistaBoxLayout.getBtnBoxLayout2().addActionListener(this);
        this.vistaBoxLayout.getBtnBoxLayout3().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // IF getBtnBorderLayout1
        if (e.getSource() == vistaBoxLayout.getBtnBoxLayout1()) {
            System.out.println("getBtnBoxLayout1 JDialogBoxLayout FUNCIONA");
            BoxLayoutModelo box = new BoxLayoutModelo();
            box.BoxLayout1();
            vistaBoxLayout.dispose();
        }// FIN IF getBtnBoxLayout1

        // IF getBtnBorderLayout2
        if (e.getSource() == vistaBoxLayout.getBtnBoxLayout2()) {
            System.out.println("getBtnBoxLayout2 JDialogBoxLayout FUNCIONA");
            BoxLayoutModelo box = new BoxLayoutModelo();
            box.BoxLayout2();
            vistaBoxLayout.dispose();
        }// FIN IF getBtnBoxLayout2

        // IF getBtnBorderLayout3
        if (e.getSource() == vistaBoxLayout.getBtnBoxLayout3()) {
            System.out.println("getBtnBoxLayout3 JDialogBoxLayout FUNCIONA");
            BoxLayoutModelo box = new BoxLayoutModelo();
            box.BoxLayout3();
            vistaBoxLayout.dispose();
        }// FIN IF getBtnBoxLayout3

    }// FIN ACTION PERFORMED

}

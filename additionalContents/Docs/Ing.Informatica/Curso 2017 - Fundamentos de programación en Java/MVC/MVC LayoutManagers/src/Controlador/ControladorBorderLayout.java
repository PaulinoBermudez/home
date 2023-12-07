
package Controlador;

import Modelo.BorderLayoutModelo;
import Vista.JDialogBorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBorderLayout implements ActionListener {

    private JDialogBorderLayout vistaBorderLayout;
    

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorBorderLayout(JDialogBorderLayout vistaBorderLayout) {
        this.vistaBorderLayout = vistaBorderLayout;
        this.vistaBorderLayout.getBtnBorderLayout1().addActionListener(this);
        this.vistaBorderLayout.getBtnBorderLayout2().addActionListener(this);
        this.vistaBorderLayout.getBtnBorderLayout3().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // IF getBtnBorderLayout1
        if (e.getSource() == vistaBorderLayout.getBtnBorderLayout1()) {
            System.out.println("getBtnBorderLayout1 JDialogBorderLayout FUNCIONA");
            BorderLayoutModelo border = new BorderLayoutModelo();
            border.BorderLayout1();
            vistaBorderLayout.dispose();
        }// FIN IF getBtnBorderLayout1

        // IF getBtnBorderLayout2
        if (e.getSource() == vistaBorderLayout.getBtnBorderLayout2()) {
            System.out.println("getBtnBorderLayout2 JDialogBorderLayout FUNCIONA");
            BorderLayoutModelo border = new BorderLayoutModelo();
            border.BorderLayout2();
            vistaBorderLayout.dispose();
        }// FIN IF getBtnBorderLayout2

        // IF getBtnBorderLayout3
        if (e.getSource() == vistaBorderLayout.getBtnBorderLayout3()) {
            System.out.println("getBtnBorderLayout3 JDialogBorderLayout FUNCIONA");
            BorderLayoutModelo border = new BorderLayoutModelo();
            border.BorderLayout3();
            vistaBorderLayout.dispose();
        }// FIN IF getBtnBorderLayout3

    }// FIN ACTION PERFORMED

}

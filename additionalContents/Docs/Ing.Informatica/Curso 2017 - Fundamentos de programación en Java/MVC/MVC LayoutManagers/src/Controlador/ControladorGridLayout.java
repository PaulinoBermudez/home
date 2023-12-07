package Controlador;

import Modelo.GridLayoutModelo;
import Vista.JDialogGridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorGridLayout implements ActionListener {

    private JDialogGridLayout vistaGridLayout;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorGridLayout(JDialogGridLayout vistaGridLayout) {
        this.vistaGridLayout = vistaGridLayout;
        this.vistaGridLayout.getBtnGridLayout1().addActionListener(this);
        this.vistaGridLayout.getBtnGridLayout2().addActionListener(this);
        this.vistaGridLayout.getBtnGridLayout3().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // IF getBtnBorderLayout1
        if (e.getSource() == vistaGridLayout.getBtnGridLayout1()) {
            System.out.println("getBtnGridLayout1 JDialogGridLayout FUNCIONA");
            GridLayoutModelo grid = new GridLayoutModelo();
            grid.GridLayout1();
            vistaGridLayout.dispose();
        }// FIN IF getBtnGridLayout1

        // IF getBtnBorderLayout2
        if (e.getSource() == vistaGridLayout.getBtnGridLayout2()) {
            System.out.println("getBtnGridLayout2 JDialogGridLayout FUNCIONA");
            GridLayoutModelo grid = new GridLayoutModelo();
            grid.GridLayout2();
            vistaGridLayout.dispose();
        }// FIN IF getBtnGridLayout2

        // IF getBtnBorderLayout3
        if (e.getSource() == vistaGridLayout.getBtnGridLayout3()) {
            System.out.println("getBtnGridLayout3 JDialogGridLayout FUNCIONA");
            GridLayoutModelo grid = new GridLayoutModelo();
            grid.GridLayout3();
            vistaGridLayout.dispose();
        }// FIN IF getBtnGridLayout3

    }// FIN ACTION PERFORMED
}

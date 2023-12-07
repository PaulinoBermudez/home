package Controlador;

import Vista.JDialogBorderLayout;
import Vista.JDialogBoxLayout;
import Vista.JDialogFlowLayout;
import Vista.JDialogGridLayout;
import Vista.VistaLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements ActionListener {

    private VistaLayout vistaLayout;
    private ControladorBorderLayout cBorder;
    private ControladorBoxLayout cBox;
    private ControladorFlowLayout cFlow;
    private ControladorGridLayout cGrid;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorPrincipal(VistaLayout vistaLayout) {
        this.vistaLayout = vistaLayout;
        this.vistaLayout.getBtnBorderLayout().addActionListener(this);
        this.vistaLayout.getBtnBoxLayout().addActionListener(this);
        this.vistaLayout.getBtnFlowLayout().addActionListener(this);
        this.vistaLayout.getBtnGridLayout().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // IF getBtnBorderLayout
        if (e.getSource() == vistaLayout.getBtnBorderLayout()) {
            System.out.println("getBtnBorderLayout vistaLayout FUNCIONA");
            JDialogBorderLayout border = new JDialogBorderLayout(vistaLayout, true);
            cBorder = new ControladorBorderLayout(border);
            border.setLocationRelativeTo(null);
            border.setVisible(true);
        }// FIN IF getBtnBorderLayout

        // IF getBtnBoxLayout
        if (e.getSource() == vistaLayout.getBtnBoxLayout()) {
            System.out.println("getBtnBoxLayout vistaLayout FUNCIONA");
            JDialogBoxLayout box = new JDialogBoxLayout(vistaLayout, true);
            cBox = new ControladorBoxLayout(box);
            box.setLocationRelativeTo(null);
            box.setVisible(true);
        }// FIN IF getBtnBoxLayout

        // IF getBtnFlowLayout
        if (e.getSource() == vistaLayout.getBtnFlowLayout()) {
            System.out.println("getBtnFlowLayout vistaLayout FUNCIONA");
            JDialogFlowLayout flow = new JDialogFlowLayout(vistaLayout, true);
            cFlow = new ControladorFlowLayout(flow);
            flow.setVisible(true);
        }// FIN IF getBtnFlowLayout

        // IF getBtnGridLayout
        if (e.getSource() == vistaLayout.getBtnGridLayout()) {
            System.out.println("getBtnGridLayout vistaLayout FUNCIONA");
            JDialogGridLayout grid = new JDialogGridLayout(vistaLayout, true);
            cGrid = new ControladorGridLayout(grid);
            grid.setVisible(true);
        }// FIN IF getBtnGridLayout

    } // FIN actionPerformed
}// FIN ControladorPrincipal

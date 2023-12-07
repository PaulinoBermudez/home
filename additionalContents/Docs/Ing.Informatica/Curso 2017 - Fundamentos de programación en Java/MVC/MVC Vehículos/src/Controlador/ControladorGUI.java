package Controlador;

import Modelo.Coche;
import Modelo.Listas;
import Modelo.TipoDeCoche;
import Modelo.TipoDeSeguro;
import Vista.InterfazGrafica;
import Vista.PanelDatosCoche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * @(#)ControladorGUI.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/25
 */
public class ControladorGUI implements ActionListener {

    private DefaultListModel modelolistacoches;
    private Listas listas;
    private InterfazGrafica gui;

    public ControladorGUI(Listas listas, InterfazGrafica gui) {

        this.listas = listas;
        this.gui = gui;

        this.gui.getBtnAgregar().addActionListener(this);
        this.gui.getBtnListar().addActionListener(this);

        this.gui.getListar().addActionListener(this);
        this.gui.getSalir().addActionListener(this);

    }// FIN ControladorGUI

    @Override
    /**
     * Método para la gestión de los distios eventos
     */
    public void actionPerformed(ActionEvent e) {

        // Boton Agregar COCHES
        if (e.getSource() == gui.getBtnAgregar()) {

            System.out.println("getBtnAgregar COCHES FUNCIONA");
            boolean error = false;
            PanelDatosCoche panel = new PanelDatosCoche();
            if (JOptionPane.showConfirmDialog(null,
                    panel,
                    "Introduzca datos",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            ) == JOptionPane.OK_OPTION) {
                String modelo = panel.getCampoModelo().getText();
                String color = panel.getCampoColor().getText();
                Boolean esMetalizado = panel.getEsMetalizada().isSelected();
                String matricula = panel.getCampoMatricula().getText();
                TipoDeCoche tipo = TipoDeCoche.getTipo(panel.getTipoCoche().getSelectedItem().toString());
                int anno = 0;
                try {
                    anno = Integer.parseInt(panel.getCampoanno().getText());
                } catch (NumberFormatException ex) {
                    error = true;
                    JOptionPane.showMessageDialog(null,
                            "<html><u>El año con cuatro dígitos Ce.g. 2003)",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                error = error || (modelo.length() == 0) || (color.length() == 0) || (matricula.length() == 0);
                if (error) {
                    JOptionPane.showMessageDialog(null,
                            "<html>Tipo de error "
                            + "<p color='red'>Algún campo está vacío"
                            + " <em> Debe rellenarlos todos",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                TipoDeSeguro seguro;
                if (panel.getTodoRiesgo().isSelected()) {
                    seguro = TipoDeSeguro.A_TODO_RIESGO;
                } else {
                    seguro = TipoDeSeguro.A_TERCEROS;
                }
                if (!error) {
                    Coche coche = new Coche(modelo, color, esMetalizado, matricula, tipo, anno, seguro);
                    listas.agregarCoche(coche);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Operación no realizada",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        } // FIN IF DEL BOTON AGREGAR COCHES

        // Menú Listar Coches
        if (e.getSource() == gui.getBtnListar()||
                e.getSource() == gui.getListar()) {

            System.out.println("getBtnListar FUNCIONA");

            DefaultListModel modelolistaCoche = new DefaultListModel();
            gui.getjListCoches().setModel(modelolistaCoche);
            modelolistaCoche.clear();
            Iterator iterador = listas.getLista().listIterator();
            while (iterador.hasNext()) {
                modelolistaCoche.addElement(iterador.next());
            }
        } // FIN IF DEL BOTON Listar Coches

        // Menú SALIR Coches
        if (e.getSource() == gui.getSalir()) {

            System.out.println("getSalir FUNCIONA");
            System.exit(0);

        }// FIN IF DEL BOTON SALIR Coches
    } //FIN actionPerformed(ActionEvent e)
} // FIN ControladorGUI

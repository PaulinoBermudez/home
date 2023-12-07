package Controlador;

import Modelo.Alumno;
import Modelo.Horario;
import Modelo.Profesor;
import Modelo.Listas;
import Vista.Vista;
import Vista.PanelDatosAlumno;
import Vista.PanelDatosProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @(#)ControladorGUI.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/25
 */
public class ControladorVista implements ActionListener {

    private DefaultListModel modelolistaAlumno;
    private DefaultListModel modelolistaProfesor;
    private Listas listas;
    private Vista vista;

    public ControladorVista(Listas listas, Vista vista) {

        this.listas = listas;
        this.vista = vista;
        
        this.vista.getBtnAgregarAlumno().addActionListener(this);
        this.vista.getBtnListarAlumno().addActionListener(this);

        this.vista.getBtnAgregarProfesor().addActionListener(this);
        this.vista.getBtnListarProfesor().addActionListener(this);

        this.vista.getListaAlumnos().addActionListener(this);
        this.vista.getListaAlumnosMañana().addActionListener(this);
        this.vista.getListaAlumnosTarde().addActionListener(this);

        this.vista.getListaProfesores().addActionListener(this);
        this.vista.getListaProfesoresMañana().addActionListener(this);
        this.vista.getListaProfesoresTarde().addActionListener(this);
        
        this.vista.getjMenuItemSalir().addActionListener(this);

    }// FIN ControladorGUI

    @Override
    /**
     * Método para la gestión de los distios eventos
     */
    public void actionPerformed(ActionEvent e) {

        // Boton Agregar Alumnos
        if (e.getSource() == vista.getBtnAgregarAlumno()) {

            System.out.println("getBtnAgregar ALUMNOS FUNCIONA");
            boolean error = false;
            PanelDatosAlumno panel = new PanelDatosAlumno();
            if (JOptionPane.showConfirmDialog(null,
                    panel,
                    "Introduzca datos de Alumno",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            ) == JOptionPane.OK_OPTION) {
                String nombre = panel.getCampoNombre().getText();
                String apellidos = panel.getCampoApellidos().getText();
                int año = 0;
                try {
                    año = Integer.parseInt(panel.getCampoAño().getText());
                } catch (Exception eX) {
                    error = true;
                }
                error = error || (nombre.length() == 0) || (apellidos.length() == 0);
                if (error) {
                    JOptionPane.showMessageDialog(null,
                            "Campo vacio o error en formato de numero",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                Horario turno;

                if (panel.getMañana().isSelected()) {
                    turno = Horario.MAÑANA;
                } else {
                    turno = Horario.TARDE;
                }
                if (!error) {
                    Alumno alumno = new Alumno(nombre, apellidos, año, turno);
                    listas.agregarAlumno(alumno);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Operacion no realizada",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }

        } // FIN IF DEL BOTON AGREGAR ALUMNO

        // Boton Listar Alumnos o
        // Menú  Listar Alumnos
        if (e.getSource() == vista.getBtnListarAlumno()
                || e.getSource() == vista.getListaAlumnos()) {

            System.out.println("getBtnListar FUNCIONA");

            DefaultListModel modelolistaAlumno = new DefaultListModel();
            vista.getjListAlumnos().setModel(modelolistaAlumno);
            modelolistaAlumno.clear();
            Iterator iterador = listas.getAlumnos().listIterator();
            while (iterador.hasNext()) {
                modelolistaAlumno.addElement(iterador.next());
            }

        } // FIN IF DEL BOTON Listar Alumnos
        
        // Boton Agregar Profesores
        if (e.getSource() == vista.getBtnAgregarProfesor()) {

            System.out.println("getBtnAgregar PROFESOR FUNCIONA");

            boolean error = false;
            PanelDatosProfesor panel = new PanelDatosProfesor();
            if (JOptionPane.showConfirmDialog(null,
                    panel,
                    "Introduzca datos de Profesor",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            ) == JOptionPane.OK_OPTION) {
                String nombre = panel.getCampoNombre().getText();
                String apellidos = panel.getCampoApellidos().getText();
                int dni = 0;
                try {
                    dni = Integer.parseInt(panel.getCampoDNI().getText());
                } catch (Exception ex) {
                    error = true;
                }
                error = error || (nombre.length() == 0) || (apellidos.length() == 0);
                if (error) {
                    JOptionPane.showMessageDialog(null,
                            "Campo vacio o error en formato de numero",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                Horario turno;

                if (panel.getMañana().isSelected()) {
                    turno = Horario.MAÑANA;
                } else {
                    turno = Horario.TARDE;
                }
                if (!error) {
                    Profesor profesor = new Profesor(nombre, apellidos, dni, turno);
                    listas.agregarProfesor(profesor);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Operación no realizada",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        }// FIN IF DEL BOTON AGREGAR PROFESOR

        // Boton Listar PROFESORES o
        // Menú  Listar PROFESORES
        if (e.getSource() == vista.getBtnListarProfesor()
                || e.getSource() == vista.getListaProfesores()) {

            System.out.println("getBtnListar FUNCIONA");

            DefaultListModel modelolistaProfesor = new DefaultListModel();
            vista.getjListProfesores().setModel(modelolistaProfesor);
            modelolistaProfesor.clear();
            Iterator iterador = listas.getProfesores().listIterator();
            while (iterador.hasNext()) {
                modelolistaProfesor.addElement(iterador.next());
            }
        } // FIN IF DEL BOTON Listar PROFESORES

        // Menú Listar Alumnos Mañana
        if (e.getSource() == vista.getListaAlumnosMañana()) {

            System.out.println("getListaAlumnosMañana FUNCIONA");

            Alumno alumno;

            JMenuItem listaAlumnosMañana = new JMenuItem();
            listaAlumnosMañana.setActionCommand("mañana");
            listaAlumnosMañana.addActionListener(this);

            String accion = listaAlumnosMañana.getActionCommand();
            DefaultListModel modelolistaAlumno = new DefaultListModel();
            vista.getjListAlumnos().setModel(modelolistaAlumno);
            modelolistaAlumno.clear();
            Iterator iterador = listas.getAlumnos().listIterator();

            while (iterador.hasNext()) {

                alumno = (Alumno) iterador.next();
                if (((accion.equals("tarde")) && (alumno.getHorario() == Horario.TARDE))
                        || ((accion.equals("mañana")) && (alumno.getHorario() == Horario.MAÑANA))) {
                    modelolistaAlumno.addElement(alumno);
                }
            }// FIN while

        }// FIN IF DEL Menú Listar Alumnos Mañana

        // Menú Listar Alumnos Tarde
        if (e.getSource() == vista.getListaAlumnosTarde()) {

            System.out.println("getListaAlumnosTarde FUNCIONA");
            
            Alumno alumno;
            
            JMenuItem listaAlumnosTarde = new JMenuItem();
            listaAlumnosTarde.setActionCommand("tarde");
            listaAlumnosTarde.addActionListener(this);

            String accion = listaAlumnosTarde.getActionCommand();
            DefaultListModel modelolistaAlumno = new DefaultListModel();
            vista.getjListAlumnos().setModel(modelolistaAlumno);
            modelolistaAlumno.clear();
            Iterator iterador = listas.getAlumnos().listIterator();

            while (iterador.hasNext()) {

                alumno = (Alumno) iterador.next();
                if (((accion.equals("tarde")) && (alumno.getHorario() == Horario.TARDE))
                        || ((accion.equals("mañana")) && (alumno.getHorario() == Horario.MAÑANA))) {
                    modelolistaAlumno.addElement(alumno);
                }
            }

        }// FIN IF DEL Menú Listar Alumnos Tarde

        // Menú Listar PROFESORES Mañana
        if (e.getSource() == vista.getListaProfesoresMañana()) {

            System.out.println("getListaProfesoresMañana FUNCIONA");
            
            Profesor profesor;

            JMenuItem listaProfesoresMañana = new JMenuItem();
            listaProfesoresMañana.setActionCommand("mañana");
            listaProfesoresMañana.addActionListener(this);

            String accion = listaProfesoresMañana.getActionCommand();
            DefaultListModel modelolistaProfesor = new DefaultListModel();
            vista.getjListProfesores().setModel(modelolistaProfesor);
            modelolistaProfesor.clear();
            Iterator iterador = listas.getProfesores().listIterator();

            while (iterador.hasNext()) {

                profesor = (Profesor) iterador.next();
                if (((accion.equals("tarde")) && (profesor.getHorario() == Horario.TARDE))
                        || ((accion.equals("mañana")) && (profesor.getHorario() == Horario.MAÑANA))) {
                    modelolistaProfesor.addElement(profesor);
                }
            }// FIN while

        }// FIN IF DEL Menú Listar PROFESORES Mañana

        // Menú Listar PROFESORES Tarde
        if (e.getSource() == vista.getListaProfesoresTarde()) {

            System.out.println("getListaProfesoresTarde FUNCIONA");
            
            Profesor profesor;

            JMenuItem listaProfesoresTarde = new JMenuItem();
            listaProfesoresTarde.setActionCommand("tarde");
            listaProfesoresTarde.addActionListener(this);

            String accion = listaProfesoresTarde.getActionCommand();
            DefaultListModel modelolistaProfesor = new DefaultListModel();
            vista.getjListProfesores().setModel(modelolistaProfesor);
            modelolistaProfesor.clear();
            Iterator iterador = listas.getProfesores().listIterator();

            while (iterador.hasNext()) {

                profesor = (Profesor) iterador.next();
                if (((accion.equals("tarde")) && (profesor.getHorario() == Horario.TARDE))
                        || ((accion.equals("mañana")) && (profesor.getHorario() == Horario.MAÑANA))) {
                    modelolistaProfesor.addElement(profesor);
                }
            }// FIN while

        }// FIN IF DEL Menú Listar PROFESORES Tarde
        
        // Menú SALIR GESTIÓN
        if (e.getSource() == vista.getjMenuItemSalir()) {

            System.out.println("getjMenuItemSalir FUNCIONA");
            System.exit(0);

        }// FIN IF DEL BOTON SALIR GESTIÓN
        

    } //FIN actionPerformed(ActionEvent e)

} // FIN ControladorGUI

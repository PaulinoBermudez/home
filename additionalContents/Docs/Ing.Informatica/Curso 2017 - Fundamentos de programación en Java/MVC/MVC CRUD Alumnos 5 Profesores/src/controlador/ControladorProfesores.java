package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Profesor;
import modelo.ProfesorDAO;
import vista.VistaProfesores;

public class ControladorProfesores implements ActionListener, KeyListener {

    VistaProfesores vistaProfesores = new VistaProfesores();
    ProfesorDAO profesorDAO = new ProfesorDAO();

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorProfesores(VistaProfesores vistaProfesores, ProfesorDAO profesorDAO) {
        this.profesorDAO = profesorDAO;
        this.vistaProfesores = vistaProfesores;
        this.vistaProfesores.getBtnRegistrar().addActionListener(this);
        this.vistaProfesores.getBtnListar().addActionListener(this);
        this.vistaProfesores.getBtnEditar().addActionListener(this);
        this.vistaProfesores.getBtnEliminar().addActionListener(this);
        this.vistaProfesores.getBtnOKEditar().addActionListener(this);
        this.vistaProfesores.getBtnBuscar().addActionListener(this);
        this.vistaProfesores.getBtnLimpiar().addActionListener(this);
        this.vistaProfesores.getTxtBuscaApellido().addKeyListener(this);
        this.vistaProfesores.getTxtBuscaDNI().addKeyListener(this);
        this.vistaProfesores.getTxtDni().addKeyListener(this);
        this.vistaProfesores.getTxtNombre().addKeyListener(this);
        this.vistaProfesores.getTxtApellidos().addKeyListener(this);
        this.vistaProfesores.getTxtDireccion().addKeyListener(this);
    }

    public void LLenarTabla(JTable tablaD) {
        // Declaramos este ArrayList para asignarle
        // el ArrayList de alumnoDao.listarAlumnos()
        ArrayList<Profesor> listarProfesor = profesorDAO.listarProfesores();

        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);

        modeloT.addColumn("DNI");
        modeloT.addColumn("NOMBRE");
        modeloT.addColumn("APELLIDOS");
        modeloT.addColumn("FECHA N.");
        modeloT.addColumn("DIRECCION");

        Object[] columna = new Object[5];

        // El for recorre el ArrayList de este método. LLenarTabla
        for (int i = 0; i < listarProfesor.size(); i++) {
            columna[0] = listarProfesor.get(i).getDni();
            columna[1] = listarProfesor.get(i).getNombre();
            columna[2] = listarProfesor.get(i).getApellidos();
            columna[3] = listarProfesor.get(i).getFechaN();
            columna[4] = listarProfesor.get(i).getDireccion();
            modeloT.addRow(columna);
        }
    }

    public void LimpiarCampos() {
        vistaProfesores.getTxtDni().setText("");
        vistaProfesores.getTxtNombre().setText("");
        vistaProfesores.getTxtApellidos().setText("");
        vistaProfesores.getJdFechaN().setDate(null);
        vistaProfesores.getTxtDireccion().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Capturo los eventos del Boton Agregar
        if (e.getSource() == vistaProfesores.getBtnRegistrar()) {
            String dni = vistaProfesores.getTxtDni().getText();
            String nombre = vistaProfesores.getTxtNombre().getText();
            String apellidos = vistaProfesores.getTxtApellidos().getText();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = formatoFecha.format(vistaProfesores.getJdFechaN().getDate());
            String direccion = vistaProfesores.getTxtDireccion().getText();
            // Agrego un  Alumno como objeto.
            Profesor profesor = new Profesor(dni, nombre, apellidos, fecha, direccion);
            String rptaRegistro = profesorDAO.agregarProfesor(profesor);
            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
                LimpiarCampos();
                // Al hacer click se actualiza la Tabla
                LLenarTabla(vistaProfesores.getJtDatos());
            } else {
                JOptionPane.showMessageDialog(null, "Registro Erroneo.");
            }
        } // FIN Boton Agregar

        // Capturo los eventos del Boton Listar
        if (e.getSource() == vistaProfesores.getBtnListar()) {
            LLenarTabla(vistaProfesores.getJtDatos());
            JOptionPane.showMessageDialog(null, "Lista de registros.");
        }// FIN Boton Listar
        
        // Capturo los eventos del Boton Editar
        if (e.getSource() == vistaProfesores.getBtnEditar()) {
            int filaEditar = vistaProfesores.getJtDatos().getSelectedRow();
            int numfilas = vistaProfesores.getJtDatos().getSelectedRowCount();
            if (filaEditar >= 0 && numfilas == 1) {
                vistaProfesores.getTxtDni().setText(String.valueOf(vistaProfesores.getJtDatos().getValueAt(filaEditar, 0)));
                vistaProfesores.getTxtDni().setEditable(false);
                vistaProfesores.getBtnOKEditar().setEnabled(true);
                vistaProfesores.getBtnEditar().setEnabled(false);
                vistaProfesores.getBtnEliminar().setEnabled(false);
                vistaProfesores.getBtnRegistrar().setEnabled(false);
                vistaProfesores.getBtnListar().setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione registro a editar");
            }
        }// FIN Boton Editar

        // Capturo los eventos del Boton OKEditar
        if (e.getSource() == vistaProfesores.getBtnOKEditar()) {
            try {
                String dni = vistaProfesores.getTxtDni().getText();
                String nombre = vistaProfesores.getTxtNombre().getText();
                String apellidos = vistaProfesores.getTxtApellidos().getText();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = formatoFecha.format(vistaProfesores.getJdFechaN().getDate());
                String direccion = vistaProfesores.getTxtDireccion().getText();
                Profesor profesor = new Profesor(dni, nombre, apellidos, fecha, direccion);
                int rptEdit = profesorDAO.editarProfesor(profesor);
                if (rptEdit > 0) {
                    LimpiarCampos();
                    JOptionPane.showMessageDialog(null, "Edicion exitosa.");
                    // Al hacer click se actualiza la Tabla
                    LLenarTabla(vistaProfesores.getJtDatos());
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar edicion.");
                }
            } catch (HeadlessException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo realizar edición.");
            }
            vistaProfesores.getTxtDni().setEditable(true);
            vistaProfesores.getBtnOKEditar().setEnabled(false);
            vistaProfesores.getBtnEditar().setEnabled(true);
            vistaProfesores.getBtnEliminar().setEnabled(true);
            vistaProfesores.getBtnRegistrar().setEnabled(true);
            vistaProfesores.getBtnListar().setEnabled(true);
        }// FIN Boton OKEditar

        // Capturo los eventos del Boton Eliminar
        if (e.getSource() == vistaProfesores.getBtnEliminar()) {
            int filInicio = vistaProfesores.getJtDatos().getSelectedRow();
            int numfilas = vistaProfesores.getJtDatos().getSelectedRowCount();
            ArrayList<String> listaDni = new ArrayList<>();
            String dni;
            if (filInicio >= 0) {
                for (int i = 0; i < numfilas; i++) {
                    dni = String.valueOf(vistaProfesores.getJtDatos().getValueAt(i + filInicio, 0));
                    listaDni.add(i, dni);
                }
                for (int j = 0; j < numfilas; j++) {
                    int rpta = JOptionPane.showConfirmDialog(null, "Desea eliminar registro con dni: " + listaDni.get(j) + "? ");
                    if (rpta == 0) {
                        profesorDAO.eliminarProfesor(listaDni.get(j));
                    }
                }
                LLenarTabla(vistaProfesores.getJtDatos());
            } else {
                JOptionPane.showMessageDialog(null, "Elija al menos un registro para eliminar.");
            }
        }// FIN Boton Eliminar

        // Capturo los eventos del Boton BUSCAR
        if (e.getSource() == vistaProfesores.getBtnBuscar()) {
            String dni = vistaProfesores.getTxtDni().getText();
            Profesor profesor = profesorDAO.buscar(dni);

            if (profesor != null) {
                try {
                    vistaProfesores.getTxtNombre().setText(profesor.getNombre());
                    vistaProfesores.getTxtApellidos().setText(profesor.getApellidos());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date fecha = sdf.parse(profesor.getFechaN());
                    vistaProfesores.getJdFechaN().setDate(fecha);
                    vistaProfesores.getTxtDireccion().setText(profesor.getDireccion());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "No se Encuentra el profesor");
                }
            }
            vistaProfesores.getTxtDni().setEditable(true);
            vistaProfesores.getBtnOKEditar().setEnabled(true);
            vistaProfesores.getBtnEditar().setEnabled(false);
            vistaProfesores.getBtnEliminar().setEnabled(false);
            vistaProfesores.getBtnRegistrar().setEnabled(false);
            vistaProfesores.getBtnListar().setEnabled(false);
        }// FIN Boton BUSCAR
        
        // Captura del evento del boton Limpiar
        if (e.getSource() == vistaProfesores.getBtnLimpiar()) {
            System.out.println("getBtnLimpiar  FUNCIONA");
            LimpiarCampos();
            JOptionPane.showMessageDialog(null, "Campos Limpios.");
            
            vistaProfesores.getBtnRegistrar().setEnabled(true);
            vistaProfesores.getBtnListar().setEnabled(true);
            vistaProfesores.getBtnEliminar().setEnabled(true);
            vistaProfesores.getBtnEditar().setEnabled(true);
            vistaProfesores.getBtnOKEditar().setEnabled(true);
            vistaProfesores.getBtnBuscar().setEnabled(true);   
        }// FIN if getBtnLimpiar
        
        
    }// FIN ACTION PERFORMED

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == vistaProfesores.getTxtDni()) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();
            }
        }

        if (e.getSource() == vistaProfesores.getTxtApellidos() || e.getSource() == vistaProfesores.getTxtNombre() || e.getSource() == vistaProfesores.getTxtDireccion()) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE)) {
                e.consume();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        // BUSCAMOS POR APELLIDO
        if (e.getSource() == vistaProfesores.getTxtBuscaApellido()) {

            String apellidos = vistaProfesores.getTxtBuscaApellido().getText();
            ArrayList<Profesor> listaProfesor = profesorDAO.buscarProfesorApellido(apellidos);

            DefaultTableModel modeloT = new DefaultTableModel();
            vistaProfesores.getJtDatos().setModel(modeloT);

            modeloT.addColumn("DNI");
            modeloT.addColumn("NOMBRE");
            modeloT.addColumn("APELLIDOS");
            modeloT.addColumn("FECHA N.");
            modeloT.addColumn("DIRECCION.");

            Object[] columna = new Object[5];

            for (int i = 0; i < listaProfesor.size(); i++) {
                columna[0] = listaProfesor.get(i).getDni();
                columna[1] = listaProfesor.get(i).getNombre();
                columna[2] = listaProfesor.get(i).getApellidos();
                columna[3] = listaProfesor.get(i).getFechaN();
                columna[4] = listaProfesor.get(i).getDireccion();
                modeloT.addRow(columna);
            }
        }

        // BUSCAMOS POR DNI
        if (e.getSource() == vistaProfesores.getTxtBuscaDNI()) {

            String dni = vistaProfesores.getTxtBuscaDNI().getText();
            ArrayList<Profesor> listaProfesor = profesorDAO.buscarProfesorDNI(dni);

            DefaultTableModel modeloT = new DefaultTableModel();
            vistaProfesores.getJtDatos().setModel(modeloT);

            modeloT.addColumn("DNI");
            modeloT.addColumn("NOMBRE");
            modeloT.addColumn("APELLIDOS");
            modeloT.addColumn("FECHA N.");
            modeloT.addColumn("DIRECCION.");

            Object[] columna = new Object[5];

            for (int i = 0; i < listaProfesor.size(); i++) {
                columna[0] = listaProfesor.get(i).getDni();
                columna[1] = listaProfesor.get(i).getNombre();
                columna[2] = listaProfesor.get(i).getApellidos();
                columna[3] = listaProfesor.get(i).getFechaN();
                columna[4] = listaProfesor.get(i).getDireccion();
                modeloT.addRow(columna);
            }
        }
    }
}

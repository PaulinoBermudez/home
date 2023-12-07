package controlador;

import java.awt.HeadlessException;
import modelo.Alumno;
import modelo.AlumnoDAO;
import vista.VistaAlumnos;
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

public class ControladorAlumnos implements ActionListener, KeyListener {

    VistaAlumnos vistaAlumnos = new VistaAlumnos();
    AlumnoDAO alumnoDao = new AlumnoDAO();

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorAlumnos(VistaAlumnos vistaAlumnos, AlumnoDAO alumnoDao) {
        this.alumnoDao = alumnoDao;
        this.vistaAlumnos = vistaAlumnos;
        this.vistaAlumnos.getBtnRegistrar().addActionListener(this);
        this.vistaAlumnos.getBtnListar().addActionListener(this);
        this.vistaAlumnos.getBtnEditar().addActionListener(this);
        this.vistaAlumnos.getBtnEliminar().addActionListener(this);
        this.vistaAlumnos.getBtnOKEditar().addActionListener(this);
        this.vistaAlumnos.getBtnBuscar().addActionListener(this);
        this.vistaAlumnos.getBtnLimpiar().addActionListener(this);
        this.vistaAlumnos.getTxtBuscaApellido().addKeyListener(this);
        this.vistaAlumnos.getTxtBuscaDNI().addKeyListener(this);
        this.vistaAlumnos.getTxtDni().addKeyListener(this);
        this.vistaAlumnos.getTxtNombre().addKeyListener(this);
        this.vistaAlumnos.getTxtApellidos().addKeyListener(this);
        this.vistaAlumnos.getTxtDireccion().addKeyListener(this);
    }

    public void LLenarTabla(JTable tablaD) {
        // Declaramos este ArrayList para asignarle
        // el ArrayList de alumnoDao.listarAlumnos()
        ArrayList<Alumno> listaAlumno = alumnoDao.listarAlumnos();

        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);

        modeloT.addColumn("DNI");
        modeloT.addColumn("NOMBRE");
        modeloT.addColumn("APELLIDOS");
        modeloT.addColumn("FECHA N.");
        modeloT.addColumn("DIRECCION");

        Object[] columna = new Object[5];

        // El for recorre el ArrayList de este método. LLenarTabla
        for (int i = 0; i < listaAlumno.size(); i++) {
            columna[0] = listaAlumno.get(i).getDni();
            columna[1] = listaAlumno.get(i).getNombre();
            columna[2] = listaAlumno.get(i).getApellidos();
            columna[3] = listaAlumno.get(i).getFechaN();
            columna[4] = listaAlumno.get(i).getDireccion();
            modeloT.addRow(columna);
        }
    }

    public void LimpiarCampos() {
        vistaAlumnos.getTxtDni().setText("");
        vistaAlumnos.getTxtNombre().setText("");
        vistaAlumnos.getTxtApellidos().setText("");
        vistaAlumnos.getJdFechaN().setDate(null);
        vistaAlumnos.getTxtDireccion().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Capturo los eventos del Boton Agregar
        if (e.getSource() == vistaAlumnos.getBtnRegistrar()) {
            String dni = vistaAlumnos.getTxtDni().getText();
            String nombre = vistaAlumnos.getTxtNombre().getText();
            String apellidos = vistaAlumnos.getTxtApellidos().getText();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = formatoFecha.format(vistaAlumnos.getJdFechaN().getDate());
            String direccion = vistaAlumnos.getTxtDireccion().getText();
            // Agrego un  Alumno como objeto.
            Alumno alumno = new Alumno(dni, nombre, apellidos, fecha, direccion);
            String rptaRegistro = alumnoDao.agregarAlumno(alumno);
            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
                LimpiarCampos();
                // Al hacer click se actualiza la Tabla
           //     LLenarTabla(vistaAlumnos.getJtDatos());
            } else {
                JOptionPane.showMessageDialog(null, "Registro Erroneo.");
            }
        }// FIN Boton Agregar

        // Capturo los eventos del Boton Listar
        if (e.getSource() == vistaAlumnos.getBtnListar()) {
            LLenarTabla(vistaAlumnos.getJtDatos());
            JOptionPane.showMessageDialog(null, "Lista de registros.");
        }// FIN Boton Listar
        
        // Capturo los eventos del Boton Editar
        if (e.getSource() == vistaAlumnos.getBtnEditar()) {
            int filaEditar = vistaAlumnos.getJtDatos().getSelectedRow();
            int numfilas = vistaAlumnos.getJtDatos().getSelectedRowCount();
            if (filaEditar >= 0 && numfilas == 1) {
                vistaAlumnos.getTxtDni().setText(String.valueOf(vistaAlumnos.getJtDatos().getValueAt(filaEditar, 0)));
                vistaAlumnos.getTxtDni().setEditable(false);
                vistaAlumnos.getBtnOKEditar().setEnabled(true);
                vistaAlumnos.getBtnEditar().setEnabled(false);
                vistaAlumnos.getBtnEliminar().setEnabled(false);
                vistaAlumnos.getBtnRegistrar().setEnabled(false);
                vistaAlumnos.getBtnListar().setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione registro a editar");
            }
        }// FIN Boton Editar

        // Capturo los eventos del Boton OKEditar
        if (e.getSource() == vistaAlumnos.getBtnOKEditar()) {
            try {
                String dni = vistaAlumnos.getTxtDni().getText();
                String nombre = vistaAlumnos.getTxtNombre().getText();
                String apellidos = vistaAlumnos.getTxtApellidos().getText();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = formatoFecha.format(vistaAlumnos.getJdFechaN().getDate());
                String direccion = vistaAlumnos.getTxtDireccion().getText();
                Alumno alumno = new Alumno(dni, nombre, apellidos, fecha, direccion);
                int rptEdit = alumnoDao.editarAlumno(alumno);
                if (rptEdit > 0) {
                    LimpiarCampos();
                    JOptionPane.showMessageDialog(null, "Edicion exitosa.");
                    // Al hacer click se actualiza la Tabla
                    LLenarTabla(vistaAlumnos.getJtDatos());
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar edicion.");
                }
            } catch (HeadlessException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo realizar edición.");
            }
            vistaAlumnos.getTxtDni().setEditable(true);
            vistaAlumnos.getBtnOKEditar().setEnabled(false);
            vistaAlumnos.getBtnEditar().setEnabled(true);
            vistaAlumnos.getBtnEliminar().setEnabled(true);
            vistaAlumnos.getBtnRegistrar().setEnabled(true);
            vistaAlumnos.getBtnListar().setEnabled(true);
        }// FIN Boton OKEditar

        // Capturo los eventos del Boton Eliminar
        if (e.getSource() == vistaAlumnos.getBtnEliminar()) {
            int filInicio = vistaAlumnos.getJtDatos().getSelectedRow();
            int numfilas = vistaAlumnos.getJtDatos().getSelectedRowCount();
            ArrayList<String> listaDni = new ArrayList<>();
            String dni;
            if (filInicio >= 0) {
                for (int i = 0; i < numfilas; i++) {
                    dni = String.valueOf(vistaAlumnos.getJtDatos().getValueAt(i + filInicio, 0));
                    listaDni.add(i, dni);
                }
                for (int j = 0; j < numfilas; j++) {
                    int rpta = JOptionPane.showConfirmDialog(null, "Desea eliminar registro con dni: " + listaDni.get(j) + "? ");
                    if (rpta == 0) {
                        alumnoDao.eliminarAlumno(listaDni.get(j));
                    }
                }
                LLenarTabla(vistaAlumnos.getJtDatos());
            } else {
                JOptionPane.showMessageDialog(null, "Elija al menos un registro para eliminar.");
            }
        }// FIN Boton Eliminar

        // Capturo los eventos del Boton BUSCAR
        if (e.getSource() == vistaAlumnos.getBtnBuscar()) {
            String dni = vistaAlumnos.getTxtDni().getText();
            Alumno alumno = alumnoDao.buscar(dni);

            if (alumno != null) {
                try {
                    vistaAlumnos.getTxtNombre().setText(alumno.getNombre());
                    vistaAlumnos.getTxtApellidos().setText(alumno.getApellidos());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date fecha = sdf.parse(alumno.getFechaN());
                    vistaAlumnos.getJdFechaN().setDate(fecha);
                    vistaAlumnos.getTxtDireccion().setText(alumno.getDireccion());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "No se Encuentra el alumno");
                }
            }
            vistaAlumnos.getTxtDni().setEditable(true);
            vistaAlumnos.getBtnOKEditar().setEnabled(true);
            vistaAlumnos.getBtnEditar().setEnabled(false);
            vistaAlumnos.getBtnEliminar().setEnabled(false);
            vistaAlumnos.getBtnRegistrar().setEnabled(false);
            vistaAlumnos.getBtnListar().setEnabled(false);
        }// FIN Boton BUSCAR
        
        // Captura del evento del boton Limpiar
        if (e.getSource() == vistaAlumnos.getBtnLimpiar()) {
            System.out.println("getBtnLimpiar  FUNCIONA");
            LimpiarCampos();
            JOptionPane.showMessageDialog(null, "Campos Limpios.");
            
            vistaAlumnos.getBtnRegistrar().setEnabled(true);
            vistaAlumnos.getBtnListar().setEnabled(true);
            vistaAlumnos.getBtnEliminar().setEnabled(true);
            vistaAlumnos.getBtnEditar().setEnabled(true);
            vistaAlumnos.getBtnOKEditar().setEnabled(true);
            vistaAlumnos.getBtnBuscar().setEnabled(true);   
        }// FIN if getBtnLimpiar
    }// FIN ACTION PERMORMED

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == vistaAlumnos.getTxtDni()) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();
            }
        }

        if (e.getSource() == vistaAlumnos.getTxtApellidos() || e.getSource() == vistaAlumnos.getTxtNombre() || e.getSource() == vistaAlumnos.getTxtDireccion()) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE)) {
                e.consume();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        // BUSCAMOS POR APELLIDO
        if (e.getSource() == vistaAlumnos.getTxtBuscaApellido()) {

            String apellidos = vistaAlumnos.getTxtBuscaApellido().getText();
            ArrayList<Alumno> listaAlumno = alumnoDao.buscarAlumnoApellido(apellidos);

            DefaultTableModel modeloT = new DefaultTableModel();
            vistaAlumnos.getJtDatos().setModel(modeloT);

            modeloT.addColumn("DNI");
            modeloT.addColumn("NOMBRE");
            modeloT.addColumn("APELLIDOS");
            modeloT.addColumn("FECHA N.");
            modeloT.addColumn("DIRECCION.");

            Object[] columna = new Object[5];

            for (int i = 0; i < listaAlumno.size(); i++) {
                columna[0] = listaAlumno.get(i).getDni();
                columna[1] = listaAlumno.get(i).getNombre();
                columna[2] = listaAlumno.get(i).getApellidos();
                columna[3] = listaAlumno.get(i).getFechaN();
                columna[4] = listaAlumno.get(i).getDireccion();
                modeloT.addRow(columna);
            }
        }

        // BUSCAMOS POR DNI
        if (e.getSource() == vistaAlumnos.getTxtBuscaDNI()) {

            String dni = vistaAlumnos.getTxtBuscaDNI().getText();
            ArrayList<Alumno> listaAlumno = alumnoDao.buscarAlumnoDNI(dni);

            DefaultTableModel modeloT = new DefaultTableModel();
            vistaAlumnos.getJtDatos().setModel(modeloT);

            modeloT.addColumn("DNI");
            modeloT.addColumn("NOMBRE");
            modeloT.addColumn("APELLIDOS");
            modeloT.addColumn("FECHA N.");
            modeloT.addColumn("DIRECCION.");

            Object[] columna = new Object[5];

            for (int i = 0; i < listaAlumno.size(); i++) {
                columna[0] = listaAlumno.get(i).getDni();
                columna[1] = listaAlumno.get(i).getNombre();
                columna[2] = listaAlumno.get(i).getApellidos();
                columna[3] = listaAlumno.get(i).getFechaN();
                columna[4] = listaAlumno.get(i).getDireccion();
                modeloT.addRow(columna);
            }
        }
    }
}

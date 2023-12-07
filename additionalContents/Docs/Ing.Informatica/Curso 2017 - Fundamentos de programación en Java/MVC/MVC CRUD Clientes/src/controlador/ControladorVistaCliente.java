package controlador;

import dao.ClienteDao;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

import vista.VistaCliente;

public class ControladorVistaCliente implements ActionListener, KeyListener {

    private VistaCliente vistaCliente = new VistaCliente();
    private ClienteDao clienteDao = new ClienteDao();

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorVistaCliente(VistaCliente vistaCliente, ClienteDao clienteDao) {
        // Parametros
        this.vistaCliente = vistaCliente;
        this.clienteDao = clienteDao;
        // Action Listener DE LOS BOTONES
        this.vistaCliente.getBtnAgregar().addActionListener(this);
        this.vistaCliente.getBtnBuscar().addActionListener(this);
        this.vistaCliente.getBtnEditar().addActionListener(this);
        this.vistaCliente.getBtnEliminar().addActionListener(this);
        this.vistaCliente.getBtnOKEditar().addActionListener(this);
        this.vistaCliente.getBtnListar().addActionListener(this);
        this.vistaCliente.getBtnLimpiar().addActionListener(this);
        // Key Listener DE LOS CAMPOS
        this.vistaCliente.getTxtNombre().addKeyListener(this);
        this.vistaCliente.getTxtApellidos().addKeyListener(this);
        this.vistaCliente.getTxtDni().addKeyListener(this);
        this.vistaCliente.getTxtBuscaDNI().addKeyListener(this);
        this.vistaCliente.getTxtBuscaApellido().addKeyListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        // Captura del evento del boton Agregar
        if (e.getSource() == vistaCliente.getBtnAgregar()) {
            System.out.println("getBtnAgregar CLIENTES FUNCIONA");
            String dni = vistaCliente.getTxtDni().getText();
            String nombre = vistaCliente.getTxtNombre().getText();
            String apellidos = vistaCliente.getTxtApellidos().getText();
            // Agrego un  Cliente como objeto.
            Cliente cliente = new Cliente(dni, nombre, apellidos);
            String rptaRegistro = clienteDao.agregar(cliente);
            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
                LimpiarCampos();
                // Al hacer click se actualiza la Tabla
                LLenarTabla(vistaCliente.getJtDatos());
            } else {
                JOptionPane.showMessageDialog(null, "Registro Erroneo.");
            }
        }// FIN if getBtnAgregar

        // Captura del evento del boton Buscar
        if (e.getSource() == vistaCliente.getBtnBuscar()) {
            System.out.println("getBtnBuscar CLIENTES FUNCIONA");
            String dni = vistaCliente.getTxtDni().getText();
            Cliente cliente = clienteDao.buscar(dni);
            if (cliente != null) {
                try {
                    vistaCliente.getTxtNombre().setText(cliente.getNombre());
                    vistaCliente.getTxtApellidos().setText(cliente.getApellidos());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se Encuentra el Cliente");
                }
            }
            vistaCliente.getTxtDni().setEditable(true);
            vistaCliente.getBtnOKEditar().setEnabled(true);
            vistaCliente.getBtnEditar().setEnabled(false);
            vistaCliente.getBtnEliminar().setEnabled(false);
            vistaCliente.getBtnAgregar().setEnabled(false);
            vistaCliente.getBtnListar().setEnabled(false);
        }// FIN if getBtnBuscar

        // Captura del evento del boton Editar
        if (e.getSource() == vistaCliente.getBtnEditar()) {
            System.out.println("getBtnEditar CLIENTES FUNCIONA");
            int filaEditar = vistaCliente.getJtDatos().getSelectedRow();
            int numfilas = vistaCliente.getJtDatos().getSelectedRowCount();
            if (filaEditar >= 0 && numfilas == 1) {
                
                vistaCliente.getTxtDni().setText(String.valueOf(vistaCliente.getJtDatos().getValueAt(filaEditar, 0)));
                vistaCliente.getTxtNombre().setText(String.valueOf(vistaCliente.getJtDatos().getValueAt(filaEditar, 1)));
                vistaCliente.getTxtApellidos().setText(String.valueOf(vistaCliente.getJtDatos().getValueAt(filaEditar, 2)));
                
                vistaCliente.getTxtDni().setEditable(false);
                vistaCliente.getBtnOKEditar().setEnabled(true);
                vistaCliente.getBtnEditar().setEnabled(false);
                vistaCliente.getBtnEliminar().setEnabled(false);
                vistaCliente.getBtnAgregar().setEnabled(false);
                vistaCliente.getBtnListar().setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione registro a editar");
            }
        }// FIN if getBtnEditar

        // Captura del evento del boton Eliminar
        if (e.getSource() == vistaCliente.getBtnEliminar()) {
            System.out.println("getBtnEliminar CLIENTES FUNCIONA");
            int filInicio = vistaCliente.getJtDatos().getSelectedRow();
            int numfilas = vistaCliente.getJtDatos().getSelectedRowCount();
            ArrayList<String> listaDni = new ArrayList<>();
            String dni;
            if (filInicio >= 0) {
                for (int i = 0; i < numfilas; i++) {
                    dni = String.valueOf(vistaCliente.getJtDatos().getValueAt(i + filInicio, 0));
                    listaDni.add(i, dni);
                }
                for (int j = 0; j < numfilas; j++) {
                    int rpta = JOptionPane.showConfirmDialog(null, "Desea eliminar registro con dni: " + listaDni.get(j) + "? ");
                    if (rpta == 0) {
                        clienteDao.eliminar(listaDni.get(j));
                    }
                }
                LLenarTabla(vistaCliente.getJtDatos());
            } else {
                JOptionPane.showMessageDialog(null, "Elija al menos un registro para eliminar.");
            }
        }// FIN if getBtnEliminar

        // Captura del evento del boton OKEditar
        if (e.getSource() == vistaCliente.getBtnOKEditar()) {
            System.out.println("getBtnOKEditar CLIENTES FUNCIONA");
            try {
                String dni = vistaCliente.getTxtDni().getText();
                String nombre = vistaCliente.getTxtNombre().getText();
                String apellidos = vistaCliente.getTxtApellidos().getText();
                // Agrego un  Cliente como objeto.
                Cliente cliente = new Cliente(dni, nombre, apellidos);
                int rptEdit = clienteDao.actualizar(cliente);
                if (rptEdit > 0) {
                    LimpiarCampos();
                    JOptionPane.showMessageDialog(null, "Edición exitosa.");
                    // Al hacer click se actualiza la Tabla
                    LLenarTabla(vistaCliente.getJtDatos());
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar edición.");
                }
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo realizar edición.");
            }
            vistaCliente.getTxtDni().setEditable(true);
            vistaCliente.getBtnOKEditar().setEnabled(false);
            vistaCliente.getBtnEditar().setEnabled(true);
            vistaCliente.getBtnEliminar().setEnabled(true);
            vistaCliente.getBtnAgregar().setEnabled(true);
            vistaCliente.getBtnListar().setEnabled(true);
        }// FIN if getBtnOKEditar

        // Captura del evento del boton Listar
        if (e.getSource() == vistaCliente.getBtnListar()) {
            System.out.println("getBtnListar CLIENTES FUNCIONA");
            LLenarTabla(vistaCliente.getJtDatos());
            JOptionPane.showMessageDialog(null, "Lista de registros.");
        }// FIN if getBtnListar

        // Captura del evento del boton Limpiar
        if (e.getSource() == vistaCliente.getBtnLimpiar()) {
            System.out.println("getBtnLimpiar  FUNCIONA");
            LimpiarCampos();
            JOptionPane.showMessageDialog(null, "Campos Limpios.");

            vistaCliente.getBtnAgregar().setEnabled(true);
            vistaCliente.getBtnListar().setEnabled(true);
            vistaCliente.getBtnEliminar().setEnabled(true);
            vistaCliente.getBtnEditar().setEnabled(true);
            vistaCliente.getBtnOKEditar().setEnabled(true);
            vistaCliente.getBtnBuscar().setEnabled(true);
        }// FIN if getBtnLimpiar

    }// FIN de los actionPerformed

    // Metodo para limpiar los campos
    public void LimpiarCampos() {
        vistaCliente.getTxtDni().setText("");
        vistaCliente.getTxtNombre().setText("");
        vistaCliente.getTxtApellidos().setText("");
    }

    // Rellenamos la Jtable
    public void LLenarTabla(JTable tablaD) {
        // Declaramos este ArrayList para asignarle
        // el ArrayList de alumnoDao.listarAlumnos()
        ArrayList<Cliente> listaCliente = clienteDao.listar();
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("DNI");
        modeloT.addColumn("NOMBRE");
        modeloT.addColumn("APELLIDOS");
        Object[] columna = new Object[3];

        // El for recorre el ArrayList de este método. LLenarTabla
        for (int i = 0; i < listaCliente.size(); i++) {
            columna[0] = listaCliente.get(i).getDni();
            columna[1] = listaCliente.get(i).getNombre();
            columna[2] = listaCliente.get(i).getApellidos();
            modeloT.addRow(columna);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == vistaCliente.getTxtDni()) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();
            }
        }
        if (e.getSource() == vistaCliente.getTxtApellidos() || e.getSource() == vistaCliente.getTxtNombre()) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE)) {
                e.consume();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        // BUSCAMOS POR APELLIDO
        if (e.getSource() == vistaCliente.getTxtBuscaApellido()) {
            String apellidos = vistaCliente.getTxtBuscaApellido().getText();
            DefaultTableModel modeloT = new DefaultTableModel();
            vistaCliente.getJtDatos().setModel(modeloT);
            modeloT.addColumn("DNI");
            modeloT.addColumn("NOMBRE");
            modeloT.addColumn("APELLIDOS");
            Object[] columna = new Object[3];
            int numRegistros = clienteDao.buscarCliente(apellidos).size();
            for (int i = 0; i < numRegistros; i++) {
                columna[0] = clienteDao.buscarCliente(apellidos).get(i).getDni();
                columna[1] = clienteDao.buscarCliente(apellidos).get(i).getNombre();
                columna[2] = clienteDao.buscarCliente(apellidos).get(i).getApellidos();
                modeloT.addRow(columna);
            }
        }

        // BUSCAMOS POR DNI
        if (e.getSource() == vistaCliente.getTxtBuscaDNI()) {
            String dni = vistaCliente.getTxtBuscaDNI().getText();
            DefaultTableModel modeloT = new DefaultTableModel();
            vistaCliente.getJtDatos().setModel(modeloT);
            modeloT.addColumn("DNI");
            modeloT.addColumn("NOMBRE");
            modeloT.addColumn("APELLIDOS");
            Object[] columna = new Object[3];
            int numRegistros = clienteDao.buscarClienteDNI(dni).size();
            for (int i = 0; i < numRegistros; i++) {
                columna[0] = clienteDao.buscarClienteDNI(dni).get(i).getDni();
                columna[1] = clienteDao.buscarClienteDNI(dni).get(i).getNombre();
                columna[2] = clienteDao.buscarClienteDNI(dni).get(i).getApellidos();
                modeloT.addRow(columna);
            }
        }
    }
}

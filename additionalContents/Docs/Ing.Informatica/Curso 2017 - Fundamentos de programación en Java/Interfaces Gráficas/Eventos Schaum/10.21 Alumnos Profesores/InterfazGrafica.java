
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

/**
 * @(#)InterfazGrafica.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/25
 */
public class InterfazGrafica extends JFrame {

    private Aplicacion aplicacion;
    private JButton agregar;
    private JButton visualizar;
    private DefaultListModel modelolistaAlumno;
    private DefaultListModel modelolistaProfesor;

    public InterfazGrafica(Aplicacion aplicacion) {

        this.aplicacion = aplicacion;

        OyenteVisualizarAlumno OyenteVisualizarAlumno = new OyenteVisualizarAlumno();
        OyenteVisualizarProfesor oyenteVisualizarProfesor = new OyenteVisualizarProfesor();
        OyenteHorarioAlumno OyenteHorarioAlumno = new OyenteHorarioAlumno();
        OyenteHorarioProfesor oyenteHorarioProfesor = new OyenteHorarioProfesor();

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        modelolistaAlumno = new DefaultListModel();
        modelolistaProfesor = new DefaultListModel();

        JList listaAlumno = new JList(modelolistaAlumno);
        panel.add(new JScrollPane(listaAlumno));

        JList listaProfesor = new JList(modelolistaProfesor);
        panel.add(new JScrollPane(listaProfesor));

        // Panel para visualizar los datos del Alumno
        JPanel panel2 = new JPanel();

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.setBorder(new EmptyBorder(0, 10, 10, 10));
        agregar = new JButton("Agregar Alumno");
        agregar.setMnemonic('A');
        agregar.addActionListener(new OyenteAgregarAlumno());
        visualizar = new JButton("Visualizar");
        visualizar.setMnemonic('V');
        visualizar.addActionListener(OyenteVisualizarAlumno);
        panel2.add(Box.createHorizontalGlue());
        panel2.add(agregar);
        panel2.add(Box.createRigidArea(new Dimension(10, 0)));
        panel2.add(visualizar);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        add(panel);
        add(panel2);

        // Panel para visualizar los datos del Profesor
        JPanel panel3 = new JPanel();

        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel3.setBorder(new EmptyBorder(0, 10, 10, 10));
        agregar = new JButton("Agregar Profesor");
        agregar.setMnemonic('P');
        agregar.addActionListener(new OyenteAgregarProfesor());
        visualizar = new JButton("Visualizar");
        visualizar.setMnemonic('i');
        visualizar.addActionListener(oyenteVisualizarProfesor);
        panel3.add(Box.createHorizontalGlue());
        panel3.add(agregar);
        panel3.add(Box.createRigidArea(new Dimension(10, 0)));
        panel3.add(visualizar);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        add(panel);
        add(panel3);

        // Menus
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuOpciones = new JMenu("Menu de opciones");

        JMenuItem listaAlumnos = new JMenuItem("Listar todos los Alumnos");
        listaAlumnos.addActionListener(OyenteVisualizarAlumno);
        menuOpciones.add(listaAlumnos);

        JMenuItem listaProfesores = new JMenuItem("Listar todos los Profesores");
        listaProfesores.addActionListener(oyenteVisualizarProfesor);
        menuOpciones.add(listaProfesores);

        // Separador
        menuOpciones.add(new JSeparator());

        // Lista Alumnos Tarde
        JMenuItem listaAlumnosTarde = new JMenuItem("Ver Alumnos de la tarde");
        listaAlumnosTarde.setActionCommand("tarde");
        listaAlumnosTarde.addActionListener(OyenteHorarioAlumno);
        menuOpciones.add(listaAlumnosTarde);

        // Lista Alumnos mañana
        JMenuItem listaAlumnosMañana = new JMenuItem("Ver Alumnos de la mañana");
        listaAlumnosMañana.setActionCommand("mañana");
        listaAlumnosMañana.addActionListener(OyenteHorarioAlumno);
        menuOpciones.add(listaAlumnosMañana);

        // Lista Profesores Tarde
        JMenuItem listaProfesoresTarde = new JMenuItem("Ver Profesores de la tarde");
        listaProfesoresTarde.setActionCommand("tarde");
        listaProfesoresTarde.addActionListener(oyenteHorarioProfesor);
        menuOpciones.add(listaProfesoresTarde);

        // Lista Profesores mañana
        JMenuItem listaProfesoresMañana = new JMenuItem("Ver Profesores de la mañana");
        listaProfesoresMañana.setActionCommand("mañana");
        listaProfesoresMañana.addActionListener(oyenteHorarioProfesor);
        menuOpciones.add(listaProfesoresMañana);

        barraMenu.add(menuOpciones);

        // Establecer como barra de menus en contenedor de alto nivel
        setJMenuBar(barraMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestion de Alumnos y Profesores");
        setSize(500, 400);
        setVisible(true);
    }

    /*
	 *  Se incluyen tres clases de oyentes que responden a las
	 * acciones de agregar un nuevo alumno (OyenteAgregarAlumno),
	 * visualizar en la lista los alumnos existentes (OyenteVisualizarAlumno)
	 * o visualizar en la lista los alumnos en funci�n del turno
	 * al que correspondan (OyenteHorarioAlumno). La ventaja de que sean
	 * clases internas es que tienen acceso directo a los miembros
	 * de la clase InterfazGrafica de modo que no hay que crear los
	 * metodos de acceso correspondientes.
     */
    class OyenteAgregarAlumno implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            boolean error = false;
            PanelDatosAlumno panel = new PanelDatosAlumno();
            if (JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Introduzca datos de Alumno",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            ) == JOptionPane.OK_OPTION) {
                String nombre = panel.campoNombre.getText();
                String apellidos = panel.campoApellidos.getText();
                int año = 0;
                try {
                    año = Integer.parseInt(panel.campoAño.getText()
                    );
                } catch (Exception e) {
                    error = true;
                }
                error = error || (nombre.length() == 0) || (apellidos.length() == 0);
                if (error) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Campo vacio o error en formato de numero",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                Horario turno;

                if (panel.mañana.isSelected()) {
                    turno = Horario.MAÑANA;
                } else {
                    turno = Horario.TARDE;
                }
                if (!error) {
                    Alumno alumno = new Alumno(nombre, apellidos, año, turno);
                    aplicacion.agregarAlumno(alumno);
                }
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Operacion no realizada",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//OyenteAgregarAlumno	

    class OyenteAgregarProfesor implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            boolean error = false;
            PanelDatosProfesor panel = new PanelDatosProfesor();
            if (JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Introduzca datos de Profesor",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            ) == JOptionPane.OK_OPTION) {
                String nombre = panel.campoNombre.getText();
                String apellidos = panel.campoApellidos.getText();
                int dni = 0;
                try {
                    dni = Integer.parseInt(panel.campoDNI.getText());
                } catch (Exception e) {
                    error = true;
                }
                error = error || (nombre.length() == 0) || (apellidos.length() == 0);
                if (error) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Campo vacio o error en formato de numero",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                Horario turno;

                if (panel.mañana.isSelected()) {
                    turno = Horario.MAÑANA;
                } else {
                    turno = Horario.TARDE;
                }
                if (!error) {
                    Profesor profesor = new Profesor(nombre, apellidos, dni, turno);
                    aplicacion.agregarProfesor(profesor);
                }
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Operacion no realizada",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//OyenteAgregarProfesor

    class OyenteVisualizarAlumno implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            modelolistaAlumno.clear();
            Iterator iterador = aplicacion.dameAlumnos().listIterator();
            while (iterador.hasNext()) {
                modelolistaAlumno.addElement(iterador.next());
            }
        }
    } //OyenteVisualizarAlumno

    class OyenteVisualizarProfesor implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            modelolistaProfesor.clear();
            Iterator iterador = aplicacion.dameProfesores().listIterator();
            while (iterador.hasNext()) {
                modelolistaProfesor.addElement(iterador.next());
            }
        }
    } //OyenteVisualizarProfesor

    class OyenteHorarioAlumno implements ActionListener {

        public void actionPerformed(ActionEvent evento) {

            Alumno alumno;
            String accion = evento.getActionCommand();
            modelolistaAlumno.clear();
            Iterator iterador = aplicacion.dameAlumnos().listIterator();

            while (iterador.hasNext()) {

                alumno = (Alumno) iterador.next();
                if (((accion.equals("tarde")) && (alumno.getHorario() == Horario.TARDE))
                        || ((accion.equals("mañana")) && (alumno.getHorario() == Horario.MAÑANA))) {
                    modelolistaAlumno.addElement(alumno);
                }
            }
        }
    }

    class OyenteHorarioProfesor implements ActionListener {

        public void actionPerformed(ActionEvent evento) {

            Profesor profesor;
            String accion = evento.getActionCommand();
            modelolistaProfesor.clear();
            Iterator iterador = aplicacion.dameProfesores().listIterator();

            while (iterador.hasNext()) {

                profesor = (Profesor) iterador.next();
                if (((accion.equals("tarde")) && (profesor.getHorario() == Horario.TARDE))
                        || ((accion.equals("mañana")) && (profesor.getHorario() == Horario.MAÑANA))) {
                    modelolistaProfesor.addElement(profesor);
                }
            }
        }
    }
}

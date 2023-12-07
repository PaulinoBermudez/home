
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
 * @author
 * @version 1.00 2017/4/25
 */
public class InterfazGrafica extends JFrame {

    private Aplicacion aplicacion;
    private JButton agregar;
    private JButton visualizar;
    private DefaultListModel modeloLista;

    public InterfazGrafica(Aplicacion aplicacion) {

        this.aplicacion = aplicacion;
        OyenteVisualizar oyenteVisualizar = new OyenteVisualizar();
        OyenteHorario oyenteHorario = new OyenteHorario();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        modeloLista = new DefaultListModel();
        JList lista = new JList(modeloLista);
        panel.add(new JScrollPane(lista));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.setBorder(new EmptyBorder(0, 10, 10, 10));
        agregar = new JButton("Agregar");
        agregar.setMnemonic('A');
        agregar.addActionListener(new OyenteNuevo());
        visualizar = new JButton("Visualizar");
        visualizar.setMnemonic('V');
        visualizar.addActionListener(oyenteVisualizar);
        panel2.add(Box.createHorizontalGlue());
        panel2.add(agregar);
        panel2.add(Box.createRigidArea(new Dimension(10, 0)));
        panel2.add(visualizar);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        add(panel);
        add(panel2);

        // menus
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuOpciones = new JMenu("Menu de opciones");
        JMenuItem listar = new JMenuItem("Listar todos los alumnos");
        listar.addActionListener(oyenteVisualizar);
        menuOpciones.add(listar);

        // separador
        menuOpciones.add(new JSeparator());

        JMenuItem listarTarde = new JMenuItem("Ver alumnos de la tarde");
        listarTarde.setActionCommand("tarde");
        listarTarde.addActionListener(oyenteHorario);
        menuOpciones.add(listarTarde);
        JMenuItem listarMañana = new JMenuItem("Ver alumnos de la mañana");
        listarMañana.setActionCommand("mañana");
        listarMañana.addActionListener(oyenteHorario);
        menuOpciones.add(listarMañana);
        barraMenu.add(menuOpciones);

        // establecer como barra de menus en contenedor de alto nivel
        setJMenuBar(barraMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestion de alumnos");
        setSize(500, 250);
        setVisible(true);
    }

    class OyenteNuevo implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            boolean error = false;
            PanelDatosAlumno panel = new PanelDatosAlumno();
            if (JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Introduzca datos",
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
    }//OyenteNuevo

    class OyenteVisualizar implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            modeloLista.clear();
            Iterator iterador = aplicacion.dameContenido().listIterator();
            while (iterador.hasNext()) {
                modeloLista.addElement(iterador.next());
            }
        }
    } //OyenteVisualizar

    class OyenteHorario implements ActionListener {

        public void actionPerformed(ActionEvent evento) {

            Alumno alumno;
            String accion = evento.getActionCommand();
            modeloLista.clear();
            Iterator iterador = aplicacion.dameContenido().listIterator();

            while (iterador.hasNext()) {

                alumno = (Alumno) iterador.next();
                if (((accion.equals("tarde")) && (alumno.getHorario() == Horario.TARDE))
                        || ((accion.equals("mañana")) && (alumno.getHorario() == Horario.MAÑANA))) {
                    modeloLista.addElement(alumno);
                }
            }
        }
    }
}

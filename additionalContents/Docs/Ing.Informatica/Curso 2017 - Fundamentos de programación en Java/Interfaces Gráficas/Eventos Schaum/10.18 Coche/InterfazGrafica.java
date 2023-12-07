
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @(#)InterfazGrafica.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/11
 */
public class InterfazGrafica extends JFrame {

    private Aplicacion aplicacion;
    private JButton agregar;
    private JButton visualizar;
    private DefaultListModel modeloLista;
    OyenteVisualizar oyenteVisualizar;

    public InterfazGrafica(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        oyenteVisualizar = new OyenteVisualizar();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        Border borde = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        TitledBorder titulo = BorderFactory.createTitledBorder(borde, "Lista coches",
                TitledBorder.CENTER, TitledBorder.TOP);
        panel.setBorder(titulo);
        modeloLista = new DefaultListModel();
        JList lista = new JList(modeloLista);
        panel.add(new JScrollPane(lista));
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        add(panel);
        add(panelBotones());
        setJMenuBar(creaMenus());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestion de coches");
        setSize(300, 250);
        setVisible(true);
    }//constructor

    private JPanel panelBotones() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setBorder(new EmptyBorder(0, 10, 10, 10));
        agregar = new JButton("agregar");
        agregar.setMnemonic(KeyEvent.VK_A);
        agregar.addActionListener(new OyenteNuevo());
        visualizar = new JButton("Visualizar");
        visualizar.setMnemonic(KeyEvent.VK_V);
        visualizar.addActionListener(new OyenteVisualizar());
        panel.add(Box.createHorizontalGlue());
        panel.add(agregar);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(visualizar);
        return panel;
    }//panelBotones

    private JMenuBar creaMenus() {
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuOperaciones = new JMenu("Operaciones");
        menuOperaciones.setMnemonic(KeyEvent.VK_O);
        JMenuItem listar = new JMenuItem("Listar coches", KeyEvent.VK_L);
        listar.addActionListener(oyenteVisualizar);
        menuOperaciones.add(listar);
        menuOperaciones.add(new JSeparator());
        JMenuItem salir = new JMenuItem("Salir", KeyEvent.VK_S);
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuOperaciones.add(salir);
        barraMenu.add(menuOperaciones);
        return barraMenu;
    }//creaMenus

    class OyenteVisualizar implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            modeloLista.clear();
            Iterator iterador = aplicacion.obtenerLista().listIterator();
            while (iterador.hasNext()) {
                modeloLista.addElement(iterador.next());
            }
        }
    }//OyenteVisualizar

    public class OyenteNuevo implements ActionListener {

        public void actionPerformed(ActionEvent evento) {

            boolean error = false;
            PanelDatosCoche panel = new PanelDatosCoche();
            if (JOptionPane.showConfirmDialog(
                    InterfazGrafica.this,
                     panel,
                     "Introduzca datos",
                     JOptionPane.OK_CANCEL_OPTION,
                     JOptionPane.PLAIN_MESSAGE
            ) == JOptionPane.OK_OPTION) {
                String modelo = panel.campoModelo.getText();
                String color = panel.campoColor.getText();
                Boolean esMetalizado = panel.esMetalizada.isSelected();
                String matricula = panel.campoMatricula.getText();
                TipoDeCoche tipo = TipoDeCoche.getTipo(panel.tipoCoche.getSelectedItem().toString());
                int anno = 0;
                try {
                    anno = Integer.parseInt(panel.campoanno.getText());
                } catch (NumberFormatException e) {
                    error = true;
                    JOptionPane.showMessageDialog(null,
                            "<html><u>El año con cuatro digitos Ce.g. 2003)",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                error = error || (modelo.length() == 0) || (color.length() == 0) || (matricula.length() == 0);
                if (error) {
                    JOptionPane.showMessageDialog(
                            null,
                            "<html>Tipo de error "
                            + "<p color='red'>Algun campo esta vacio"
                            + " <em> Debe rellenarlos todos",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                TipoDeSeguro seguro;
                if (panel.todoRiesgo.isSelected()) {
                    seguro = TipoDeSeguro.A_TODO_RIESGO;
                } else {
                    seguro = TipoDeSeguro.A_TERCEROS;
                }
                if (!error) {
                    Coche coche = new Coche(modelo, color, esMetalizado, matricula, tipo, anno, seguro);
                    aplicacion.agregarCoche(coche);
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
}//InterfazGrafica

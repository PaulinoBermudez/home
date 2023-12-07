
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)JButtonEjemplo2.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */
public class JButtonEjemplo2 extends JFrame implements ActionListener {

    private JButton boton1;
    private JButton boton2;
    private JButton boton3;

    public JButtonEjemplo2() {

        setTitle("Ejemplo Swing - JButton");
        setLayout(null);

        boton1 = new JButton("1");
        boton1.setBounds(10, 100, 90, 30);
        add(boton1);

        boton2 = new JButton("2");
        boton2.setBounds(110, 100, 90, 30);
        add(boton2);

        boton3 = new JButton("3");
        boton3.setBounds(210, 100, 90, 30);
        add(boton3);

        //Se registra un oyente creando un objeto de la interfaz ActionListener
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton1) {

            setTitle("Boton 1");

            JOptionPane.showMessageDialog(
                    null,
                    "Mensaje Java UNED",
                    "Titulo - Peligro Curso de Java",
                    JOptionPane.WARNING_MESSAGE);

        }

        if (e.getSource() == boton2) {

            setTitle("Boton 2");

            JOptionPane.showMessageDialog(
                    null,
                    "Te has equivocado de boton",
                    "Titulo - Peligro Curso de Java",
                    JOptionPane.ERROR_MESSAGE);

        }

        if (e.getSource() == boton3) {

            setTitle("Boton 3");

            ImageIcon icon = new ImageIcon("T:/0 UNED/Curso Java Código Fuente/Curso 2017/Interfaces Gráficas/Botones y Eventos/alumno32.png");
            JOptionPane.showMessageDialog(
                    null,
                    "Icono de un Alumno.",
                    "Ventana personalizada",
                    JOptionPane.INFORMATION_MESSAGE,
                    icon);
        }
    }

    public static void main(String[] args) {

        JButtonEjemplo2 ventana = new JButtonEjemplo2();
        ventana.setBounds(0, 0, 350, 200);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }
}

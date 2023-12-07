
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)CapturaEvento.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class CapturaEvento extends JFrame implements ActionListener {

    private JButton elBoton;

    public CapturaEvento() {
        organizaComponentes();
        pack();
        setSize(380, 120);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * A los objetos que pueden recibir el clic debe
     * agregarseles un ActionListener que lo reciben
     * de la implementacion de la clase actual (this)
     */
    private void organizaComponentes() {

        JPanel panel = new JPanel();
        elBoton = new JButton("Pulsar");
        elBoton.addActionListener(this);
        add(panel);
        panel.add(elBoton);
    }

    /** Todos los objetos que tienen un ActionListener de la 
     * clase remitiran el flujo del programa a este metodo
     * que es obligatorio y su sintaxis es asi como se muestra
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(
                this,
                "Gracias");
    }

    public static void main(String[] args) {
        new CapturaEvento();

    }
}

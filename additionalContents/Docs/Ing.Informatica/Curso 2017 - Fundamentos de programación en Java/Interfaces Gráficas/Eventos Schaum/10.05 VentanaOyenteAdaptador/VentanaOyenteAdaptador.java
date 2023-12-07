
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;

/**
 * @(#)VentanaOyenteAdaptador.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/16
 */
public class VentanaOyenteAdaptador extends JFrame {

    private JTextArea areaTexto;

    public VentanaOyenteAdaptador() {

        JButton boton = new JButton("Limpiar");
        areaTexto = new JTextArea(12, 30);
        JPanel panel = new JPanel();
        panel.add(boton);
        panel.add(areaTexto);
        add(panel);
        ActionListener oyenteBoton = new OyenteAccion();
        boton.addActionListener(oyenteBoton);
        MouseListener oyenteRaton = new OyenteRaton();
        areaTexto.addMouseListener(oyenteRaton);
    }

    class OyenteRaton extends MouseInputAdapter {

        public void mouseClicked(MouseEvent e) {

            areaTexto.append("Se ha hecho clic \n");
            areaTexto.append("Posicion X: " + e.getX());
            areaTexto.append("Posicion Y: " + e.getY());
        }

        public void mousePressed(MouseEvent e) {

            if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
                areaTexto.append("El botón pulsado es el de la derecha \n");
            }
            areaTexto.append("Se ha pulsado el botón del ratón \n");
        }

        public void mouseReleased(MouseEvent e) {

            areaTexto.append("Se ha soltado el bot�n del ratón \n");
        }

        public void mouseEntered(MouseEvent e) {

            areaTexto.append("El ratón ha entrado en el componente \0");
        }

        public void mouseExited(MouseEvent e) {

            areaTexto.append("El ratón ha salido del componente \n");
        }

    }

    class OyenteAccion implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            areaTexto.setText("");
        }
    }

    public static void main(String[] args) {

        VentanaOyenteAdaptador ventana = new VentanaOyenteAdaptador();
        ventana.setTitle("Eventos de ratón");
        ventana.pack();
        ventana.setVisible(true);
    }
}

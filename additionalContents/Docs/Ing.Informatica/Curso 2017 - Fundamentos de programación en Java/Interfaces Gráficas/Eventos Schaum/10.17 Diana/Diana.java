
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Diana extends JButton {

    static final int NUM = 5;
    int centroX;
    int centroY;

    public Diana() {
        this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(250, 250));
        this.addMouseListener(new MouseInputAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                String mensaje = "No has dado en el centro";

                if (((Math.abs(x - centroX)) < (centroX / NUM))
                        && ((Math.abs(y - centroY)) < (centroY / NUM))) {
                    mensaje = "Muy bien acertaste en el centro";
                }
                JOptionPane.showMessageDialog(
                        Diana.this,
                        mensaje,
                        "Pulsacion del ratón realizada",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }//constructor

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //pintado del fondo
        int alto = getSize().height;
        int ancho = getSize().width;
        centroX = ancho / 2;
        centroY = alto / 2;
        for (int i = NUM; i > 0; i--) {
            if (i % 2 == 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.blue);
            }
            if (i == 1) {
                g.setColor(Color.red);
            }
            int radioX = i * centroX / NUM;
            int radioY = i * centroY / NUM;
            g.fillOval(centroX - radioX, centroY - radioY, 2 * radioX, 2 * radioY);
        }
        g.setColor(Color.black);
        g.drawLine(0, 0, ancho, alto);
        g.drawLine(0, alto, ancho, 0);
    }//paintComponent

    public static void main(String args[]) {
        JFrame ventana = new JFrame("Diana");
        Diana diana = new Diana();
        ventana.add(diana);
        JLabel etiqueta = new JLabel("Haz clic en la diana", JLabel.CENTER);
        ventana.add(etiqueta, BorderLayout.NORTH);
        ventana.pack();
        ventana.setVisible(true);
    }
}

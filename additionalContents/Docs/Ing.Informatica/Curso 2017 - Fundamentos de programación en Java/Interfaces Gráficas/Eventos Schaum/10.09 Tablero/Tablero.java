
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Escribir una aplicacion grafica que cree un tablero
 * de tamaño de ocho por ocho con cuadros blancos y negros
 * similar al utilizado en el juego de las damas o del ajedrez.
 * La aplicacion debe detectar la pulsacion sobre el
 * tablero e informar sobre el color del cuadro pulsado.
 *
 */
public class Tablero extends JPanel {

    public Tablero(int tamaño) {
        JButton[][] botones;
        botones = new JButton[tamaño][tamaño];

        // Se crea un oyente de acciones y se le pasa el panel como argumento.
        OyenteAcciones oyente = new OyenteAcciones(this);
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                //Se crean los botones y se establece su tamaño.
                botones[i][j] = new JButton();
                botones[i][j].setPreferredSize(new Dimension(50, 50));

                if (((i + j + 1) % 2) == 0) {
                    botones[i][j].setBackground(Color.BLACK);
                }
                botones[i][j].addActionListener(oyente);
                add(botones[i][j]);
            }
        }
        //Se establece el gestor de disposicion GridLayout para el panel.
        setLayout(new GridLayout(tamaño, tamaño));
    }

    class OyenteAcciones implements ActionListener {

        private JPanel panel;

        public OyenteAcciones(JPanel panel) {
            this.panel = panel;
        }

        public void actionPerformed(ActionEvent evento) {
            //Se obtiene el color del boton pulsado.
            //getSource indica que objeto genero el Evento
            JButton boton = (JButton) evento.getSource();
            String color = "blanco";
            if (boton.getBackground() == Color.BLACK) {
                color = "negro";
            }

            //Se muestra un cuadro de dialogo informativo.
            JOptionPane.showMessageDialog(panel,
                    "Se ha pulsado un cuadro de color " + color,
                    "Cuadro pulsado",
                    JOptionPane.INFORMATION_MESSAGE);
            //El icono que se utilizara en el cuadro emergente es la letra i de informacion.
        }
    }

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Tablero");
        Tablero tablero = new Tablero(8);
        ventana.add(tablero);
        // El metodo pack() hace que la ventana coja el tamaño mas pequeño
        //posible que permita ver todos los componentes.
        ventana.pack();
        ventana.setVisible(true);
    }
}

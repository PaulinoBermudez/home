
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/*
 * La propia ventana grafica es oyente de eventos de ventana
 * ya que implementa la interfaz WindowListener
 **/
public class VentanaOyente extends JFrame implements WindowListener {

    private JTextArea areaTexto;
    private JLabel etiqueta;
    private JPanel panel;
    private final String FIN = "\n";

    public VentanaOyente() {
        etiqueta = new JLabel("Eventos");
        //Se crea un area de texto con 10 filas y 30 columnas
        areaTexto = new JTextArea(10, 30);
        // Se le asocia una cadena de texto inicial.
        areaTexto.setText("Texto inicial del area de texto");
        panel = new JPanel();

        panel.add(etiqueta);
        panel.add(areaTexto);
        add(panel);
        // Con this es la propia ventana la que se registra a si misma
        // como oyente de eventos de ventana
        addWindowListener(this);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ventana oyente");
        setVisible(true);
        pack();
    }

    /* Se proporcinan los metodos correspodientes a la interfaz WindowListener.
     * En los metodos correspodientes a la interfaz WindowListener
     * se agrega una linea al contenido del area de texto con la
     * indicacion del evento producido
     **/
    public void windowOpened(WindowEvent e) {
        areaTexto.append(FIN + "Ventana abierta");
    }

    public void windowClosing(WindowEvent e) {
        areaTexto.append(FIN + "Ventana cerrandose");
    }

    public void windowClosed(WindowEvent e) {
        areaTexto.append(FIN + "Ventana cerrada");
    }

    public void windowIconified(WindowEvent e) {
        areaTexto.append(FIN + "Ventana iconocida");
    }

    public void windowDeiconified(WindowEvent e) {
        areaTexto.append(FIN + "Ventana desiconocida");
    }

    public void windowActivated(WindowEvent e) {
        areaTexto.append(FIN + "Ventana activada");
    }

    public void windowDeactivated(WindowEvent e) {
        areaTexto.append(FIN + "Ventana desactivada");
    }

    public static void main(String args[]) {
        VentanaOyente ventana = new VentanaOyente();
    }

}

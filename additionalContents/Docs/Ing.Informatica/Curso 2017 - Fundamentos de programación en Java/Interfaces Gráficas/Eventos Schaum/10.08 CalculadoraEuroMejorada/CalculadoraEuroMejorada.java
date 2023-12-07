
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Aplicacion grafica que permite de forma sencilla realizar el cambio de
 * pesetas a euros y viceversa. La tasa de cambio que se aplica es 1 euro igual
 * a 166,386 pesetas. En todo momento el usuario debe estar informado de la
 * conversion que se esta realizando. Se debe permitir operar con los botones
 * desde el teclado y hay que a�adir un boton que permita borrar los campos de
 * datos y resultado. Tambien para darle mayor robustez se debe incluir un
 * control de errores que avise mediante una ventana emergente si se ha
 * introducido un numero en formato erroneo evitando que la aplicacion se
 * detenga de forma anomala.
 */
public class CalculadoraEuroMejorada extends JPanel {

    private final double TASACAMBIO = 166.386;
    private double cambioEfectivo = TASACAMBIO;
    private JTextField campoCantidad;
    private JTextField campoResultado;

    public CalculadoraEuroMejorada() {
        add(new JLabel("Cantidad a convertir"));
        campoCantidad = new JTextField("0.0", 6);
        add(campoCantidad);
        add(new JLabel("Resultado"));
        campoResultado = new JTextField("0.0", 6);
        campoResultado.setEditable(false);
        add(campoResultado);

        //Pulsando ALT+e se activa este boton. 
        //Si la letra e aparece en el texto del boton
        //su primera ocurrencia aparecera subrayada
        JToggleButton moneda = new JToggleButton("Euros a Pesetas", false);
        moneda.setMnemonic(KeyEvent.VK_E);
        add(moneda);
        moneda.addChangeListener(new OyenteBotonConmutador());
        JButton cambiar = new JButton("Cambiar");
        cambiar.setMnemonic(KeyEvent.VK_C);
        add(cambiar);
        cambiar.addActionListener(new OyenteCambio());

        //Se crea un icono apartir de una
        //imagen grafica en formato gif.
        ImageIcon icono = new ImageIcon("cross2.png");

        //Se crea un balon que ademas
        //de un texto llene un icono.
        JButton borrar = new JButton("Borrar", icono);
        borrar.setMnemonic(KeyEvent.VK_B);
        add(borrar);

        // Se agrega un oyente anonimo.
        // Invoca al metodo privado de borrado de datos.
        // CLASE ANONIMA.
        borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                borrarDatos();
            }
        });
    }

    // Metodo privado de la clase.
    // Permite mejorar la estructuracion de codigo.
    public void borrarDatos() {
        campoCantidad.setText("0.0");
        campoResultado.setText("0.0");
    }

    class OyenteCambio implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            double dinero = 0.0;

            //Se protege la lectura de datos para evitar que un error en el formato
            //numerico provoque la terminacion anomala de la ejecucion.
            try {

                dinero = Double.parseDouble(campoCantidad.getText());

            } catch (NumberFormatException exception) {
                //Se crea una ventana emergente con el mensaje de error y un
                //icono que mueslra dicho error.
                JOptionPane.showMessageDialog(CalculadoraEuroMejorada.this,
                        "Solo se pueden introducir digitos y el punto",
                        "Error en el formato numerico",
                        JOptionPane.ERROR_MESSAGE);
                borrarDatos();
            }

            dinero = dinero * cambioEfectivo;
            String cadena = String.format("%6.2f", dinero);
            campoResultado.setText(cadena);
        }
    }//OyenteCambio

    class OyenteBotonConmutador implements ChangeListener {

        public void stateChanged(ChangeEvent evento) {
            JToggleButton boton = (JToggleButton) evento.getSource();
            if (boton.isSelected()) {
                boton.setText("Pesetas a Euros");
                cambioEfectivo = 1 / TASACAMBIO;
            } else {
                boton.setText("Euros a Pesetas");
                cambioEfectivo = TASACAMBIO;
            }
        }
    }//OyenteBotonConmutador

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Calculadora cambio moneda");
        CalculadoraEuroMejorada calculadora = new CalculadoraEuroMejorada();
        ventana.add(calculadora);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 130);
        ventana.setVisible(true);
    }
}// CalculadoraEuroMejorada



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Aplicacion grafica que nos permite calcular el indice de masa corporal - IMC.
 * Este indice se obtiene dividiendo el peso en kilos de una persona por el
 * cuadrado de su altura en metros.
 */
public class IndiceMasaCorporal extends JFrame {

    private JTextField campoAltura;
    private JTextField campoPeso;
    private JTextField campoIMC;

    public IndiceMasaCorporal() {

        JLabel etiquetaAltura = new JLabel("Altura (metros)");
        JLabel etiquetaPeso = new JLabel("Peso (kg)");
        JLabel etiquetaIMC = new JLabel("Indice Masa Corporal");
        JButton calcular = new JButton("Calcular IMC");

        //Se crean los campos de altura y peso
        //donde el usuario introducira los datos
        campoAltura = new JTextField(6);
        campoPeso = new JTextField(6);
        campoIMC = new JTextField(6);
        campoIMC.setEditable(false);
        JPanel panel = new JPanel();

        panel.add(etiquetaAltura);
        panel.add(campoAltura);
        panel.add(etiquetaPeso);
        panel.add(campoPeso);
        panel.add(calcular);
        panel.add(etiquetaIMC);
        panel.add(campoIMC);
        add(panel);

        // Al boton de calcular se le asocia un oyente de acciones
        // mediante una CLASE ANONIMA.
        calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                Double peso = Double.parseDouble(campoPeso.getText());
                Double altura = Double.parseDouble(campoAltura.getText());
                Double imc = peso / (altura * altura);
                //Al resultado se le da formato con dos
                //decimales y se muestra en el campo IMC.
                String cadena = String.format("%6.2f", imc);
                campoIMC.setText(cadena);
            }
        }
        );// addActionListener
    } //constructor IndiceMasaCorporal

    public static void main(String[] args) {
        IndiceMasaCorporal ventana = new IndiceMasaCorporal();
        ventana.setTitle("Indice de Masa Corporal");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 100);
        ventana.setVisible(true);
    }
}

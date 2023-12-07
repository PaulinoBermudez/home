
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * @(#)ComboMecanico.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/5/11
 */

public class ComboMecanico {

    public static final String[] mecanico = {"Manolo", "Juan", "Pedro", "David"};

    public static void main(String[] args) {
        JFrame frame = new JFrame("Input Dialog Mecanicos");
        String mecanicoElegido = (String) JOptionPane.showInputDialog(
                frame,
                "Elegir Mecanico",
                "Mecanico",
                JOptionPane.QUESTION_MESSAGE,
                null,
                mecanico,
                mecanico[0]);

        System.out.printf("Mecanico %s.\n", mecanicoElegido);
        System.exit(0);
    }

}


import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Para crear una ventana con marco lo mas adecuado es crear una clase que
 * extienda la clase JFrame. Esta clase ya tiene marco y los controles basicos.
 *
 */
public class EjemploSwing extends JFrame {

    public EjemploSwing() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hay que crear una etiqueta de tipo JLabel y agregarla a la ventana.
        JLabel etiqueta = new JLabel("Introduccion Practica de Programacion Java");
        add(etiqueta);

        /**
         * Se configuran el resto de propiedades de la ventana, como son su
         * titulo, que se pueda modificar su tama�o, que su tama�o inicial se
         * ajuste al tama�o preferido de los componentes que contiene y que sea
         * visible
         *
         */
        setTitle("Interfaz Grafica de Usuario");
        setResizable(true);
        pack();
        setVisible(true);
        setSize(400, 100);
    }

    public static void main(String args[]) {
        // Se crea un objeto del tipo ventana que habiamos definido
        EjemploSwing ventana = new EjemploSwing();
    }
}

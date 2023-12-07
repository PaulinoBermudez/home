
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Aplicacion grafica con una ventana que
 * tenga una etiqueta y dos botones de operacion.
 * El comportamiento de la aplicacion debe reflejar en
 * el texto de la etiqueta cual es el ultimo boton en
 * el que el usuario ha hecho clic.
 * 
 **/
public class BotonesEtiquetaOyente extends JFrame {

    private JLabel etiqueta;
    private JButton botonUno;
    private JButton botonDos;
    private JPanel panel;

    public BotonesEtiquetaOyente() {
        etiqueta = new JLabel("No se ha pulsado ningun boton");
        botonUno = new JButton("Boton Uno");
        botonDos = new JButton("Boton Dos");
        panel = new JPanel();

        // Se agregan los objetos graficos al panel y el panel a la ventana.
        panel.add(etiqueta);
        panel.add(botonUno);
        panel.add(botonDos);
        add(panel);

        // Se crea un objeto oyente de acciones.
        OyenteAccion oyenteBoton = new OyenteAccion();

        //Se asigna el mismo oyente a los dos botones de interaccion.
        //Cuando ActionListener detecta una accion se genera un ActionEvent en el elemento.
        //Se registran dos oyentes creando un objeto de la interfaz ActionListener.
        botonUno.addActionListener(oyenteBoton);
        botonDos.addActionListener(oyenteBoton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventana con gestor de eventos");
        // El metodo pack() hace que la ventana coja el tamaño 
        // mas pequeño posible que permita ver todos los componentes.
        pack();
        setVisible(true);
    }

    // Se crea una clase oyente de acciones como clase interna.
    class OyenteAccion implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            //getSource indica que objeto genero el Evento
            JButton boton = (JButton) evento.getSource();
            etiqueta.setText("Boton pulsado: " + boton.getText());
        } // fin actionPerformed
    } //OyenteAccion

    public static void main(String args[]) {
        BotonesEtiquetaOyente ventana = new BotonesEtiquetaOyente();
    }

}//BotonesEtiquetaOyente

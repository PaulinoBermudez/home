
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * La clase oyente es una clase publica externa a
 * la clase en la que se generan los eventos.
 **/
public class OyenteExternoAccion implements ActionListener {

    private int numVeces;
    private JLabel etiqueta;

    // El oyente tiene un constructor que recibe como parametro la etiqueta a modificar
    public OyenteExternoAccion(JLabel etiqueta) {
        numVeces = 0;
        this.etiqueta = etiqueta;
    }

    //Los ActionEvent invocan el metodo actionPerformed(ActionEvent evento)
    //que realiza las acciones programadas ante ese evento.
    public void actionPerformed(ActionEvent evento) {
        numVeces++;
        //getSource indica que objeto genero el Evento
        JButton boton = (JButton) evento.getSource();
        etiqueta.setText(boton.getText() + ": " + numVeces + " veces");
    }
} // OyenteExternoAccion

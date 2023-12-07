import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Construye una ventana con un botón y una campo de texto.
 * Cuando se pulsa el boton, escribe "Hola mundo" en el campo de texto.
 * 
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */
 
public class HolaMundoSwing {
	
    private JFrame ventana;
    private JButton boton;
    private JTextField texto;
    
    public static void main(String [] args) {
        new HolaMundoSwing();
    }
    
    /**
     * Crea la ventana, inicializa todo y la visualiza
     */
    public HolaMundoSwing(){
    	
        // Nueva ventana. Se el pone un FlowLayout para que el boton y campo
        // de texto quede alineados.
        ventana = new JFrame("Ventana Hola Mundo");
        ventana.getContentPane().setLayout(new FlowLayout());
        
        // Se crea el boton y se mete en la ventana
        boton = new JButton("Pulsar");
        ventana.getContentPane().add (boton);
        
        // Se crea el campo de texto y se mete en la ventana
        texto = new JTextField(20);
        ventana.getContentPane().add(texto);
        
        // Se le dice al boton qué tiene que hacer cuando lo pulsemos.
        // CLASE ANONIMA.
        boton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
                texto.setText ("Hola mundo");
        	}
        }
        );
        
        // Se le dice a la ventana que termine el programa cuando se la cierre
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // Se le da un tamaño automático a la ventana para que quepa todo su
        // contenido.
        ventana.pack();
        
        // Se hace visible la ventana
        ventana.setVisible(true);
    }

}

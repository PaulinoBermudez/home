import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @(#)Ventana.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class Ventana extends JFrame {
	
	private JLabel nombre;
	private JLabel apellidos;

    public Ventana() {
    	
    	setLayout(null);

    	setTitle("Ejemplo JLabel");
    	
		nombre = new JLabel("Nombre:");
	  //nombre.setBounds(x, y, width, height);
		nombre.setBounds(30,20,300,30);
		add(nombre);
		
		apellidos = new JLabel("Apellidos:");
		apellidos.setBounds(30,50,300,30);
		add(apellidos);
		
    	setSize(300,150);
    	
    }
    
    public static void main (String[] args) {
    	
    	Ventana ventana = new Ventana();
    	ventana.setVisible(true);
    	ventana.setLocationRelativeTo(null);
	}
}

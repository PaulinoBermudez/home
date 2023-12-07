import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Container;

/**
 * @(#)VentanaFlow.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/13
 */


public class VentanaFlow extends JFrame {
	
	public VentanaFlow() {	
		
		super("Titulo de ventana");
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		JLabel etiqueta = new JLabel("Nombre: ");
		JTextField texto = new JTextField(20);
		JButton boton = new JButton("Ok"); 
		contenedor.add(etiqueta);
		contenedor.add(texto);
		contenedor.add(boton);
	}
	
	public static void main (String[] args) {
		
		VentanaFlow ventana = new VentanaFlow();
		ventana.setVisible(true);
		
	}
}
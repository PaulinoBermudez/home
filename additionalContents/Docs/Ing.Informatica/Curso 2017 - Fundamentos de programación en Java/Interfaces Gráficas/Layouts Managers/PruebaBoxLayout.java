import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * @(#)PruebaBoxLayout.java
 *
 *
 * @author 
 * @version 1.00 2017/7/17
 */

public class PruebaBoxLayout {
	
	public static void main(String [] args){
		
		// Se crea la ventana con el BoxLayout
		JFrame v = new JFrame();
		v.getContentPane().setLayout(new BoxLayout(v.getContentPane(),BoxLayout.Y_AXIS));
		
		// Se crea un botón centrado y se añade
		JButton boton = new JButton("B");
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		v.getContentPane().add(boton);
		
		// Se crea una etiqueta centrada y se añade
		JLabel etiqueta = new JLabel("una etiqueta larga");
		etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
		v.getContentPane().add(etiqueta);
		
		// Visualizar la ventana
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
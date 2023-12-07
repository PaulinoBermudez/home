import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @(#)HolaMundo.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class HolaMundo extends JFrame{
    
    public HolaMundo() {
    	
    	setTitle("Ejemplo Ventana Hola");
    	  
        setLayout(null); // posicionamiento absoluto
        JLabel etiqueta = new JLabel("Hola Mundo");
      //etiqueta.setBounds(x, y, width, height);
        etiqueta.setBounds(10,20,200,30);
        add(etiqueta);
    }
    
    public static void main(String[] args) {
        HolaMundo ventana = new HolaMundo();
        ventana.setBounds(100,10,300,100);
        ventana.setVisible(true);
    }
}
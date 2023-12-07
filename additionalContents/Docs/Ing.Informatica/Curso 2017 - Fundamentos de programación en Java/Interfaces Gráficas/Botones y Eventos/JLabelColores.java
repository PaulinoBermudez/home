import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @(#)JLabelColores.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JLabelColores extends JFrame {
	
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    
    public JLabelColores() {
    	
    	setTitle("Ejemplo - JLabel Colores");
        setLayout(null);
        
        label1 = new JLabel("Rojo");
        label1.setBounds(10,20,100,30);
        add(label1);
        
        label2 = new JLabel("Verde");
        label2.setBounds(10,60,100,30);
        add(label2);
        
        label3 = new JLabel("Azul");
        label3.setBounds(10,100,100,30);
        add(label3);
    }
    
    public static void main(String[] ar) {
    	
        JLabelColores ventana = new JLabelColores();
        ventana.setLocationRelativeTo(null);
        ventana.setBounds(0,0,300,200);
        ventana.setVisible(true);
    }
}

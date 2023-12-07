import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @(#)JLabelEjemplo.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JLabelEjemplo extends JFrame {
	
    private JLabel label1;
    private JLabel label2;
    
    public JLabelEjemplo() {
    	
    	setTitle("Ejemplo Swing - JLabel");
        setLayout(null);
        
        label1 = new JLabel("Es un ejemplo de contenedor JLabel.");
        label1.setBounds(10,20,300,30);
        add(label1);
        
        label2 = new JLabel("UNED - Java");
        label2.setBounds(10,100,100,30);
        add(label2);
    }
    
    public static void main(String[] args) {
    	
        JLabelEjemplo ventana = new JLabelEjemplo();
        ventana.setLocationRelativeTo(null);
        ventana.setBounds(0,0,300,200);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}
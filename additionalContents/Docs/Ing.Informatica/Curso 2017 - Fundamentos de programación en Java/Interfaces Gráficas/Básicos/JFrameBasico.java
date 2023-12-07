import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @(#)JFrameBasico.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JFrameBasico {
	
    public static void main(String[] args){
    	
    	JFrame ventana = new JFrame("UNED POO");
		ventana.setSize(300,200);
		ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }
}

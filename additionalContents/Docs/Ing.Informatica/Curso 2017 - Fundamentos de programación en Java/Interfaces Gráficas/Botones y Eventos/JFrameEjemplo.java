import javax.swing.JFrame;

/**
 * @(#)JFrameEjemplo.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JFrameEjemplo extends JFrame{
	
    public JFrameEjemplo(){
    	setTitle("Ejemplo Swing - JFrame");
        setLayout(null);
    }

    public static void main(String[] args) {
        JFrameEjemplo ventana = new JFrameEjemplo();
        ventana.setLocationRelativeTo(null);
        ventana.setBounds(10,20,300,200);
        ventana.setVisible(true); 
    }
}

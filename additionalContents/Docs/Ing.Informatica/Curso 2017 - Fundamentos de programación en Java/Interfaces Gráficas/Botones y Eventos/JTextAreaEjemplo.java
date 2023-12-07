import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @(#)JTextAreaEjemplo.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */
 
public class JTextAreaEjemplo extends JFrame{
	
    private JTextField textfield1;
    private JScrollPane scrollpane1;
    private JTextArea textarea1;
    
    public JTextAreaEjemplo() {
    	
    	setTitle("Ejemplo JTextArea y JTextField");
        setLayout(null);
        
        textfield1=new JTextField();
        textfield1.setBounds(10,10,200,30);
        add(textfield1);
        
        textarea1=new JTextArea();        
        scrollpane1=new JScrollPane(textarea1);    
        scrollpane1.setBounds(10,50,400,300);
        add(scrollpane1);
    }

    public static void main(String[] args) {
        JTextAreaEjemplo ventana = new JTextAreaEjemplo();
        ventana.setLocationRelativeTo(null);
        ventana.setBounds(0,0,540,400);
        ventana.setVisible(true);
    }    
}

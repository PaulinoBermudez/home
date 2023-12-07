import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)JTextAreaControl.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JTextAreaControl extends JFrame implements ActionListener{
	
    private JScrollPane scrollpane1;
    private JScrollPane scrollpane2;
    private JTextArea textarea1;
    private JTextArea textarea2;
    private JButton boton1;
    
    public JTextAreaControl() {
    	
    	setTitle("Ejemplo JTextArea Dos Controles");
        setLayout(null);
        
        textarea1 = new JTextArea();
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10,10,200,140);
        add(scrollpane1);
        
        textarea2 = new JTextArea();
        scrollpane2 = new JScrollPane(textarea2);
        scrollpane2.setBounds(220,10,200,140);
        add(scrollpane2);
        
        boton1 = new JButton("Verificar contenidos");
        boton1.setBounds(10,170,150,30);
        add(boton1);
        
        boton1.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton1) {
        	
            String texto1=textarea1.getText();
            String texto2=textarea2.getText();
            
            if (texto1.equals(texto2) == true) {
                setTitle("Los dos controles tiene el mismo texto.");
            } else {
            	setTitle("Los dos controles no tiene el mismo texto.");
            }           	
        }
    }

    public static void main(String[] args) {
    	
        JTextAreaControl ventana = new JTextAreaControl();
        ventana.setBounds(0,0,500,350);
        ventana.setVisible(true);
    }            
}

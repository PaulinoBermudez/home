import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)JTextFieldSumar.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JTextFieldSumar extends JFrame implements ActionListener{
	
    private JTextField textfield1;
    private JTextField textfield2;
    private JButton boton1;
    
    public JTextFieldSumar() {
    	 
        setLayout(null);
        
        textfield1=new JTextField();
        textfield1.setBounds(10,10,100,30);
        add(textfield1);
        
        textfield2=new JTextField();
        textfield2.setBounds(10,50,100,30);
        add(textfield2);
        
        boton1=new JButton("Sumar");
        boton1.setBounds(10,90,100,30);
        add(boton1);
        
        boton1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == boton1) {
        	
            String cad1 = textfield1.getText();
            String cad2 = textfield2.getText();
            
            int x1 = Integer.parseInt(cad1);
            int x2 = Integer.parseInt(cad2);
            
            int suma = x1+x2;
            
            String total = String.valueOf(suma);
            
            setTitle(total);
        }
    }
    
    public static void main(String[] args) {
    	
        JTextFieldSumar ventana = new JTextFieldSumar();
        ventana.setBounds(0,0,170,170);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}

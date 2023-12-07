import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)JTextAreaCarta.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JTextAreaCarta extends JFrame implements ActionListener{
	
    private JScrollPane scrollpane1;
    private JTextArea textarea1;
    private JButton boton1;
    
    public JTextAreaCarta() {
    	
    	setTitle("Ejemplo JTextArea Comprobar");
        setLayout(null);
        
        textarea1=new JTextArea();
        scrollpane1=new JScrollPane(textarea1);
        scrollpane1.setBounds(10,10,300,200);
        add(scrollpane1);
        
        boton1=new JButton("Verificar");
        boton1.setBounds(10,260,100,30);
        add(boton1);

        boton1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton1) {
            String texto = textarea1.getText();
            if (texto.indexOf("casa")!= -1) {
                setTitle("Si contiene el texto \"casa\"");
            } else {
                setTitle("No contiene el texto \"casa\"");            
            }
        }
    }
    
    public static void main(String[] args) {
        JTextAreaCarta ventana = new JTextAreaCarta();
        ventana.setBounds(0,0,400,380);
        ventana.setVisible(true);
    }        
}

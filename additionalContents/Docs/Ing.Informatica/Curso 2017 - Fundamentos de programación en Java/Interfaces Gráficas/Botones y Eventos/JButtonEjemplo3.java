import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)JButtonEjemplo3.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JButtonEjemplo3 extends JFrame implements ActionListener{
	
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    
    public JButtonEjemplo3() {
    	
    	setTitle("Swing - JButton");
        setLayout(null);
        
        boton1=new JButton("Varón");
        boton1.setBounds(10,10,100,30);
        add(boton1);
        
        boton2=new JButton("Mujer");
        boton2.setBounds(10,70,100,30);
        add(boton2);
        
        //Se registra un oyente creando un objeto de la interfaz ActionListener
        boton1.addActionListener(this);
        boton2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            setTitle("Varón");
        }
        if (e.getSource()==boton2) {
            setTitle("Mujer");
        }
    }
    
    public static void main(String[] args) {
        JButtonEjemplo3 ventana = new JButtonEjemplo3();
        ventana.setBounds(0,0,250,160);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}

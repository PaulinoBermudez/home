import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @(#)JMenuNumeros.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JMenuNumeros extends JFrame implements ActionListener{
	
    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1;
    private JMenuItem mi2;
    private JTextField tf1;
    private JTextField tf2;
    
    public JMenuNumeros() {
    	
    	setTitle("Menu Números");
        setLayout(null);
        
        mb = new JMenuBar();
        setJMenuBar(mb);
        
        menu1 = new JMenu("Opciones");
        mb.add(menu1);
        
        mi1 = new JMenuItem("Redimensionar ventana");
        menu1.add(mi1);
   
        mi2 = new JMenuItem("Salir");
        menu1.add(mi2);
        
        tf1 = new JTextField();
        tf1.setBounds(10,10,100,30);
        add(tf1);
        
        tf2 = new JTextField();
        tf2.setBounds(10,50,100,30);
        add(tf2);
        
        mi1.addActionListener(this);
        mi2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mi1) {
            String cad1 = tf1.getText();
            String cad2 = tf2.getText();
            int ancho = Integer.parseInt(cad1);
            int alto = Integer.parseInt(cad2);
            setSize(ancho,alto); 
        }
        
        if (e.getSource() == mi2) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        JMenuNumeros ventana = new JMenuNumeros();
        ventana.setLocationRelativeTo(null);
        ventana.setBounds(0,0,300,200);
        ventana.setVisible(true);
    }    
}

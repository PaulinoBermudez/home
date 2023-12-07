import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @(#)JMenuEjemplo.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JMenuEjemplo extends JFrame implements ActionListener{
	
    private JMenuBar barraMenu;
    private JMenu opciones;
    private JMenuItem itemRojo;
    private JMenuItem itemVerde;
    private JMenuItem itemAzul;
    
    
    public JMenuEjemplo() {
    	
    	setTitle("Menu Cambiar colores");

        setLayout(null);
        
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        
        opciones = new JMenu("Opciones");
        barraMenu.add(opciones);
        
        itemRojo=new JMenuItem("Rojo");
        opciones.add(itemRojo);
        
        itemVerde = new JMenuItem("Verde");
        opciones.add(itemVerde);
        
        itemAzul = new JMenuItem("Azul");
        opciones.add(itemAzul);
        
        itemRojo.addActionListener(this);
        itemVerde.addActionListener(this);
        itemAzul.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
    	
    	Container f = this.getContentPane();
    	
        if (e.getSource() == itemRojo) {
            getContentPane().setBackground(Color.RED);
        }
        
        if (e.getSource() == itemVerde) {
            f.setBackground(Color.GREEN);
        }
        
        if (e.getSource() == itemAzul) {
            f.setBackground(Color.BLUE);
        }        
    }
    
    public static void main(String[] args) {
        JMenuEjemplo ventana = new JMenuEjemplo();
        ventana.setBounds(10,20,300,200);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }    
}

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @(#)JMenuDoble.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JMenuDoble extends JFrame implements ActionListener{
	
    private JMenuBar barraMenu;
    private JMenu opciones;
    private JMenu medida;
    private JMenu color;
    private JMenuItem item640;
    private JMenuItem item1024;
    private JMenuItem itemRojo;
    private JMenuItem itemVerde;
    
    public JMenuDoble() {
    	
    	setTitle("Menu Doble");
    	
        setLayout(null);
        
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        
        opciones = new JMenu("Opciones");
        barraMenu.add(opciones);
        
        medida = new JMenu("Medida de la ventana");
        opciones.add(medida);
        
        color = new JMenu("Color de fondo");
        opciones.add(color);
        
        item640 = new JMenuItem("640*480");
        medida.add(item640);
        
        item1024 = new JMenuItem("1024*768");
        medida.add(item1024);
         
        itemRojo=new JMenuItem("Rojo");
        color.add(itemRojo);
        
        itemVerde = new JMenuItem("Verde");
        color.add(itemVerde);
        
        item640.addActionListener(this);
        item1024.addActionListener(this);
        itemRojo.addActionListener(this);
        itemVerde.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == item640) {
            setSize(640,480);
        }
        
        if (e.getSource() == item1024) {
            setSize(1024,768);
        }
        
        if (e.getSource() == itemRojo) {
            getContentPane().setBackground(Color.RED);
        }
        
        if (e.getSource() == itemVerde) {
            getContentPane().setBackground(Color.GREEN);
        }
    }
    
    public static void main(String[] args) {
    	
        JMenuDoble ventana = new JMenuDoble();
        ventana.setBounds(0,0,300,200);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }     
}

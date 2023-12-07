import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @(#)JComboBoxEjemplo.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JComboBoxEjemplo extends JFrame implements ItemListener{
	
    private JComboBox combo1;
    
    public JComboBoxEjemplo() {
    	
    	setTitle("Ejemplo JComboBox");
        setLayout(null);
        
        combo1=new JComboBox();
        combo1.setBounds(10,10,80,20);
        add(combo1);
        
        combo1.addItem("Rojo");
        combo1.addItem("Vede");
        combo1.addItem("Azul");
        combo1.addItem("Amarillo");
        combo1.addItem("Negro");
        combo1.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == combo1) {
            String seleccionado = (String)combo1.getSelectedItem();
            setTitle(seleccionado);
        }
    }
    
    public static void main(String[] args) {
        JComboBoxEjemplo ventana = new JComboBoxEjemplo();
        ventana.setLocationRelativeTo(null);
        //      setBounds(x,y,width,height);
        ventana.setBounds(0,0,280,150);
        ventana.setVisible(true);
    }    
}

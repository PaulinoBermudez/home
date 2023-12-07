import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)JComboBoxPais.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JComboBoxPais extends JFrame implements ActionListener{
	
    private JLabel label1;
    private JLabel label2;
    private JTextField textfield1;
    private JComboBox combo1;
    private JButton boton1;
    
    public JComboBoxPais() {
    	
    	setTitle("Ejemplo JComboBox Nombre País");
        setLayout(null);
        
        label1=new JLabel("Usuario:");
        label1.setBounds(10,10,100,30);
        add(label1);
        
        textfield1=new JTextField();
        textfield1.setBounds(120,10,120,30);
        add(textfield1);
        
        label2=new JLabel("País");
        label2.setBounds(10,50,100,30);
        add(label2);
        
        combo1=new JComboBox();
        combo1.setBounds(120,50,100,30);
        combo1.addItem("Alemania");
        combo1.addItem("Francia");
        combo1.addItem("España");
        combo1.addItem("Italia");
        add(combo1);
        
        boton1=new JButton("Confirmar");
        boton1.setBounds(10,100,100,30);
        boton1.addActionListener(this);
        add(boton1);
    }
    
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == boton1) {
            String nombre = textfield1.getText();
            String pais = (String)combo1.getSelectedItem();
            setTitle(nombre + " - " + pais);
        }
    }
    
    public static void main(String[] args) {
        JComboBoxPais ventana = new JComboBoxPais();
        ventana.setBounds(10,20,300,200);
        ventana.setVisible(true);
    }    
}
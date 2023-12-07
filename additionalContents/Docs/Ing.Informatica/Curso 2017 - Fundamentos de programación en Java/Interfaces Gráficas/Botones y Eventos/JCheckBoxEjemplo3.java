import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)JCheckBoxEjemplo3.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JCheckBoxEjemplo3 extends JFrame implements ActionListener {
	
    private JCheckBox check1;
    private JCheckBox check2;
    private JCheckBox check3;
    private JButton btnConfirmar;
    
    public JCheckBoxEjemplo3() {
    	
    	setTitle("Ejemplo JCheckBox 3");
        setLayout(null);
        
        check1 = new JCheckBox("Chrome");
        check1.setBounds(10,10,150,30);
        add(check1);
        
        check2 = new JCheckBox("FireFox");
        check2.setBounds(10,50,150,30);      
        add(check2);
        
        check3 = new JCheckBox("Opera");
        check3.setBounds(10,90,150,30);        
        add(check3);
                      
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(10,140,100,30);
        btnConfirmar.addActionListener(this);
        add(btnConfirmar);
    }
    
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == btnConfirmar) {
            String cad = "";
            if (check1.isSelected() == true) {
                cad = cad + "Chrome-";
            }
            if (check2.isSelected() == true) {
                cad = cad + "FireFox-";
            }
            if (check3.isSelected() == true) {
                cad = cad + "Opera-";
            }
            setTitle(cad);        	
        }
    }
    
    public static void main(String[] args) {
        JCheckBoxEjemplo3 ventana = new JCheckBoxEjemplo3();
        ventana.setBounds(0,0,350,230);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    } 	
}
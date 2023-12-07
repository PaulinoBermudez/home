import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * @(#)JCheckBoxEjemplo2.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JCheckBoxEjemplo2 extends JFrame implements ActionListener, ChangeListener{
	
    private JLabel label1;
    private JCheckBox check1;
    private JButton btnContinuar;
    
    public JCheckBoxEjemplo2() {
    	
    	setTitle("Ejemplo JCheckBox 2");
        setLayout(null);
        
        label1 = new JLabel("Esta de acuerdo con las normas del servicio?");
        label1.setBounds(10,10,400,30);
        add(label1);
        
        check1 = new JCheckBox("Acepto");
        check1.setBounds(10,50,100,30);
        check1.addChangeListener(this);
        add(check1);
        
        btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(10,100,100,30);
        add(btnContinuar);
        
        btnContinuar.addActionListener(this);
        btnContinuar.setEnabled(false);
    }
    
    public void stateChanged(ChangeEvent e) {
        if (check1.isSelected() == true) {
            btnContinuar.setEnabled(true);
        } else {
            btnContinuar.setEnabled(false);	
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnContinuar) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        JCheckBoxEjemplo2 ventana = new JCheckBoxEjemplo2();
        ventana.setBounds(0,0,350,200);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }        
}

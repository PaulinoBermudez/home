import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)JRadioButtonEjemplo2.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JRadioButtonEjemplo2 extends JFrame implements ActionListener{
	
    private JTextField txtOperando1;
    private JTextField txtOperando2;
    private ButtonGroup bg;
    private JRadioButton rdSumar;
    private JRadioButton rdRestar;
    private JButton btnOperar;
    
    public JRadioButtonEjemplo2() {
    	
    	setTitle("Ejemplo JRadioButton 2");
        setLayout(null);
        
        txtOperando1 = new JTextField();
        txtOperando1.setBounds(10,10,100,30);
        add(txtOperando1);
        
        txtOperando2 = new JTextField();
        txtOperando2.setBounds(10,60,100,30);
        add(txtOperando2);
        
        bg = new ButtonGroup();
        
        rdSumar = new JRadioButton("Sumar");
        rdSumar.setBounds(10,110,100,30);
        bg.add(rdSumar);
        add(rdSumar);
        
        rdRestar = new JRadioButton("Restar");
        rdRestar.setBounds(10,140,100,30);
        bg.add(rdRestar);
        add(rdRestar);
        
        btnOperar = new JButton("Operar");
        btnOperar.setBounds(10,180,100,30);
        btnOperar.addActionListener(this);
        add(btnOperar);
    }
    
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == btnOperar) {
            int v1 = Integer.parseInt(txtOperando1.getText());
            int v2 = Integer.parseInt(txtOperando2.getText());
            int resultado = 0;
            if (rdSumar.isSelected()) {
            	resultado = v1+v2;
            }
            if (rdRestar.isSelected()) {
                resultado = v1-v2;
            }
            setTitle(String.valueOf(resultado));
        }
    }

    public static void main(String[] args) {
        JRadioButtonEjemplo2 ventana = new JRadioButtonEjemplo2();
        ventana.setLocationRelativeTo(null);
        ventana.setBounds(0,0,350,250);
        ventana.setVisible(true);
    } 	
}

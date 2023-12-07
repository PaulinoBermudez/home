import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)JButtonClave.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JButtonClave extends JFrame implements ActionListener {
    
    private JLabel label1;
    private JLabel label2;
    private JTextField txtNombre;
    private JTextField txtClave;
    private JButton confirmar;
    
    private JPasswordField password;
    
    public JButtonClave() {
        
        setTitle("JButton - Password");
        setLayout(null);
        
        label1 = new JLabel("Nombre:");
        label1.setBounds(10,10,100,30);
        add(label1);
        
        label2 = new JLabel("Clave:");
        label2.setBounds(10,50,100,30);
        add(label2);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(80,10,100,25);
        add(txtNombre);
        
        password = new JPasswordField();
        password.setBounds(80,50,100,25);
        add(password);
        
        confirmar = new JButton("Confirmar");
        confirmar.setBounds(10,100,100,30);
        add(confirmar);
        
        confirmar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == confirmar) {
            
            String cad1 = txtNombre.getText();
            String cad2 = password.getText();
            
            if (cad1.equals("admin") == true && cad2.equals("1234") == true) {
            	
                setTitle("Correcto");
                
                ImageIcon icon = new ImageIcon("T:/0 UNED/Curso Java Código Fuente/Curso 2017/Interfaces Gráficas/Botones y Eventos/alumno32.png");
        		JOptionPane.showMessageDialog(
                null,
                "Has accedido al Sistema",
                "Clave Correcta",
                JOptionPane.INFORMATION_MESSAGE,
                icon);
                
                //System.exit(0);
                
            }else {
            	
                setTitle("Incorrecto");
                
                JOptionPane.showMessageDialog(
                null,
                "Vuelve a intentarlo",
                "Clave Incorrecta",
                JOptionPane.ERROR_MESSAGE);
                  
            }
        }
    }
    
    public static void main(String[] args) {
        JButtonClave ventana = new JButtonClave();
        ventana.setBounds(0,0,270,200);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
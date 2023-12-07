import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @(#)JButtonEjemplo.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JButtonEjemplo extends JFrame implements ActionListener{
	
    private JButton finalizar;
    
    public JButtonEjemplo(){
    	
    	setTitle("Ejemplo JButton");
        setLayout(null);
        finalizar = new JButton("Finalizar");
        finalizar.setBounds(30,25,100,30);
        add(finalizar);
        //Se registra un oyente creando un objeto de la interfaz ActionListener
        finalizar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
    	//getSource indica qué objeto generó el Evento
        if (e.getSource() == finalizar){
        	
        	JOptionPane.showMessageDialog(
                null,
                "Has pulsado el Botón Finalizar");
                	
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
    	
        JButtonEjemplo ventana = new JButtonEjemplo();
        ventana.setBounds(0,0,250,200);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
}

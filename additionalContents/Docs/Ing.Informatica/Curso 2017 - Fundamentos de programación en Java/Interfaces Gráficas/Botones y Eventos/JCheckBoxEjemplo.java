import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * @(#)JCheckBoxEjemplo.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/4
 */

public class JCheckBoxEjemplo extends JFrame implements ChangeListener{
	
    private JCheckBox check1;
    private JCheckBox check2;
    private JCheckBox check3;
    
    public JCheckBoxEjemplo() {
    	
    	setTitle("Ejemplo JCheckBox");
        setLayout(null);
        
        check1 = new JCheckBox("Inglés");
        check1.setBounds(10,10,150,30);
        add(check1);
        
        check2 = new JCheckBox("Francés");
        check2.setBounds(10,50,150,30);
        add(check2);
        
        check3 = new JCheckBox("Alemán");
        check3.setBounds(10,90,150,30);     
        add(check3);
        
        check1.addChangeListener(this);
        check2.addChangeListener(this);
        check3.addChangeListener(this);
    }
    
    public void stateChanged(ChangeEvent e){
        String cad="";
        if (check1.isSelected() == true) {
            cad = cad + "Inglés-";
        }
        if (check2.isSelected()==true) {
            cad = cad + "Francés-";
        }
        if (check3.isSelected()==true) {
            cad = cad + "Alemán-";
        }
        setTitle(cad);
    }

    public static void main(String[] args) {
        JCheckBoxEjemplo ventana = new JCheckBoxEjemplo();
        ventana.setBounds(0,0,300,200);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }    
}

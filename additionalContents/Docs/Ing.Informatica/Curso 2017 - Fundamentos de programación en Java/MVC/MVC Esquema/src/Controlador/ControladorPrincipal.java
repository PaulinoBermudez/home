
package Controlador;

import Vista.JDialogCurso1;
import Vista.JDialogCurso2;
import Vista.JDialogCurso3;
import Vista.JDialogCurso4;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Toni
 */
public class ControladorPrincipal implements ActionListener{
    
    private VistaPrincipal vistaPrincipal;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorPrincipal(VistaPrincipal vistaPrincipal){
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.getBtnCurso1().addActionListener(this);
        this.vistaPrincipal.getBtnCurso2().addActionListener(this);
        this.vistaPrincipal.getBtnCurso3().addActionListener(this);
        this.vistaPrincipal.getBtnCurso4().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        // IF getBtnCurso1
        if (e.getSource() == vistaPrincipal.getBtnCurso1()) {
            System.out.println("getBtnCurso1 vistaPrincipal FUNCIONA");
            JDialogCurso1 curso1 = new JDialogCurso1(vistaPrincipal, true);
            ControladorCurso1 cCurso1 = new ControladorCurso1(curso1);
            curso1.setLocationRelativeTo(null);
            curso1.setVisible(true);
        }// FIN IF getBtnCurso1
        
        // IF getBtnCurso2
        if (e.getSource() == vistaPrincipal.getBtnCurso2()) {
            System.out.println("getBtnCurso2 vistaPrincipal FUNCIONA");
            JDialogCurso2 curso2 = new JDialogCurso2(vistaPrincipal, true);
            ControladorCurso2 cCurso2 = new ControladorCurso2(curso2);
            curso2.setLocationRelativeTo(null);
            curso2.setVisible(true);
        }// FIN IF getBtnCurso2
        
        // IF getBtnCurso3
        if (e.getSource() == vistaPrincipal.getBtnCurso3()) {
            System.out.println("getBtnCurso3 vistaPrincipal FUNCIONA");
            JDialogCurso3 curso3 = new JDialogCurso3(vistaPrincipal, true);
            ControladorCurso3 cCurso3 = new ControladorCurso3(curso3);
            curso3.setLocationRelativeTo(null);
            curso3.setVisible(true);
        }// FIN IF getBtnCurso3
        
        // IF getBtnCurso4
        if (e.getSource() == vistaPrincipal.getBtnCurso4()) {
            System.out.println("getBtnCurso4 vistaPrincipal FUNCIONA");
            JDialogCurso4 curso4 = new JDialogCurso4(vistaPrincipal, true);
            ControladorCurso4 cCurso4 = new ControladorCurso4(curso4);
            curso4.setLocationRelativeTo(null);
            curso4.setVisible(true);
        }// FIN IF getBtnCurso4
        
    }// FIN actionPerformed
    
}// FIN ControladorPrincipal

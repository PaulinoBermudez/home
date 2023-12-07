package Controlador;

import Vista.JDialogCurso1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Toni
 */
public class ControladorCurso1 implements ActionListener{

    private JDialogCurso1 vistaCurso1;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorCurso1(JDialogCurso1 vistaCurso1) {
        this.vistaCurso1 = vistaCurso1;
        this.vistaCurso1.getBtnAsignatura1().addActionListener(this);
        this.vistaCurso1.getBtnAsignatura2().addActionListener(this);
        this.vistaCurso1.getBtnAsignatura3().addActionListener(this);
        this.vistaCurso1.getBtnAsignatura4().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        // IF getBtnAsignatura1
        if (e.getSource() == vistaCurso1.getBtnAsignatura1()) {
            System.out.println("getBtnAsignatura1 JDialogCurso1 FUNCIONA");
            vistaCurso1.dispose();
        }// FIN IF getBtnAsignatura1
        
        // IF getBtnAsignatura2
        if (e.getSource() == vistaCurso1.getBtnAsignatura2()) {
            System.out.println("getBtnAsignatura2 JDialogCurso2 FUNCIONA");
            vistaCurso1.dispose();
        }// FIN IF getBtnAsignatura2
        
        // IF getBtnAsignatura3
        if (e.getSource() == vistaCurso1.getBtnAsignatura3()) {
            System.out.println("getBtnAsignatura3 JDialogCurso3 FUNCIONA");
            vistaCurso1.dispose();
        }// FIN IF getBtnAsignatura3
        
        // IF getBtnAsignatura1
        if (e.getSource() == vistaCurso1.getBtnAsignatura4()) {
            System.out.println("getBtnAsignatura4 JDialogCurso4 FUNCIONA");
            vistaCurso1.dispose();
        }// FIN IF getBtnAsignatura4

    }

}

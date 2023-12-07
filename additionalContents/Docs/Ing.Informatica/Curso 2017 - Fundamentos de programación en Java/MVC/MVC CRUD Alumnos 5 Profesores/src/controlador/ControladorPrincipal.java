package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.AlumnoDAO;
import modelo.ProfesorDAO;
import vista.VistaAlumnos;
import vista.VistaPrincipal;
import vista.VistaProfesores;

public class ControladorPrincipal implements ActionListener {

    private VistaPrincipal vistaPrincipal;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.getBtnAlumnos().addActionListener(this);
        this.vistaPrincipal.getBtnProfesores().addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {

        // Capturo los eventos del Boton Agregar
        if (e.getSource() == vistaPrincipal.getBtnAlumnos()) {
            System.out.println("getBtnAlumnos PRINCIPAL ALUMNOS FUNCIONA");
            VistaAlumnos vistaAlumnos = new VistaAlumnos();
            AlumnoDAO alumnoDao = new AlumnoDAO();
            ControladorAlumnos cAlumnos = new ControladorAlumnos(vistaAlumnos, alumnoDao);
            vistaAlumnos.setVisible(true);
            vistaAlumnos.setLocationRelativeTo(null);
        }// FIN IF getBtnAlumnos

        // Capturo los eventos del Boton Agregar
        if (e.getSource() == vistaPrincipal.getBtnProfesores()) {
            System.out.println("getBtnAlumnos PRINCIPAL Profesores FUNCIONA");
            VistaProfesores vistaProfesores = new VistaProfesores();
            ProfesorDAO profesorDao = new ProfesorDAO();
            ControladorProfesores cProfesores = new ControladorProfesores(vistaProfesores, profesorDao);
            vistaProfesores.setVisible(true);
            vistaProfesores.setLocationRelativeTo(null);

        }// FIN IF getBtnProfesores

    }

}

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.AlumnoDAO;
import modelo.ProfesorDAO;
import vista.VistaAlumnos;
import vista.VistaPrincipal;
import vista.VistaProfesores;

public class ControladorPrincipal implements ActionListener {

    private ControladorPrincipal cPrincipal;
    private ControladorAlumnos cAlumnos;
    private ControladorProfesores cProfesores;
    private VistaPrincipal vistaPrincipal;
    private VistaAlumnos vistaAlumnos;
    private VistaProfesores vistaProfesores;
    private AlumnoDAO alumnoDao;
    private ProfesorDAO profesorDao;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.getBtnAlumnos().addActionListener(this);
        this.vistaPrincipal.getBtnProfesores().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Capturo los eventos del Boton getBtnAlumnos
        if (e.getSource() == vistaPrincipal.getBtnAlumnos()) {
            System.out.println("getBtnAlumnos PRINCIPAL ALUMNOS FUNCIONA");
            vistaAlumnos = new VistaAlumnos();
            alumnoDao = new AlumnoDAO();
            cAlumnos = new ControladorAlumnos(vistaAlumnos, alumnoDao, cPrincipal);
            vistaAlumnos.setVisible(true);
            vistaAlumnos.setLocationRelativeTo(null);
        }// FIN IF getBtnAlumnos

        // Capturo los eventos del Boton getBtnProfesores
        if (e.getSource() == vistaPrincipal.getBtnProfesores()) {
            System.out.println("getBtnAlumnos PRINCIPAL Profesores FUNCIONA");
            vistaProfesores = new VistaProfesores();
            profesorDao = new ProfesorDAO();
            cProfesores = new ControladorProfesores(vistaProfesores, profesorDao, cPrincipal);
            vistaProfesores.setVisible(true);
            vistaProfesores.setLocationRelativeTo(null);
        }// FIN IF getBtnProfesores

    }

}

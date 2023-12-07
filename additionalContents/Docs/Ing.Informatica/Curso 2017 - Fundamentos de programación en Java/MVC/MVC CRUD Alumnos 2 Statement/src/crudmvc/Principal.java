package crudmvc;

import controlador.ControladorAlumnos;
import modelo.AlumnoDAO;
import vista.VistaAlumnos;

/**
 *
 * @author Antonio Rivero Cuesta
 */
public class Principal {
	
    public static void main(String[] args) {
    	
        VistaAlumnos vistaAlumnos = new VistaAlumnos();
        AlumnoDAO alumnoDao = new AlumnoDAO();
        ControladorAlumnos controlaA = new ControladorAlumnos(vistaAlumnos, alumnoDao);
        
        vistaAlumnos.setVisible(true);
        vistaAlumnos.setLocationRelativeTo(null);
    }
}

package Principal;

import Modelo.Alumno;
import Modelo.Horario;
import Controlador.ControladorVista;
import Modelo.Listas;
import Modelo.Profesor;
import Vista.Vista;

/**
 *
 * @author Toni
 */
public class Principal {

    public static void main(String args[]) {

        Listas listas = new Listas();
        Vista vista = new Vista();

        ControladorVista cVista = new ControladorVista(listas, vista);

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        /*
        PRUEBAS ALUMNOS PROFESORES
         */

        Alumno toni = new Alumno("Toni", "Rivero", 1973, Horario.MAÑANA);
        Alumno marc = new Alumno("Marc", "Rivero", 2009, Horario.TARDE);
        listas.agregarAlumno(toni);
        listas.agregarAlumno(marc);
        Profesor miguel = new Profesor("Miguel", "Rivero", 1973, Horario.MAÑANA);
        Profesor lorenzo = new Profesor("Lorenzo", "Rivero", 2009, Horario.TARDE);
        listas.agregarProfesor(miguel);
        listas.agregarProfesor(lorenzo);

        /*
        PRUEBAS ALUMNOS PROFESORES
         */
    }
}

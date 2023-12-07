
import javax.swing.JOptionPane;

/**
 * @(#)PersonaApp.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */
public class PersonaApp {

    public static void main(String[] args) {

        // Creo un objeto de tipo Persona.
        Persona kike = new Persona("Kike", 25);

        // Creo un objeto de tipo Estudiante.
        Estudiante chacho = new Estudiante("Juan Jose", 20, "Industriales", 123456);

        // Creo un objeto de tipo Profesor.
        Profesor toni = new Profesor("Rivero", 40, "Fundamentos de Informatica", "Titular");

        System.out.println("Objeto Kike de tipo Persona");
        System.out.printf("Nombre: %s, Edad: %d \n",
                kike.getNombre(),
                kike.getEdad());
        System.out.println("");

        System.out.println("Objeto Chacho de tipo Estudiante");
        System.out.printf("Nombre: %s, Carrera: %s, Edad: %d, Expediente: %d \n",
                chacho.getNombre(),
                chacho.getCarrera(),
                chacho.getEdad(),
                chacho.getExpediente());
        System.out.println("");

        System.out.println("Objeto Toni de tipo Profesor");
        System.out.printf("Nombre: %s, Edad: %d, Materia: %s, Cargo: %s, \n",
                toni.getNombre(),
                toni.getEdad(),
                toni.getMateria(),
                toni.getCargo());
        System.out.println("");

        // Comprobamos si el Objeto toni es de tipo Persona
        if (toni instanceof Persona) {
            System.out.println("toni es un Profesor y tambien una Persona");
             	
        JOptionPane.showMessageDialog(
                null,
                "Comprobar Objeto",
                "Es un Objeto de esta Clase",
                JOptionPane.INFORMATION_MESSAGE);
    	}
    }
}

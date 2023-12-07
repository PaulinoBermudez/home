/**
 * @(#)Profesor.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */

public class Profesor extends Persona {

    private String IdProfesor;

    public Profesor (String nombre, String apellidos, int edad) {

        super(nombre, apellidos, edad);

        IdProfesor = "Unknown";
    }

    public void setIdProfesor (String IdProfesor) {
    	this.IdProfesor = IdProfesor;
    }

    public String getIdProfesor () {
    	return IdProfesor;
    }

    public void mostrarNombreApellidosYCarnet() {

        // nombre = "Paco"; Si trat�ramos de acceder directamente a un campo privado de la superclase, salta un error

        // S� podemos acceder a variables de instancia a trav�s de los m�todos de acceso p�blicos de la superclase

        System.out.println ("Profesor de nombre: " + getNombre() + " " +  getApellidos() +

         " con Id de profesor: " + getIdProfesor());
     }
}
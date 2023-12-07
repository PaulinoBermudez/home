/**
 * @(#)TestHerencia1.java
 *
 *
 * @author 
 * @version 1.00 2015/12/30
 */

public class TestHerencia1 {

    public static void main (String args[]) {

        Profesor profesor1 = new Profesor ("Juan", "Hernández García", 33);

        profesor1.setIdProfesor("Prof 22-387-11");

        profesor1.mostrarNombreApellidosYCarnet();
    }
}
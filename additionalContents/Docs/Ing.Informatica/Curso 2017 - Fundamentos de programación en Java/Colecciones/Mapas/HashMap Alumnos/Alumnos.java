/**
 * @(#)Alumnos.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/20
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Alumnos{
		
	//Definimos los atributos.
    private int edad;
    private String nombre;
    
    Alumnos(String nombre, int edad){
    	this.nombre = nombre;
        this.edad = edad;  
    }
	
    public String toString(){
    	return nombre;
    }
   
    // Sobreescribimos el metodo equals y el metodo hashcode
    
    /* Ahora vamos a cambiar el comportamiento de la clase
     * Alumnos para que al insertarlo en un HashMap o en
     * un HashSet se valide si el elemento insertado ya existe.
     * Sobrescribimos el método .equals() de tal manera que dos
     * objetos Alumno serán iguales si coinciden sus nombres.
	*/
	
    @Override
    public boolean equals(Object o) {
        if (o instanceof Alumnos) {
            Alumnos p = (Alumnos)o;
           return this.nombre.equals(p.nombre);  
        } else {
            return false;
        }
    }
   
    // Recordar que el metodo  hashcode retorna un int
    
    /*
     *De igual manera sobrescribimos el método .hashCode().
     * Para generar el hascode utilizamos la variable edad
     * y la longitud del String, consiguiendo así un entero.
     */
    @Override
    public int hashCode() {
        return edad * this.nombre.length();
    }
}
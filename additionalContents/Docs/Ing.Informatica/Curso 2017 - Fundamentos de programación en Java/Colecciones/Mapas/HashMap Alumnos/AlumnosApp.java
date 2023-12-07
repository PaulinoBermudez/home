/**
 * @(#)AlumnosApp.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/10
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AlumnosApp{
	
	public static void main(String[] args){
		
        Alumnos person1 = new Alumnos("Juan",18);
        Alumnos person2 = new Alumnos("Miguel",25);
        Alumnos person3 = new Alumnos("Luis",18);
        Alumnos person4 = new Alumnos("Luis",18);
       
        //insertar los objetos Alumnos en un HashSet.
        HashSet<Alumnos> personas = new HashSet<Alumnos>();
        
        personas.add(person1);
        personas.add(person2);
        personas.add(person3);
        personas.add(person4);
 
        //verificamos el tamaño del HashSet alumnos.
        System.out.println(personas.size());
        System.out.println("");
   
        //agregamos 4 objetos alumno a un HashMap.
        Map<Alumnos,String> m = new HashMap<Alumnos,String>();
   
        m.put(person1, "valor1");
        m.put(person2, "valor2");
        m.put(person3, "valor1");
        m.put(person4, "mi valor");
        

        // El método keySet() devuelve todos los elementos del HashMap.
        System.out.println(m.keySet());
        System.out.println("");
        
        // El método size() nos devolvera un tamaño de "4" ya que el 
        // HashMap tampoco realiza ninguna comparación.        
        System.out.println(m.size());
    }	
}
/**
 * @(#)PersonaApp.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/17
 */

import java.util.HashMap;
import java.util.Map;

public class PersonaApp {
	
	public static void main (String []args) {
		
		Map <Integer,Persona> mp = new HashMap<Integer,Persona>();
		
		Persona p = new Persona(4,"María",167);
		mp.put(4, p); // Agregamos un objeto persona al map
		
		p = new Persona(1,"Marta",165);
		mp.put(1, p); // Agregamos un objeto persona al map
		
		p = new Persona(3,"Elena",185);
		mp.put(3, p); // Agregamos un objeto persona al map
		
		p = new Persona(2,"Yolanda",174);
		mp.put(2, p); // Agregamos un objeto persona al map
		
		p = new Persona(5,"María Dolores",169);
		// Esto crea una colisión 
		// Dos objetos no pueden tener la misma clave.
		mp.put(4, p); 
		
		System.out.println("Personas en el mapa: \n"+mp.toString().replaceAll(",", "\n"));
	}
}
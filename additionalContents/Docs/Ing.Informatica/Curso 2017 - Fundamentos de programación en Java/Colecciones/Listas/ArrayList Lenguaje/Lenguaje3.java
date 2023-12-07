/**
 * @(#)Lenguaje3.java
 *
 * Utilizo un for-each
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/22
 */

import java.util.ArrayList;

public class Lenguaje3{
	
	public static void main(String args[]){
		
		//Declaro un ArrayList
    	ArrayList<String> lenguajes = new ArrayList<String>();
    	
    	//Agrego cuatro lenguajes
    	lenguajes.add ("Java");
    	lenguajes.add ("Python");
    	lenguajes.add ("Modula2");
    	lenguajes.add ("C##");
    	
    	//Imprimo las peliculas introducidas    	
    	System.out.println(lenguajes);
    	System.out.println("");
		
		for (String lenguaje : lenguajes)
			System.out.println("Leguaje de programacion " + lenguaje);
  }
}
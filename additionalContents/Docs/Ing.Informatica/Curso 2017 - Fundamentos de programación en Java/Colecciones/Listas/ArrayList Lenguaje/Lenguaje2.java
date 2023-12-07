/**
 * @(#)Lenguaje2.java
 *
 * Utilizo un Iterator
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/22
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Lenguaje2{
	
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
    
    	Iterator <String> iterador = lenguajes.iterator();
    	while (iterador.hasNext()){
    		String lenguaje = iterador.next();
    		System.out.println("Leguaje de programacion " + lenguaje);
    	}
  	}
}
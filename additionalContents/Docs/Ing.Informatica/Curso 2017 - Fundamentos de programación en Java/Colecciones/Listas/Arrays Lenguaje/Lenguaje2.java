/**
 * @(#)Lenguaje2.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/22
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lenguaje2{
	
	public static void main(String args[]){
		
		List<String> lenguajes = Arrays.asList("Java", "Python", "Ruby", "C#");
    
    	Iterator <String> iterador = lenguajes.iterator();

    	while (iterador.hasNext()){
    		String lenguaje = iterador.next();
    		System.out.println("Me gusta " + lenguaje);
    	}
  	}
}
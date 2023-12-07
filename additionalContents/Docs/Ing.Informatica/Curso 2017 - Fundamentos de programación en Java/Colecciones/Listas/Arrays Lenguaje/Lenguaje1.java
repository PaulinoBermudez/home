/**
 * @(#)Lenguaje1.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/22
 */

import java.util.Arrays;
import java.util.List;


public class Lenguaje1{
	
	public static void main(String args[]) {
		
		List<String> lenguajes = Arrays.asList("Java", "Python", "Ruby", "C#");

    	for (int i = 0; i < lenguajes.size(); i++){
    		
    		String lenguaje = lenguajes.get(i);
    		System.out.println("Me gusta " + lenguaje);
    }
  }
} 
/**
 * @(#)Lenguaje3.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/22
 */

import java.util.Arrays;
import java.util.List;


public class Lenguaje3{
	
	public static void main(String args[]){
		
		List<String> lenguajes = Arrays.asList("Java", "Python", "Ruby", "C#");
		
		for (String lenguaje : lenguajes)
			System.out.println("Me gusta " + lenguaje);
  }
}
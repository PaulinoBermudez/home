/**
 * @(#)Lenguaje1.java
 *
 * Utilizo un for
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2015/6/22
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Lenguaje1{
	
	public static void main(String args[]) {
		
		//Declaro un ArrayList
    	ArrayList<String> lenguajes = new ArrayList<String>();
    	Scanner teclado = new Scanner(System.in);
    	
    	//Agrego cuatro lenguajes
    	lenguajes.add ("Java");
    	lenguajes.add ("Python");
    	lenguajes.add ("Modula2");
    	lenguajes.add ("C##");
    	
    	//Imprimo las peliculas introducidas
    	System.out.println(lenguajes);
    	System.out.println("");
    	
    	
		//Imprimo las peliculas reccorriendo el ArrayList con un for
    	for (int i = 0; i < lenguajes.size(); i++){
    		String lenguaje = lenguajes.get(i);
    		System.out.println("Leguaje de programacion " + lenguaje);
    	}
    	
    	try{
    	
    	System.out.println();
    	System.out.print("Introducir la posicion a Leer: ");
		int posicion = teclado.nextInt();
    	System.out.println();
    	System.out.println(lenguajes.get(posicion));
    	
    	}catch(IndexOutOfBoundsException IOB){
    		System.out.print("Posicion fuera de rango, vuelva a insertar posicion: ");
			int posicion = teclado.nextInt();
		}
  	}
}
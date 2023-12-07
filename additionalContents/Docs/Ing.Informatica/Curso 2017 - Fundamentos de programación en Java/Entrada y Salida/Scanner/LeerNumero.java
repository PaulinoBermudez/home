/**
 * @(#)Ejemplo3.java
 * Programa para leer un fichero de texto en una
 * carpeta y mostrar por pantalla un numero que
 * contiene.
 * Caso contrario devuelve -1.
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/15
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class LeerNumero{
	
	public static void main (String[] args){
	
	Scanner entrada = new Scanner(System.in);
	long numero = -1;
	
	try{
		entrada = new Scanner(new File("C:/Scanner.txt"));
		while (entrada.hasNextLong()){
			numero = entrada.nextLong();
	    }
	    entrada.close();
	    }
	    catch (FileNotFoundException e){
	    	
	    	//Se utiliza para imprimir el registro del stack
        	// donde se ha iniciado la excepción. 
	    	e.printStackTrace();
		}		
		System.out.println("Numero: "+numero);
	}
}





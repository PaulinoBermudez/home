/**
 * @(#)EntradaJava.java
 * Ejemplo con BufferedReader
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntradaJava{
	
    public static void main(String[] args) throws IOException{
    	
        // readLine() nos obliga a declarar IOException
        // Ya tenemos el "lector"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Se pide un dato al usuario
        System.out.print("Escribir un nombre: ");
		
		//Se lee el nombre con readLine() que retorna un String con el dato
        String nombre = br.readLine(); 
		
		//Se pide otro dato al usuario
        System.out.print("Bienvenido " + nombre + ". Escribir edad: ");
		
		//Se guarda la entrada (edad) en una variable
        String entrada = br.readLine(); 

        //readLine siempre retorna String y la clase BufferedReader...
        //no tiene un m�todo para leer enteros, as� que debemos convertirlo.

		//Se transforma la entrada anterior en un entero
		//Si el usuario ingres� solo n�meros funcionar� bien,
		// de lo contrario generar� una excepci�n
        int edad = Integer.parseInt(entrada);
        
        //Operacion numerica con la edad
        System.out.println("Gracias " + nombre + " en 5 a�os usted tendr� " + (edad + 5) + " a�os."); 
    }
}	
/**
 * @(#)Scanner.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/15
 */


import java.util.Scanner;

public class CadenaTexto{
 	
 	public static void main(String arg[]){
 		
 		String variableString;
 		
 		// se declara e inicializa una instancia de la clase Scanner.
 		Scanner entrada=new Scanner(System.in);
 		System.out.print("Ingrese un texto: ");
 		variableString = entrada.nextLine();
 		System.out.println("Texto ingresado: " + variableString);
 	}
}
import java.util.InputMismatchException;

/**
 * @(#)Scanner.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/15
 */

import java.util.Scanner;
 
public class Numeros{
	
	private int variableEntero;
	private float variableFloat;
		
	public void Datos(){
		
		try{
		
		Scanner entrada=new Scanner(System.in);
			
		System.out.print("Ingrese un entero: ");
		variableEntero = entrada.nextInt();
		System.out.println("Entero ingresado: "+variableEntero);
			
		System.out.print("Ingrese un float: ");
		variableFloat = entrada.nextFloat();
		System.out.println("float ingresado: "+variableFloat);
		
		}catch(InputMismatchException e){
			System.out.println ("Introducir bien los números: ");
			Datos();
		}
	}
}
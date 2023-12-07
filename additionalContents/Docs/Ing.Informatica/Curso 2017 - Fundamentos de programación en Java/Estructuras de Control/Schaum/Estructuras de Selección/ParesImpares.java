/*
 * Escribir un programa de nombre ParesImpares, en el
 * que nos piden un número entero y el programa indica
 * por pantalla si es par o impar.
 *
 */

import java.util.Scanner;

public class ParesImpares{
	
	public static void main(String[] args){
		
		Scanner teclado=new Scanner(System.in);
		System.out.print("Escriba un numero: ");
		int numero=teclado.nextInt();
		
		if(numero % 2==0){
			System.out.println("El numero "+numero+" es par");
		}else{
			System.out.println("El numero "+numero+" es impar");
   		}
   }
}
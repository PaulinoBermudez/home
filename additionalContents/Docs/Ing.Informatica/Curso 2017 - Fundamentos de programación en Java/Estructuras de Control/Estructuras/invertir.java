/*
 * Programa para invertir una cadena de números
 *
 */

import java.util.Scanner;

class invertir{

	 static int invertir(int n){
		
		if (n<10)
		System.out.println(n);
		//caso base
		
		else{
			System.out.print(n%10);
			invertir (n/10);
			// caso recursivo
		}
		return n;
	}
	public static void main(String args[]){
		int n;
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduzca los datos: ");
		System.out.print ("Numero: ");
		n = teclado.nextInt();
		invertir(n);
	}
}
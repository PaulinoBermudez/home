/*
 * Escriba un programa, de nombre dibujaTri�ngulo2,
 * que reciba un entero como par�metro, el m�todo debe
 * dibujar un tri�ngulo como el que se muestra en el
 * siguiente dibujo despu�s de comprobar que el valor del
 * par�metro se encuentra entre 3 y 15 ambos incluidos.
 *
 *        * 
 *      * * 
 *    * * * 
 *  * * * * 
 */

import java.util.Scanner;

class dibujaTriangulo2{
	static void dibujaTriangulo2(int lado){
		if (lado > 3 && lado < 15){
			for (int i=0; i<lado;i++){
				for (int j=0; j<lado-i;j++){
					System.out.print("  ");
				}
				for(int j=0; j<i+1;j++){
					System.out.print("* ");
				}
				System.out.println();
			}
		}else{System.out.println("El lado del triangulo debe estar entre 3 y 15.");
		}
	}
	
	public static void main(String args[]){
		int lado;
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduzca los datos: ");
		System.out.print ("Lado: ");
		lado = teclado.nextInt();
		dibujaTriangulo2(lado);
	}
}
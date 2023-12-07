/*
 * Escriba un programa, de nombre dibujaTriángulo3,
 * que reciba un entero como parámetro, el método debe
 * dibujar un triángulo como el que se muestra en el
 * siguiente dibujo después de comprobar que el valor del
 * parámetro es un número impar positivo.
 *
 *        * 
 *      * * *
 *    * * * * *
 *  * * * * * * *
 */

import java.util.Scanner;

class dibujaTriangulo3{
	static void dibujaTriangulo3(int lado){
		if (lado %2 == 1 && lado> 0){
			for(int i = 0; i < (lado + 1)/2; i++){
				for(int j = 0; j < (lado + 1)/2 - i-1; j++){
					System.out.print("  ");
				}
				for(int j = 0; j < 2*i + 1; j++){
					System.out.print("* ");
				}
				System.out.println();
			}
		}else{
			System.out.println("El lado del triangulo debe ser un impar positivo. ");
		}
	}
	
	public static void main(String args[]){
		int lado;
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduzca los datos: ");
		System.out.print ("Lado: ");
		lado = teclado.nextInt();
		dibujaTriangulo3(lado);
	}
}
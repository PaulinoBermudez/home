/*
 * Escriba un programa, de nombre dibujaTriángulo,
 * que reciba un entero como parámetro, el método debe
 * dibujar un triángulo como el que se muestra en el
 * siguiente dibujo después de comprobar que el valor del
 * parámetro es menor de 15.
 *
 *        * * * * 
 *        * * * 
 *        * * 
 *        *
 */

import java.util.Scanner;

class dibujaTriangulo{
	static void dibujaTriangulo(int lado){
		if (lado<15){
			for (int i=0; i<lado;i++){
				for (int j=0; j<lado-i;j++){
					System.out.print("* ");
				}
				System.out.println();
			}
		}else{System.out.println("Lado muy grande.");
		}
	}
	
	public static void main(String args[]){
		int lado;
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduzca los datos: ");
		System.out.print ("Lado: ");
		lado = teclado.nextInt();
		dibujaTriangulo(lado);
	}
}
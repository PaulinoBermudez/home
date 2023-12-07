/*
 * Escribir un programa, de nombre dibujaRectangulo,
 * que reciba dos valores enteros como parámetros, el método
 * debe dibujar un rectángulo en el que la base es mayor que
 * la altura, por lo que se utilizará como base el
 * mayor de los valores proporcionados como parámetro
 * y como altura el menor.
 *
 */

import java.util.Scanner;

class dibujaRectangulo{
	
static void dibujaRectangulo(int a, int b){
	int base = (a>b)? a:b;
	int altura = (a<b) ? a:b;
	for (int i =0; i<altura;i++){
		for (int j=0; j<base; j++){
			System.out.print("* ");
		}
		System.out.println();
	}
}

public static void main (String args[]){
		int a,b;
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduzca los datos: ");
		System.out.print ("Lado 1: ");
		a = teclado.nextInt();
		System.out.print ("Lado 2: ");
		b = teclado.nextInt();
		
		dibujaRectangulo(a,b);
}	
}
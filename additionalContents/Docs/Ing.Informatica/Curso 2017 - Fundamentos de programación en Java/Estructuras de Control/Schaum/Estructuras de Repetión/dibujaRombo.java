/**
 * Escriba un método dibujaRombo que reciba un entero como parámetro.
 * El método debe dibujar un rombo como el que se muestra en el
 * siguiente dibujo después de comprobar que el valor que recibe como argumento,
 * que indica la altura del rombo, es un número impar mayor o igual que 3.
 * Por ejemplo si el valor del parámetro es 5 el método dibujará el siguiente
 * rombo con 5 asteriscos en la parte central:
 */

import java.util.Scanner;

public class dibujaRombo{
static void dibujaRombo(int altura){
	if (altura %2 == 1 && altura >= 3){
		
		// se dibuja la parte superior
		for(int i= 0; i < (altura + 1)/2; i++){
			for(int j = 0; j < (altura + 1)/2 - i-1; j++){
				System.out.print("  ");
			}
			for(int j= 0; j < 2*i+1; j++){
				System.out.print("* ");			
			}
			System.out.println();
		}
		
		//Se dibuja la parte inferior
		//Expresión que calcula cuántos espacios hay que escribir en la fila i
		for(int i = 0; i < altura/2; i++){
			for(int j = 0; j < i + 1; j++){
				System.out.print("  ");
			}
			
			//Expresión que calcula cuántos asteriscos hay que escribir
			// en la fila i de la parle inferior.
			for(int j = 0; j < (altura/2 - i)*2 - 1; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}else{
			System.out.println("El lado del triángulo debe ser un impar positivo.");
		}
}

	public static void main(String args[]){
		int lado;
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduzca los datos: ");
		System.out.print ("Lado: ");
		lado = teclado.nextInt();
		dibujaRombo(lado);
	}
}
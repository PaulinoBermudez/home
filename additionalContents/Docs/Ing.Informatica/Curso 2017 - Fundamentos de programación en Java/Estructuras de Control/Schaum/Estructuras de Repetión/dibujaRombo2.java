/**
 * Escriba un método dibujaRombo que reciba un entero como parámetro.
 * El método debe dibujar un rombo como el que se muestra en el
 * siguiente dibujo después de comprobar que el valor que recibe como argumento,
 * que indica la altura del rombo, es un número.impar mayor o igual que 3.
 * Por ejemplo si el valor del parámetro es 5 el método dibujará el siguiente
 * rombo con 5 asteriscos en la parte central:
 */

import java.util.Scanner;

public class dibujaRombo2{
static void dibujaRombo2(int altura){
	if (altura %2 == 1 && altura >= 3){
	int espacios = altura / 2;
	int asteriscos = 1;
	
	// se dibuja 7a parte superior
	for(int i = 0; i < (altura + 1)/2; i++){
		for(int j = 0; j < espacios; j++){
		System.out.print("  ");
	}
	for(int j = 0; j < asteriscos; j++){
		System.out.print("* ");
	}
	System.out.println();
	espacios -= 1;
	asteriscos += 2;
	}
	espacios = 1;
	asteriscos = altura - 2;
	// se djbuja la parte jnferjor
	for(int i = 0; i < altura/2; i++){
		for(int j = 0; j < espacios; j++){
			System.out.print("  ");
		}
	for(int j = 0; j < asteriscos; j++){
		System.out.print("* ");
	}
	System.out.println();
	//Cada fila siguiente liene un espacio
	//más y dos asteriscos menos.
	espacios += 1;
	asteriscos -= 2;
	}
	}else{
		System.out.println("El lado del triángulo debe ser un impar positivo. ");
	}
}


	public static void main(String args[]){
		int lado;
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduzca los datos: ");
		System.out.print ("Lado: ");
		lado = teclado.nextInt();
		dibujaRombo2(lado);
	}
}
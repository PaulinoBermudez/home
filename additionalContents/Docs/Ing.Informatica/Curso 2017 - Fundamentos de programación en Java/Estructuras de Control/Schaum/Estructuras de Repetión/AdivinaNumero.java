/**
 * Escriba un programa que juegue con el usuario a adivinar un número.
 * El ordenador debe generar un número entre 1 y 100 Y el usuario tiene
 * que intentar adivinarlo. Para ello, cada vez que el usuario introduce
 * un valor el ordenador debe decirle al usuario si el número que tiene
 * que adivinar es mayor o menor que el que ha introducido.
 * Cuando consiga adivinarlo debe indicárselo e imprimir en pantalla el
 * número de veces que el usuario ha intentado adivinar el número.
 * Si el usuario introduce algo que no es un número debe indicarlo de
 * esta forma en pantalla y contarlo como un intento.
 */

import java.util.*;
public class AdivinaNumero {
	public static void main (String []args){
		Scanner teclado = new Scanner(System. in);
		
		int númeroAdivinar = (int)(Math.random()*100);
		// debe ser entre 1 y 100. por 70 que se incrementa en uno
		númeroAdivinar++;
		int número = 0;
		int intentos = 0;
		do{
			System.out. print(" Introduzca un número (1-100): ");
			número = teclado.nextInt();
			intentos++;
			System.out.println("El número introducido fue: " + número);
			
			if (número > númeroAdivinar)
				System.out.println("El número es menor. Inténtalo otra vez.");
				if (número < númeroAdivinar)
					System.out.println("El número es mayor. Inténtalo otra vez.");
					}while(número != númeroAdivinar);
					System.out.println("Enhorabuena. Ya lo ha adivinado. El número era: " + númeroAdivinar);
					System.out.println("Lo ha conseguido en " + intentos + " intentos.");
	}
}
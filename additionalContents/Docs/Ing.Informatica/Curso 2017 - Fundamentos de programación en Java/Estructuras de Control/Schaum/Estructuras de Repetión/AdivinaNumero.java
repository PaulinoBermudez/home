/**
 * Escriba un programa que juegue con el usuario a adivinar un n�mero.
 * El ordenador debe generar un n�mero entre 1 y 100 Y el usuario tiene
 * que intentar adivinarlo. Para ello, cada vez que el usuario introduce
 * un valor el ordenador debe decirle al usuario si el n�mero que tiene
 * que adivinar es mayor o menor que el que ha introducido.
 * Cuando consiga adivinarlo debe indic�rselo e imprimir en pantalla el
 * n�mero de veces que el usuario ha intentado adivinar el n�mero.
 * Si el usuario introduce algo que no es un n�mero debe indicarlo de
 * esta forma en pantalla y contarlo como un intento.
 */

import java.util.*;
public class AdivinaNumero {
	public static void main (String []args){
		Scanner teclado = new Scanner(System. in);
		
		int n�meroAdivinar = (int)(Math.random()*100);
		// debe ser entre 1 y 100. por 70 que se incrementa en uno
		n�meroAdivinar++;
		int n�mero = 0;
		int intentos = 0;
		do{
			System.out. print(" Introduzca un n�mero (1-100): ");
			n�mero = teclado.nextInt();
			intentos++;
			System.out.println("El n�mero introducido fue: " + n�mero);
			
			if (n�mero > n�meroAdivinar)
				System.out.println("El n�mero es menor. Int�ntalo otra vez.");
				if (n�mero < n�meroAdivinar)
					System.out.println("El n�mero es mayor. Int�ntalo otra vez.");
					}while(n�mero != n�meroAdivinar);
					System.out.println("Enhorabuena. Ya lo ha adivinado. El n�mero era: " + n�meroAdivinar);
					System.out.println("Lo ha conseguido en " + intentos + " intentos.");
	}
}
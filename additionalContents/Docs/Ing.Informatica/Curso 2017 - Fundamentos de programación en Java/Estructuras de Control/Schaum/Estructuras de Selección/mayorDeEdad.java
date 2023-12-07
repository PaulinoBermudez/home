/*
 *Escribir un programa, de nombre mayorDeEdad, 
 *que reciba una edad como mensaje por pantalla
 *si es mayor de edad o no.
 *Debemos introducir por tecla una edad y observar
 *si la persona es o no mayor de edad.
 *
 */

import java.util.Scanner;

class mayorDeEdad{
	
	static void mayorDeEdad(){
		
		int edad;
		final int MAYORIA_EDAD =18;
		
		Scanner teclado = new Scanner (System.in);
		System.out.print ("¿Cúal es la edad de la persona? ");
		edad = teclado.nextInt();
		
		System.out.print("La persona ");
		if(edad < MAYORIA_EDAD){
			System.out.print("no ");
		}
		
		System.out.println("es mayor de edad.");
	}
	
	public static void main(String args[]){
		mayorDeEdad();
	}
}
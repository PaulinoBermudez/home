/**
 * @(#)Switch2.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2016/1/7
 */

import java.util.Scanner;

public class Switch2 {
	static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
	static int select = -1; //opción elegida del usuario
	static int num1 = 0, num2 = 0; //Variables
	
	public static void main(String[] args) {
		
		//Mientras la opción elegida sea 0, preguntamos al usuario
		while(select != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
				System.out.println("Elige opción:\n1.- Sumar" +
						"\n2.- Restar\n" +
						"3.- Multiplicar\n" +
						"4.- Dividir\n" +
						"0.- Salir");
				//Recoger una variable por consola
				select = Integer.parseInt(scanner.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(select){
				case 1: 
					pideNumeros();
					System.out.println(num1+" + "+num2+" = "+(num1+num2));
					break;
				case 2: 
					pideNumeros();
					System.out.println(num1+" - "+num2+" = "+(num1-num2));
					break;
				case 3: 
					pideNumeros();
					System.out.println(num1+" * "+num2+" = "+(num1*num2));
					break;
				case 4: 
					pideNumeros();
					System.out.println(num1+" / "+num2+" = "+(num1/num2));
					break;
				case 0: 
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
				
				System.out.println("\n"); //Mostrar un salto de línea en Java
				
			}catch(Exception e){
				System.out.println("Uoop! Error!");
			}
		}

	}
	
	//Método para recoger variables por consola
	public static void pideNumeros(){
		System.out.println("Introduce número 1:");
		num1 = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Introduce número 2:");
		num2 = Integer.parseInt(scanner.nextLine());

		//Mostrar un salto de línea en Java
		System.out.println("\n"); 
	}

}
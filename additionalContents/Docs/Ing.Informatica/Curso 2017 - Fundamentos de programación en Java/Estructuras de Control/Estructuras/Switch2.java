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
	static int select = -1; //opci�n elegida del usuario
	static int num1 = 0, num2 = 0; //Variables
	
	public static void main(String[] args) {
		
		//Mientras la opci�n elegida sea 0, preguntamos al usuario
		while(select != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
				System.out.println("Elige opci�n:\n1.- Sumar" +
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
					System.out.println("N�mero no reconocido");break;
				}
				
				System.out.println("\n"); //Mostrar un salto de l�nea en Java
				
			}catch(Exception e){
				System.out.println("Uoop! Error!");
			}
		}

	}
	
	//M�todo para recoger variables por consola
	public static void pideNumeros(){
		System.out.println("Introduce n�mero 1:");
		num1 = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Introduce n�mero 2:");
		num2 = Integer.parseInt(scanner.nextLine());

		//Mostrar un salto de l�nea en Java
		System.out.println("\n"); 
	}

}
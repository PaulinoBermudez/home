/**
 * @(#)EntradaJava2.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

import java.util.Scanner;

public class EntradaJava2{
	
    public static void main(String[] args){
    	
    	//Se crea el lector
        Scanner sc = new Scanner(System.in); 
        
        //Se pide un dato al usuario
        System.out.print("Por favor ingrese su nombre: ");
        
        //Se lee el nombre con nextLine() que retorna un String con el dato
        String nombre = sc.nextLine();
        
		//Se pide otro dato al usuario
        System.out.println("Bienvenido "+nombre+". Por favor ingrese su edad");
		
		//Se guarda la edad directamente con nextInt()
        int edad = sc.nextInt(); 

		//Operacion numerica con la edad
        System.out.println("Gracias "+nombre+" en 10 años usted tendrá "+(edad + 10)+" años."); 
    }
}
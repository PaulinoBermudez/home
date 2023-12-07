/**
 * @(#)AreaCilindro.java
 * Programa para calcular el area de un cilindro.
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/15
 */

import java.util.Scanner;

public class AreaCilindro{
	
	private static final double PI =3.1415;
	private double radio;
	private double altura;
		
	public void Datos(){
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Introduzca los datos del cilindro: ");
			
		System.out.print ("Radio: ");
		radio = teclado.nextDouble();
			
		System.out.print ("altura: ");
		altura = teclado.nextDouble();
			
		System.out.print ("El area del cilindro es: ");
		System.out.println(PI*radio*radio*altura);			
	}
}
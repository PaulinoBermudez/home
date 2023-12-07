/**
 * @(#)LeerTeclado.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LeerTeclado {
	
	public static void main(String arg[]) throws IOException{
		
		InputStreamReader conversor;
		BufferedReader teclado;
		String linea;
			
		conversor = new InputStreamReader(System.in);
		teclado = new BufferedReader(conversor);
		
		System. out. print("Introduzca un byte: ");
		linea = teclado.readLine();
		byte b = Byte.parseByte(linea);
		System.out.println("El valor leído fue: " + b);

		System.out. print("Introduzca un int: ");
		linea = teclado.readLine();
		int i = Integer.parseInt(linea);
		System.out.println("El valor leído fue: " + i);
		
		System.out.print("Introduzca un doub1e: ");
		linea = teclado.readLine();
		double d = Double.parseDouble(linea);
		System.out.println("El valor leido fue: " + d);
		
		boolean leido;
		
		do {
			try {
				System.out.print("Introduzca un int: ");
				linea = teclado.readLine();
				i = Integer.parseInt(linea);
				leido = true;
			} catch (NumberFormatException e) {
				System.out.println("Numero no valido. Vuelva a intentarlo. ");
				leido = false;
			}
		} while (!leido);
		System.out.println("El valor leído fue: "+ i);
	}
}
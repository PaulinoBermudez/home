/**
 * @(#)PruebaArchivos.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/29
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaArchivos{
	
	public static void main (String arg[]){
		
		String nombreArchivo = "prueba.txt";
		FileWriter escribir;
		
		try{
			escribir = new FileWriter(nombreArchivo);
			for (char c= 'a'; c<= 'z'; c++){
				escribir.write(c);
			}
			escribir.close();
		}catch (IOException e){
			System.out.println("Imposible abrir el archivo para escribir.");
		}
		
		FileReader leer;
		int c;
		
		try{
			leer =new FileReader(nombreArchivo);
			c= leer.read();
			// -1 indica que no hay más caracteres.
			while (c != -1){
				System.out.print((char)c);
				c=leer.read();
			}
			leer.close();
		}catch (IOException e){
			System.out.println("Imposible abrir el archivo para leer.");
		}
	}
}
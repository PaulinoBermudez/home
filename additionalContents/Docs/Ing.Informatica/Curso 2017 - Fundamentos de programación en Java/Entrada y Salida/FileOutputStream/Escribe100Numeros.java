/**
 * @(#)Escribe100Numeros.java
 * 
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileOutputStream;

public class Escribe100Numeros{
	
	public static void main(String args[]){
		
		try{
			
			FileOutputStream archivoNumeros = new FileOutputStream ("C:\\Java/Numeros.txt");
			
			for (int i=0; i<100; i++){
				archivoNumeros.write(i);
			}
			
			archivoNumeros.close();
			
		}catch(IOException ioE){
			
			System.out.println("Error de escritura: " + ioE.toString());
		}
	}
}
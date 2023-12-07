/**
 * @(#)LeerArchivo.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeerArchivo{
	
	public static void main(String args[]){
		
		String nombreArchivo = "LeerArchivo.java";
		FileReader archivo;
		BufferedReader filtro;
		String linea;
		
		try {
			archivo = new FileReader(nombreArchivo);
			filtro = new BufferedReader(archivo);
			linea = filtro.readLine();
			
			while (linea != null){
			System.out.println(linea);
			linea = filtro.readLine();
			}
			
			filtro.close();
		} catch (IOException e){
			System.out.println("Imposible abrir el archivo para leer.");
		}
	}
}
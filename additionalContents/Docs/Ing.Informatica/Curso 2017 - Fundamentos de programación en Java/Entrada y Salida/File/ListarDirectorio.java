/**
 * @(#)ListarDirectorio.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 *
 * En el siguiente ejemplo puede ver un programa que muestra
 * el contenido de un directorio. 
 * Si no se indica nada en la linea de comandos, muestra
 * el contenido del directorio actual.
 * Si se indica un directorio, muestra el contenido del
 * directorio indicado.
 * Si se encuentra un nombre de directorio, sólo se indica el nombre.
 * Si se encuentra el nombre de un archivo, se muestra su tamaño y fecha.
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ListarDirectorio {
	
	public static void main (String arg[]){
		
		String directorio;
		
		if (arg.length > 0) {
			directorio = arg[0];
		} else {
			
			// Directorio donde realizamos la lectura
			directorio = "E:/Píldoras Informáticas Java";
			// Directorio actual
			//directorio = ".";
		}
		
		// Se crea un objeto de la clase File
		File actual = new File(directorio);
		System.out.print("El directorio es: ");
		try {
			// Devuelve la ruta única absoluta asociada al objeto File.
			System.out.println(actual.getCanonicalPath());
		} catch (IOException e) {
			System.out.println("RUTA INCORRECTA");
		}
		System.out.println("Su contenido es:");
		
		// Se obtiene la lista completa de los objetos File
		// que contiene en el sistema de archivos.
		File[] archivos = actual.listFiles();
		
		// Con el bucle for se recorre el array obtenido.
		// Si el objeto que se esta recorriendo es un
		// archivo se imprime su tamaño y su fecha.
		for(File archivo: archivos){
			System.out.printf("%-15s" ,archivo.getName());
			if(archivo.isFile()){
				System.out.printf("%6d        ",archivo.length());
				System.out.printf("%1$tD %1$tT", new Date(archivo.lastModified()));
			}
			System.out.println("");
		}
	}
}
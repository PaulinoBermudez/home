/**
 * @(#)Archivo.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Archivo{
	
	/**
	 * El metodo leerTextoArchivo extrae el texto del archivo.
     * Se apoya en la clase FileReader para acceder al archivo
     * y en un buffer de lectura BufferedReader para poder
     * extraer los datos del texto.
     *
     */
     public String leerTextoArchivo(String nombreArchivo){
     	String texto = "";
     	FileReader archivo = null;
     	String linea = "";
     	
     	try {
     		
	    	// Se abre el archivo.
	    	archivo = new FileReader(nombreArchivo);
	    	
	    	// Se genera un buffer de lectura donde se va
	    	// cargando el texto extraido del archivo.
			BufferedReader lector = new BufferedReader(archivo);
			
			/* 
			* Se recorre con un bucle el archivo linea por linea
			* y se almacena el contenido de dicha linea en el buffer
			* lector.
			*/		
	     	while ((linea = lector.readLine()) != null){
	     		texto += linea + "\n";
	    	}
	    	
		    } catch (FileNotFoundException e) {
		      throw new RuntimeException("Archivo no encontrado");
		    } catch (IOException e) {
		      throw new RuntimeException("Ocurrio un error de entrada/salida");
		    } finally {
		      if (archivo != null) {
		        try {
		        	
		        	// Una vez que se finaliza la lectura
		        	// Se cierra el archivo con archivo.close()
		        	archivo.close();
		        } catch (IOException e) {
		          e.printStackTrace();
		        }
		      }
		    }
		    return texto;
	}
	
  
  /**
   * El metodo escribirTextoArchivo guarda el texto del archivo.
   * Se apoya en la clase FileWriter para acceder al archivo
   * y en un buffer de escritura BufferedWriter para poder
   * guardar los datos del texto. 
   */
   
  public void escribirTextoArchivo(String nombreArchivo, String texto){
  	
    FileWriter salida = null;
    try{
    	// Abrimos el fichero
    	salida = new FileWriter(nombreArchivo);
    	
    	// Se genera un buffer de salida donde se va
    	// almacenando el texto con ayuda del BufferedWriter escritor. 
    	BufferedWriter escritor = new BufferedWriter(salida);
    	
    	// Se escriben los datos en el archivo con
    	// escritor.write(texto), 
    	escritor.write(texto);
    	
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (salida != null) {
      	
        try {
        	
        	// Una vez que se finalice la escritura  
    		// se cerrara el archivo con salida.close(). 
        	salida.close();
        	} catch (IOException e) {
        		
        	//Se utiliza para imprimir el registro del stack
        	// donde se ha iniciado la excepción. 
          e.printStackTrace();
        }
      }
    }
  }
}
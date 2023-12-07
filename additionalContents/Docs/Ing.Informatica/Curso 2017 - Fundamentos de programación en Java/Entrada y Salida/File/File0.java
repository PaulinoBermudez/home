/**
 * @(#)File0.java
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/7/6
 *
 * Este programa que muestra el contenido de un directorio.
 * Se muestra el contenido del directorio actual. 
 */

import java.io.File;

public class File0 {
	
	 public static void main(String[] args) {
	 	
	 	// Se muestra el contenido del directorio actual.
        File directorio = new File(".");  
        String[] lista = directorio.list();
        
        for (int i = 0; i < lista.length; i++) {
        	
            System.out.println(lista[i]);
        }
 	}
}
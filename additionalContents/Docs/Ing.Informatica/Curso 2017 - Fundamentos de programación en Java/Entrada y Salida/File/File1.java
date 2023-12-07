/**
 * @(#)File1.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/6
 *
 * El programa muestra el uso de algunos metodos de la clase File.
 * Se crea un objeto File "ruta" asociado al directorio
 * c:/ficheros y un objeto File "f" asociado al fichero datos.txt
 * que se encuentra en ese directorio.
 * Si el fichero no existe se crea y si el directorio no existe se
 * crea y a continuación se crea el fichero.
 * Si el fichero existe se muestra el tamaño del mismo.
 *
 */

import java.io.File;
import java.io.IOException;

public class File1 {

    public static void main(String[] args) throws IOException {
    	
        File ruta = new File("c:/Java/ficheros");
        File f = new File(ruta, "datos.txt");
        
        // Devuelve la ruta absoluta asociada al objeto File.
        System.out.println(f.getAbsolutePath());
        
        // Devuelve un String conteniendo el directorio padre del File.
        // Devuelve null si no tiene directorio padre.
        System.out.println(f.getParent());
        
        System.out.println(ruta.getAbsolutePath());
        System.out.println(ruta.getParent());
        
        // Se comprueba si el fichero existe o no.
        if (!f.exists()) {  
            System.out.println("Fichero " + f.getName() + " no existe");
            // Se comprueba si la ruta existe o no.
            if (!ruta.exists()) {  
                System.out.println("El directorio " + ruta.getName() + " no existe");
                // Se crea la ruta. Si se ha creado correctamente
                if (ruta.mkdir()) { 
                    System.out.println("Directorio creado");
                    // Se crea el fichero. Si se ha creado correctamente
                    if (f.createNewFile()) {  
                        System.out.println("Fichero " + f.getName() + " creado");
                    } else {
                        System.out.println("No se ha podido crear " + f.getName());
                    }
                } else {
                    System.out.println("No se ha podido crear " + ruta.getName());
                }
            // Si la ruta existe creamos el fichero    
            } else {  
                if (f.createNewFile()) {
                    System.out.println("Fichero " + f.getName() + " creado");
                } else {
                    System.out.println("No se ha podido crear " + f.getName());
                }
            }
        // El fichero existe. Mostramos el tamaño    
        } else {
            System.out.println("Fichero " + f.getName() + " existe");
            System.out.println("Tamaño " + f.length() + " bytes");
        }
    }
}
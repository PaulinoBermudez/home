/**
 * @(#)FiltroApp.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/6
 *
 * Programa que utiliza el filtro para mostrar archivos
 * que tienen una extensión determinada, en este caso los
 * que tienen la extensión .pdf
 */

import java.io.File;

public class FiltroApp {
	
    public static void main(String[] args) {
    	
        File ruta = new File("H:/0 UNED/00 Matemáticas Ciencias Sociales");
        
        System.out.println("Archivos .pdf en el directorio " + ruta.getAbsolutePath());
        
        String[] lista = ruta.list(new Filtro(".pdf")); //se crea el filtro y se le pasa a list
        
        if (lista == null) {
            System.out.println("Total: 0 archivos");
        } else {
        	
            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);
            }
            
            System.out.println("Total: " + lista.length);
        }
    }
}
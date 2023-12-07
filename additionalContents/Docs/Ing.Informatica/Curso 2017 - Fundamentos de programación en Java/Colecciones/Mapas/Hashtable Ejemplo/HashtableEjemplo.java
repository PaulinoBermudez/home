/**
 * @(#)HashtableEjemplo.java
 *
 * Ejemplo Hashtable.
 * Iterador Enumeration.
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/20
 */

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableEjemplo {
	
	public static void main(String[] args) {
		
		Hashtable<String,String> contenedor = new Hashtable<String,String>();
		
		contenedor.put("101", "Pepe");
        contenedor.put("102", "Manuel");
        contenedor.put("103", "Miguel");
        contenedor.put("104", "Enrique");
        contenedor.put("105", "Juanjo");
                
        System.out.println(contenedor.get("105"));
        System.out.println(contenedor.get("101"));
        
        /* 
         * hasMoreElements.
         * Devuelve true si no se ha accedido a todos los elementos de la colección.
         * 
         * nextElement.
         * Devuelve el siguiente elemento.
         *
         */
         
        Enumeration<String> elementos = contenedor.elements();
        while (elementos.hasMoreElements()){
        	
        	System.out.println("hashtable valores: " + elementos.nextElement());
        }
                
        Enumeration<String> llaves = contenedor.keys();
        while (llaves.hasMoreElements()) {
        	
        	System.out.println("hashtable llaves: " + llaves.nextElement());
        }
        
        System.out.println("Claves: " +contenedor.keys());
	}
}


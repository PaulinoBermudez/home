/**
 * @(#)ListarUnMapa2.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/20
 */

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Enumeration;
import java.util.Hashtable;

public class ListarUnMapa2{
	
	public static void main(String[] args){
		
		Hashtable<String,String> hm = new Hashtable<String,String>();
		
		hm.put("1","Luis");
        hm.put("2","Amaya");
        hm.put("3","Julio");

        // Agregamos un elemento con clave existente.
        // Se sobrescribe su valor ya que no puede
        // haber valores duplicados.
        hm.put("1","Victor");
                   
        
        System.out.println("Salida Iterator");
        System.out.println("");
        
        Iterator<Entry<String,String>> it = hm.entrySet().iterator();
                
        while (it.hasNext()){
        	Entry<String,String> e = it.next();
        	System.out.println(e.getKey() + " " + e.getValue());
        }
        
        System.out.println("");
        System.out.println("Fin Iterator");
        System.out.println("");
        
        /* 
         * hasMoreElements.
         * Devuelve true si no se ha accedido a todos los elementos de la colección.
         * 
         * nextElement.
         * Devuelve el siguiente elemento.
         *
         */
        
        Enumeration<String> elementos = hm.elements();
        while (elementos.hasMoreElements()){
        	
        	System.out.println("hashtable valores: " + elementos.nextElement());
        }
        
        System.out.println("");
                
        Enumeration<String> llaves = hm.keys();
        while (llaves.hasMoreElements()) {
        	
        	System.out.println("hashtable llaves: " + llaves.nextElement());
        }
        
        System.out.println("");
        
        System.out.println("Claves: " + hm.keys());  
    }
}

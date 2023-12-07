/**
 * @(#)HashMapEjemplo.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/20
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapEjemplo{

    public static void main(String[] args) {

        Map<String, String> ids = new HashMap<String, String>();

        ids.put("Juan", "Piloto");
        ids.put("Miguel", "Director");
        ids.put("Alberto", "Casanova");

        /**Ahora vamos a mostrar los valores que tenemos.
         * Para recorrer a traves de los valores de nuestro mapa
         * usamos un entrySet.
         * EntrySet nos permite recorrer los valores del mapa
         * e invocar la clave y su valor correspondiente.
        */
        
        for (Entry<String, String> id : ids.entrySet()) {

            // key es un valor unico!
            System.out.println("Nombre de usuario:" + id.getKey());

            // valor NO es un valor unico, asi que puede repetirse.
            System.out.println("ID: " + id.getValue() +"\n");
        }
          
        
        // Vamos a borrar un valor de nuestro mapa
 
		String llaveASerRemovida = "Juan";
		 
		// primero checkeo si la llave existe en mi mapa
		if (ids.containsKey(llaveASerRemovida)) {
		 
		// si existe la remuevo.
		ids.remove(llaveASerRemovida);
		} else {
		   // si no existe solo muestro un mensaje.
		   System.out.println("¡La llave no existe!");
		}
		 
		// Ahora vuelvo a mostrar los valores de nuestro mapa.
		System.out.println("Nuevos valores de nuestro mapa:");
		 
		for (Entry<String, String> id : ids.entrySet()) {
		   System.out.println("Key: " + id.getKey());
		   System.out.println("Value: " + id.getValue() + "\n");
		}
        
        
        // Ahora vamos a actualizar un valor de nuestro mapa
 
		String llaveAActualizar = "Alberto";
		 
		if (ids.containsKey(llaveAActualizar)) {
		    ids.put(llaveAActualizar, "Alberto Magal");
		} else {
		    System.out.println(llaveAActualizar + " no esta en el mapa!");
		}
		 
		System.out.println("Valores actualizados:");
		for (Entry<String, String> id : ids.entrySet()) {
		    System.out.println("Key: " + id.getKey());
		    System.out.println("Value: " + id.getValue() + "\n");
		}   
   }
}
/**
 * @(#)HashMapDemo.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/20
 */

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class HashMapDemo {
	
	public static void main(String args[]) {
		
		// create hash map
		
		HashMap newmap = new HashMap();
      
	    // populate hash map
	    newmap.put(1, "Tutoriales");
	    newmap.put(2, "Puntos");
	    newmap.put(3, "Record");
	      
	    // get keyset value from map
	    Set keyset=newmap.keySet();
	      
	    // check key set values
	    System.out.println("Key set values are: " + keyset);
	    System.out.println("");
	   
	   	// Imprimimos el Map con un Iterador
		Iterator<Integer> it = newmap.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			System.out.println("Clave: " + key + " --- Valor: " + newmap.get(key));
		}
	}   
}
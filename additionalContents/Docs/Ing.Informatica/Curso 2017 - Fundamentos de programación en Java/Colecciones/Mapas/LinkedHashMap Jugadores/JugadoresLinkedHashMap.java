/**
 * @(#)JugadoresLinkedHashMap.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/17
 */

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class JugadoresLinkedHashMap {

	public static void main(String[] args) {

		System.out.println("\n********* LinkedHashMap *********");
		System.out.println("");
		
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		
		linkedHashMap.put(1, "Casillas");
		linkedHashMap.put(15, "Ramos");
		linkedHashMap.put(3, "Pique");
		linkedHashMap.put(5, "Puyol");
		linkedHashMap.put(11, "Capdevila");
		linkedHashMap.put(14, "Xabi Alonso");
		linkedHashMap.put(16, "Busquets");
		linkedHashMap.put(8, "Xavi Hernandez");
		linkedHashMap.put(18, "Pedrito");
		linkedHashMap.put(6, "Iniesta");
		linkedHashMap.put(7, "Villa");
		
		// Imprimimos el Map con un Iterador que ya hemos instanciado anteriormente
		Iterator<Integer> it = linkedHashMap.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			System.out.println("Clave: " + key + " -> Valor: " + linkedHashMap.get(key));
		}
		
		System.out.println("\n\n********* Foreach: Forma alternativa para recorrer los Map mostrando la Clave y el valor:*********");
		System.out.println("");
		
		for (Entry<Integer, String> jugador : linkedHashMap.entrySet()){
			
			Integer clave = jugador.getKey();
			String valor = jugador.getValue();
			System.out.println(clave+"  ->  "+valor);
		}		
	}
}
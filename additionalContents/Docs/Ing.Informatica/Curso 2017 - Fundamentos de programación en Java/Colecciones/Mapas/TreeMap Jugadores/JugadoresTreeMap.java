/**
 * @(#)JugadoresTreeMap.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/17
 */

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class JugadoresTreeMap {

	public static void main(String[] args) {
		
		System.out.println("\n********* TreeMap *********");
		System.out.println("");
		
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		treeMap.put(1, "Casillas");
		treeMap.put(15, "Ramos");
		treeMap.put(3, "Pique");
		treeMap.put(5, "Puyol");
		treeMap.put(11, "Capdevila");
		treeMap.put(14, "Xabi Alonso");
		treeMap.put(16, "Busquets");
		treeMap.put(8, "Xavi Hernandez");
		treeMap.put(18, "Pedrito");
		treeMap.put(6, "Iniesta");
		treeMap.put(7, "Villa");
		
		// Imprimimos el Map con un Iterador
		Iterator<Integer> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			System.out.println("Clave: " + key + " -> Valor: " + treeMap.get(key));
		}
			
		System.out.println("\n********* Trabajando con los metodos de Map *********");
		System.out.println("");
		
		System.out.println("Mostramos el numero de elementos que tiene el TreeMap: treeMap.size() = "+treeMap.size());
		System.out.println("Vemos si el TreeMap esta vacio : treeMap.isEmpty() = "+treeMap.isEmpty());
		System.out.println("Obtenemos un elemento del Map pasandole la clave 6: treeMap.get(6) = "+treeMap.get(6));
		System.out.println("Borramos un elemento del Map el 18 (porque fue sustituido): treeMap.remove(18)"+treeMap.remove(18));
		System.out.println("Vemos que pasa si queremos obtener la clave 18 que ya no existe: treeMap.get(18) = "+treeMap.get(18));
		System.out.println("Vemos si existe un elemento con la clave 18: treeMap.containsKey(18) = "+treeMap.containsKey(18));
		System.out.println("Vemos si existe un elemento con la clave 1: treeMap.containsKey(1) = "+treeMap.containsKey(1));
		System.out.println("Vemos si existe el valo 'Villa' en el Map: treeMap.containsValue(\"Villa\") = "+treeMap.containsValue("Villa"));
		System.out.println("Vemos si existe el valo 'Ricardo' en el Map: treeMap.containsValue(\"Ricardo\") = "+treeMap.containsValue("Ricardo"));
		System.out.println("Borramos todos los elementos del Map: treeMap.clear()");treeMap.clear();
		System.out.println("Comprobamos si lo hemos eliminado viendo su tamaño: treeMap.size() = "+treeMap.size());
		System.out.println("Lo comprobamos tambien viendo si esta vacio treeMap.isEmpty() = "+treeMap.isEmpty());		
	}
}
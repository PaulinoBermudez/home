/**
 * @(#)TreeSetEjemplo3.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/23
 */

import java.util.Iterator;
import java.util.TreeSet;
 
public class TreeSetEjemplo3 {
	
	public static void main(String[] args) {
		
		System.out.println("Ejemplo de TreeSet\n");
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
		
		tree.add(12);
		tree.add(63);
		tree.add(34);
		tree.add(45);
 
		// here it test it's sorted, 63 is the last element. see output below
		Iterator<Integer> iterator = tree.iterator();
		System.out.print("Elementos del TreeSet: ");
 
		// Displaying the Tree set data
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
 
		// Check empty or not
		if (tree.isEmpty()) {
			System.out.print("El TreeSet esta vacio.");
		} else {
			System.out.println("Tamaño del TreeSet: " + tree.size());
		}
 
		// Retrieve first data from tree set
		System.out.println("Primer Elemento: " + tree.first());
	 
		// Retrieve last data from tree set
		System.out.println("Ultimo Elemento: " + tree.last());
	 
		if (tree.remove(45)) { // remove element by value
			System.out.println("Elemento eliminado del TreeSet");
		} else {
			System.out.println("Este Elemento no existe");
		}
		
		System.out.print("Elementos que contiene el TreeSet: ");
		iterator = tree.iterator();
	 
		// Displaying the Tree set data
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		System.out.println("Elementos que contiene el TreeSet: " + tree.size());
	 
		// Remove all
		tree.clear();
		if (tree.isEmpty()) {
			System.out.print("El TreeSet esta vacio.");
		} else {
			System.out.println("Tamaño del TreeSet: " + tree.size());
		}
   }
}
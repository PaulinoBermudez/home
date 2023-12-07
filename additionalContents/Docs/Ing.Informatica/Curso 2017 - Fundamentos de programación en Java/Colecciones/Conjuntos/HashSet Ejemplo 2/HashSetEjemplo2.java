/**
 * @(#)HashSetEjemplo2.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/23
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;

public class HashSetEjemplo2 {
    
    public static void main(String[] args) {
    	
    	Scanner teclado = new Scanner(System.in);
		System.out.print("Introducir el numero de elementos: ");
		int elementos = teclado.nextInt();
        
        HashSet<String>  conjunto = new HashSet<String>();
        
        // Agregamos n Elementos en el HashSet
		System.out.println("\nAgregamos n elementos al HashSet");
		for (int i=1; i<=elementos; i++){
			conjunto.add("Elemento HashSet " + i);
			
		}
		
		// Declaramos el Iterador e imprimimos los Elementos del HashSet
		System.out.println("\nImprimimos los elementos del HashSet: ");
		Iterator<String> HashSetIterator = conjunto.iterator();
		while(HashSetIterator.hasNext()){
			String elemento = HashSetIterator.next();
			System.out.println(elemento);
		}
    }
}
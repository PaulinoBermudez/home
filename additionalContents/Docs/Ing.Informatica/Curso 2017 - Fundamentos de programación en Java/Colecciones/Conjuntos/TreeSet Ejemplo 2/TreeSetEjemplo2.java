/**
 * @(#)TreeSetEjemplo2.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/23
 */

import java.util.TreeSet;
import java.util.Scanner;
import java.util.Iterator;

public class TreeSetEjemplo2 {
    
    public static void main(String[] args) {
    	
    	double timeInicial;
		double timeFinal;
    	
    	Scanner teclado = new Scanner(System.in);
		System.out.print("Introducir el numero de elementos: ");
		int elementos = teclado.nextInt();
        
        TreeSet<String>  conjunto = new TreeSet<String>();
        
        // Agregamos n Elementos en el TreeSet
		System.out.println("\nAgregamos n elementos al TreeSet");
		for (int i=1; i<=elementos; i++){
			conjunto.add("Elemento TreeSet " + i);
			
		}
		
		timeInicial = System.currentTimeMillis();
		
		// Declaramos el Iterador e imprimimos los Elementos del TreeSet
		System.out.println("\nImprimimos los elementos del HashSet: ");
		Iterator<String> TreeSetIterator = conjunto.iterator();
		while(TreeSetIterator.hasNext()){
			String elemento = TreeSetIterator.next();
			System.out.println(elemento);
		}
		
		System.out.println("");
		timeFinal = System.currentTimeMillis();
		
		// Resultados de las medidas.
		System.out.println ("Tiempo invertido con HashSet:  " + (timeFinal-timeInicial)/1000 + "  s.");
		System.out.println("");
		
		
		//Tamaño del TreeSet
		System.out.println("Tamaño del TreeSet: " + conjunto.size());
    
    conjunto.clear();
    
    System.out.println("Tamaño del TreeSet: " + conjunto.size());
    
    }
}
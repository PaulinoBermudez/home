/**
 * @(#)ListasEjemplo.java
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/7/6
 *
 * Creamos la clase LinkedList
 */
 
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListasEjemplo {

	public static void main(String[] args) {
		
		double antes;
		double timeInicial;
		double timeFinal;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introducir el numero de elementos a insertar en las listas: ");
   
		int elementos = teclado.nextInt();
		
		// Creamos un LinkedList y un ArrayList de Strings.
		LinkedList<String> nombreLinkedList = new LinkedList<String>();
		ArrayList<String> nombreArrayList = new ArrayList<String>();
		
		// Agregamos n Elementos en el LinkedList
		System.out.println("\nAgregamos n elementos al LinkedList");
		for (int i=1; i<=elementos; i++){
			nombreLinkedList.add("Elemento LinkedList " +i);
		}
		
		// Agregamos n Elementos en el ArrayList
		System.out.println("\nAgregamos n elementos al ArrayList");
		for (int i=1; i<=elementos; i++){
			nombreArrayList.add("Elemento ArrayList " +i);
		}
		
		/* Medidas de tiempo para LinkedList */
		
		timeInicial = System.currentTimeMillis();
		
		// Declaramos el Iterador e imprimimos los Elementos del LinkedList
		System.out.println("\nImprimimos los elementos del LinkedList: ");
		Iterator<String> linkedIterator = nombreLinkedList.iterator();
		while(linkedIterator.hasNext()){
			String elemento = linkedIterator.next();
			System.out.println(elemento);
		}
		
		System.out.println("");

		timeFinal = System.currentTimeMillis();
	    
		
		/* Medidas de tiempo para ArrayList */
		
		timeInicial = System.currentTimeMillis();

		// Declaramos el Iterador e imprimimos los Elementos del ArrayList
		System.out.println("\nImprimimos los elementos del ArrayList: ");
		Iterator<String> arrayIterator = nombreArrayList.iterator();
		while(arrayIterator.hasNext()){
			String elemento = arrayIterator.next();
			System.out.println(elemento);
		}

		System.out.println("");

		timeFinal = System.currentTimeMillis();
		
		System.out.println ("\tTiempo invertido con ArrayList: " + (timeFinal-timeInicial)/1000 + "  s.");
		System.out.println ("\tTiempo invertido con LinkedList: " + (timeFinal-timeInicial)/1000 + "  s.");
	    
	    
	    System.out.println("");
	    
	    
	    
	    
	    /*
         * Una vez cargadas las listas: nombreArrayList y nombreLinkedList,
         * medimos el periodo de tiempo que consume una insercion
         * en la posicion 0 en cada implementacion.
         *
         */

        System.out.print("Tiempo invertido en insertar un elemento en la posici�n 0 del ArrayList: ");

        antes = System.nanoTime();

        nombreArrayList.add(0,"Pepe"); // Inserci�n en posicion 0 de una persona

        System.out.print(System.nanoTime()- antes);
        System.out.println(" ns");

        System.out.print("Tiempo invertido en insertar un elemento en la posici�n 0 del LinkedList: ");

        antes = System.nanoTime();

        nombreLinkedList.add(0,"Pepe");  // Inserci�n en posicion 0 de una persona

        System.out.print(System.nanoTime()- antes);
        System.out.println(" ns");
        System.out.println("");
        
        /*
         * Medimos el periodo de tiempo que consume una inserci�n
         * en la posici�n 2000 en cada implementaci�n.
         *
         */
 
        System.out.print("Tiempo invertido en insertar un elemento en la posici�n 2000 del ArrayList: ");

        antes = System.nanoTime();

        nombreArrayList.add(2000,"Pepe"); // Inserci�n en posicion 5000 de una persona

        System.out.print(System.nanoTime()- antes);
        System.out.println(" ns");
        
        System.out.print("Tiempo invertido en insertar un elemento en la posici�n 2000 del LinkedList: ");

        antes = System.nanoTime();

        nombreLinkedList.add(2000,"Pepe");  // Inserci�n en posicion 5000 de una persona

        System.out.print(System.nanoTime()- antes);
        System.out.println(" ns");
        System.out.println("");
        
        /*
         * Medimos el periodo de tiempo que consume una inserci�n
         * en la posici�n 10001 en cada implementaci�n.
         * En este caso es la �ltima posici�n.
         *
         */
        
        System.out.print("Tiempo invertido en insertar un elemento en la posici�n 5001 del ArrayList: ");

        antes = System.nanoTime();

        nombreArrayList.add(10001,"Pepe"); // Inserci�n en posicion 10001 de una persona

        System.out.print(System.nanoTime()- antes);
		System.out.println(" ns");
		
        System.out.print("Tiempo invertido en insertar un elemento en la posici�n 5001 del LinkedList: ");

        antes = System.nanoTime();

        nombreLinkedList.add(10001,"Pepe");  // Inserci�n en posicion 10001 de una persona

        System.out.print(System.nanoTime()- antes);
        System.out.println(" ns");
        System.out.println("");
	}
}

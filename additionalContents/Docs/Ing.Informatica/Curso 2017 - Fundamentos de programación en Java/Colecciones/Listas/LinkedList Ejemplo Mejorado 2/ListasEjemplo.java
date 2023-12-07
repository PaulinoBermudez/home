/**
 * @(#)ListasEjemplo.java
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/7/6
 *
 * Con este programa comparamos un:
 * ArrayList y un LinkedList
 */
 
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;

public class ListasEjemplo {
	
	private double antes;
	private double timeInicial;
	private double timeFinal;
	
	// Creamos un LinkedList y un ArrayList de Strings.
	LinkedList<String> nombreLinkedList = new LinkedList<String>();
	ArrayList<String> nombreArrayList = new ArrayList<String>();
		
	/*
	 * Con este metodo introducimos los datos.
	 * Tambien agregamos los n elementos.
	 *
	 */
	 
	public void Datos(){
		Scanner teclado = new Scanner(System.in);
		
	//	System.out.print("Introducir el numero de elementos a insertar en las listas: ");
   
		int elementos = teclado.nextInt();
		
		// Agregamos n Elementos en el LinkedList
		System.out.println("\nAgregamos " + elementos + " elementos al LinkedList");
		for (int i=1; i<=elementos; i++){
			nombreLinkedList.add("Elemento LinkedList " +i);
		}
		
		// Agregamos n Elementos en el ArrayList
		System.out.println("\nAgregamos " + elementos + " elementos al ArrayList");
		for (int i=1; i<=elementos; i++){
			nombreArrayList.add("Elemento ArrayList " +i);
		}
		
		System.out.println("");
	}
	
	
	/*
	 * Con este metodo tomamos las medidas de tiempo.
	 *
	 */
	
	public void medidasTiempo(){
		
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
		
		
		// Resultados de las dos medidas.
		System.out.println ("Tiempo invertido con ArrayList:  " + (timeFinal-timeInicial)/1000 + "  s.");
		System.out.println ("Tiempo invertido con LinkedList: " + (timeFinal-timeInicial)/1000 + "  s.");
	    
	    System.out.println("");
		
	}
	
	/*
     * Una vez cargadas las listas:
     *
     * 		nombreArrayList.
     *		nombreLinkedList.
     *
     * medimos el periodo de tiempo que consume una insercion
     * en la posicion n en cada implementacion.
     *
     */
     	
	public void insercionElementos(){
		
		try{
				
			Scanner teclado = new Scanner(System.in);
		//	System.out.print("Introducir la posicion a insertar: ");
			int elementos = teclado.nextInt();
			System.out.println("");
				
			System.out.print("Tiempo en insertar un elemento en la posición " + elementos + " del ArrayList : ");
	
	        antes = System.nanoTime();
			
			// Inserción en posicion n de un elemento con ArrayList.
	        nombreArrayList.add(elementos,"Pepe");
	
	        System.out.print((System.nanoTime()- antes)/1000);
	        System.out.println(" ms");
	
	        System.out.print("Tiempo en insertar un elemento en la posición " + elementos + " del LinkedList: ");
	
	        antes = System.nanoTime();
			
			// Inserción en posicion n de un elemento con LinkedList.
	        nombreLinkedList.add(elementos,"Pepe");
	
	        System.out.print((System.nanoTime()- antes)/1000);
	        System.out.println(" ms");
	        System.out.println("");
        
        
        
			}catch(IndexOutOfBoundsException IOB){
				System.out.print("Posicion fuera de rango, vuelva a insertar numero: ");
				insercionElementos();
			}
		
	}
	
	
	/*
     * Una vez cargadas las listas:
     *
     * 		nombreArrayList.
     *		nombreLinkedList.
     *
     * medimos el periodo de tiempo que consume una eliminacion
     * en la posicion n en cada implementacion.
     *
     */
     	
	public void eliminacionElementos(){
		
		try{
		
			Scanner teclado = new Scanner(System.in);
			System.out.print("Introducir la posicion a eliminar: ");
			int elementos = teclado.nextInt();
			System.out.println("");
				
			System.out.print("Tiempo en eliminar un elemento en la posición " + elementos + " del ArrayList : ");
	
	        antes = System.nanoTime();
			
			// Eliminar un elemento en posicion n con ArrayList.
	        nombreArrayList.remove(elementos);
	
	        System.out.print((System.nanoTime()- antes)/1000);
	        System.out.println(" ms");
	
	        System.out.print("Tiempo en eliminar un elemento en la posición " + elementos + " del LinkedList: ");
	
	        antes = System.nanoTime();
			
			// Eliminar un elemento en posicion n con LinkedList.
	        nombreLinkedList.remove(elementos);
	
	        System.out.print((System.nanoTime()- antes)/1000);
	        System.out.println(" ms");
	        System.out.println("");
	        
	        }catch(IndexOutOfBoundsException IOB){
				System.out.print("Posicion fuera de rango, vuelva a insertar numero: ");
				insercionElementos();
			}
	}
	
	public void buscarElemento(){
		
		try{
		
			Scanner teclado = new Scanner(System.in);
			System.out.print("Introducir la posicion a buscar: ");
			int elementos = teclado.nextInt();
			System.out.println("");
				
			System.out.print("Tiempo en buscar un elemento en la posición " + elementos + " del ArrayList : ");
	
	        antes = System.nanoTime();
			
			// Buscar un elemento en posicion n con ArrayList.
	        nombreArrayList.get(elementos);
	
	        System.out.print((System.nanoTime()- antes)/1000);
	        System.out.println(" ms");
	
	        System.out.print("Tiempo en buscar un elemento en la posición " + elementos + " del LinkedList: ");
	
	        antes = System.nanoTime();
			
			// Buscar un elemento en posicion n con LinkedList.
	        nombreLinkedList.get(elementos);
	
	        System.out.print((System.nanoTime()- antes)/1000);
	        System.out.println(" ms");
	        System.out.println("");
	        
	        }catch(IndexOutOfBoundsException IOB){
				System.out.print("Posicion fuera de rango, vuelva a insertar numero: ");
				insercionElementos();
			}
		
	}
	
	public void borraTodo(){
		System.out.println("");
		nombreArrayList.clear();
		nombreLinkedList.clear();
		System.out.println("");
	}
	
	public void hayElementos(){
		System.out.println("");
		System.out.println("Elementos restantes en el ArrayList : " + nombreArrayList.size());
		System.out.println("Elementos restantes en el LinkedList: " + nombreLinkedList.size());
		System.out.println("");
	}
}
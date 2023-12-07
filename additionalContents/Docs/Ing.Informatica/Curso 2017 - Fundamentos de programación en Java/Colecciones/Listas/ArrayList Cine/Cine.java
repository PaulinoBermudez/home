/**
 * @(#)Cine.java
 *
 * Peliculas application
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/17
 */
 
 import java.util.ArrayList;
 import java.util.Iterator;
 
 /*
  * Ejemplo en donde se muestra como funciona
  * un ArrayList
  */
  
public class Cine{
    
    public static void main(String[] args){
    	
    	//Declaro un ArrayList
    	ArrayList<String> pelis = new ArrayList<String>();
    	
    	//Agrego cuatro peliculas
    	pelis.add ("Casablanca");
    	pelis.add ("39 Escalones");
    	pelis.add ("La reina de Africa");
    	pelis.add ("El Padrino");
    	
    	//Imprimo las peliculas introducidas    	
    	System.out.println(pelis);
    	System.out.println("");
    	
    	//Elimino la pelicula de la posicion 2
    	pelis.remove(2);
    	
    	//Imprimo las peliculas
    	System.out.println(pelis);
    	System.out.println("");
    	
    	//Agrego una pelicula en la posicion 0.
    	pelis.add(0, "PulpFiction");
    	
    	//Imprimo las peliculas
    	System.out.println(pelis);
    	System.out.println("");
    	
    	// Usamos iterator para recorrer el ArrayList
    	
    	/*
    	 * Los Iteradores tienen tres metodos:
    	 * hasNext() para comprobar que siguen quedando elementos en el iterador. 
    	 * next() para que nos de el siguiente elemento del iterador.
    	 * remove() que sirve para eliminar el elemento del iterador.
    	 */
    	
    	System.out.println("Hacemos el recorrido con un Iterator");
    	Iterator<String> it = pelis.iterator();
    	while (it.hasNext()){
    		String elemento = it.next();
    		System.out.println(elemento);
    	}
    	System.out.println("");
    	
    	
    	 /**
    	 * Recorrido de la coleccion con un bucle for each
    	 *
    	 */
    	 
    	System.out.println("Hacemos el recorrido con un for each");
    	for (String nombre: pelis)
    		System.out.println(nombre);
    		
    	
    	 /**
    	 *
    	 * Borrar elemento con for each
    	 *
    	 * Ojo, nos genera un error en tiempo
    	 * de ejecución.
    	 *
    	 */
    	 
    	for (String nombre:pelis){
    		
    		if (nombre.equals("Casablanca")){
    			pelis.remove("Casablanca");
			}
		}
    }
}

/**
 * @(#)Peliculas.java
 *
 * Peliculas application
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/17
 */

import java.util.ArrayList;
import java.util.Iterator;

public class PeliculasApp {
	
    public static void main(String[] args) {
    	
    	//Declaro un ArrayList
    	ArrayList<Peliculas> pelis = new ArrayList<Peliculas>();
    	
    	//Creo varias peliculas
    	Peliculas pelicula1 = new Peliculas ("Casablanca", "Michael Curtiz", 1942, Tgenero.ACCION,"Narra un drama romantico en la ciudad marroqui de Casablanca bajo");
    	Peliculas pelicula2 = new Peliculas ("El Padrino", "Martin Scorsese", 1972, Tgenero.CIENCIA_FICCION,"El padrino es una pelicula basada en el libro del mismo nombre escrito");
    	Peliculas pelicula3 = new Peliculas ("La viuda Negra", "Armand Mastroianni", 2008, Tgenero.ACCION,"Una fotografa de redaccion del periodico local esta secretamente enamorada");
    	
    	//Agrego peliculas
    	pelis.add (pelicula1);
    	pelis.add (pelicula2);
    	pelis.add (pelicula3); 
    	
    	
    	// Usamos iterator para recorrer el ArrayList
    	
    	/*
    	 * Los Iteradores tienen tres metodos:
    	 * hasNext() para comprobar que siguen quedando elementos en el iterador. 
    	 * next()  para que nos de el siguiente elemento del iterador.
    	 * remove() que sirve para eliminar el elemento del iterador.
    	 */
    	
    	Iterator<Peliculas> it = pelis.iterator();
    	while (it.hasNext()){
    		Peliculas elemento = it.next();
    		
    		System.out.println(elemento.getTitulo());
    		System.out.println(elemento.getDirector());
    		System.out.println(elemento.getanyo());
    		System.out.println(elemento.getTgenero());
    		System.out.println(elemento.getSinopsis());
    		System.out.println("");
    		System.out.println("");
    	}
    	
    	// Utilizo por segunda vez el iterador pero
    	// llamando al metodo mostrarInfoPelicula.
    	while (it.hasNext()){
    		Peliculas elemento = it.next();
    		
    		elemento.mostrarInfoPelicula();
    		System.out.println("");
    		System.out.println("");
    	}	
    }
}

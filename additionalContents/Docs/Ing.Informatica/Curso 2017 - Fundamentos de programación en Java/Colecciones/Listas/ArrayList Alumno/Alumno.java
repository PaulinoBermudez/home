/**
 * @(#)Alumno.java
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
  
public class Alumno{
    
    public static void main(String[] args){
    	
    	//Declaro un ArrayList
    	ArrayList<String> alumnos = new ArrayList<String>();
    	
    	//Agrego cuatro peliculas
    	alumnos.add ("Luis");
    	alumnos.add ("Miguel");
    	alumnos.add ("Antonio");
    	alumnos.add ("Jose");
    	
    	//Imprimo las peliculas introducidas    	
    	System.out.println(alumnos);
    	System.out.println("");
    	
    	//Elimino la pelicula de la posicion 2
    //	alumnos.remove(2);
    	
    	//Imprimo las peliculas
    	System.out.println(alumnos);
    	System.out.println("");
    	
    	//Agrego una pelicula en la posicion 0.
    	alumnos.add(0, "Juan");
    	
    	//Imprimo las peliculas
    	System.out.println(alumnos);
    	System.out.println("");
    	
    	// Usamos iterator para recorrer el ArrayList
    	
    	/*
    	 * Los Iteradores tienen tres metodos:
    	 * hasNext() para comprobar que siguen quedando elementos en el iterador. 
    	 * next() para que nos de el siguiente elemento del iterador.
    	 * remove() que sirve para eliminar el elemento del iterador.
    	 */
    	
    	System.out.println("Hacemos el recorrido con un Iterator");
    	Iterator<String> it = alumnos.iterator();
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
    	for (String nombre: alumnos)
    		System.out.println(nombre);
    		
    	
    	 /**
    	 *
    	 * Borrar elemento con for each
    	 *
    	 * Ojo, nos genera un error en tiempo
    	 * de ejecución.
    	 *
    	 */
    	
    	System.out.println("Borramos un elemento con un for each");
    	for (String nombre:alumnos){
    		
    		if (nombre.equals("Miguel")){
    			alumnos.remove("Miguel");
			}
		}
    }
}
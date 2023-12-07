/**
 * @(#)PersonaApp.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/22
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonaApp {

    public static void main(String arg[]) {
    	
    	List<Persona> listaarray = new ArrayList<Persona>();
        List<Persona> listalinked = new LinkedList<Persona>();

        long antes;

        for(int i=0;i<10000;i++){
        	
        	listaarray.add(new Persona(i,"Persona"+i,i));
            listalinked.add(new Persona(i,"Persona"+i,i));
        }
        
        /*
         * Una vez cargadas las listas: listaarray y listalinked,
         * medimos el periodo de tiempo que consume una insercion
         * en la posicion 0 en cada implementacion.
         *
         */

        System.out.println("Posicion 0");
        System.out.print("Tiempo en insertar una persona en listaarray (en ns): ");

        antes = System.nanoTime();

        listaarray.add(0,new Persona(10001,"Prueba",10001)); // Inserción en posicion 0 de una persona

        System.out.println(System.nanoTime()- antes);

        System.out.print("Tiempo en insertar una persona en listalinked (en ns): ");

        antes = System.nanoTime();

        listalinked.add(0,new Persona(10001,"Prueba",10001));  // Inserción en posicion 0 de una persona

        System.out.println(System.nanoTime()- antes);
        
        System.out.println("");
        
        /*
         * Medimos el periodo de tiempo que consume una inserción
         * en la posición 5000 en cada implementación.
         *
         */
         
        System.out.println("Posicion 5000");
        System.out.print("Tiempo en insertar una persona en listaarray (en ns): ");

        antes = System.nanoTime();

        listaarray.add(5000,new Persona(10001,"Prueba",10001)); // Inserción en posicion 5000 de una persona

        System.out.println(System.nanoTime()- antes);
        
        System.out.print("Tiempo en insertar una persona en listalinked (en ns): ");

        antes = System.nanoTime();

        listalinked.add(5000,new Persona(10001,"Prueba",10001));  // Inserción en posicion 5000 de una persona

        System.out.println(System.nanoTime()- antes);
        
        System.out.println("");
        
        /*
         * Medimos el periodo de tiempo que consume una inserción
         * en la posición 10001 en cada implementación.
         * En este caso es la última posición.
         *
         */
        
        System.out.println("Posicion 10000");
        System.out.print("Tiempo en insertar una persona en listaarray (en ns): ");

        antes = System.nanoTime();

        listaarray.add(10002,new Persona(10001,"Prueba",10001)); // Inserción en posicion 10001 de una persona

        System.out.println(System.nanoTime()- antes);

        System.out.print("Tiempo en insertar una persona en listalinked (en ns): ");

        antes = System.nanoTime();

        listalinked.add(10002,new Persona(10001,"Prueba",10001));  // Inserción en posicion 10001 de una persona

        System.out.println(System.nanoTime()- antes);
        
        System.out.println("");
      } 
}
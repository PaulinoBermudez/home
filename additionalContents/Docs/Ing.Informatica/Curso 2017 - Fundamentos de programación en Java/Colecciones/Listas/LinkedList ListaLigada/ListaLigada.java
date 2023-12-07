/**
 * @(#)ListaLigada.java
 *
 * Ejemplo LinkedList
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/20
 */

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ListaLigada {
 
    public static void main (String args[]) {
    	
        Scanner leer = new Scanner(System.in);
 
        int num;
        int op;
 
        LinkedList lista = new LinkedList();
        
        do{
            System.out.println( "\t Men� \t" );
            System.out.println( "Operaciones con listas" );
            System.out.println( "1.- Insertar al principio" );
            System.out.println( "2.- Insertar al final" );
            System.out.println( "3.- Borrar al principio" );
            System.out.println( "4.- Borrar al final" );
            System.out.println( "5.- Mostrar la lista" );
            System.out.println( "6.- Borrar toda la lista" );
            System.out.println( "7.- Salir" );
            System.out.println( "\n" );
            System.out.print( "Elija la operaci�n que desee: " );
 
            op = leer.nextInt();
 
            switch(op){
                case 1:
                      System.out.print("Inserte numero: ");
                      num = leer.nextInt();
                      lista.addFirst(num);
                      break;
                case 2:
                      System.out.print("Inserte numero: ");
                      num = leer.nextInt();
                      lista.addLast(num);
                      break;
                case 3:
                      System.out.println("Se borrara el primer nodo");
                      lista.removeFirst();
                      break;
                case 4:
                      System.out.println("Se borrara el nodo final");
                      lista.removeLast();
                      break;
                case 5:
                      System.out.println("La lista es la siguiente");
                      List lista2 = new ArrayList(lista);
                      Iterator it = lista2.iterator();
                      while (it.hasNext()){
                           System.out.println(it.next()+"");
                       }
                       break;
                case 6:
                      System.out.println("Se borraran todos los elementos de la lista");
                      lista.clear();
                      break;
                case 7:
                      System.out.println("Salir");
                      break;
                }
            }
        while( op != 7 );
    }
}
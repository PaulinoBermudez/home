/**
 * @(#)ListasEjemploApp2.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/23
 */

import java.util.Scanner;

public class ListasEjemploApp2 {
	
    public static void main (String args[]) {
    	
        Scanner leer = new Scanner(System.in);
		
        int op;
 
        ListasEjemplo lista = new ListasEjemplo();
        
        do{
            System.out.println("Menu");
            System.out.println("");
            System.out.println("Operaciones con listas");
            System.out.println("");
            System.out.println("1 - Datos a Insertar.");
            System.out.println("2 - Medidas de Tiempo.");
            System.out.println("3 - Insercion de Elementos.");
            System.out.println("4 - Eliminacion de Elementos.");
            System.out.println("5 - Buscar Elemento.");
            System.out.println("6 - Borrar toda la lista.");
            System.out.println("7 - Elementos restantes en la lista.");
            System.out.println("8 - Salir" );
            System.out.println("\n" );
            System.out.print("Elija la operacion que desee: ");
            
 
            op = leer.nextInt();
 
            switch(op){
                case 1:
                      System.out.print("Introducir el numero de elementos a insertar en las listas: " );
                 //     num = leer.nextInt();
                      lista.Datos();
                      break;
                case 2:
                      System.out.println("Medidas de Tiempo");
                  //    num = leer.nextInt();
                      lista.medidasTiempo();
                      break;
                case 3:
                      System.out.print("Introducir la posicion a insertar: ");
                      lista.insercionElementos();
                      break;
                case 4:
                      System.out.println("Eliminacion de Elementos: ");
                      lista.eliminacionElementos();
                      break;
                case 5:
                      System.out.println("Buscar Elemento: ");
                      lista.buscarElemento();
                      break;
                case 6:
                      System.out.println("Se borraran todos los elementos de la lista: ");
                      lista.borraTodo();
                      break;
                case 7:
                      System.out.println("Elementos restantes de la lista: ");
                      lista.hayElementos();
                      break;
                case 8:
                      System.out.println("Salir");
                      break;
                }
            }
        while( op != 8 );
    }
}

/**
 * @(#)CocheApp.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2016/2/20
 */

import java.util.Scanner;

public class CocheApp {
	
    public static void main (String args[]) {
    	
        Scanner leer = new Scanner(System.in);
		
        int op;
 
        Datos lista = new Datos();
        
        do{
            System.out.println("Menu");
            System.out.println("");
            System.out.println("Operaciones");
            System.out.println("");
            System.out.println("1 - Agregar Coches.");
            System.out.println("2 - Mostrar Coches.");
            System.out.println("3 - Mostrar Por Marca.");
            System.out.println("4 - Mostrar Por Km.");
            System.out.println("5 - Mostrar Mayor Km.");
            System.out.println("6 - Mostrar Ordenados Por Km.");
            System.out.println("7 - Salir.");
            System.out.println("\n" );
            System.out.print("Elija la operacion que desee: ");
            
 
            op = leer.nextInt();
 
            switch(op){
                case 1:
                      System.out.print("Numero de coches: " );
                      lista.agregarCoches();
                      break;
                case 2:
                      System.out.println("Mostrar coches");
                      lista.mostrarCoches();
                      break;
                case 3:
                      System.out.print("Mostrar por Marca: ");
                      lista.mostrarPorMarca();
                      break;
                case 4:
                      System.out.println("Mostrar por Km: ");
                      lista.mostrarPorKm();
                      break;
                case 5:
                      System.out.println("Mostrar mayor Km: ");
                      lista.mostrarMayorKm();
                      break;
                case 6:
                      System.out.println("Mostrar ordenados por Km: ");
                      lista.mostrarOrdenadosPorKm();
                      break;
                case 7:
                      System.out.println("Salir");
                      break;
                }
            }
        while( op != 7 );
    }
}

/**
 * @(#)TestCantantes.java
 *
 *
 * @author 
 * @version 1.00 2016/2/25
 */


public class TestCantantes {
    
    public static void main (String[] args) {
        
        System.out.println("Esta es una lista de cantantes famosos");
  
        ListaCantantesFamosos lista = new ListaCantantesFamosos();
        
        lista.imprimirLista();
        
        boolean lanzador = true;
        while (lanzador==true) {
            System.out.println("\n¿Desea añadir un nuevo nombre a la lista?(y/n)");
            EntradaPalabras confirmador = new EntradaPalabras();
            
            if (confirmador.getPalabra().equalsIgnoreCase("y")) {
                System.out.println("\nPor favor, introduzca un nuevo cantante:");
                EntradaPalabras nombre = new EntradaPalabras();
                lista.añadirNombre(nombre.getPalabra());
            } else {
                lanzador = false;
                System.out.println("\nSu lista definitiva esta compuesta por " + (lista.getTamaño()) + " referencias de:");
                lista.imprimirLista();
                System.out.println("\nEspero que haya disfrutado del programa.\n\nDesarrollado por @dib_vz");
            }
        }
    }
}
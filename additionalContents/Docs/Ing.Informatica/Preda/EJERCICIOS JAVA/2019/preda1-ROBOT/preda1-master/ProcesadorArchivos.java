
/**
 * La clase Grafo tienen como finalidad la implementación del grafo solicitado en la práctica, así como
 * las funciones que sean necesarias para su implementación.
 * 
 * @author Alejandro Ángel Rodríguez Simón
 * @version Alfa0.3 - EN PROCESO Completar el método generarLista para que invoque al procedimiento generarAdyacencias
 * @version Alfa0.2 - Implementado el bucle que general la Lista de Adyacencia nodo a nodo
 * @version Alfa0.1 - Creación de la clase y codificación de su Constructor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcesadorArchivos
{
    // Declaración de las variables de clase
    static File fMuestra;
    static Scanner entrada = null;
    
    /**
     * Constructor for objects of class ProcesadorArchivos, el cual inicializará las variables de control y lectura del fichero de entrada
     */
    public ProcesadorArchivos(String fichero)
    {
        // En este constructor se inicializan las variables de clase
        try {
            File fMuestra = new File(fichero); // Se inicializa la variable al fichero de entrada
            entrada = new Scanner(fMuestra); //se crea un Scanner asociado al fichero
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
        } 
    }
    
    /**
     * Este método continuará la lectura del fichero de prueba y conforme lea nuevos datos llamará el método adecuado de la clase ListaDeAdyacencia
     * para añadir el elemento en el nodo correcto
     *
     * @param  lista Se pasa al método como variable la lista que deb emos generar a partir de los datos del fichero
     * @return     aqui una explicaci�n de la informaci�n que devuelve el metodo, si lo hace
     */
    public void generarLista(ListaDeAdyacencia lista)
    {
        // Preparamos las variables de método para controlar la generación de la lista de adyacencia
        int iterador = 1;
        String siguiente = "";        
        // Generamos la lista de adyacencia con los dos primeros valores leídos del archivo de la práctica
        lista = new ListaDeAdyacencia(entrada.nextInt(), entrada.nextInt());
        // Con este bucle añadimos los nodos del tablero uno por uno para generar la lista de nodos

        while (iterador <= lista.getLongitudMaxima()) {
            // System.out.println("Vamos a añadir el nodo "+(iterador));
            siguiente = entrada.next();
            lista.añadirNodo (iterador, siguiente);
            // System.out.println("La longitud de listaNodos es "+lista.getLongitudReal());            
            iterador++;
            }
        // Ejecutamos el procedimiento de la lista que generará las adyacencias en la lista de nodos
        lista.generarAdyacencias();       
    }
}

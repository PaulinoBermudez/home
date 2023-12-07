
/**
 * La clase ListaDeAdyacencia será con la que implementaré la estructura de datos para la ejecución del algoritmo de Dijkstra
 * Esta estructura de datos estará formada por 
 * - Dos variables enteras, fila y columna, para conservar las medidas originales que serán empleadas en ciertos momentos del algoritmo 
 *       para tratar ciertas condiciones referentes a las posiciones de las casillas.
 * - Una tercera variable entera para marcar la longitud máxima del ArrayList a procesos externos
 * - Dos variables adicionales, filaRobot y columnaRobot, que marcarán la posición inicial del robot para facilitarse a Dijkstra
 * - Una ArrayList de Nodos
 * También contendrá un array de arraylist para representar las listas enlazadas de cada nodo.
 * 
 * @author Alejandro �ngel Rodr�guez Sim�n
 * @version Alfa0.5 - Completada: generación de adyacencias para cada nodo de listaNodos.
 *                    EN PROCESO: verificación de que la generación es correcta
 * @version Alfa0.4 - ArrayList de nodos completada.
 *                    Procedimiento para generar listaNodos, completo.
 *                    Comprobación de S en el perímetro, completo
 *                    Añadir nodo a izquierda/derecha comprobando las columnas, completo.
 *                    EN PROCESO: generación de adyacencias para cada nodo de listaNodos.
 * @version Alfa0.3 - Tras no se capaz de generar ArrayList bidimensionales se implementa una única ArrayList para la estructura listaNodos
 * @version Alfa0.2 - Modificada la estructura de la ArrayList para ser bidimensional
 * @version Alfa0.1 - Establecer los campos, la ArrayList y el constructor
 */

import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeAdyacencia
{
    // Declaracion de las variables de clase
    static int fila, columna; 
    static int longitud;
    static int filaRobot, columnaRobot;
    public ArrayList<Nodo> listaNodos = new ArrayList<Nodo>();    

    /**
     * Constructor sin par�mentro de la clase ListaEnlazada
     */
    public ListaDeAdyacencia(int n, int m)
    {
        // Variables para la construcción
        int creador;        
        this.fila=n;
        this.columna=m;
        this.longitud = n*m;
        this.filaRobot = Integer.MIN_VALUE;
        this.filaRobot = Integer.MIN_VALUE;        
    }

    /**
     * Este método será el empleado para añadir un nodo a la lista de adyacencia
     *
     * @param  costeNodo y refNodo son dos parámetros int para almacenar el coste de desplazarse al nodo indicado
     */    
    public void añadirNodo(int refNodo, String costeNodo)
    {
        Nodo auxiliar = new Nodo(0,0);
        /**
         * La estructura condicional que se ejecuta en este punto tiene como objetivo rellenar con la información correcta el nodo del
         * ArrayList con un valor entero que nos permita entender el comportamiento del algoritmo. La posibilidades son las siguiente:
         * S - En caso de que el coste del nodo sea S, hemos encontrado la salida. El peso lo almacenaremos como 0 y el algoritmo parará al 
         * llegas a este punto
         * R - Si el coste es R estamos ante la posición inicial del Robot, por lo que le asignamos también el valor 0 y almacenamos la posición
         * en las variables integer correspondientes para que a la hora de ejecutar el algoritmo de cálculo este objeto sepa por donde empezar
         * O - Se trata de un obstáculo, insalvable. Asignamos como coste la variable MAX_VALUE para que sea altamente reconocible e incluso
         * en caso de que no lo sea, el algoritmo pueda ignorarlo al nunca poder encontrar en la entrada un valor mayor
         * Cualquier otro coste se añadirá tal cual a la matriz pues asumimos que estos son los únicos valores discrepantes y que el archivo
         * contiene los datos correctamente introducidos.
         */
        if (costeNodo.equals("S")) {
            if ( !comprobarTablero(refNodo)) {
                System.exit(1);
            } else {
                auxiliar = new Nodo (refNodo, 0);
            }
        }else {
            if (costeNodo.equals("R")) {
                filaRobot = refNodo/this.columna;
                columnaRobot = refNodo%this.columna;
                auxiliar = new Nodo (refNodo, Integer.MIN_VALUE);
            } else {               
                if (costeNodo.equals("O")) {
                    auxiliar = new Nodo (refNodo, Integer.MAX_VALUE);
                } else {
                    auxiliar = new Nodo (refNodo, costeNodo);
                }
            }
        } 
        listaNodos.add(auxiliar);
        // System.out.println("Se ha añadido el nodo con referencia "+(refNodo)+" y coste "+costeNodo);
    }
    
    /**
     * El siguiente método tiene como finalidad comprobar que el nodo salida, S, se encuentra en un lateral del tablero
     * Para ello tendremos en cuenta lo siguiente:
     * - Al estar trabajando con una ArrayList el índice comienza en 1
     * - Si S se encuentra en la primera fila la referencia del nodo será <= al número de columnas
     * - Si S se encuentra en la última fila la referencia del nodo será >= (longitud de la lista - número de columnas)
     * - Si S se encuentra en la primera columna el resto de la división entre la referencia del nódo y el número de columnas
     * será igual a 1
     * - Si S se encuentra en la última columna el resto de la división será 0
     *
     * @param  y   aqui va una explicaci�n de los par�mentros que utiliza el metodo
     * @return     aqui una explicaci�n de la informaci�n que devuelve el metodo, si lo hace
     */
    private boolean comprobarTablero(int refNodo)
    {
        if ( (refNodo <= this.columna) || (refNodo >= (this.longitud - this.columna))) {
            return true;
        } else {
            if ( (refNodo % this.columna) == 1 || (refNodo % this.columna) == 0) {
                return true;
            } else {
              System.out.println("==============================");
              System.out.println("Parece que el fichero tiene un error de formato,");
              System.out.println("El fichero no tiene situada la salida en una pared exterior del tablero");
              System.out.println("Por favor, revise el fichero y ejecute de nuevo el programa");
              return false;
            }
        }      
    }

    /**
     * En este método generaremos las adyacencias entre módulos, comprobando las 8 posiciones posibles de los nodos que podrían ser adyacentes
     * Para ello, deberemos controlar los nodos O puesto que ningún otro nodo será adyacente a él al no producirse ningún desplazamiento 
     * a/desde ese nodo.
     * Para comprobar que no nos salimos de la lista, jugaremos con el valor referencia y el número de columnas para obtener cualquiera
     * de las 8 posiciones adyacentes que un nodo cualquier puede tener.
     * En caso de ser una adyacencia válida, añade el nodo.
     */
    public void generarAdyacencias()
    {
        // Añadimos los campos que necesitamos en el método
        Nodo auxiliar;       
        int indice, valor; // almacenarán la referencia del nodo y su valor, para ahorrar llamadas a métodos y mejorar la legibilidad
        Iterator<Nodo> recorrido = listaNodos.iterator(); //se crea el iterador it para el array numeros
        
        while(recorrido.hasNext()) {
            auxiliar = recorrido.next();
            indice = listaNodos.indexOf(auxiliar);
            valor = auxiliar.getCoste();
            System.out.println("Probando nodo índice "+indice+" y valor "+valor);
            if ( valor != Integer.MAX_VALUE) {
                if ( indice < (this.columna)) {
                    agregarAnteriorSiguiente(auxiliar, indice);
                    agregarNodo(auxiliar, indice+5);
                } else {
                    if ( indice > (listaNodos.size()-(1+this.columna))) { // se resta columna+1 porque los índices empiezan en 0
                        agregarAnteriorSiguiente(auxiliar, indice);
                        agregarNodo(auxiliar, indice-5);
                    } else {
                        agregarAnteriorSiguiente(auxiliar, indice);                            
                        agregarNodo(auxiliar, indice+5);
                        agregarNodo(auxiliar, indice-5);
                        }
                    }
            }
        }    
    }
    
    /**
     * Este método encapsula el procedimiento de añadir un nodo como adyacente a otro y llamar al método para añadirlo en los laterales
     *
     * @param  Nodo aInsertar se trata del nodo a insertar en la nueva posición
     *         posicion es la nueva posición en la que debe añadirse el nodo
     */
    private void agregarNodo(Nodo aInsertar, int posicion)
    {
        Nodo nuevoNodo = new Nodo(aInsertar.getNodo(), aInsertar.getCoste());
        nuevoNodo.setSiguiente(listaNodos.get(posicion).getSiguiente());
        listaNodos.get(posicion).setSiguiente(nuevoNodo);
        System.out.println("Nodo añadido en otra fila");
        agregarAnteriorSiguiente(aInsertar, posicion);

    }

    
    /**
     * Este método encapsula el código necesario para añadir un Nodo a la lista de adyacencias en la posición anterior y siguiente a una posición
     * comprobando que no sean los laterales del tablero representado
     *
     * @param  Nodo aInsertar se trata de un Nodo con la información que debe contener el nuevo nodo a insertar
     */
    private void agregarAnteriorSiguiente(Nodo aInsertar, int posicion)
    {
        /* Para calcular si un nodo está en un lateral del tablero accedemos a su referencia y la comparamos con el número de columnas existentes
         * Para hacerlo, calculamos el resto de la division entera que nos indicará la columna en la que se encuentra:
         * En caso de ser 0 la posición es múltiplo del número de columnas y se trata del lateral izquierdo del tablero
         * Si el resto es (columnas-1) hablaremos de la última columna de la derecha
         * Con cualquier otro resultado, añadimos a ambos lados.
         * Para añadir un nodo creamos uno nuevo con la información del que hay que insertar y modificamos el campo siguiente
         */        
        int restoUltimaColumna = (this.columna-1); // Calculamos el resto del lateral derecho del tablero para ejecutar un switch
        System.out.println("el resto de la división es "+(posicion % (this.columna)));
        
        if ((posicion % columna) == restoUltimaColumna) {
                if (posicion != 0) { // La primera posicion del array es 0 y si no la controlamos lanza una excepción pues está en el lado izqdo
                    // Columna final, lado derecho, debemos insertar a la izquierda de la posición
                    Nodo nuevoIzquierda = new Nodo(aInsertar.getNodo(), aInsertar.getCoste());
                    // El nuevo nodo debe apuntar al primero de los ya añadidos, o tendrá valor null en caso de ser el primero
                    nuevoIzquierda.setSiguiente(listaNodos.get(posicion-1).getSiguiente());
                    // Y ahora lo ponemos el primero
                    listaNodos.get(posicion-1).setSiguiente(nuevoIzquierda);
                    System.out.println("Añadido izquierda");
                } else {
                    // Columna primera, lado izquierdo, debemos inserta a la derecha. El código es casi igual
                    Nodo nuevoDerecha = new Nodo(aInsertar.getNodo(), aInsertar.getCoste());
                    // El nuevo nodo debe apuntar al primero de los ya añadidos, o tendrá valor null en caso de ser el primero
                    nuevoDerecha.setSiguiente(listaNodos.get(posicion+1).getSiguiente());
                    // Y ahora lo ponemos el primero
                    listaNodos.get(posicion+1).setSiguiente(nuevoDerecha);
                    System.out.println("Añadido derecha"); 
                    }
        }
        if (posicion % (columna) == 0) {
                // Columna primera, lado izquierdo, debemos inserta a la derecha. El código es casi igual
                Nodo nuevoDerecha = new Nodo(aInsertar.getNodo(), aInsertar.getCoste());
                // El nuevo nodo debe apuntar al primero de los ya añadidos, o tendrá valor null en caso de ser el primero
                nuevoDerecha.setSiguiente(listaNodos.get(posicion+1).getSiguiente());
                // Y ahora lo ponemos el primero
                listaNodos.get(posicion+1).setSiguiente(nuevoDerecha);
                System.out.println("Añadido derecha");
            }
        if ( !(posicion % (columna) == 0) && !((posicion % columna) == restoUltimaColumna)) {
            // En este caso se añade en ambos lados, simplemente reutilizamos el código, cambiando los nombres para evitar errores
                Nodo nuevoIzquierda2 = new Nodo(aInsertar.getNodo(), aInsertar.getCoste());
                nuevoIzquierda2.setSiguiente(listaNodos.get(posicion-1).getSiguiente());
                listaNodos.get(posicion-1).setSiguiente(nuevoIzquierda2);     
                Nodo nuevoDerecha2 = new Nodo(aInsertar.getNodo(), aInsertar.getCoste());
                nuevoDerecha2.setSiguiente(listaNodos.get(posicion+1).getSiguiente());
                listaNodos.get(posicion+1).setSiguiente(nuevoDerecha2);             
                System.out.println("Añadido izquierda y añadido derecha");                
            }       

    }

    
    /**
     * Este método devuelve la longitud máxima que deberá tener la ArrayLista calculando el número de nodos según la lectura del fichero
     * @return     devuelve el producto de las filas por columnas del tablero representado en el fichero, n*m
     */
    public int getLongitudMaxima()
    {
        // codigo del metodo
        return this.longitud;
    }
    

    /**
     * Con este método obtenemos la longitud real de la ArrayList
     * @return     devuelve el resultado de pedir la longitud de la ArrayList
     */
    public int getLongitudReal()
    {
        // codigo del metodo
        return listaNodos.size();
    }    


}


/**
 * Implementación de la clase Robot que inicia el tratamiento de la matriz indicada según el algoritmo Dijkstra como se pide en el enuncia
 * 
 * @author Alejandro Ángel Rodríguez Simón
 * @version Alfa 0.3 - Una vez evaluadas las condiciones para la ejecución correcta, obtiene el nombre del archivo de entrada y comprueba
 *          si existe, en caso de no existir arroja una FileNotFoundException.
 * @version Alfa 0.2 - Realizo una comprobación de los argumentos -t y -h.
 *          En el caso del -t muestro un mensaje de que se va a realizar la traza de la ejecución del programa y fijo traza = true
 *          En el caso del -h muestro el mensaje mediante un método para encapsularlo y reutilizar con las excepciones de control de errores
 *          de los parámetros de fichero
 * @version Alfa 0.1 - Simplemente codifico la recepción correcta de parámetros pues es mi primera vez usando Java
 */

public class Robot
{
    // Declaramos las clases que vamos a necesitar
    static ListaDeAdyacencia lista;
    static ProcesadorArchivos manipuladorGrafos;
   
    
    public static void main(String[] args)    {   
        boolean traza = false;    
        /**
         * Lo primero que haremos será evaluar los argumentos que se nos han facilitado en la ejecución del programa, para lo que ejecutamos
         * este método que realizará lo siguiente:
         * - Si detecta que se ha pedido traza devolverá valor true y con un atributo invocaremos el resto de métodos notificando la traza
         * - Si detecta que se ha solicitado la ayuda muestra el mensaje correspondiente y finaliza la ejecución del programa
         * - Si detecta que no hay parámentros suficientes suficientes para una ejecución correcta muestra un mensaje y para la ejecución
         */    
        traza = evaluarArray(args);
        // Leemos el fichero de entrada, cuyo se nombre se encontrará en la posición:
        // 0 si args.length = 2 --> En este caso hay dos parámetros, si ninguno es -t o -h, serán dos nombres de fichero 
        // 1 si args.length = 3 --> En este caso existe -t y dos nombres de fichero, el primero se considera la entrada
        // Si args.length = 1, evaluarArray() dará error; si args.length = 4 entonces la llamada incluye -h y se ejecuta mostrarAyuda()
        System.out.println("El valor de traza es "+traza);
        System.out.println("El valor de args.length es "+args.length); 
        ProcesadorArchivos manipuladorGrafos = new ProcesadorArchivos(args[args.length-2]);
        manipuladorGrafos.generarLista(lista);
        
        } 

        /**
         * Lo primero que haremos será evaluar los argumentos que se nos han facilitado en la ejecución del programa, tomando las siguientes
         * consideraciones:
         *     - Si aparece el parámetro -h se mostrará el mensaje de ayuda y se finalizará la ejecución. Usará el método mostrarAyuda().
         *     - Si aparece el parámetro -t se mostrará un mensaje indicando que se solicita traza y se fija la variable boolean traza a true, 
         *         de forma que se pueda utilizar como elementro de control para mostrar los mensajes de traza.
         *     - A continuación evaluará si se han facilitado dos nombres de archivo calculando el número de parametros facilitados, de forma
         *         que podamos realizar un control de excepciones en caso de que no se hayan facilitado dos nombres de ficheros.
         */         
        private static boolean evaluarArray(String args2[]) {
            int recorridoArrays = 0; // Variable para hacer recorridos por el array de argumentos;   
            boolean traza2 = false;
            boolean ayuda = false;
            
            for (recorridoArrays = 0; recorridoArrays <args2.length; recorridoArrays++) {
                // Lo primero que comprobamos es que se ha solicitado traza del programa
                if (args2[recorridoArrays].equals("-t")) {
                    traza2 = true;
                    System.out.println("***** Ha solicitado traza de la ejecución del programa *****");
                    // Este if comprueba si es posible que la invocación del comando sea correcta
                    // Si se ha solicitado traza debe haber al menos dos parámentros más, por lo que si el número es menor mostramos un mensaje
                    // de error ya que no tenemos los ficheros de entrada y salida, y ejecutamos avisarErrorEntrada()
                    if ((args2.length-1)<2) {
                        avisarErrorEntrada();
                    }
                    break; // salimos del if, ya hemos realizado la comprobación
                }
                else {
                    // Este if se ejecuta cuando el argumento no tiene valor -t, y trata de averiguar dos cosas:
                    // Si el parámentro es un -h y por tanto debe ejecutar mostrarAyuda();
                    // Si no se han facilitado los dos ficheros y por tanto debe ejecutar avisarErrorEntrada                    
                    if (args2[recorridoArrays].equals("-h")) {
                        ayuda = true;
                    }
                    else {
                        if (args2.length<2) {
                            avisarErrorEntrada();
                        }
                    }
                }
            }   
        
            // Este segundo for termina de comprobar el array de parámetros para mostrar el mensaje de error en caso de que se detecte
            // La petición de traza en el primero antes que la petición de ayuda
            for ( recorridoArrays = recorridoArrays; recorridoArrays < args2.length; recorridoArrays++) {
                if (args2[recorridoArrays].equals("-h")) {
                    ayuda = true;
                }
            }   
            if (ayuda == true) { 
                mostrarAyuda();
            }
            return traza2;
        }

        /** Este método tiene como finalidad mostrar un mensaje de error genérico acerca del número de parámetros facilitados como
         * argumentos a la ejecución, o con el formato de los ficheros. Se crea un método propio por economía de escritura y facilidad en la
         * invocación en caso de ser necesario.
         */
        private static void avisarErrorEntrada()
        {      
            System.out.println("");                    
            System.out.println("Ha introducido un número incorrecto de parámetros");
            System.out.println("Falta el nombre de al menos un fichero");
            System.out.println("Por favor, revise la ayuda del programa");
            System.out.println("");
            System.out.println("");                    
            mostrarAyuda();        
        }
        
        /** Este método tiene como finalidad mostrar el mensaje de ayuda descrito en el enunciado de la práctica
         *  Se ha creado un método para él sólo de forma que se ahorren líneas de código llamándolo desde donde sea necesario
         */
        private static void mostrarAyuda()
        {
            // Se elimina esta línea que estaba simplemente para mostrar un mensaje de ayuda y comprobar que funcion
            // antes de hacer el texto completo
            // System.out.println("***** Ha solicitado mostrar el mensaje de ayuda *****");
            System.out.println("SINTAXIS:");
            System.out.println("robot [-t][-h][fichero_entrada] [fichero_salida]");
            System.out.println("-t Traza la aplicación del algoritmo a");
            System.out.println("los datos");
            System.out.println("-h Muestra esta ayuda");
            System.out.println("fichero_entrada Nombre del fichero de entrada");
            System.out.println("fichero_salida Nombre del fichero de salida");
            System.exit(1);
        }          
        

}  

/**
 * CLASE PRINCIPAL.
 * 
 * Necesitamos organizar un torneo de tenis con N jugadores en donde cada jugador ha de jugar exactamente una vez contra cada uno de sus posibles n-1 competidores, 
 * y además ha de jugar un partido cada día, teniendo a lo sumo UN D�?A DE DESCANSO en todo el torneo. Se supone que hay campos de tenis suficientes para jugar cada 
 * día todos los partidos necesarios.
 * 
 * Se pide diseñar para resolverlo un algoritmo basado en el esquema de Divide y Vencerás.
 * 
 */

/**
 * 
 * @Fecha 04/01/2021
 * @Version 1.0
 * @Autor Paulino Esteban Bermúdez Rodríguez
 * 
 */
import java.io.IOException;
import java.util.*;

public class Main {
    /**
     * Booleanos que indican si se debe imprimir la traza y/o la ayuda, respectivamente.
     */
    private static boolean verTraza = false; 
    private static boolean verAyuda = false;
    
    public static void main(String[] args) throws IOException {
        String argumento;
        
        // Bucle para comprobar los argumentos y hacer con cada uno de ellos lo que le corresponde
        for (int entrada = 0; entrada < args.length; entrada++) {
            argumento = args[entrada];
            int jugadores = Integer.parseInt(argumento);
            if (argumento.equals("-h")) {
                System.out.println("Vemos la ayuda del programa ... CARGANDO...\n\n");
                verAyuda = true;
            } else if (argumento.equals("-t")) {
                System.out.println("Vemos la traza del programa ... CARGANDO...\n\n");
                verTraza = true;
            } else if (  argumento.length() == 1 && jugadores >= 2 ){
                System.out.println("El número de jugadores para el torneo introducido es: " + jugadores);
                Torneo tenis = new Torneo();
            } else {
                System.out.println("\n");
                System.out.println("Error Desconocido. Se ha producido un error inesperado, por favor vuelva a ejecutar el programa.");
                System.out.println("Si necesita ver la ayuda del programa, ejecute:\n $ 'java torneo.jar n -h' \n");
                System.out.println("-h: Ayuda\n n: Número de jugadores del torneo de tenis.");
                System.out.println("\n");
            }
            
        } // for de entrada de argumentos
        // if-else que en función de los atributos boolean hace la mayor parte de lo que aparece por pantalla en el programa
        if (verAyuda){
            System.out.println("\t\tSINTAXIS.\n");
            System.out.println("Para la ejecución del organizador de partidas del torneo de tenis, ejecute: \n");
            System.out.println("\t$ java -jar torneo.jar n [-t][-h]  \n");
            System.out.println("1.  n:  Número entero positivo, mayor que 1, indica el número de jugadores del torneo de tenis.");
            System.out.println("2. -t:  Traza las llamadas recursivas del programa.");
            System.out.println("3. -h:  Muestra esta ayuda. \n");
            System.out.println("@Versión: 1.0");
            System.out.println("@CentroAsociado: UNED-Las Tablas.");
            System.out.println("@Author: Paulino Esteban Bermúdez R.");
        } else {
            Torneo tenis = new Torneo();
            if (verTraza){
                System.out.println("Traza:\n");
                System.out.println(tenis.traza);
            }
        }
        System.exit(0);
    } //static void main
} //Main
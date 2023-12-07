/**
 * Necesitamos organizar un torneo de tenis con N jugadores en donde cada jugador ha de jugar exactamente una vez contra cada uno de sus posibles n-1 competidores, 
 * y además ha de jugar un partido cada día, teniendo a lo sumo UN D�?A DE DESCANSO en todo el torneo. Se supone que hay campos de tenis suficientes para jugar cada 
 * día todos los partidos necesarios.
 * 
 * Se pide diseñar para resolverlo un algoritmo basado en el esquema de Divide y Vencerás.
 * 
 * 
 * @Fecha 04/01/2021
 * @Version 1.0
 * @Autor Paulino Esteban Bermúdez Rodríguez
 * 
 */
package es.UNED.torneotenis;
import java.io.IOException;
import java.util.*;
public class Main {
    /*** Booleanos que indican si se debe imprimir la traza y/o la ayuda, respectivamente.*/
    private static boolean verTraza = false;  
    private static boolean verAyuda = false;
    /**
     * Método principal.
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        String argumento;        
        String entra = String.valueOf(args[0]);
        //jugadores = Integer.valueOf(args[1]);        
        System.out.println("\t\tINICIO DEL PROGRAMA - TORNEO DE TENIS.\n"+
                "+----------------------------------------------------------------+\n"+
                "| Nota: Introduzca un valor entero +, <1. Como primer parámetro. |\n"+
                "+----------------------------------------------------------------+\n");
        // Bucle para comprobar los argumentos y hacer con cada uno de ellos lo que le corresponde
        for (int entrada = 0; entrada < args.length; entrada++) {
            // Argumentos de entrada del programa, en este caso SIEMPRE es necesario, introducir un valor para 'n', los argumentos opcionales son '-t' y '-h'.
            // Comprobacion de los valores de entrada en el programa.
            argumento = args[entrada];
            // Argumento -h para la ayuda del programa.
            if ( argumento.equals("-h")) {
                System.out.println("\nVemos la ayuda del programa ... CARGANDO...\n\n");
                verAyuda = true;
                System.out.println("\t\tSINTAXIS.\n");
                System.out.println("Para la ejecución del organizador de partidas del torneo de tenis, ejecute: \n");
                System.out.println("\t$ java -jar torneo.jar n [-t][-h]  \n");
                System.out.println("1.  n:  Número entero positivo, mayor que 1, indica el número de jugadores del torneo de tenis.");
                System.out.println("2. -t:  Traza las llamadas recursivas del programa.");
                System.out.println("3. -h:  Muestra esta ayuda. \n");
                System.out.println("@Versión: 1.0");
                System.out.println("@CentroAsociado: UNED-Las Tablas.");
                System.out.println("@Author: Paulino Esteban Bermúdez R.");
                System.exit(0);
            }            
            int jugadores = Integer.valueOf(entra);
            // Argumento -t para la trazabilidad del programa.
            if (argumento.equals("-t")) {
                System.out.println("\nVemos la traza del programa ... CARGANDO...\n\n");
                verTraza = true;
                // Creamos un nuevo elemento Torneo llamado partido que dibujará el calendario del torneo de tenis
                Torneo partidos = new Torneo();
                System.out.println("............................................................");
                System.out.println("· El número de jugadores para el torneo introducido es: " + jugadores +" ·");
                System.out.println("............................................................");
                System.out.println("Argumento[0]=>'Jugadores' es de tipo:" + ((Object)jugadores).getClass().getSimpleName());
                int grupo[][] = new int[jugadores][jugadores];
                partidos.Torneo(grupo, jugadores);
                int tenista, partido;
                for ( tenista = 0; tenista < jugadores; tenista++) {
                    for ( partido = 0; partido < jugadores; partido++) { System.out.print(grupo[tenista][partido]+ " ");}
                    System.out.println("");
                }
            } else if ( argumento.length() == 1 && jugadores >= 2 ){
                Torneo partidos = new Torneo();
                System.out.println("............................................................");
                System.out.println("· El número de jugadores para el torneo introducido es: " + jugadores +" ·");
                System.out.println("............................................................");
                int jugador[][] = new int[jugadores][jugadores];
                partidos.Torneo(jugador, jugadores);
                int deportista, partido;
                for ( deportista = 0; deportista < jugadores; deportista++) {
                    for ( partido = 0; partido < jugadores; partido++) { System.out.print(jugador[deportista][partido]+ " "); }
                    System.out.println("");
                }
            }else if(argumento.length() == 1 && jugadores < 2){
                System.out.println("Error en el dato de entrada.\n"+ "El valor del parámetro es inferior a 2, para poder realizar el calendario, \n"+
                "este parámetro debe ser mayor que 2 para jugar el torneo.\n\n"+ "Si necesita ver la ayuda del programa, ejecute:\n $ 'java torneo.jar n -h' \n"+
                "-h: Ayuda\n n: Número de jugadores del torneo de tenis.\n");
            }else {
                System.out.println("\n");
                System.out.println("Error Desconocido. Se ha producido un error inesperado, por favor vuelva a ejecutar el programa.");
                System.out.println("Si necesita ver la ayuda del programa, ejecute:\n $ 'java torneo.jar n -h' \n");
                System.out.println("-h: Ayuda\n n: Número de jugadores del torneo de tenis.\n");
            }
        } // for de entrada de argumentos
        int jugadores = Integer.valueOf(entra);
        // if-else que en función de los atributos boolean hace la mayor parte de lo que aparece por pantalla en el programa
        if (verAyuda){
            boolean ayuda = true;
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
            if (verTraza){
                System.out.println("Traza:\n");
                boolean traza = true;
                Torneo tenis = new Torneo();
                tenis.traza(true);
                int grupo[][] = new int[jugadores][jugadores];
                tenis.Torneo(grupo, jugadores);
                System.out.println(traza);
            }            
        }
        System.exit(0);
    } //static void main
} //Main
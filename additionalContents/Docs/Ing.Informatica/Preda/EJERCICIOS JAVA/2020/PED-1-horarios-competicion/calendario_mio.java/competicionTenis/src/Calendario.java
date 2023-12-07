package src;
import java.util.Scanner;

/**
* Write a description of class Calendario here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Calendario{
    private int [] equipos;
    private String[][] m1, m2, jornadas1, jornadas2;
    /*
     * Nº de equipos -> N
     */
    public Calendario(int N){
        equipos = new int[N];
        // Asigno posiciones del array a los equipos.
        for (int i = 0; i < N ; i++){
            equipos[i] = i + 1;
        }
        
        m1 = new String[N-1][N/2];
        m2 = new String[N-1][N/2];
        jornadas1 = new String[N-1][N/2];
        jornadas2 = new String[N-1][N/2];
        int contador = 0;
        int contador2 = N-2;
        
             for(int i=0; i < N-1; i++){
                for(int j = 0; j < N/2; j++){
                    /*
                     * Completo las matrices
                     */
                    m1[i][j] = String.valueOf(equipos[contador]);
                    contador++;
                    if(contador==(N-1)){
                        contador=0;
                    }
                    if ( j== 0){
                        m2[i][j] = String.valueOf(N);                    
                    }else{
                        m2[i][j] = String.valueOf(equipos[contador2]);
                        contador2--;
                        if(contador2 == -1){
                            contador2 = N-2;
                        }
                    }
                    /*
                     * Creamos la matriz con las partidas a competir
                     */
                    // PRIMERA VUELTA
                    if ( j == 0){
                        if(i%2==0){
                            jornadas1[i][j] = m1[i][j] + " vs " + m2[i][j] + "|";
                        }else{
                            jornadas1[i][j] = m2[i][j] + " vs " + m1[i][j] + "|";
                        }
                    }else{
                        jornadas1[i][j] = m1[i][j] + " vs " + m2[i][j] + "|";
                    }
                    // SEGUNDA VUELTA
                    if(j==0){
                        if(i%2==0){
                            jornadas2[i][j] = m1[i][j] + " vs " + m2[i][j] + "|";
                        }else{
                            jornadas2[i][j] = m2[i][j] + " vs " + m1[i][j] + "|";
                        }
                    }else{
                        jornadas2[i][j] = m1[i][j] + " vs " + m2[i][j] + "|";
                    }
                }
            }
        
            for(int i=0; i < N-1; i++){
                for(int j = 0; j < N/2; j++){
                    /*
                     * Completo las matrices
                     */
                    m1[i][j] = String.valueOf(equipos[contador]);
                    contador++;
                    if(contador==(N-1)){
                        contador=0;
                    }
                    if ( j== 0){
                        m2[i][j] = String.valueOf(N);                    
                    }else{
                        m2[i][j] = String.valueOf(equipos[contador2]);
                        contador2--;
                        if(contador2 == -1){
                            contador2 = N-2;
                        }
                    }
                    /*
                     * Creamos la matriz con las partidas a competir
                     */
                    // PRIMERA VUELTA
                    if ( j == 0){
                        if(i%2==0){
                            jornadas1[i][j] = m1[i][j] + " vs " + m2[i][j] + "|";
                        }else{
                            jornadas1[i][j] = m2[i][j] + " vs " + m1[i][j] + "|";
                        }
                    }else{
                        jornadas1[i][j] = m1[i][j] + " vs " + m2[i][j] + "|";
                    }
                    // SEGUNDA VUELTA
                    if(j==0){
                        if(i%2==0){
                            jornadas2[i][j] = m1[i][j] + " vs " + m2[i][j] + "|";
                        }else{
                            jornadas2[i][j] = m2[i][j] + " vs " + m1[i][j] + "|";
                        }
                    }else{
                        jornadas2[i][j] = m1[i][j] + " vs " + m2[i][j] + "|";
                    }
                }
            
        }
        /*
         * Imprimimos por consola el resultado de la matriz
         */   
        
        int jornadas = 0;
        for(int i=0; i<N-1; i++){
            System.out.print(i + " - ");
            for(int j=0; j<N/2; j++){
                System.out.print(jornadas1[i][j]);
                //if( j==N/2){
                  //  System.out.println();
                //}
            }
            jornadas++;
            System.out.println();
        }
        
        jornadas = N;            
        for(int i = 0; i < N-1; i++){
            System.out.print(i + " - ");
            for(int j=0; j<N/2; j++){
                System.out.print("Jornadas->"+ j + " = "+jornadas2[i][j]);
                if( j == N+1){
                    System.out.print(j + "- Descansa ");
                }
            }
            jornadas++;
            System.out.println();
        }
        
    }
    /*
     * @param args
     */
    public static void main(String[] args){
        new Calendario(5);
    }    
}


/**
 * 
      
        for (int i = 0; i < args.length; i++){
            switch(args[i]){
                case "n":{
                    int jugadores;
                    jugadores = Integer.parseInt(args[0]);
                    //new Torneo(jugadores);
                    new Torneo(8);
                }
                case "-t n":
                    System.out.println("Ejecución con trazabilidad");
                    break;
                case "-h":
                    System.out.println(" BIENVENIDO A LA AYUDA DEL PROGRAMA: \n");
                    System.out.print(" Para la ejecución correcta del programa usted debe inicializarlo usando la siguiente sintaxis: \n ");
                    System.out.println();
                    System.out.print("* Ejecución normal del programa. \n\t torneo n \n Donde n es un valor entero positivo mayor que 1. Indica el número de jugadores del torneo de tenis.");                    
                    System.out.print("* Ver la traza de cada invocación recursiva que describa la parametrización de cada llamada recursiva. \n\t torneo -t n");
                    System.out.println();
                    System.out.print("@Versión: 1.0. \n@Autor: Paulino Esteban Bermúdez R. \n@Fecha:04.01.2021");
                    break;
                default:
                    System.out.println("Error en los argumentos de entrada, por favor ejecute el programa con la opción -h si necesita la ayuda y vuelva a intentarlo de nuevo.");
            }
        }*/

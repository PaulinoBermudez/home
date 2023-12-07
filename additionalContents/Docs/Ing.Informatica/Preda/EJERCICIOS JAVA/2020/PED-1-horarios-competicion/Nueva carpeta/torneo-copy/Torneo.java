/**
 * Necesitamos organizar un torneo de tenis con N jugadores en donde cada jugador ha de jugar exactamente una vez contra cada uno de sus posibles n-1 competidores, 
 * y además ha de jugar un partido cada día, teniendo a lo sumo UN D�?A DE DESCANSO en todo el torneo. Se supone que hay campos de tenis suficientes para jugar cada 
 * día todos los partidos necesarios.
 * 
 * Se pide diseñar para resolverlo un algoritmo basado en el esquema de Divide y Vencerás.
 * 
 * @Version: 1.0
 * @Fecha: 04/01/2021
 * @Author: Paulino Bermúdez R.
 */
public class Torneo{
    private int[] jugador; // Nº de jugadores que compiten en el torneo
    private String[][] grupoA;  // Grupo A. de N / 2 jugadores
    private String[][] grupoB;  // Grupo B. de N / 2 jugadores
    private String[][] jornadas1; // Competicion entre NvsN jugadores del grupo A y lo mismo pero para B.
    private String[][] jornadas2; // Vuelta de competicion entre N vs N jugadores del grupo A y B
    /*
     * Número de jugadores: N.
     */
    public Torneo(int N){
        jugador = new int[N];
        /*
         * Asignamos posiciones del array a los jugadores de cada grupo.
         */
        for ( int i = 0; i < N ; i++ ){
            jugador[i] = i+1;
            //System.out.println("Jugadores: " + jugador[i]);
        }
        /*
         *  Para rellenar la tabla de competición usando el sistema de liga, necesito dibujarla de la siguiente manera:
         *  Ej: N:7 --> Para saber quien descansa ese día a N le sumo 1. N+1 = 8
         *  * GrupoX: --> N/2 -> 7/2 = 4 (Redondeo a la alza)
         *  |                     +_1___2___3___4_+
         *  | N-1 -> 7-1 =6   1.  |8_7|1_6|2_5|3_4| ==> 7 descansa 1 dia
         *  v                 2.  |4_8|5_3|6_2|7_1| ==> 4 descansa 2 dia
         *                    3.  |8_1|2_7|3_6|4_5| ==> 1 descansa 3 dia
         *                    4.  |5_8|6_4|7_3|1_2| ==> 5 descansa 4 dia
         *                    5.  |8_2|3_1|4_7|5_6| ==> 2 descansa 5 dia
         *                    6.  |6_8|7_5|1_4|2_3| ==> 6 descansa 6 dia
         *                    7.  |7_3|4_2|5_1|6_7| ==> 3 descansa 7 dia
         *                        +---------------+
         *
         *  Ej2: N = 8 --> Al ser par, el toneo termina en n-1 días
         *  *  GrupoX: --> N/2 -> 8/2 = 4
         *  |                     +_1___2___3___4_+
         *  | N-1 -> 8-1 =7   1.  |7_8|1_6|2_5|3_4| 
         *  v                 2.  |8_3|4_2|5_1|6-7| 
         *                    3.  |6_8|7_5|1_4|2_3| 
         *                    4.  |8_2|3_1|4_7|5_6| 
         *                    5.  |5_8|6_4|7_3|1_2| 
         *                    6.  |8_1|2_7|3_6|4_5| 
         *                    7.  |4_8|5_3|6_2|7_1| 
         *                        +---------------+
         *
         */
        grupoA = new String[N-1][N/2];
        grupoB = new String[N-1][N/2];
        
        jornadas1 = new String[N-1][N/2];
        jornadas2 = new String[N-1][N/2];
        
        int contadorA = 0;
        int contadorB = N-2;
        //log.debug("Entrada en bucle anidado para rellenar matrices");
        for( int i = 0; i < N-1; i++ ){
            for ( int j = 0; j < N/2; j++ ){
                /*
                 * Relleno las matrices con los N jugadores, usando el sistema de todos contra todos o sistema de liga. (round-robin).
                 * Si n es el numero de competidores, una ronda simple de este sistema requiere (n*(n-1)/2) encuentros. Si n es un numero par, entonces en (n-1) rondas, se puede jugar n/2 partidos simultáneamente.
                 * Si n es impar, habrá n rondas con ((n-1)/2) juegos simultáneos y un equipo libre por cada ronda.
                 * 
                 * https://es.wikipedia.org/wiki/Sistema_de_todos_contra_todos
                 */
                //log.degung("Grupos - Rellenamos la matriz");
                grupoA[i][j] = String.valueOf(jugador[contadorA]);
                contadorA++;
                if ( contadorA == (N-1) ){
                    contadorA = 0;
                }
                if ( j == 0 ){
                    grupoB[i][j] = String.valueOf(N);
                } else {
                    grupoB[i][j] = String.valueOf(jugador[contadorB]);
                    contadorB--;
                    if ( contadorB == -1 ){
                        contadorB = N-2;
                    }
                }
                // System.out.println("+++++++++++++++++" + grupoA[i][j] + "+++++++++++++++++");                
                // System.out.println("-----------------" + grupoB[i][j] + "-----------------");                                
                /*
                 * Generamos los partidos del torneo con ambas matrices.
                 */
                // Primera vuelta
                if ( j == 0 ){
                    if ( i % 2 == 0){
                        jornadas1[i][j] = grupoA[i][j] + " VS. " + grupoB[i][j] + "\t";
                        //System.out.print("1.if =>" + jornadas1[i][j]);
                    } else {
                        jornadas1[i][j] = grupoB[i][j] + " VS. " + grupoA[i][j] + "\t";
                        //System.out.print("1. else2 ->" + jornadas1[i][j]);
                    }
                } else {
                    jornadas1[i][j] = grupoA[i][j] + " VS. " + grupoB[i][j] + "\t";
                    //System.out.print("1. else *>" + jornadas1[i][j]);
                }
                //System.out.println( "\t" + i + " => " + j);
                // Segunda vuelta
                if ( j == 0 ){
                    if ( i % 2 == 0){
                        jornadas2[i][j] = grupoA[i][j] + " VS. " + grupoB[i][j] + "\t";
                        //System.out.println("2. if !=>" + jornadas2[i][j]);
                    } else {
                        jornadas2[i][j] = grupoB[i][j] + " VS. " + grupoA[i][j] + "\t";
                        //System.out.println("2. else2 ]->" + jornadas2[i][j]);                        
                    }
                } else {
                    jornadas2[i][j] = grupoA[i][j] + " VS. " + grupoB[i][j] + "\t";
                    //System.out.println("2. else [->" + jornadas2[i][j]);                    
                }
                //System.out.println( "\t\t\t\t" + i + " -> " + j);
            }
        }    
        /*
         * Mostramos por consolala matriz resultante de los partidos a disputar.
         */        
        // Iniciamos la competición en la jornada 1 partido 1
        int jornadas = 1;
        for ( int i = 0; i < N ; i++ ){
            System.out.println("Partido " + (i+1) );            
            for ( int j = 0; j < N/2; j++){
                //System.out.print("Partido " + i + "-" + j + ": ");
                System.out.print(jornadas1[i][j] + "\n");
                if ( j == N/2){
                    System.out.println(j+1 + "Descansa");
                }                
            }
            if ( i == N/2 ){
                System.out.print(i+1 + "Descansa \n");
            }
            jornadas++;
        }
        // Finalizamos la competición en la jornada N y el partido N 
        jornadas =  N;
        for ( int i = 0 ; i <= N-1 ; i++){
            for (int j = 0; j < N/2; j++){
                System.out.println("Partido2: " + i + "-" + j + ": ");
                System.out.print(jornadas2[i][j]);
                if ( j == (N/2)-1){
                    System.out.println("\n" + j + "Descansa \n");
                }
                if ( i == N ){
                    System.out.println("Final " + i );
                }
            }
            jornadas++;
        } 
        
    }
    public static void main(String[] args){        
        new Torneo(8);
    }
} 
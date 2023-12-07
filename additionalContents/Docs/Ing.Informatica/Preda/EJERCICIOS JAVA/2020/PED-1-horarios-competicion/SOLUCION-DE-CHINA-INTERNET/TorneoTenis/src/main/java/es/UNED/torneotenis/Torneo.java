/**
 * Necesitamos organizar un torneo de tenis con N jugadores en donde cada jugador ha de jugar exactamente una vez contra cada uno de sus posibles n-1 competidores, 
 * y además ha de jugar un partido cada día, teniendo a lo sumo UN D�?A DE DESCANSO en todo el torneo. Se supone que hay campos de tenis suficientes para jugar cada 
 * día todos los partidos necesarios.
 * 
 * Se pide diseñar para resolverlo un algoritmo basado en el esquema de Divide y Vencerás.
 * 
 */
package es.UNED.torneotenis;

/**
 * 
 * @Fecha 04/01/2021
 * @Version 1.0
 * @Autor Paulino Esteban Bermúdez Rodríguez
 * 
 */

public class Torneo {
    public String traza = "";
    public void Torneo( int matrix[][],int n){  // Matriz de los NxN jugadores // Inicializa sus 'n' jugadores 
        // Atributos  
        
        int i;
        int j;
        traza += "*Entro el método Torneo de la clase Torneo";
        traza += "Creo un nuevo elemento de la clase Torneo llamado partidos";
        
        // Aplicamos el algoritmo de DyV a la matriz de NxN siendo N el argumento entero positivo que forma los tenista del torneo.
        // Para aplicarlo en este problema, tenemos que usar la division de la tabla más grande de NxN, en tablas más pequeñas de (N/2)x(N/2), y después
        // volvemos a unir la solución de las tablas divididas en una sola, así obtenemos que:
        /**
         *                                                           +++++++++++++++++
         *                                                           +1+2+3+4+5+6+7+8+
         *      +++++++++       \\\     ++++++++++++++++      \\\    +2+1+3+4+6+5+8+7+
         *      + 1 + 2 +   ======\\    + 1 + 2 + 3 + 4+  ======\\   +3+4+2+1+7+8+5+6+
         *      +++++++++   ========>   + 2 + 1 + 3 + 4+  ========>  +4+3+1+2+8+7+6+5+
         *      + 2 + 1 +   ======//    + 3 + 4 + 1 + 2+  ======//   +5+6+7+8+1+2+3+4+
         *      +++++++++       ///     + 4 + 3 + 2 + 1+      ///    +6+5+8+7+2+1+4+3+
         *                              ++++++++++++++++             +7+8+5+6+3+4+1+2+       
         *                                                           +8+7+6+5+4+3+2+1+
         *                                                           +++++++++++++++++
         * En este caso este resultado es para un N par, para los valores impares, tan solo tenemos que hacer uso de un 'jugador auxiliar', es decir, N=N+1, este 
         * nuevo jugador, hará de comodín para que los jugadores que jueguen contra (N+1), ese día descansen.
         * Ej: n=7
         *                                                               | d1| d2| d3| d4| d5| d6| d7+  
         *                                                           +++++++++++++++++++++++++++++++++
         *                                                           + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + -> Día7: 1 descansa
         *      +++++++++       \\\     ++++++++++++++++      \\\    + 2 + 1 + 4 + 3 + 6 + 5 + 8 + 7 + -> Día6: 2 descansa
         *      + 1 + 2 +   ======\\    + 1 + 2 + 3 + 4+  ======\\   + 3 + 4 + 2 + 1 + 7 + 8 + 5 + 6 + -> Día5: 3 descansa
         *      +++++++++   ========>   + 2 + 1 + 3 + 4+  ========>  + 4 + 3 + 1 + 2 + 8 + 7 + 6 + 5 + -> Día4: 4 descansa 
         *      + 2 + 1 +   ======//    + 3 + 4 + 1 + 2+  ======//   + 5 + 6 + 7 + 8 + 1 + 2 + 3 + 4 + -> Día3: 5 descansa
         *      +++++++++       ///     + 4 + 3 + 2 + 1+      ///    + 6 + 5 + 8 + 7 + 2 + 1 + 4 + 3 + -> Día2: 6 descansa
         *                              ++++++++++++++++             + 7 + 8 + 5 + 6 + 3 + 4 + 1 + 2 + -> Día1: 7 descansa       
         *                                                           +++++++++++++++++++++++++++++++++
         */
        valorNum(n);
        if ( n > 2){
            traza += "Aplicamos el algoritmo de divide y vencerás.";
            Torneo(matrix, n/2);
            // Rellenamos la esquina superior derecha
            traza += "*Rellenamos la esquina superior derecha";
            for ( i=0; i<n/2; i++){
                for ( j=n/2; j<n; j++){
                    matrix[i][j] = matrix[i][j-n/2] + n/2;
                    //System.out.print(matrix[i][j]);
                }
            }
            // Rellenamos la esquinainferior izquierda
            traza += "*Rellenamos la esquina inferior izquierda";
            for ( i = n/2; i<n; i++){
                for ( j = 0; j < n/2; j++) {
                    matrix[i][j] = matrix[i-n/2][j+n/2];
                }
            }
            // Rellenamos la esquina inferior derecha
            traza += "*Rellenamos la esquina inferior derecha";
            for (i = n/2; i < n; i++) {
                for (j = n/2; j < n; j++) {
                    matrix[i][j] = matrix[i-n/2][j-n/2];
                }
            }
            
        } else if( n == 2) {
            matrix[0][0] = 1;
            matrix[0][1] = 2;
            matrix[1][0] = 2;
            matrix[1][1] = 1;
        }else {
            System.out.println("Los datos introducidos son incorrectos, vuelva a intentarlo de nuevo con otros datos");
        }
    } // void Torneo
    public void traza(boolean valor){
        System.out.println("--------------------------------------------------------");
        System.out.println("\tINICIALIZACION DE LAS TRAZAS DEL PROGRAMA.");
        System.out.println("--------------------------------------------------------");
        System.out.println("1. Entro en el método de Torneo");
        System.out.println("2. Creamos el nuevo objeto partido de la clase torneo");
        System.out.println("3. Comprobamos el valor de entrada como parámetro: par o impar.");
        System.out.println("4. Aplicamos el algoritmo de DyV a la matriz de NxN siendo N el argumento entero positivo que forma los tenista del torneo.\n" +
        " Para aplicarlo en este problema, tenemos que usar la division de la tabla más grande de NxN, en tablas más pequeñas de (N/2)x(N/2), y después\n" +
        " volvemos a unir la solución de las tablas divididas en una sola, así obtenemos el calendario.");
        System.out.println("5. Mostramos el resultado del DyV por pantalla.");
        System.out.println("FIN DE LA TRAZABILIDAD DEL PROGRAMA.");
    }

    private int valorNum(int n) {
        //System.out.println("Valor1 de n jugadores: " + n);
        traza += "*Comprobación de nº de jugadores. ¿Es par?";
        // Comprobamos que el número de jugadores sea par
        if ( n % 2 != 0 ) {
            traza += "*> No";
            n = n+1;
        // Jugadores impares en el torneo
        } else {
            traza += "*> Si";
        }
        //System.out.println("Valor2 de n jugadores: " + n);
        return n;
        
    }
}

package src;


import java.util.Arrays;

/**
 * Clase para la resolucion de un Sudoku hexadecimal.
 *
 * @author César Aguilera <cesarap at correo.ugr.es>
 * @see http://twitter.com/cs4r
 */
public class SudokuHex {

    /**
     * Array bidimensional donde se va a leer el tablero con el que se construya
     * una instancia de esta clase, si se ejecuta el metodo solve() de manera
     * satisfactoria, este atributo almacenara el sudoku hexadecimal resuelto, 
     * (una casilla a -1 significa que esta libre).
     */
    private final static int[][] tableroOriginal = new int[][]{
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
    
    /**
     * Valores precomputados para hacer mas rapida la conversion de matriz
     * bidimensional a String.
     */
    private final static char[] digitos_hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    
    /**
     * Array de flags para indicar cada uno de los valores posibles de una
     * casilla.
     */
    private final static int[] mascaraBitsValoresPermitidos = new int[]{
        1, // Flag para indicar 0 como valor permitido
        1 << 1, // 1
        1 << 2, // 2 
        1 << 3, // 3
        1 << 4, // 4
        1 << 5, // 5
        1 << 6, // 6
        1 << 7, // 7 
        1 << 8, // 8
        1 << 9, // 9
        1 << 10, // a
        1 << 11, // b
        1 << 12, // c
        1 << 13, // d
        1 << 14, // e
        1 << 15 // f
    };
    /**
     * Valores precomputados necesarios para aplicar multiplicacion y busqueda
     * usando una secuencia de DeBruijn.
     */
    private final static int[] multiplyDeBruijnBitPosition = new int[]{
        0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8,
        31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
    /**
     * Coordenadas de fila y columna donde se encuentra la esquina superior
     * izquierda de cada uno de los bloques del sudoku (secciones).
     */
    private final static int[] coordEsquinaIzqBloques = new int[]{0, 4, 8, 12};

    /*
     * // Frecuencia de aparicion de filas y columnas en el tablero
     * // de 0 a 15 se guarda la frecuencia de las filas
     * // de 16 a 31 se guarda la frecuenca de las columnas
     * // en la posicicion 32 se guarda la fila que mas aparece
     * // en la posicion 33 se guarda la columna que mas aparece
     * int frecuenciaAparicionesFilasYColumnas[34];
     */
    /**
     * Calcula el numero de valores permitidos de una casilla.
     *
     * @param mascaraCasilla codifica de manera binaria los valores posibles de
     * la casilla.
     * @return Numero de bits activos en mascaraCasilla (Hamming weigh).
     * @see http://en.wikipedia.org/wiki/Hamming_weight y
     * http://aggregate.ee.engr.uky.edu/MAGIC/#Population%20Count%20%28Ones%20Count%29
     */
    private static int getNumeroValoresPermitidosCasilla(int mascaraCasilla) {
        mascaraCasilla = mascaraCasilla - ((mascaraCasilla >> 1) & 0x55555555);
        mascaraCasilla = (mascaraCasilla & 0x33333333) + ((mascaraCasilla >> 2)
                & 0x33333333);
        return (((mascaraCasilla + (mascaraCasilla >> 4)) & 0x0F0F0F0F)
                * 0x01010101) >> 24;
    }

    /**
     * Actualiza las restricciones del tablero una vez modificada una casilla.
     *
     * @param tablero Array bidimensional que representa un tablero del sudoku
     * hexadecimal
     * @param fil fila de la casilla que ha sido modificada
     * @param col columna de la casilla que ha sido modificada
     * @param valoresPermitidosCasillas Array bidimensional que codifica de
     * manera binaria los valores posibles para cada casilla del tablero
     */
    private static void actualizarRestriccionesTablero(final int[][] tablero, final int fil, final int col, final int[][] valoresPermitidosCasillas) {

        // Cambiar 0's por 1's, para que con un AND logico pueda actualizar 
        // rapidamente los valores permitidos en la mascara del resto de casillas
        final int inversoMascaraCasillaModificada =
                ~mascaraBitsValoresPermitidos[tablero[fil][col]];

        // Eliminar el valor establecido en tablero[fil][col] de los
        // valores permitidos para las casillas libres de la misma columna
        // Bucle desenrollado, equivale a:
        // for (int i = 0; i < 16; ++i) {
        //    valoresPermitidosCasillas[i][col] &= inversoMascara;
        // }

        valoresPermitidosCasillas[0][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[1][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[2][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[3][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[4][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[5][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[6][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[7][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[8][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[9][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[10][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[11][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[12][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[13][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[14][col] &= inversoMascaraCasillaModificada;
        valoresPermitidosCasillas[15][col] &= inversoMascaraCasillaModificada;

        // Eliminar el valor establecido en tablero[fil][col] de los
        // valores permitidos para las casillas libres de la misma fila
        // Bucle desenrollado, equivale a:
        // for (int j = 0; j < 16; ++j) {
        //    valoresPermitidosFila[j] &= inversoMascara;
        // }
        // 
        // Como es un metodo que se va a llamar mucho desde mi algoritmo
        // guardo la referencia de la fila que voy a utilizar
        // para minizar el numero de accesos al heap

        final int[] valoresPermitidosFila;
        valoresPermitidosFila = valoresPermitidosCasillas[fil];
        valoresPermitidosFila[0] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[1] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[2] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[3] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[4] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[5] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[6] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[7] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[8] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[9] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[10] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[11] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[12] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[13] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[14] &= inversoMascaraCasillaModificada;
        valoresPermitidosFila[15] &= inversoMascaraCasillaModificada;


        // Eliminar el valor establecido en tablero[fil][col] de los
        // valores permitidos para las casillas libres del mismo bloque:

        // Para ello hay que hacer la intersección de:
        //    - fil1 con col1, col2, col3
        //    - fil2 con col1, col2, col3
        //    - fil3 con col1, col2, col3
        // Aplicarle AND con inversoMascara a cada una de las intersecciones: 9 en total

        int fil1 = 0, fil2 = 0, fil3 = 0;

        switch (fil & 3) { //  fil%4
            case 0:
                fil1 = (fil + 1);
                fil2 = (fil + 2);
                fil3 = (fil + 3);
                break;
            case 1:
                fil1 = (fil - 1);
                fil2 = (fil + 1);
                fil3 = (fil + 2);
                break;
            case 2:
                fil1 = (fil - 2);
                fil2 = (fil - 1);
                fil3 = (fil + 1);
                break;
            case 3:
                fil1 = (fil - 3);
                fil2 = (fil - 2);
                fil3 = (fil - 1);
                break;
        }

        int col1 = 0, col2 = 0, col3 = 0;

        switch (col & 3) { // col%4
            case 0:
                col1 = (col + 1);
                col2 = (col + 2);
                col3 = (col + 3);
                break;
            case 1:
                col1 = (col - 1);
                col2 = (col + 1);
                col3 = (col + 2);
                break;
            case 2:
                col1 = (col - 2);
                col2 = (col - 1);
                col3 = (col + 1);
                break;
            case 3:
                col1 = (col - 3);
                col2 = (col - 2);
                col3 = (col - 1);
                break;
        }

        // Como es un metodo que se va a llamar mucho desde mi algoritmo
        // Guardo la referencia de cada una de las filas que voy a utilizar
        // para minizar el numero de accesos al heap
        // Si accedo directamente con valoresPermitidosCasillas[fili][colj];
        // para i=1...3, j=1...3 ejecuto 9*2 = 18 accesos 
        // En cambio de la siguiente forma ejecuto 12 accesos
        final int[] permitidosFila1, permitidosFila2, permitidosFila3;

        permitidosFila1 = valoresPermitidosCasillas[fil1];
        permitidosFila2 = valoresPermitidosCasillas[fil2];
        permitidosFila3 = valoresPermitidosCasillas[fil3];

        permitidosFila1[col1] &= inversoMascaraCasillaModificada;
        permitidosFila1[col2] &= inversoMascaraCasillaModificada;
        permitidosFila1[col3] &= inversoMascaraCasillaModificada;

        permitidosFila2[col1] &= inversoMascaraCasillaModificada;
        permitidosFila2[col2] &= inversoMascaraCasillaModificada;
        permitidosFila2[col3] &= inversoMascaraCasillaModificada;

        permitidosFila3[col1] &= inversoMascaraCasillaModificada;
        permitidosFila3[col2] &= inversoMascaraCasillaModificada;
        permitidosFila3[col3] &= inversoMascaraCasillaModificada;
    }

    /**
     * Calcula el mayor valor permitido para una casilla.
     *
     * @param mascaraValoresPermitidos codifica de manera binaria los valores
     * posibles de la casilla
     * @return Posicion del ultimo bit activo en mascaraValoresPermitidos
     * @see http://supertech.csail.mit.edu/papers/debruijn.pdf y
     * http://graphics.stanford.edu/~seander/bithacks.html
     */
    private static int getMayorValorPermitidoCasilla(int mascaraValoresPermitidos) {
//
//        // Empieza en -1 porque la flag del 0 es 1
//        int numeroPermitido = -1;
//        while (mascaraValoresPermitidos > 0) {
//            // Mientras en la mascara haya flags activos
//            // Contar el numero de flags activos que hay
//            ++numeroPermitido;
//            // Desplazar a la derecha para descartar una vez contado
//            mascaraValoresPermitidos >>= 1;
//        }


        // Multiply and lookup, es mas eficiente
        return multiplyDeBruijnBitPosition[(((mascaraValoresPermitidos & -mascaraValoresPermitidos) * 0x077CB531)) >>> 27];
    }

    /**
     * Establece un valor determinado en una casilla del tablero.
     *
     * @param tablero Array bidimensional que representa un tablero del sudoku
     * hexadecimal.
     * @param fil fila de la casilla a modificar.
     * @param col columna de la casilla a modificar.
     * @param valor valor a establecer en la casilla.
     * @param valoresPermitidosCasillas Array bidimensional que codifica de
     * manera binaria los valores posibles para cada casilla del tablero.
     */
    private static void setValorEnCasilla(final int[][] tablero, final int fil, final int col, final int valor, final int[][] valoresPermitidosCasillas) {
        // Establecer el valor en la casilla
        tablero[fil][col] = valor;
        // Como la casila pasa a ser fija, no se permite ningun valor en esa casilla
        valoresPermitidosCasillas[fil][col] = 0;
        // Actualizar las restricciones del tablero
        actualizarRestriccionesTablero(tablero, fil, col, valoresPermitidosCasillas);

//
//        frecuenciaAparicionesFilasYColumnas[fil] = (++frecuenciaAparicionesFilasYColumnas[fil]) & 15;
//
//        // Actualizar fila mas frecuente
//        if (frecuenciaAparicionesFilasYColumnas[fil] >= frecuenciaAparicionesFilasYColumnas[frecuenciaAparicionesFilasYColumnas[32]]) {
//            frecuenciaAparicionesFilasYColumnas[32] = fil;
//        }
//
//        // Actualizar columna mas frecuente
//
//        frecuenciaAparicionesFilasYColumnas[16 + col] = (++frecuenciaAparicionesFilasYColumnas[16 + col]) & 15;
//
//        if (frecuenciaAparicionesFilasYColumnas[16 + col] >= frecuenciaAparicionesFilasYColumnas[frecuenciaAparicionesFilasYColumnas[33]]) {
//            frecuenciaAparicionesFilasYColumnas[33] = col;
//        }


    }

    /**
     * Rellena las celdas del tablero que solo admiten un unico valor posible.
     *
     * @param tablero Array bidimensional que representa un tablero del sudoku
     * hexadecimal.
     * @param valoresPermitidosCasillas Array bidimensional que codifica de
     * manera binaria los valores posibles para cada casilla del tablero.
     * @return Numero de casillas que ha conseguido rellenar en el tablero.
     */
    private static int rellenarCasillasConUnicoValorPosible(final int[][] tablero,
            final int[][] valoresPermitidosCasillas) {

        // Recorre el tablero fila a fila, recorriendo las columnas de cada fila
        /// (forma clasica), mira que casillas estan totalmente restringidas
        // a un solo valor. Establece el unico valor posible para este tipo 
        // de casillas.
        int rellenadas = 0;
        for (int i = 0; i < 16; ++i) {
            // Como es un metodo que se va a llamar mucho desde mi algoritmo
            // Guardo la referencia de cada una de las filas que voy a utilizar
            // para minizar el numero de accesos al heap
            final int[] valoresPermitidosFila = valoresPermitidosCasillas[i];
            for (int j = 0; j < 16; ++j) {
                // Como voy a utilizar los valores permitidos para la casilla mas 
                // de 1 vez, lo guardo en una variable
                final int valoresPermitidosCasilla = valoresPermitidosFila[j];
                if (getNumeroValoresPermitidosCasilla(valoresPermitidosCasilla) == 1) {
                    // Si la casilla solo admite un unico valor, establezco ese valor en la casilla
                    setValorEnCasilla(tablero, i, j, getMayorValorPermitidoCasilla(valoresPermitidosCasilla), valoresPermitidosCasillas);
                    // A partir de ahora la cuento como ocupada
                    ++rellenadas;
                }
            }
        }
        return rellenadas;
    }

    /**
     * Rellena las celdas del tablero que, a pesar de tener mas de un valor
     * posible, solo admiten un unico valor en la fila, es decir, el valor solo
     * aparece dentro de la fila en dicha celda como valor posible.
     *
     * @param tablero Array bidimensional que representa un tablero del sudoku
     * hexadecimal.
     * @param valoresPermitidosCasillas Array bidimensional que codifica de
     * manera binaria los valores posibles para cada casilla del tablero.
     * @return Numero de casillas que ha conseguido rellenar en el tablero.
     */
    private static int rellenarCasillasConUnicoValorPosibleEnFila(final int[][] tablero,
            final int[][] valoresPermitidosCasillas) {
        int rellenadas = 0;
        // Probar con todos los valores
        for (int valor = 15; valor > -1; --valor) {
            final int mascaraValor = mascaraBitsValoresPermitidos[valor];
            // Recorrer las filas
            for (int i = 0; i < 16; ++i) {
                final int[] valoresPermitidosFila = valoresPermitidosCasillas[i];
                int col = -1;
                int apariciones = 0;
                // Recorrer las columnas de la fila
                for (int j = 0; j < 16; ++j) {
                    // Si es posible establecer el valor en la casilla i, j
                    if ((valoresPermitidosFila[j] & mascaraValor) != 0) {
                        // Guardar la columna de la casilla
                        col = j;
                        // Contar las apariciones
                        // Si hay dos apariciones en la misma fila 
                        // pasar a la siguiente fila
                        if (++apariciones == 2) {
                            break;
                        }
                    }
                }
                // Si solo hay una aparicion del valor posible en la fila i
                // establecer ese valor en la casilla de la fila i y columna col 
                if (apariciones == 1) {
                    setValorEnCasilla(tablero, i, col, valor, valoresPermitidosCasillas);
                    // A partir de ahora la cuento como ocupada
                    ++rellenadas;
                }
            }
        }
        return rellenadas;
    }

    /**
     * Rellena las celdas del tablero que, a pesar de tener mas de un valor
     * posible, solo admiten un unico valor en la columna, es decir, el valor
     * solo aparece dentro de la columna en dicha celda como valor posible.
     *
     * @param tablero Array bidimensional que representa un tablero del sudoku
     * hexadecimal.
     * @param valoresPermitidosCasillas Array bidimensional que codifica de
     * manera binaria los valores posibles para cada casilla del tablero.
     * @return Numero de casillas que ha conseguido rellenar en el tablero.
     */
    private static int rellenarCasillasConUnicoValorPosibleEnColumna(final int[][] tablero,
            final int[][] valoresPermitidosCasillas) {
        int rellenadas = 0;
        // Probar con todos los valores
        for (int valor = 15; valor > -1; --valor) {
            final int mascaraValor = mascaraBitsValoresPermitidos[valor];
            // Recorrer las columnas
            for (int j = 0; j < 16; ++j) {
                int fil = -1;
                int apariciones = 0;
                // Recorrer las filas de la columna
                for (int i = 0; i < 16; ++i) {
                    // Si es posible establecer el valor en la casilla i, j
                    if ((valoresPermitidosCasillas[i][j] & mascaraValor) != 0) {
                        // Guardar la fila de la casilla
                        fil = i;
                        // Contar las apariciones
                        // Si hay dos apariciones en la misma columna
                        // pasar a la siguiente columna
                        if (++apariciones == 2) {
                            break;
                        }
                    }
                }
                // Si solo hay una aparicion del valor posible en la columna j
                // establecer ese valor en la casilla de la fila fil y columna j
                if (apariciones == 1) {
                    setValorEnCasilla(tablero, fil, j, valor, valoresPermitidosCasillas);
                    // A partir de ahora la cuento como ocupada
                    ++rellenadas;
                }
            }

        }
        return rellenadas;
    }

    /**
     * Rellena las celdas del tablero que, a pesar de tener mas de un valor
     * posible, solo admiten un unico valor en el bloque, es decir, el valor
     * solo aparece dentro del bloque en dicha celda como valor posible.
     *
     * @param tablero Array bidimensional que representa un tablero del sudoku
     * hexadecimal.
     * @param valoresPermitidosCasillas Array bidimensional que codifica de
     * manera binaria los valores posibles para cada casilla del tablero.
     * @return Numero de casillas que ha conseguido rellenar en el tablero.
     */
    private static int rellenarCeldasConUnicoValorPosibleEnBloque(final int[][] tablero,
            final int[][] valoresPermitidosCasillas) {
        int rellenadas = 0;
        // Probar con todos los valores
        for (int valor = 15; valor > -1; --valor) {
            final int mascaraValor = mascaraBitsValoresPermitidos[valor];
            // Recorrer los bloques 
            for (int iEsquinaBloque : coordEsquinaIzqBloques) {
                // Calcular limites de fila del bloque
                final int limiteI = iEsquinaBloque + 4;
                siguienteBloque:
                for (int jEsquinaBloque : coordEsquinaIzqBloques) {
                    // Calcular limites de columna del bloque
                    final int limiteJ = jEsquinaBloque + 4;
                    int apariciones = 0;
                    int fil = 0, col = 0;
                    // Recorrer las casillas de un bloque
                    for (int i = iEsquinaBloque; i < limiteI; ++i) {
                        final int[] valoresPermitidosFila = valoresPermitidosCasillas[i];
                        for (int j = jEsquinaBloque; j < limiteJ; ++j) {
                            // Si es posible establecer el valor en la casilla i, j del bloque
                            if ((valoresPermitidosFila[j] & mascaraValor) != 0) {
                                // Guardar la fila y columna de la casilla
                                fil = i;
                                col = j;
                                // Contar las apariciones
                                // Si hay dos apariciones en el mismo bloque
                                // pasar al siguiente bloque
                                if (++apariciones == 2) {
                                    continue siguienteBloque;
                                }
                            }
                        }
                    }
                    // Si solo hay una aparicion del valor posible en el bloque
                    // establecer ese valor en la casilla (fil, col)
                    if (apariciones == 1) {
                        setValorEnCasilla(tablero, fil, col, valor, valoresPermitidosCasillas);
                        // A partir de ahora la cuento como ocupada
                        ++rellenadas;
                    }
                }

            }
        }
        return rellenadas;
    }

    /**
     * Rellena la primera celda libre del tablero con el valor mas alto que
     * admite como posible.
     *
     * @param tablero Array bidimensional que representa un tablero del sudoku
     * hexadecimal.
     * @param valoresPermitidosCasillas Array bidimensional que codifica de
     * manera binaria los valores posibles para cada casilla del tablero.
     * @param casillasOcupadas Numero de casillas actualmente rellenadas en
     * tablero.
     */
    private static void rellenaPrimeraCeldaLibre(final int[][] tablero, final int[][] valoresPermitidosCasillas, final int casillasOcupadas) {
        // Encontrar la primera casilla libre
        for (int i = 0; i < 16; ++i) {
            final int[] valoresPermitidosFila = valoresPermitidosCasillas[i];
            final int[] casillasFila = tablero[i];
            for (int j = 0; j < 16; ++j) {
                // Si la casilla esta libre
                if (casillasFila[j] == -1) {
                    // Para la primera casilla encontrada probar todos los valores
                    for (int valor = 15; valor > -1; --valor) {
                        // Si es posible establecer el valor
                        if ((valoresPermitidosFila[j] & mascaraBitsValoresPermitidos[valor]) > 0) {
                            // Copiar el tablero
                            // Utilizo Array.copyOf porque es mas eficiente
                            // que hacerlo reservando memoria y copiando
                            // con un bucle
                            final int[][] nuevoTablero = new int[][]{
                                Arrays.copyOf(tablero[0], 16),
                                Arrays.copyOf(tablero[1], 16),
                                Arrays.copyOf(tablero[2], 16),
                                Arrays.copyOf(tablero[3], 16),
                                Arrays.copyOf(tablero[4], 16),
                                Arrays.copyOf(tablero[5], 16),
                                Arrays.copyOf(tablero[6], 16),
                                Arrays.copyOf(tablero[7], 16),
                                Arrays.copyOf(tablero[8], 16),
                                Arrays.copyOf(tablero[9], 16),
                                Arrays.copyOf(tablero[10], 16),
                                Arrays.copyOf(tablero[11], 16),
                                Arrays.copyOf(tablero[12], 16),
                                Arrays.copyOf(tablero[13], 16),
                                Arrays.copyOf(tablero[14], 16),
                                Arrays.copyOf(tablero[15], 16)
                            };
                            // Copiar las restricciones de las casillas
                            // Utilizo Array.copyOf porque es mas eficiente
                            // que hacerlo reservando memoria y copiando 
                            // con un bucle
                            final int[][] nuevosValoresPermitidosCasillas = new int[][]{
                                Arrays.copyOf(valoresPermitidosCasillas[0], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[1], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[2], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[3], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[4], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[5], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[6], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[7], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[8], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[9], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[10], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[11], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[12], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[13], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[14], 16),
                                Arrays.copyOf(valoresPermitidosCasillas[15], 16)
                            };

                            // //copiar la frecuencia de aparicion de filas 
                            // // y columnas
                            //final int[] nuevofrecuenciaAparicionesFilasYColumnas = Arrays.copyOf(frecuenciaAparicionesFilasYColumnas, 34);

                            // Establecer el primer valor que se aparece como
                            // posible (fuerza bruta) en el nuevo tablero
                            setValorEnCasilla(nuevoTablero, i, j, valor, nuevosValoresPermitidosCasillas);

                            // Llamar a resolverSudoku para que aplique 
                            // las tecnicas de resolucion de sudokus sobre 
                            // el nuevo tablero
                            final int colocadas = resolverSudoku(nuevoTablero, nuevosValoresPermitidosCasillas, casillasOcupadas + 1);


                            // CASO BASE
                            // El tablero resultante esta lleno
                            // guardarlo en tablero original y finalizar
                            if (colocadas == 256) {
                                // Todas las fichas estan colocadas entonces
                                // copio la soclucion en el tablero original
                                System.arraycopy(nuevoTablero[0], 0, tableroOriginal[0], 0, 16);
                                System.arraycopy(nuevoTablero[1], 0, tableroOriginal[1], 0, 16);
                                System.arraycopy(nuevoTablero[2], 0, tableroOriginal[2], 0, 16);
                                System.arraycopy(nuevoTablero[3], 0, tableroOriginal[3], 0, 16);
                                System.arraycopy(nuevoTablero[4], 0, tableroOriginal[4], 0, 16);
                                System.arraycopy(nuevoTablero[5], 0, tableroOriginal[5], 0, 16);
                                System.arraycopy(nuevoTablero[6], 0, tableroOriginal[6], 0, 16);
                                System.arraycopy(nuevoTablero[7], 0, tableroOriginal[7], 0, 16);
                                System.arraycopy(nuevoTablero[8], 0, tableroOriginal[8], 0, 16);
                                System.arraycopy(nuevoTablero[9], 0, tableroOriginal[9], 0, 16);
                                System.arraycopy(nuevoTablero[10], 0, tableroOriginal[10], 0, 16);
                                System.arraycopy(nuevoTablero[11], 0, tableroOriginal[11], 0, 16);
                                System.arraycopy(nuevoTablero[12], 0, tableroOriginal[12], 0, 16);
                                System.arraycopy(nuevoTablero[13], 0, tableroOriginal[13], 0, 16);
                                System.arraycopy(nuevoTablero[14], 0, tableroOriginal[14], 0, 16);
                                System.arraycopy(nuevoTablero[15], 0, tableroOriginal[15], 0, 16);
                                return;
                            }
                        }
                    }
                    // Como este metodo busca la primera celda libre y la rellena
                    // No tiene sentido continuar con el bucle tras haber encontrado
                    // una vacia
                    
                    // Parar cuando acaba el bucle de valores posibles para una
                    // casilla
                    return;
                }
            }
        }
    }

//    private static int rellenarCasillasFilaMasFrecuente(final int[][] tablero, final int[][] valoresPermitidosCasillas, final int[] frecuenciaAparicionesFilasYColumnas) {
//        int rellenadas = 0;
//        final int numApariciones = frecuenciaAparicionesFilasYColumnas[frecuenciaAparicionesFilasYColumnas[32]];
//
//        if (numApariciones > 8 && numApariciones < 16) {
//            final int numFilaMasFrecuente = frecuenciaAparicionesFilasYColumnas[32];
//            // Si la fila no esta rellenada
//            final int[] filaMasFrecuente = tablero[numFilaMasFrecuente];
//            final int[] valoresPermitidosFila = valoresPermitidosCasillas[numFilaMasFrecuente];
//            for (int j = 0; j < 16; ++j) {
//                if (filaMasFrecuente[j] == -1) {
//                    final int valoresPermitidosCasilla = valoresPermitidosFila[j];
//                    if (getNumeroValoresPermitidosCasilla(valoresPermitidosCasilla) == 1) {
//                        // Si la casilla solo admite un unico valor, establezco ese valor en la casilla
//                        setValorEnCasilla(tablero, numFilaMasFrecuente, j, getMayorValorPermitidoCasilla(valoresPermitidosCasilla), valoresPermitidosCasillas);
//                        // A partir de ahora la cuento como ocupada
//                        ++rellenadas;
//                    }
//                }
//            }
//        }
//        return rellenadas;
//    }
//
//    private static int rellenarCasillasColumnaMasFrecuente(final int[][] tablero, final int[][] valoresPermitidosCasillas, final int[] frecuenciaAparicionesFilasYColumnas) {
//        int rellenadas = 0;
//        final int numApariciones = frecuenciaAparicionesFilasYColumnas[16 + frecuenciaAparicionesFilasYColumnas[33]];
//        if (numApariciones > 8 && numApariciones < 16) {
//            final int numColumnaMasFrecuente = frecuenciaAparicionesFilasYColumnas[33];
//            // Si la fila no esta rellenada
//            for (int i = 0; i < 16; ++i) {
//                if (tablero[i][numColumnaMasFrecuente] == -1) {
//                    final int valoresPermitidosCasilla = valoresPermitidosCasillas[i][numColumnaMasFrecuente];
//                    if (getNumeroValoresPermitidosCasilla(valoresPermitidosCasilla) == 1) {
//                        // Si la casilla solo admite un unico valor, establezco ese valor en la casilla
//                        setValorEnCasilla(tablero, i, numColumnaMasFrecuente, getMayorValorPermitidoCasilla(valoresPermitidosCasilla), valoresPermitidosCasillas);
//                        // A partir de ahora la cuento como ocupada
//                        ++rellenadas;
//                    }
//                }
//            }
//        }
//
//        return rellenadas;
//
//    }
//
//    private static int rellenarCasillasRegionMasFrecuente(final int[][] tablero, final int[][] valoresPermitidosCasillas, final int[] frecuenciaAparicionesFilasYColumnas) {
//        int rellenadas = 0;
//
//        final int fil = frecuenciaAparicionesFilasYColumnas[32] - (frecuenciaAparicionesFilasYColumnas[32] & 3);
//        final int col = frecuenciaAparicionesFilasYColumnas[33] - (frecuenciaAparicionesFilasYColumnas[33] & 3);
//
//        for (int i = fil; i < (fil + 4); ++i) {
//            // Como es un metodo que se va a llamar mucho desde mi algoritmo
//            // Guardo la referencia de cada una de las filas que voy a utilizar
//            // para minizar el numero de accesos al heap
//            final int[] valoresPermitidosFila = valoresPermitidosCasillas[i];
//            for (int j = col; j < (col + 4); ++j) {
//                // Como voy a utilizar los valores permitidos para la casilla mas 
//                // de 1 vez, lo guardo en una variable
//                final int valoresPermitidosCasilla = valoresPermitidosFila[j];
//                if (getNumeroValoresPermitidosCasilla(valoresPermitidosCasilla) == 1) {
//                    // Si la casilla solo admite un unico valor, establezco ese valor en la casilla
//                    setValorEnCasilla(tablero, i, j, getMayorValorPermitidoCasilla(valoresPermitidosCasilla), valoresPermitidosCasillas);
//                    // A partir de ahora la cuento como ocupada
//                    ++rellenadas;
//                }
//            }
//        }
//
//        return rellenadas;
//
//    }
//    
//    
    /**
     * Metodo para resoler un sudoku hexadecimal.
     *
     * @param tablero Array bidimensional que representa un tablero del sudoku
     * hexadecimal.
     * @param valoresPermitidosCasillas Array bidimensional que codifica de
     * manera binaria los valores posibles para cada casilla del tablero.
     * @param casillasOcupadas Casillas actualmente rellenadas en tablero.
     * @return Numero de casillas rellenadas en tablero.
     */
    private static int resolverSudoku(final int[][] tablero, final int[][] valoresPermitidosCasillas, int casillasOcupadas) {
//       // Mientras la configuracion del sudoku lo permita
//       // relleno las casillas que solo admiten un valor pero que son
//       // mas frecuentes
//
//         while (casillasOcupadas > 220 && cambios > 1) {
//              cambios = rellenarCasillasFilaMasFrecuente(tablero, valoresPermitidosCasillas, frecuenciaAparicionesFilasYColumnas);
//
//              if (cambios > 1) {
//                  cambios += rellenarCasillasRegionMasFrecuente(tablero, valoresPermitidosCasillas, frecuenciaAparicionesFilasYColumnas);
//                  cambios += rellenarCasillasColumnaMasFrecuente(tablero, valoresPermitidosCasillas, frecuenciaAparicionesFilasYColumnas);
//              }
//            casillasOcupadas += cambios;
//         }
//       
        int cambios = 1;
        while (cambios > 0) {
            // Mientras la configuracion del sudoku lo permita y HAYA cambios
            // relleno las casillas que solo admiten un valor

            // En la fila
            cambios = rellenarCasillasConUnicoValorPosibleEnFila(tablero, valoresPermitidosCasillas);
            // En la columna
            cambios += rellenarCasillasConUnicoValorPosibleEnColumna(tablero, valoresPermitidosCasillas);
            // En la celda
            cambios += rellenarCasillasConUnicoValorPosible(tablero, valoresPermitidosCasillas);

            // Si lo anterior no ha sido suficientemente satisfactorio pruebo 
            // una tecnica mas costosa: rellenar las casillas
            // con el unico valor posible en el bloque
            if (cambios < 5) {
                cambios += rellenarCeldasConUnicoValorPosibleEnBloque(tablero, valoresPermitidosCasillas);
            }
            // Sumar cambios a casillasOcupadas
            casillasOcupadas += cambios;
        }

        // Las tecnicas no han podido rellenar mas el sudoku.
        // Comprobar si esta completamente relleno
        if (casillasOcupadas < 256) {
            // No se ha podido rellenar completamente el tablero siguiendo
            // las tecnicas, pruebo a rellenar con fuerza bruta la primera
            // celda libre que encuentre
            rellenaPrimeraCeldaLibre(tablero, valoresPermitidosCasillas, casillasOcupadas);
        }
        return casillasOcupadas;
    }

    /**
     * Constructor de la clase sudokuHex
     *
     * @param template Cadena representando una plantilla de sudoku hexadecimal.
     */
    public SudokuHex(String template) {
        final int tama = template.length();
        // Recorrer el String
        for (int i = 0, fil = 0, col = 0; i < tama; ++i) {
            if (col == 16) {
                // Si col es 16
                // Incrementar fila
                ++fil;
                // Columna a 0
                col ^= col;
            }
            // Convertir caracter a numero y guardarlo en tableroOriginal
            char c = template.charAt(i);
            switch (c) {
                case '.':
                    tableroOriginal[fil][col++] = -1;
                    break;
                case '-':
                   tableroOriginal[fil][col++] = -1;
                    break;
                case '0':
                   tableroOriginal[fil][col++] = 0;
                    break;
                case '1':
                   tableroOriginal[fil][col++] = 1;
                    break;
                case '2':
                   tableroOriginal[fil][col++] = 2;
                    break;
                case '3':
                   tableroOriginal[fil][col++] = 3;
                    break;
                case '4':
                   tableroOriginal[fil][col++] = 4;
                    break;
                case '5':
                   tableroOriginal[fil][col++] = 5;
                    break;
                case '6':
                   tableroOriginal[fil][col++] = 6;
                    break;
                case '7':
                   tableroOriginal[fil][col++] = 7;
                    break;
                case '8':
                   tableroOriginal[fil][col++] = 8;
                    break;
                case '9':
                   tableroOriginal[fil][col++] = 9;
                    break;
                case 'A':
                   tableroOriginal[fil][col++] = 10;
                    break;
                case 'a':
                   tableroOriginal[fil][col++] = 10;
                    break;
                case 'B':
                   tableroOriginal[fil][col++] = 11;
                    break;
                case 'b':
                   tableroOriginal[fil][col++] = 11;
                    break;
                case 'C':
                   tableroOriginal[fil][col++] = 12;
                    break;
                case 'c':
                   tableroOriginal[fil][col++] = 12;
                    break;
                case 'D':
                   tableroOriginal[fil][col++] = 13;
                    break;
                case 'd':
                   tableroOriginal[fil][col++] = 13;
                    break;
                case 'E':
                   tableroOriginal[fil][col++] = 14;
                    break;
                case 'e':
                   tableroOriginal[fil][col++] = 14;
                    break;
                case 'F':
                   tableroOriginal[fil][col++] = 15;
                    break;
                case 'f':
                   tableroOriginal[fil][col++] = 15;
                    break;
                default:
                    // Si el caracter no esta dentro del dominio
                    // pasar de el
                    break;
            }
        }
    }

    /**
     * Metodo para resolver el sudoku hexadecimal.
     */
    public void solve() {
        // A partir del tablero original va a computar los valores de 
        // las restricciones de cada casilla del tablero
        final int[][] valoresPermitidosCasillas = new int[][]{
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},};
        //final int[] frecuenciaAparicionesFilasYColumnas = new int[34];
        int casillasOcupadas = 0;
        int mascaraTodosValoresPermitidos = 0;

        // A partir de la mascara de bits de valores permitidos calculo
        // la mascara que indica que todos los valores estan permitidos
        // para una casilla
        //
        // Equivalente a:
        // for (int i = 1; i < 16; i += 2) {
        //    mascaraTodosValoresPermitidos += mascaraBitsValoresPermitidos[i - 1] + mascaraBitsValoresPermitidos[i];
        // }


        mascaraTodosValoresPermitidos += mascaraBitsValoresPermitidos[0] + mascaraBitsValoresPermitidos[1];
        mascaraTodosValoresPermitidos += mascaraBitsValoresPermitidos[2] + mascaraBitsValoresPermitidos[3];
        mascaraTodosValoresPermitidos += mascaraBitsValoresPermitidos[4] + mascaraBitsValoresPermitidos[5];
        mascaraTodosValoresPermitidos += mascaraBitsValoresPermitidos[6] + mascaraBitsValoresPermitidos[7];
        mascaraTodosValoresPermitidos += mascaraBitsValoresPermitidos[8] + mascaraBitsValoresPermitidos[9];
        mascaraTodosValoresPermitidos += mascaraBitsValoresPermitidos[10] + mascaraBitsValoresPermitidos[11];
        mascaraTodosValoresPermitidos += mascaraBitsValoresPermitidos[12] + mascaraBitsValoresPermitidos[13];
        mascaraTodosValoresPermitidos += mascaraBitsValoresPermitidos[14] + mascaraBitsValoresPermitidos[15];

        // Inicialmente en todas las casillas se permiten todos los valores
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                valoresPermitidosCasillas[i][j] ^= mascaraTodosValoresPermitidos;
            }
        }

        // Recorrer el tablero original para computar las restricciones
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                final int valorCasilla = tableroOriginal[i][j];
                if (valorCasilla > -1) {
                    // La casilla esta ocupada
                    // No hay ningun valor permitido para esa casilla
                    // (A parte del que tiene)
                    valoresPermitidosCasillas[i][j] = 0;
                    // Sabiendo que esa casilla tiene un valor fijo
                    // Actualizo las restricciones del tablero
                    actualizarRestriccionesTablero(tableroOriginal, i, j, valoresPermitidosCasillas);
                    // Actualizo contador casilla ocupadas
                    ++casillasOcupadas;
                    /* 
                     ++frecuenciaAparicionesFilasYColumnas[i];
                     ++frecuenciaAparicionesFilasYColumnas[16 + j];
                     */
                }
            }
        }
//      // Calcular frecuencias filas y columnas
        // Calcular fila y columna mas frecuentes
//
//        for (int i = 0, maxAparicionesFila = 0, maxAparicionesColumna = 0; i < 16; ++i) {
//            final int numAparicionesDeFilaAct = frecuenciaAparicionesFilasYColumnas[i];
//            final int numAparicionesDeColumnaAct = frecuenciaAparicionesFilasYColumnas[16 + i];
//
//            if (numAparicionesDeFilaAct > maxAparicionesFila) {
//                frecuenciaAparicionesFilasYColumnas[32] = i; // Valor mas frecuente columnas en pos 32
//                maxAparicionesFila = numAparicionesDeFilaAct;
//            }
//            if (numAparicionesDeColumnaAct > maxAparicionesColumna) {
//                frecuenciaAparicionesFilasYColumnas[33] = i; // Valor mas frecuente columnas en pos 33
//                maxAparicionesColumna = numAparicionesDeColumnaAct;
//            }
//        }

        // Mi metodo para resolver sudokus como las balas
        resolverSudoku(tableroOriginal, valoresPermitidosCasillas, casillasOcupadas);
    }

    /**
     * Representacion del sudoku como una cadena de caracteres.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        // uso un StringBuilder porque es mas eficiente para la concatenacion
        final StringBuilder res = new StringBuilder();
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                // Como voy a utilizar el valor de la casilla mas de 1 vez
                // lo guardo en una variable
                final int valor = tableroOriginal[i][j];
                if (valor > -1) {
                    // Si la casilla esta ocupada
                    // traducir de entero a char
                    res.append(digitos_hex[valor]);
                } else {
                    // La casilla no esta ocupada
                    // El caracter . indica casilla vacia
                    res.append('.');
                }
            }
        }
        return res.toString();
    }
}

package src;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Programa para testear y medir tiempos en el Algoritmo resolucion de sudokus
 * hexadecimales
 *
 * @author Cesar Aguilera, @cs4r on twitter
 * @date 26/10/2012
 */
public class Test {

    public static final String SUDOKU_POR_DEFECTO = "a0....3.fd...c.....d459.b.c..2f.be.cd.280...1.7.5..2.e0..834..b."
            + "....2.83...f.061......1.e3..4f..78..6df4.....e..4.d..c..1.26.b87"
            + "ca7.f3.d..0..5.4..f.....649a..0b..04..b7.5......dbe.a...27.3...."
            + ".c..e4d..f6.b..a.d.b...27e.10.cf.7a..1.b.0dc8.....5...7f.2....ed";

    public static void main(String args[]) throws FileNotFoundException, IOException {
        List<String> plantillas = new ArrayList<String>();
        List<String> resultados = new ArrayList<String>();
        SudokuHex sudoku;

        long inicio, fin, tiempo, tiempoTotal = 0, tiempos[];
        int numSudokus = 0, numeroValidos = 0;

        // Argumentos de entrada

        if (args.length == 0) {
            System.err.println("Por favor, indique un fichero .txt de sudokus como argumento de este programa.");
            System.err.println("Asumiendo sudoku por defecto...");
            plantillas.add(SUDOKU_POR_DEFECTO);
            numSudokus = 1;
        } else {

            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);

            String aux = new String();

            while (br.ready()) {
                aux += br.readLine();
                if (aux.length() == 256) {
                    plantillas.add(aux);
                    aux = new String();
                    ++numSudokus;
                }
            }

            br.close();
            fr.close();
        }
        tiempos = new long[numSudokus];

        System.out.println("Total sudokus a resolver: " + numSudokus);
        for (int n = 0; n < numSudokus; ++n) {
            // Resolucion del sudoku
            inicio = new Date().getTime();
            sudoku = new SudokuHex(plantillas.get(n));
            sudoku.solve();
            fin = (new Date()).getTime();
            tiempo = fin - inicio;
            tiempoTotal += tiempo;
            tiempos[n] = tiempo;

            String sdk = sudoku.toString();
            // Resultado
            System.out.println("Solucion:");
            System.out.println(sdk);
            System.out.println("Tiempo: " + tiempo + " milisegundos.");
            resultados.add(sdk);
            /*
             System.out.println("Formato bonito:");

             int fil = 0, col = 0;
             for (int i = 0; i < sdk.length(); ++i) {
             if (col == 0 && (fil == 0 || fil == 4 || fil == 8 || fil == 12)) {
             System.out.println(" ");
             }
             if (col == 4 || col == 8 || col == 12) {
             System.out.print(" ");
             }
             System.out.print(sdk.charAt(i));
             ++col;
             if (col == 16) {
             System.out.println();
             ++fil;
             col = 0;
             }
             }
             */

        }
        //FileWriter fw = new FileWriter(args[0] + "SOLUCIONES");
        //BufferedWriter bw = new BufferedWriter(fw);

        // Para cada uno de los resultados obtenidos

        numSudokus = resultados.size();

        for (int r = 0; r < numSudokus; ++r) {
            // Guardar resultado en fichero, acaba en un salto de linea
            String solucion = resultados.get(r);
            //bw.write(solucion);
            //bw.write("\n");


            // Transformar cadena a matriz
            char[][] tablero = new char[16][16];
            int fil = 0, col = 0;
            for (int i = 0; i < solucion.length(); ++i) {
                tablero[fil][col++] = solucion.charAt(i);
                if (col == 16) {
                    col = 0;
                    ++fil;
                }
            }

            // Comprobar si cada una de las soluciones es valida
            boolean correcto = true;
            comprobador:
            {
                // Para cada casilla
                for (int x = 0; x < 16; ++x) {
                    for (int y = 0; y < 16; ++y) {

                        // Comprueba fila
                        for (int c = y + 1; c < 16; ++c) {
                            if (tablero[x][y] == tablero[x][c] || tablero[x][c] == '.') {
                                correcto = false;
                                break comprobador;
                            }

                        }

                        // Comprueba columna
                        for (int f = x + 1; f < 16; ++f) {
                            if (tablero[x][y] == tablero[f][y] || tablero[f][y] == '.') {
                                correcto = false;
                                break comprobador;
                            }
                        }

                        // Comprobar bloque
                        if (x % 4 == 0 && y % 4 == 0) {
                            for (int a = x; a < 4; ++a) {
                                for (int b = y; b < 4; ++b) {
                                    {
                                        if (tablero[x][y] == tablero[a][b] && a != x && b != y) {
                                            correcto = false;
                                            break comprobador;
                                        }
                                    }
                                }
                            }
                        }


                    }
                }
            }


            if (correcto == false) {
                System.out.println(r + ": NO cumple las restricciones");
            } else {
                System.out.println(r + ": CUMPLE las restricciones");
                ++numeroValidos;
            }


            //bw.close();
            //fw.close();
        }

        Arrays.sort(tiempos);

        long mediana = (numSudokus % 2 == 0) ? tiempos[numSudokus / 2 - 1] : tiempos[numSudokus / 2];
        System.out.println("Tiempo total: " + tiempoTotal + " milisegundos " + "(" + tiempoTotal / 1000. + " segundos)");
        System.out.println("Mejor Tiempo: " + tiempos[0] + " milisegundos");
        System.out.println("Peor Tiempo: " + tiempos[numSudokus - 1] + " milisegundos");
        System.out.printf("Tiempo medio: %.2f milisegundos\n", (double) tiempoTotal / numSudokus);
        System.out.println("Mediana: " + mediana + " milisegundos");
        System.out.println("Moda: " + Test.moda(tiempos) + " milisegundos");
        System.out.println("Resueltos correctamente: " + numeroValidos + "/" + numSudokus);


        resultados.clear();
    }

    static public long moda(long[] x) {
        Map<Long, Integer> collection = new HashMap<Long, Integer>();
        long moda = 0;
        long valor = 0, repeticiones = 0;
        for (long i : x) {
            if (collection.containsKey(i)) {
                collection.put(i, collection.get(i) + 1);
            } else {
                collection.put(i, 1);
            }
        }
        Set<Long> keys = collection.keySet();
        Iterator<Long> it = keys.iterator();
        while (it.hasNext()) {
            repeticiones = it.next();
            if (collection.get(repeticiones) > valor) {
                valor = collection.get(repeticiones);
                moda = repeticiones;
            }
        }
        return moda;
    }
}

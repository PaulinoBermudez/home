/**
 * @(#)LecturaEscrituraFichero.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/15
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.PrintWriter;

public class LecturaEscrituraFichero {
	
	public static void main(String[] args) throws IOException {
		
		int[][] numeros = { { 1, 2, 3, 4, 5},
							{ 6, 7, 8, 9, 10},
							{11, 12, 13, 14, 15},
							{16, 17, 18, 19, 20},
							{21, 22, 23, 24, 25}};
							
		String idFichero = "c:\\Java/Numeros.txt";
		PrintWriter ficheroSalida = new PrintWriter(idFichero);
		for (int i=0; i<numeros.length; i++) {
			for (int j=0; j<numeros[i].length; j++)
				ficheroSalida.print(numeros[i][j] + ",");
				ficheroSalida.println("");
		}
		
		ficheroSalida.close();
		
		File ficheroEntrada = new File (idFichero);
		if (ficheroEntrada.exists()) {
			Scanner datosFichero = new Scanner(ficheroEntrada);
			System.out.println("Números del fichero");
			while (datosFichero.hasNext()) {
				StringTokenizer numerosFichero = new StringTokenizer(datosFichero.next(),",");
				while (numerosFichero.hasMoreTokens())
					System.out.print(numerosFichero.nextToken() + "\t");
					System.out.println("");
			}
			datosFichero.close();
		}
		else
			System.out.println("¡El fichero no existe!");
	}
}
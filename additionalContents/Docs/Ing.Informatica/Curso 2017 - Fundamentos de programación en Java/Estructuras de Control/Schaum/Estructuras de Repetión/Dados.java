/**
 * Escriba un programa que permita determinar la probabilidad
 * con que aparece cada uno de los valores al lanzar un dado.
 * Para ello se lanzará el dado 1.000.000 de veces y se
 * imprimirá porpantalla cuantas veces ha aparecido cada número
 * y el porcentaje que representa respecto al total.
 */


public class Dados {
	public static void main(String[] args){
		double valorAleatorio;
		int valorDado;
		int numTiradas = 1000000;
		int[] tiradas = new int[6];
		
		// se lanza el dado 1.000.000 veces
		for(int i=0; i < numTiradas; i++){
			//Para que el número generado esté entre 1y6, como un dado.
			valorAleatorio = Math.random()*6;
			valorDado = (int)(valorAleatorio + 1);
			tiradas[valorDado-1]++;
		}
			//Sse imphme cuántas veces ha aparecjdo cada número y su porcentaje
			for(int i = 0; i < tiradas.length; i++){
				System.out.printf("El valor %d aparece %d lo que representa un %.2f%%.\n",i + 1, tiradas[i], (tiradas[i] / (double)numTiradas) * 100);
			}
		}
	}
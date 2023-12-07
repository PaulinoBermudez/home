/**
 *  Try / Chatch / Finally
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2014/4/16
 */

import java.io.*;
public class PedirNumero2 {

    public static void main (String[] args) {
    	int numero = -1;
    	int intentos = 0;
    	String linea;
    	
    	BufferedReader teclado = new BufferedReader (new InputStreamReader(System.in));
    	
    	do {
    		try{
    			System.out.print("Introduzca número entre 0 y 100: ");
    			linea = teclado.readLine();
    			numero = Integer.parseInt(linea);
    		}catch(IOException e){
    		System.out.print("Introduzca número entre 0 y 100: ");	
    		}finally{
    			intentos++;
    		}
    	}while(numero < 0 || numero >100);
    	System.out.print("El número introducido es: " + numero);
    	System.out.print(", Número de intentos: "+ intentos);
} 
}
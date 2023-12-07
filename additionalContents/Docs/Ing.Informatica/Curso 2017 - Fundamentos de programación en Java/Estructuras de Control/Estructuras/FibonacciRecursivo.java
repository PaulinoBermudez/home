/*
 * Programa que calcula la sucesión de Fibonacci.
 * Se utiliza se utiliza un algoritmo Recursivo.
 * Si utilizamos directamente la definición obtendremos
 * un algoritmo con un coste exponencial.
 * El principal problema es que calcularía varias veces los mismos valores,
 * para evitar esto existe otra opción dada por el algoritmo iterativo,
 * que requiere de un tiempo de orden n.
 */

import java.io.*;

public class FibonacciRecursivo {
    public static long fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) throws  IOException {
    		
    	System.out.print("numero:  ");
		BufferedReader b=new BufferedReader (new InputStreamReader (System.in));
		String numero2 =b.readLine ();
		int N=Integer.parseInt (numero2);
		
    	double timeInicial = System.currentTimeMillis();
        //int N = Integer.parseInt(args[0]);
        for (int i = 1; i <= N; i++){
        	
        	System.out.print(i + ": " + fib(i));
            
       //System.out.println();
       double timeFinal = System.currentTimeMillis();
	   System.out.println ("\tTiempo: "+ (timeFinal-timeInicial)/1000 + "  s.");	
	     
        }      
    }
}

/*
 * Programa que calcula la sucesión de Fibonacci.
 * Se utiliza se utiliza un algoritmo iterativo.
 * El algoritmo iterativo requiere de un tiempo de orden n.
 */

import java.io.*;

public class FibonacciIterativo{

   public static void main(String[] args) throws  IOException{
   	
   	System.out.print("numero:  ");
		BufferedReader b=new BufferedReader (new InputStreamReader (System.in));
		String numero2 =b.readLine ();
		int N=Integer.parseInt (numero2);
		int f = 0, g = 1;
		
		double timeInicial = System.currentTimeMillis();
		for (int i = 1; i <= N; i++) {
			f = f + g;
			g = f - g;
			
			System.out.print(f);
			double timeFinal = System.currentTimeMillis();
			System.out.println ("\tTiempo: "+ (timeFinal-timeInicial)/1000 + "  s."); 
      }
   }
}

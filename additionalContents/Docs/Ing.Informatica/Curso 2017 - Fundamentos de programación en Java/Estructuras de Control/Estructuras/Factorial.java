/*
 * Programa para calcular el factorial de un número.
 *
 */

import java.io.*;

class Factorial {
	
	static int factorial(int n){
		if (n>1)
		return factorial(n-1)*n; //caso recursivo
		else
		return 1; // caso base
		
	}
	
	public static void main(String[] args) throws IOException{
        BufferedReader a=new BufferedReader (new InputStreamReader (System.in));
		System.out.print("introducir primer numero  :  ");
		String numero1 =a.readLine ();
		int n=Integer.parseInt (numero1);
		
		
		int z;
		z= factorial(n);
		System.out.println();
		System.out.print("Resultado: "+z);
		System.out.println();
		System.out.println();

}
}
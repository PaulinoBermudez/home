/*
 * Programa para calcular el Máximo Común Divisor de dos números
 *
 */

import java.io.*;

class mcd{
	static int mcd(int m, int n){
		//m es mayor o igual que n
		if (m%n==0)
		System.out.println(n);
		//caso base
		else{
		return mcd (n, (m%n));
		}
		//caso recursivo
		return n;
	}
	
	public static void main(String[] args) throws IOException{
		
        BufferedReader a=new BufferedReader (new InputStreamReader (System.in));
		System.out.print("Introducir primer numero  :  ");
		String numero1 =a.readLine ();
		int m=Integer.parseInt (numero1);
		
		BufferedReader b=new BufferedReader (new InputStreamReader (System.in));
		System.out.print("Introducir segundo numero  :  ");
		String numero2 =b.readLine ();
		int n=Integer.parseInt (numero2);
		
		System.out.print("El m.c.d. de "+m+" y "+n+" es:  ");
		int z;
		z= mcd(m, n);
	}
}
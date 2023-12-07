/**
 * @(#)EnumeradorPila.java
 *
 * Iterador Enumeration.
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/20
 */


import java.util.Enumeration;
import java.util.Stack;

public class EnumeradorPila{
	
	
	public static void main(String[] args){
		
		final int N = 8;
		Stack pila = new Stack();
		
		String [] palabra = {"Urbion", "Magina", "Abantos", "Peralte", "Citores" };
		
		for (int i = 0; i < N; i++){
			int n;
			n = (int)(Math.random()*N*2);
			if (n < palabra.length)
				pila.push(palabra[n]);
				else if (n < N+2)
					pila.push(new Double(Math.pow(n, 2)));
					else
						pila.push(new Integer(n * 3));
		}
		
		
		// crea un enumerador de la pila
		Enumeration enumera = pila.elements();
		
		// bucle para recorrer la pila
		System.out.println("Elementos de la pila " +
		"en el orden establecido por el enumerador:");
		
		while (enumera.hasMoreElements()){
			Object q;
			q = enumera.nextElement();
			System.out.print(q + " ");
		}
		
		// bucle para recorrer la pila
		System.out.println("\nElementos de la pila en orden LIFO: ");
		while (!pila.empty()){
			Object q;
			q = pila.pop();
			System.out.print(q + " ");
		}
	}
}
/**
 * @(#)TreeSetDemo.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/23
 */

import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetDemo {
	
	public static void main(String args[]) {
		
		// Creamos un TreeSet
		TreeSet ts = new TreeSet();
		
		// Agregamos elementos al TreeSet
		ts.add("C");
      	ts.add("A");
      	ts.add("B");
      	ts.add("E");
      	ts.add("F");
      	ts.add("D");
      	System.out.println(ts);
      	System.out.println("");
      	
      	System.out.println("Utilizamos un Iterator para imprimir los elementos");
        Iterator<String> itr = ts.iterator();
        while (itr.hasNext())
        	System.out.println(itr.next());
   }
}
/**
 * @(#)ListarConjunto.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/20
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ListarConjunto{
	
	public static void main(String[] args){
		
		Set<String> hs = new HashSet<String>();
		
        hs.add("Victor");
        hs.add("Amaya");
        hs.add("Amaya"); // Los elementos solo pueden estar una vez
        hs.add("Javier");
        
        Iterator<String> iter = hs.iterator();
        while (iter.hasNext())
        	System.out.println(iter.next());
    }
}

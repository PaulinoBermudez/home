/**
 * @(#)EjemploClone.java
 * Calling the clone() method of a HashSet creates a shallow copy of that HashSet.
 *
 * he elements of the set aren't duplicated.
 * Both sets will refer to the same elements.
 *
 * @author Antonio Rivero
 * @version 1.00 2015/8/24
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EjemploClone {
	
	public static void main(String[] a) {
		
		String elements[] = { "A", "B", "C", "D", "E" };
    	Set set = new HashSet(Arrays.asList(elements));

    	Set set2 = ((Set) ((HashSet) set).clone());

    	System.out.println(set2);
  	}
}
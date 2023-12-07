/**
 * @(#)HashSetEjemplo1.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/23
 */

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEjemplo1 {
    
    public static void main(String[] args) {
        
        HashSet<String>  conjunto = new HashSet<String>();
        
        conjunto.add("Curso");
        conjunto.add("Java");
        conjunto.add("UNED");
        
        System.out.println(conjunto);
        System.out.println("");
        
        System.out.println("Utilizamos un Iterator para imprimir los elementos");
        Iterator<String> itr = conjunto.iterator();
        while (itr.hasNext())
        	System.out.println(itr.next());
    }
}
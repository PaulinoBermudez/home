/**
 * @(#)TreeSetEjemplo.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/23
 */

import java.util.TreeSet;

public class TreeSetEjemplo {
    
    public static void main(String[] args) {
        
        TreeSet<String>  conjunto = new TreeSet<String>();
        
        conjunto.add("Curso");
        conjunto.add("Java");
        conjunto.add("UNED");
        
        System.out.println(conjunto);
    }
}
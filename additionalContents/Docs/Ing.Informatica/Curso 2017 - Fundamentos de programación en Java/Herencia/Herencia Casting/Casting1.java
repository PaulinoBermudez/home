/**
 * @(#)Casting1.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2016/1/4
 */

public class Casting1 {
 
    public static void main(String[] args) {
 
        int a = 1;
        double b = 2.5;
 
        b = a;
        
        // a = b; nos informara un error,
        // porque int no puede contener un double
 
        System.out.println(b);
    }
}
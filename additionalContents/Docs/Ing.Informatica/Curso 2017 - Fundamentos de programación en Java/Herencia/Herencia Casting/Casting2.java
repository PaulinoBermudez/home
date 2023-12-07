/**
 * @(#)Casting2.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2016/1/4
 */

public class Casting2 {
 
    public static void main(String[] args) {
 
        int a = 1;
        double b = 2.5;
        
        /*
         * Un casting se indica entre paréntesis
         * con el tipo de dato al que queremos pasar,
         * en este caso int.
         * La variable a, contendrá un 2 y no un 2.5.
         *
         */
         
        a = (int)b;
 
        System.out.println(a);
    }
}
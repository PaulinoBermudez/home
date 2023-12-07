/**
 * @(#)Casting3.java
 *
 * Si tenemos un int y hacemos un casting a char
 * éste se convertirá en un carácter asociado
 * de la tabla ASCII
 * 
 * @author Antonio Rivero
 * @version 1.00 2016/1/4
 */

public class Casting3 {
 
    public static void main(String[] args) {
 
        int codigo = 97;
 
        char codigoASCII = (char)codigo;
 
        System.out.println(codigoASCII);
    }
}
/**
 * @(#)Array4.java
 *
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/12/25
 */

public class Array4 {
 
    public static void main(String[] args) {
 
        //Definimos un array con 10 posiciones
        int numero[] = new int [10];
 
        //Recorremos el array
        //array.lenght indica la longitud del array, en este caso, devuelve 10
        for (int i=0, multiplo=5;i<numero.length;i++, multiplo+=5){
            numero[i]=multiplo;
            System.out.println(numero[i]);
        }
    }
}
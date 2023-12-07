/*
 * El factorial de un entero positivo n, el factorial de n o n.
 * Factorial se define en principio como el producto de todos 
 * los números enteros positivos desde 1,
 * (es decir, los números naturales) hasta n.
 *
 */

import java.util.Scanner;

public class Factorial3 {

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Introducir un número entero");
       int n = scanner.nextInt();
       int resultado = factorial(n);
       System.out.println("Factorial de " + n + " es " + resultado);
   }

   public static int factorial(int n) {
       int resultado = 1;
       for (int i = 1; i <= n; i++) {
           resultado = resultado * i;
       }
       return resultado;
   }
}
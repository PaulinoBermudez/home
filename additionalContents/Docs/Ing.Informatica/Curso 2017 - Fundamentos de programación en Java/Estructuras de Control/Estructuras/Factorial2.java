/*
 * El factorial de un entero positivo n, el factorial de n o n.
 * Factorial se define en principio como el producto de todos 
 * los números enteros positivos desde 1,
 * (es decir, los números naturales) hasta n.
 *
 */

import java.util.Scanner;
 
class Factorial2{
   public static void main(String args[]){
      int n, c, fact = 1;
 
      System.out.print("Introducir un número entero: ");
      Scanner in = new Scanner(System.in);
 
      n = in.nextInt();
 
      if ( n < 0 )
         System.out.println("El número no puede ser negativo.");
      else
      {
         for ( c = 1 ; c <= n ; c++ )
            fact = fact*c;
 
         System.out.println("Factorial de "+n+" es = "+fact);
      }
   }
}
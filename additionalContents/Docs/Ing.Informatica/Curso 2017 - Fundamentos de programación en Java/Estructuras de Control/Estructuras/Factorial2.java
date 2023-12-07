/*
 * El factorial de un entero positivo n, el factorial de n o n.
 * Factorial se define en principio como el producto de todos 
 * los n�meros enteros positivos desde 1,
 * (es decir, los n�meros naturales) hasta n.
 *
 */

import java.util.Scanner;
 
class Factorial2{
   public static void main(String args[]){
      int n, c, fact = 1;
 
      System.out.print("Introducir un n�mero entero: ");
      Scanner in = new Scanner(System.in);
 
      n = in.nextInt();
 
      if ( n < 0 )
         System.out.println("El n�mero no puede ser negativo.");
      else
      {
         for ( c = 1 ; c <= n ; c++ )
            fact = fact*c;
 
         System.out.println("Factorial de "+n+" es = "+fact);
      }
   }
}
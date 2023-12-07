/*
 * Escriba un método que escriba en la pantalla
 * el valor de la suma de los n primeros números pares.
 */

import java.util.*;
public class SumaPares{
   public static void main(String[] args) throws Exception{
      Scanner teclado=new Scanner(System.in);
      
      int numero, suma=0;
      System.out.print("Introduzca el numero n: ");
      numero=teclado.nextInt();
      
      for(int i=0; i<2*numero; i=i+2){
         suma=suma+i;
      }
      
      System.out.println("La suma de los primeros "+numero+ " numeros pares es: "+suma);
   }
}
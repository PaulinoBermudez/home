/*
 * Escribir un Programa, de nombre cambioMonedas,
 * que reciba como parametro un valor real que
 * indica una cantidad de dinero en euros.
 * El metodo imprime por pantalla la cantidad de
 * monedas de cada tipo en que se debe devolver
 * la cantidad de dinero indicada.
 */

import java.util.Scanner;

public class CambioMonedas{
	
   public static void main(String[] args){
      
   Scanner teclado = new Scanner(System.in);
   
   System.out.print("Introduzca el cambio a devolver en centimos de euro: ");
   
      int centimos = teclado.nextInt();
      
      System.out.println("Para devolver "+centimos+" debe dar: ");
      
      if(centimos>=200){
         System.out.println("Monedas de 2 euros: "+centimos/200);
         centimos%=200;
      }
      
      if(centimos>=100){
         System.out.println("Monedas de 1 euro: "+centimos/100);
         centimos%=100;
      }
      
      if(centimos>=50){
         System.out.println("Monedas de 50 centimos: "+centimos/50);
         centimos%=50;
      }
      
      if(centimos>=20){
         System.out.println("Monedas de 20 centimos: "+centimos/20);
         centimos%=20;
      }
      
      if(centimos>=10){
         System.out.println("Monedas de 10 centimos: "+centimos/10);
         centimos%=10;
      }
         
      if(centimos>=5){
         System.out.println("Monedas de 5 centimos: "+centimos/5);
         centimos%=5;
      }
         
      if(centimos>=2){
         System.out.println("Monedas de 2 centimos: "+centimos/2);
         centimos%=2;
      }
         
       if(centimos>=1){
         System.out.println("Monedas de 1 centimo: "+centimos/1);
         centimos=0;
      }                  
   }
}
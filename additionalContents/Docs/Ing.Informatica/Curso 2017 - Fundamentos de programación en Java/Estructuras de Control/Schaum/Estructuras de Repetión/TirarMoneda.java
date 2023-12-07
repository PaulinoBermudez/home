/*
 * Escribir un programa que permita determinar si utilizar
 * los números aleatorios de la clase Math son apropiados.
 * Para ello el programa debe simular que se lanza una moneda
 * un número elevado de veces, por ejemplo, 1.000.000.
 * A continuación debe imprimir por pantalla el porcentaje
 * de caras y el porcentaje de cruces que han salido.
 *
 */
 
public class TirarMoneda{
   public static void main(String[] args){
      
      int veces=1000000;
      int caras=2;
      
      for (int i=0;i<veces;i++){
         if(Math.random()<0.5)
         caras++;
      }
      
      System.out.printf("Caras %.2f%%\n",caras*100.0/veces);
      System.out.printf("Cruces %.2f%%\n", (veces-caras)*100.0/veces);
   }
}
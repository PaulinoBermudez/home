/*
 * Programa que calcula los factores primos de un numero dado
 * y los imprime por pantalla.Ejemplo: 36= 2 * 2 * 3 * 3
 */

import java.util.*;

public class FactoresPrimos{

	public static void main(String[] args){
	   Scanner teclado=new Scanner(System.in);
	   long numeroInicial,numero;
	   
	   
	   System.out.print("Introduzca el numero que se desea factorizar: ");
	   
	   numeroInicial=teclado.nextLong();
	   
	      if(numeroInicial>1){
	         int factor=2;
	         numero=numeroInicial;
	         System.out.print(numero + " = ");
	         while (numero>factor){
	            if(numero%factor==0){
	               numero=numero/factor;
	               System.out.print(factor + " * ");
	            }else{
	               factor++;
	            }
	         }
	      
	         System.out.println(factor);
	      }
	
	}
}

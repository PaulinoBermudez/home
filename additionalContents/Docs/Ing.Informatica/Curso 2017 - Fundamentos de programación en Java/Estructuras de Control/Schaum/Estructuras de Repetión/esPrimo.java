/**
 * Escriba un método, de nombre esPrimo,
 * que reciba un número entero por parámetro
 * y devuelva Un booleano que indique si se
 * trata de un número primo o no.
 */

import java.util.Scanner;  
public class esPrimo {  
     public static void main(String[] args) {  
         Scanner primo = new Scanner(System.in);  
         int a=0,i,n;  
         System.out.print("Ingrese numero: ");  
         n=primo.nextInt();  
         for(i=1;i<(n+1);i++){  
         if(n%i==0){  
             a++;  
            }  
         }  
         if(a!=2){  
              System.out.println("No es Primo");  
            }else{  
                System.out.println("Si es Primo");  
         }  
     }  
} 
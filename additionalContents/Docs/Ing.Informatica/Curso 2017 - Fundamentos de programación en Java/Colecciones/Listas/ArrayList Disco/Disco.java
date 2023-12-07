/**
 * @(#)Disco.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/17
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Disco{
	
    public static void main(String[] args){
    	
        //Creamos un arrayList de String
        ArrayList<String> lista = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        
        int n;
        System.out.print("Numero: ");
        n = sc.nextInt();
        
        for (int i=1; i<=n; i++){
        	
	        //Agregamos objetos
	        lista.add("Disco: " + i);
	        /*   
	        lista.add("Disco 2");
	        lista.add("Disco 3");
	        lista.add("Disco 4");
	        lista.add("Disco 5");
	        */
        }
     
        //Creamos un iterador
        Iterator<String> iterador = lista.iterator();
      
        //Usamos el método hasNext, para comprobar si hay algun Disco
        while(iterador.hasNext()){
            //El iterador devuelve el proximo Disco
            System.out.println(iterador.next());
        }
    }
}
/**
 * @(#)Numeros.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/17
 */
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Numeros {

    public static void main(String[] args){
    	
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        
        int num;
        do {
            System.out.println("Introduce numeros enteros. Pulsa 0 para acabar: ");
            System.out.print("Numero: ");
            num = sc.nextInt();
            if (num != 0)
                numeros.add(num);
        }while (num != 0);
        
        System.out.println("Ha introducido: " + numeros.size() + " numeros:");
        
        // Mostrar el arrayList completo
        System.out.println(numeros);
        
        // Recorrido usando un iterador para mostrar un elemento por linea
        Iterator it = numeros.iterator();
        while(it.hasNext())
              System.out.println(it.next());
        
        // Recorrido usando for-each para sumar los elementos
        double suma = 0;
        for(Integer i: numeros){
            suma = suma + i;
        }
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + suma/numeros.size());
    }
}

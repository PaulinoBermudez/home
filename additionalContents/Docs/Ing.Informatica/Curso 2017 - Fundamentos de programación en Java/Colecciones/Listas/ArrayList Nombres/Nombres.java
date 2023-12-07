/**
 * @(#)Nombres.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/17
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Nombres{

    public static void main(String[] args){
    	
        ArrayList<String> nombres = new ArrayList<String>();
        
        nombres.add("Ana");
        nombres.add("Luisa");
        nombres.add("Felipe");
        nombres.add("Pablo");
        
        System.out.println(nombres);
        nombres = invertir(nombres);
        System.out.println(nombres);
    }

    public static ArrayList<String> invertir(ArrayList<String> nombres){
    	
        // Crea una lista para el resultado del método
        ArrayList<String> resultado = new ArrayList<String>();
        
        // Recorre la lista de nombres en orden inverso
        for (int i = nombres.size() - 1; i >= 0; i--){
             // Agrega cada nombre al resultado
              resultado.add(nombres.get(i));
        }
        return resultado;
    }
}

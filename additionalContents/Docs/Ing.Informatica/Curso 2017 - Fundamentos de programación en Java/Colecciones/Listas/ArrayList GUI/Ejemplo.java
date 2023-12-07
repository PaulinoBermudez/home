/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2016/4/9
 */


//import de la clase ArrayList
import java.util.ArrayList;

public class Ejemplo {

    public static void main(String[] args) {
        
        //1.-Declaración del ArrayList
        
        //ArrayList que contienen Strings
        ArrayList al_strings1=new ArrayList<>();
        ArrayList al_strings2=new ArrayList<>();
        //ArrayList que contiene vectores de Strings
        ArrayList<String[]> al_vector_strings=new ArrayList<>();
        //ArrayList que contiene enteros
        ArrayList al_enteros=new ArrayList<>();
        
        //2.-Añadir un elemento al ArrayList
        //al añadir un elemento el primero se indexa con el índice 0 
        //el segundo con el 1...
        al_strings1.add("a");
        al_strings1.add("b");
        al_strings1.add("c");
        
        al_strings2.add("d");
        al_strings2.add("e");
        al_strings2.add("f");
        
        //se pueden añadir todos los elementos de un array list en otro
        //conservando el orden de los mismos
        
        al_strings1.addAll(al_strings2);
        
        //para consultar el número de elementos de un ArrayList tenemos 
        //el método size()
        
        System.out.println("Tamaño del ArrayList: "+al_strings1.size());
        
        //3.-Para obtener el valor almacenado de una posición concreta 
        //tenemo el método get() 
        
        for(int i=0; i<al_strings1.size(); i++){
            System.out.println("índice: "+i+" contiene: "+al_strings1.get(i));
        }
        
        //salida:
        //Tamaño del ArrayList: 6
        //índice: 0 contiene: a
        //índice: 1 contiene: b
        //índice: 2 contiene: c
        //índice: 3 contiene: d
        //índice: 4 contiene: e
        //índice: 5 contiene: f
        
        //4.-Para saber si el ArrayList contiene un cierto elemento podemos
        //utilizar el método contains
        
        if(al_strings1.contains("a")) {System.out.println("Contego la a");}
        
        //5.-Para modificar el valor de una posición concreta tenemos el método
        //set(,)
        
        al_strings1.set(0,"z");
        
        //6.-Para eliminar una posición concreta podemos utilizar el metodo 
        //remove(), es importante observar que la eliminación de una 
        //posición hace que cambie el índice de los elementos posteriores
        
        al_strings1.remove(1);
        
        System.out.println("Tamaño del ArrayList: "+al_strings1.size());
        for(int i=0; i<al_strings1.size(); i++){
            System.out.println("índice: "+i+" contiene: "+al_strings1.get(i));
        }
        
        //Salida:
        //Tamaño del ArrayList: 5
        //índice: 0 contiene: z
        //índice: 1 contiene: c
        //índice: 2 contiene: d
        //índice: 3 contiene: e
        //índice: 4 contiene: f      
        
        //7.-Para borrar todos los elementos contamos con el método clear()
        
        al_strings1.clear();
        
        //8.-Finalmente para comprobar si el ArrayList está vacío lo podemos
        //utilizar el metodo isEmpty().
        
        if(al_strings1.isEmpty()) {System.out.println("Estoy vacío");}
        
        //Salida:
        //Estoy vacío
        
    }
}
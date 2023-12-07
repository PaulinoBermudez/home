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
        
        //1.-Declaraci�n del ArrayList
        
        //ArrayList que contienen Strings
        ArrayList al_strings1=new ArrayList<>();
        ArrayList al_strings2=new ArrayList<>();
        //ArrayList que contiene vectores de Strings
        ArrayList<String[]> al_vector_strings=new ArrayList<>();
        //ArrayList que contiene enteros
        ArrayList al_enteros=new ArrayList<>();
        
        //2.-A�adir un elemento al ArrayList
        //al a�adir un elemento el primero se indexa con el �ndice 0 
        //el segundo con el 1...
        al_strings1.add("a");
        al_strings1.add("b");
        al_strings1.add("c");
        
        al_strings2.add("d");
        al_strings2.add("e");
        al_strings2.add("f");
        
        //se pueden a�adir todos los elementos de un array list en otro
        //conservando el orden de los mismos
        
        al_strings1.addAll(al_strings2);
        
        //para consultar el n�mero de elementos de un ArrayList tenemos 
        //el m�todo size()
        
        System.out.println("Tama�o del ArrayList: "+al_strings1.size());
        
        //3.-Para obtener el valor almacenado de una posici�n concreta 
        //tenemo el m�todo get() 
        
        for(int i=0; i<al_strings1.size(); i++){
            System.out.println("�ndice: "+i+" contiene: "+al_strings1.get(i));
        }
        
        //salida:
        //Tama�o del ArrayList: 6
        //�ndice: 0 contiene: a
        //�ndice: 1 contiene: b
        //�ndice: 2 contiene: c
        //�ndice: 3 contiene: d
        //�ndice: 4 contiene: e
        //�ndice: 5 contiene: f
        
        //4.-Para saber si el ArrayList contiene un cierto elemento podemos
        //utilizar el m�todo contains
        
        if(al_strings1.contains("a")) {System.out.println("Contego la a");}
        
        //5.-Para modificar el valor de una posici�n concreta tenemos el m�todo
        //set(,)
        
        al_strings1.set(0,"z");
        
        //6.-Para eliminar una posici�n concreta podemos utilizar el metodo 
        //remove(), es importante observar que la eliminaci�n de una 
        //posici�n hace que cambie el �ndice de los elementos posteriores
        
        al_strings1.remove(1);
        
        System.out.println("Tama�o del ArrayList: "+al_strings1.size());
        for(int i=0; i<al_strings1.size(); i++){
            System.out.println("�ndice: "+i+" contiene: "+al_strings1.get(i));
        }
        
        //Salida:
        //Tama�o del ArrayList: 5
        //�ndice: 0 contiene: z
        //�ndice: 1 contiene: c
        //�ndice: 2 contiene: d
        //�ndice: 3 contiene: e
        //�ndice: 4 contiene: f      
        
        //7.-Para borrar todos los elementos contamos con el m�todo clear()
        
        al_strings1.clear();
        
        //8.-Finalmente para comprobar si el ArrayList est� vac�o lo podemos
        //utilizar el metodo isEmpty().
        
        if(al_strings1.isEmpty()) {System.out.println("Estoy vac�o");}
        
        //Salida:
        //Estoy vac�o
        
    }
}
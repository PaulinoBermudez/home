/**
 * @(#)C1.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/17
 */

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
 
public class C1 {
 
    public static void main(String[] args) {
     
        Map<Integer, String> map = new HashMap<Integer, String>();
 
        // PUT(KEY,VALUE)
        map.put(0, "A");    
        map.put(1, "B");
        map.put(2, "C");
        map.put(2, "C");
        map.put(3, null);
        map.put(null, "D");
        map.put(null, null); // Machaca el D por el null
         
 
        // GET
        System.out.println("get(0): " + map.get(0)); // A
 
        // KEYSET()
        Set keys = map.keySet();
         
        Iterator<Integer> it = keys.iterator();
        //sin orden
         
        System.out.print("keySet: ");
         
        while (it.hasNext())
            System.out.print(it.next() + " ");
        // null 0 1 2 3 (sin orden)
 
        // VALUES()
        System.out.print("\n values: ");
        for (String st : map.values())
            System.out.print(st + " ");
        // null A B C null (sin orden)
 
        // CONTAINSVALUE(VALUE)
        System.out.println("\n containsValue  B: " + map.containsValue("B"));
        // true
 
        // CONTAINSKEY(KEY)
        System.out.println("containsKey 1: " + map.containsKey(1));
        // true
 
        // SIZE
        System.out.println("size() : " + map.size());
        // 5
 
        // EQUALS
        System.out.println("equals map y hola? " + map.equals("hola"));
        // false
 
        Map<Integer, String> map2 = map;
        //Las dos refs. map2 y map 
        //apuntan al mismo objeto del Heap 
 
 
        System.out.println("equals map y map2? " + map.equals(map2));
        // true
 
        // HASHCODE
        System.out.println("hashCode de map: " + map.hashCode()); 
 
        // ISEMPTY
        System.out.println("isEmpty map? " + map.isEmpty());
        // false
 
        // REMOVE(KEY)
        System.out.println("remove 0 de map: " + map.remove(0));
        // A. Elimina por la key.
 
        System.out.println("size map: " + map.size()); // 4
 
        // CLEAR
        map.clear();
        // El objeto del Heap deja de tener elemnetos
 
         
        System.out.println("clear map. size map: " + map.size()); // 0
 
    }
}
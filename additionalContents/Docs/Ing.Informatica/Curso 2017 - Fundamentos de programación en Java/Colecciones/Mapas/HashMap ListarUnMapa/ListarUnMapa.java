/**
 * @(#)ListarUnMapa.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/20
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;

public class ListarUnMapa{
	
	public static void main(String[] args){
		
		Map<String,String> hm = new HashMap<String,String>();
		
		hm.put("1","Luis");
        hm.put("2","Pepe");
        hm.put("3","Manolo");

        // Agregamos un elemento con clave existente.
        // Se sobrescribe su valor ya que no puede
        // haber valores duplicados.
        hm.put("1","Victor");
                   
        Iterator<Entry<String,String>> it = hm.entrySet().iterator();
                
        while (it.hasNext()){
        	Entry<String,String> e = it.next();
        	System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}

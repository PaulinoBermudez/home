/**
 * @(#)ConjHash.java
 *
 * Ejemplo con un HashSet
 * Crear dos conjuntos de enteros
 * y realizar las operaciones algebraicas:
 * 	Unión.
 *  Diferencia.
 *  Intersección.
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/20
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class ConjHash{
	
	public static void main(String[] args){
		
		ConjHash a = new ConjHash();
		HashSet cn2, cn1;	
		cn2 = a.creaConj();
		System.out.println("Conjunto cn2: " + cn2);
		cn1 = a.creaConj();
		System.out.println("Conjunto cn1: " + cn1);
		
		// union de conjuntos
		HashSet union;
		union = (HashSet)cn2.clone();
		union.addAll(cn1);
		System.out.print("cn2 + cn1: ");
		a.iteraConj(union);
		
		// diferencia de conjuntos
		HashSet dif;
		dif =(HashSet)cn2.clone();
		dif.removeAll(cn1);
		System.out.print("cn2 - cn1: ");
		a.iteraConj(dif);
		
		// intersección de conjuntos
		HashSet inter;
		inter = (HashSet)cn2.clone();
		inter.retainAll(cn1);
		System.out.print("cn2 * cn1: ");
		a.iteraConj(inter);
	}
	
	public void iteraConj(Set cnj){
		
		Iterator ic;
		Integer q;
		ic = cnj.iterator();
		
		while (ic.hasNext()){
			q = (Integer) ic.next();
			System.out.print(q + " ");
		}
		
		System.out.println();
	}
	
	public HashSet creaConj(){
		
		HashSet q = new HashSet();
		int n = (int)(Math.random()*7 +3);
		
		for (int i = 0; i < n; i++){
			boolean s;
			Integer e = (int)(Math.random()*17 +3);
			Integer r = new Integer(e);
			s = q.add(r);
			if (!s) System.out.println(e + " repetido");
		}
		
		return q;
	}
}
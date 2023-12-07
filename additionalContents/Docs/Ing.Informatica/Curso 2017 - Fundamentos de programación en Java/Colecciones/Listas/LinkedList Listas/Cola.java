/**
 * @(#)Cola.java
 *
 * Ejemplo LinkedList
 * @author Antonio Rivero
 * @version 1.00 2015/7/20
 */

import java.util.LinkedList;

class Cola{
	
	private LinkedList<Character> qq;
	
	public Cola (){
		qq = new LinkedList<Character> ();
	}
	
	public boolean colaVacia(){
		return qq.isEmpty();
	}
	public void insertar(Character elemento){
		qq.addLast(elemento);
	}
	
	public Character quitar() throws Exception{
		return qq.removeFirst();
	}
	
	public void borrarCola(){
		qq.clear();
	}
	public Character frenteCola() throws Exception{
		return qq.getFirst();
	}
}
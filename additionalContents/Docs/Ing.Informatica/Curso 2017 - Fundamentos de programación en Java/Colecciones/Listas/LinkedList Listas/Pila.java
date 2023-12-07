/**
 * @(#)Pila.java
 *
 * Ejemplo LinkedList
 * @author Antonio Rivero
 * @version 1.00 2015/7/20
 */

import java.util.LinkedList;

class Pila{
	
	private LinkedList<Character> pila;
	
	public Pila(){
		pila = new LinkedList<Character> ();
	}
	
	public boolean pilaVacia(){
		return pila.isEmpty();
	}
	
	public void insertar(Character elemento){
		pila.addFirst(elemento);
	}
	
	public Character quitar()throws Exception{
		return pila.removeFirst();
	}
	
	public void limpiarPila(){
		pila.clear();
	}
	
	public Character cimaPila() throws Exception{
		return pila.getFirst();
	}
}
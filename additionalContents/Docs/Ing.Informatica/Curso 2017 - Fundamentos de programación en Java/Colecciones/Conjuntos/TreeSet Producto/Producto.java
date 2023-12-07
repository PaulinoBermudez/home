/**
 * @(#)Producto.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/23
 */

public class Producto implements Comparable {
	
	private String nombre;
	private int cantidad; 
	
	public Producto(String s, int i) {
		
		nombre = s;
		cantidad = i;
	}
	
	public String toString(){
		return ("Nombre: "+nombre+" Cantidad: "+cantidad);
	}
	
	public int compareTo( Object objeto ) {
		
		// Indica en base a que atributos se compara el objeto
		// Devuelve +1 si this es > que objeto
		// Devuelve -1 si this es < que objeto
		// Devuelve 0 si son iguales

		Producto producto = (Producto)objeto;
		String nombreObjeto = producto.nombre.toLowerCase();
		String nombreThis = this.nombre.toLowerCase();
		
		return( nombreThis.compareTo( nombreObjeto ) );
	}
}
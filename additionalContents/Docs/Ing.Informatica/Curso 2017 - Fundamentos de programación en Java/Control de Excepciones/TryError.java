/**
 * Ejemplo Excepciones con error.
 * Intentamos acceder a una posición de vector erronea
 */

public class TryError{
	public static void main(String arg[]){
		int [] array = new int[20];
		
		// Se produce un error al intentar acceder a la posición 26 del vector.
		array[25] = 24;
	}
}
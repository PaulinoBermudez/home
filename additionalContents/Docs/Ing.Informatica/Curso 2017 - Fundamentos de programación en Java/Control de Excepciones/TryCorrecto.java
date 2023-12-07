/**
 * Ejemplo Excepciones Correcto.
 * Intentamos acceder a una posición de vector erronea
 */

 public class TryCorrecto{
 	public static void main(String arg[]){
 		int [] array = new int[20];
 		try{
 			
 			// Se produce un error al intentar acceder a la posición 25 del vector.
 			array[30] = 24;
 			}
 			
 			//Aquí se captura la excepción generada
 			catch(ArrayIndexOutOfBoundsException excepcion){
			System.out.println(" Error de índice en un array");
		    }
	}
}

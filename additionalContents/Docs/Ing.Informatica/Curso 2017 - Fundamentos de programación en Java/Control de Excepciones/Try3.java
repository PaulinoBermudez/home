/**
 * Intentemos provocar también un error de tipo división por cero
 * y pongamos un catch específico para dicho error
 *
 * Podemos comprobar que se ejecuta el catch correspondiente al tipo de error generado.
 * La línea que lanza el error de índice la hemos comentado para que no lo genere y
 * podamos generar el error de división por cero.
 */

public class Try3{
	public static void main(String arg[]){
		int [] array = new int[20];
		 try
		 	{
         	array[56] = 24;	
			int b = 0;
			int a = 23/b;
			}
			catch(ArrayIndexOutOfBoundsException excepcion)
		    {
		    System.out.println(" Error de índice en un array");
		    }
		    catch(ArithmeticException excepcion)
		    {
			System.out.println(" No se puede dividir entre 0");
		    }
	}
}
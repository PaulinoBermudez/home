

public class PruebaExcepciones {
	public static void main(String args[]) {
		int valor=5, cero=0;
		int[] array = {1, 2, 3};
		try {
		//	valor = valor/cero; //divisi�n por cero
			array[4]= 5; //acceso a una posici�n no disponible
		}
		catch( ArithmeticException e ) {
			System.out.println("Division por cero");
		}
		catch( Exception e ) {
			System.out.println("Se ha producido un error en el vector");
		}
	}
}
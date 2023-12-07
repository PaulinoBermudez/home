
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;

public class ArrayListDeArrayList {
	
private static final String nombreFichero = "numeros.txt";
	
	public static void main (String args[]){
		
		// Nos creamos un ArrayList de objetos
		System.out.println("Creamos un ArrayList de ArrayList");
		ArrayList<ArrayList<Integer>> arrayListNumeros = new ArrayList<ArrayList<Integer>>();
		
		// LLamamos al fichero donde estan los datos
		File fichero = new File(nombreFichero);
		Scanner s = null;
		
		try {
			// Leemos el contenido del fichero
			System.out.println("Leemos el contenido del fichero");
			s = new Scanner(fichero);
			
			// Obtengo los datos del fichero
			while (s.hasNextLine()){
				String linea = s.nextLine();	// Obtengo una linea del fichero con los numeros
				String [] cortarString = linea.split(" ");		// Obtengo los numeros de la linea en un array
				ArrayList<Integer> numeros = new ArrayList<Integer>();
				
				// Se agregan los numeros de la fila en el ArrayList
				for (int i=0; i<cortarString.length; i++){
					numeros.add(Integer.parseInt(cortarString[i]));
				}
				// Se agregan en el ArrayList de enteros al ArratList de ArrayList
				arrayListNumeros.add(numeros);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (s != null)
					s.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// Para ver que hemos leido bien los numeros del fichero, recorremos el ArrayList de
		// ArrayList y lo mostramos por pantalla.
		System.out.println("\nContenido de los ArrayList del ArrayList");
		Iterator<ArrayList<Integer>> itrArrayListNumeros = arrayListNumeros.iterator();
		while(itrArrayListNumeros.hasNext()){
			ArrayList<Integer> numeros = itrArrayListNumeros.next();
			Iterator<Integer> itrNumeros = numeros.iterator();
			while(itrNumeros.hasNext()){
				int numero = itrNumeros.next();
				System.out.print(numero + " ");
			}
			System.out.println();
		}
		
		// Recorremos los ArrayList que hay en el ArrayList y eliminamos los numeros que son cero
		itrArrayListNumeros = arrayListNumeros.iterator();
		while(itrArrayListNumeros.hasNext()){
			ArrayList<Integer> numeros = itrArrayListNumeros.next();
			Iterator<Integer> itrNumeros = numeros.iterator();
			while(itrNumeros.hasNext()){
				int numero = itrNumeros.next();
				if (numero == 0)
					itrNumeros.remove();
			}
		}
		
		// Recorremos el ArrayList de los ArrayList y 
		// eliminamos los ArrayList que no contengan elementos
		itrArrayListNumeros = arrayListNumeros.iterator();
		while(itrArrayListNumeros.hasNext()){
			ArrayList<Integer> numeros = itrArrayListNumeros.next();
			// Si el ArrayList esta vacio, lo eliminamos del ArrayList
			if (numeros.isEmpty())
				itrArrayListNumeros.remove();
		}
		
		// Mostramos el ArrayList tras eliminar todos los ceros
		String salida = "";
		System.out.println("\nSalida sin ceros");
		itrArrayListNumeros = arrayListNumeros.iterator();
		while(itrArrayListNumeros.hasNext()){
			ArrayList<Integer> numeros = itrArrayListNumeros.next();
			Iterator<Integer> itrNumeros = numeros.iterator();
			while(itrNumeros.hasNext()){
				int numero = itrNumeros.next();
				salida += numero+" ";
			}
			salida += "\n";
		}
		
		System.out.println(salida);	
	}
}

/**
 * @(#)Entrenador.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */
 
import java.util.ArrayList;

public class SeleccionFutbolApp {

	// ArrayList de objetos SeleccionFutbol.
	// Idenpendientemente de la clase hija a la que pertenezca el objeto
	public static ArrayList<SeleccionFutbol> integrantes = new ArrayList<SeleccionFutbol>();

	public static void main(String[] args){

		Entrenador delBosque = new Entrenador(1, "Vicente", "Del Bosque", 60, "284EZ89");
		Futbolista iniesta = new Futbolista(2, "Andres", "Iniesta", 29, 6, "Interior Derecho");
		Masajista raulMartinez = new Masajista(3, "Raul", "Martinez", 41, "Licenciado en Fisioterapia", 18);

		integrantes.add(delBosque);
		integrantes.add(iniesta);
		integrantes.add(raulMartinez);

		// Concentracion
		System.out.println("Todos los integrantes comienzan una concentracion. (Todos ejecutan el mismo metodo)");
		for (SeleccionFutbol integrante : integrantes) {
			System.out.print(integrante.getNombre()+" "+integrante.getApellidos()+" -> ");
			integrante.Concentrarse();
		}
		
		// Viaje
		System.out.println("\n Todos los integrantes viajan para jugar un partido. (Todos ejecutan el mismo metodo)");
		for (SeleccionFutbol integrante : integrantes) {
			System.out.print(integrante.getNombre()+" "+integrante.getApellidos()+" -> ");
			integrante.Viajar();
		}
		
		// Entrenamiento
		System.out.println("\n Entrenamiento: Solamente el entrenador y el futbolista tiene metodos para entrenar:");
		System.out.print(delBosque.getNombre()+" "+delBosque.getApellidos()+" -> ");
		delBosque.dirigirEntrenamiento();
		System.out.print(iniesta.getNombre()+" "+iniesta.getApellidos()+" -> ");
		iniesta.entrenar();
		
		// Masaje
		System.out.println("\n Masaje: Solo el masajista tiene el metodo para dar un masaje:");
		System.out.print(raulMartinez.getNombre()+" "+raulMartinez.getApellidos()+" -> ");
		raulMartinez.darMasaje();
		
		// Partido de Futbol
		System.out.println("\n Partido de Futbol: Solamente el entrenador y el futbolista tiene metodos para el partido de futbol:");
		System.out.print(delBosque.getNombre()+" "+delBosque.getApellidos()+" -> ");
		delBosque.dirigirPartido();
		System.out.print(iniesta.getNombre()+" "+iniesta.getApellidos()+" -> ");
		iniesta.jugarPartido();
	}
}
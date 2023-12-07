/**
 * @(#)JugadorSeleccionApp.java
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/6/10
 */

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class JugadorSeleccionApp {

	public static void main(String[] args) {
		
		System.out.println("\n\n********* TreeMap con Objetos y como Clave un String *********");
		System.out.println("");
		
		Map <String, JugadorSeleccion> jugadores = new TreeMap<String, JugadorSeleccion>();
		
		jugadores.put("Casillas", new JugadorSeleccion(1, "Casillas", "Portero"));
		jugadores.put("Ramos", new JugadorSeleccion(15, "Ramos", "Lateral Derecho"));
		jugadores.put("Pique", new JugadorSeleccion(13, "Pique", "Central"));
		jugadores.put("Puyol", new JugadorSeleccion(5, "Puyol", "Central"));
		jugadores.put("Capdevila", new JugadorSeleccion(11, "Capdevila", "Lateral Izquierdo"));
		jugadores.put("Xabi", new JugadorSeleccion(14, "Xabi Alonso", "Medio Centro"));
		jugadores.put("Busquets", new JugadorSeleccion(16, "Busquets", "Medio Centro"));
		jugadores.put("Xavi", new JugadorSeleccion(8, "Xavi Hernandez", "Centro Campista"));
		jugadores.put("Pedrito", new JugadorSeleccion(18, "Pedrito", "Interior Izquierdo"));
		jugadores.put("Iniesta", new JugadorSeleccion(6, "Iniesta", "Interior Derecho"));
		jugadores.put("Villa", new JugadorSeleccion(7, "Villa", "Delantero"));
		
		for (Entry<String, JugadorSeleccion> jugador : jugadores.entrySet()){
			String clave = jugador.getKey();
			JugadorSeleccion valor = jugador.getValue();
			System.out.println(clave+"  ->  "+valor.toString());
		}
		
		// Cuidado con comparar objetos que son iguales pero no son lo mismo
		JugadorSeleccion villa = new JugadorSeleccion(7, "Villa", "Delantero");
		System.out.println("\n\nEsta este objeto 'villa' en el Map: jugadores.containsValue(villa) = "+jugadores.containsValue(villa));
		
		// En este caso si que estamos preguntando por el mismo objeto
		JugadorSeleccion navas = new JugadorSeleccion(22, "Navas", "Extremo Derecho");
		jugadores.put("Navas", navas);
		System.out.println("Esta este objeto 'navas' en el Map: jugadores.containsValue(navas) = "+jugadores.containsValue(navas));
	}
}
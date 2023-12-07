/**
 * @(#)PersonaApp.java
 *
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/6/9
 */


public class PersonaApp {
	
	public static void main (String[] args) {
		
		Persona kuki = new Persona();
		kuki.setNombre("Kuki");
		kuki.setEdad(25);
		
		Estudiante chacho = new Estudiante();
		chacho.setNombre("Juan Jose");
		chacho.setLegajo(240682);
		chacho.setCarrera("Industriales");
		
		Profesor toni = new Profesor();
		toni.setNombre("Rivero");
		toni.setMateria("Fundamentos de Informatica");
		toni.setCargo("Titular");
		
		System.out.println("Objeto kuki de tipo Persona");
		System.out.printf("Nombre: %s, Edad: %d \n", 
						kuki.getNombre(),
						kuki.getEdad());
		System.out.println("");
		
		System.out.println("Objeto chacho de tipo Estudiante");
		System.out.printf("Nombre: %s, Carrera: %s, Legajo: %d \n", 
						chacho.getNombre(),
						chacho.getCarrera(), 
						chacho.getLegajo());
		System.out.println("");
		
		System.out.println("Objeto toni de tipo Profesor");
		System.out.printf("Nombre: %s, Materia: %s, Cargo: %s \n", 
						toni.getNombre(),
						toni.getMateria(), 
						toni.getCargo());
		System.out.println("");				
	}
}
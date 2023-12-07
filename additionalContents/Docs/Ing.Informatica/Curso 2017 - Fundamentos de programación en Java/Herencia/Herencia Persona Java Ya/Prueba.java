/**
 * Confeccionar una clase Persona que tenga como atributos el nombre y la edad.
 * Definir como responsabilidades un metodo que cargue los datos personales
 * y otro que los imprima.
 * Plantear una segunda clase Empleado que herede de la clase Persona.
 * Anadir un atributo sueldo y los metodos de cargar el sueldo e imprimir su sueldo.
 * Definir un objeto de la clase Persona y llamar a sus metodos.
 * Tambien crear un objeto de la clase Empleado y llamar a sus metodos. 
 */

public class Prueba{
	
    public static void main(String[] args){
    	
        Persona persona1 = new Persona();
        persona1.cargarDatosPersonales();
        System.out.println("");
        
        Empleado empleado1 = new Empleado();
        empleado1.cargarDatosPersonales();
        empleado1.cargarSueldo();
        System.out.println("");
        
        persona1.imprimirDatosPersonales();
        empleado1.imprimirDatosPersonales();
        empleado1.imprimirSueldo();
        System.out.println("");
        
        Empleado Toni = new Empleado();
     	if (Toni instanceof Persona)
     	System.out.println("Toni es un Empleado y también una Persona");
    }
}
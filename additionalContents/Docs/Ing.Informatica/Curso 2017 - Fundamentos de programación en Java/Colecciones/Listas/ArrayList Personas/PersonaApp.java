/**
 * @(#)PersonaApp.java
 *
 *
 * @author 
 * @version 1.00 2016/2/25
 */


import java.util.Scanner;
import java.util.ArrayList;
public class PersonaApp{
	public static void main(String []args){
		
		Scanner scanner = new Scanner(System.in);
		ArrayList listaPersonas = new ArrayList();
		
		int numeroPersonas = 3;//Ingresaremos en nuestro ArrayList 3 Personas, pueden ser mas...		
		
		for(int i = 0;i < numeroPersonas;i++){
			Persona persona = new Persona();//Creamos una persona
			System.out.println("Digite el id de la persona numero "+i);
			persona.setId(scanner.nextLine());
			System.out.println("Digite el nombre de la persona numero "+i);
			persona.setNombres(scanner.nextLine());
			System.out.println("Digite el apellido de la persona numero "+i);
			persona.setApellidos(scanner.nextLine());
			listaPersonas.add(persona);//adjuntamos a la lista la persona que acabamos de crear		
		}
		
		for(int j = 0;j < listaPersonas.size();j++){//ahora imprimiremos las personas de nuestro ArrayList
			System.out.println("============================================================");
			System.out.println("Persona numero "+j);
			Persona persona = (Persona)listaPersonas.get(j);
			System.out.println("Id: "+persona.getId());
			System.out.println("Nombre: "+persona.getNombres());
			System.out.println("Apellidos: "+persona.getApellidos());
			System.out.println("============================================================");
		}
	}
}
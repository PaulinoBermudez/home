/**
 * Excepciones
 * Ejemplo: Con try-catch
 */
 
import java.util.Scanner;

public class VerPersona {
	public static void main (String[] args) {
		Persona unobjeto = new Persona();
		try{	
			Scanner teclado=new Scanner(System.in);
			int edad;
			System.out.print("Ingrese edad:");
	        edad=teclado.nextInt();
			unobjeto.setEdad(edad);
			System.out.println(unobjeto.toString());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
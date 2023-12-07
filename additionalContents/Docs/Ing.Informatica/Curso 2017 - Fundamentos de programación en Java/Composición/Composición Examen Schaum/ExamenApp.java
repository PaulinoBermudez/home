/**
 * @(#)ExamenApp.java
 *
 *
 * @author Antonio Rivero  
 * @version 1.00 2015/5/30
 */

public class ExamenApp{
	
	public static void main(String[] args){
		
		Fecha fecha = new Fecha(1,4,2005);
		Hora hora = new Hora(7, 30);
		Examen programacion = new Examen("Fundamentos de Informatica","A-15", fecha, hora);
		
		System.out.println(programacion.toString());
		
		programacion.setFecha (new Fecha(1, 6, 2005));
		programacion.setHora(new Hora(9, 0));
		
		System.out.println(programacion.toString());	
	}
}

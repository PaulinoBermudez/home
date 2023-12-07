import java.io.*;
import java.util.Scanner;

public class SeleccionMultiple{
	public static void main (String[] args) {
		try{
			System.out.println("MEN�");
			System.out.println("C. Cargar archivo");
			System.out.println("G. Grabar archivo");
			System.out.println("I. Imprimir archivo");
			System.out.println("S. Salir del programa");
			System.out.println("Elija opci�n (C, G, I, S)");
			
			char opcion = (char)System.in.read();
			System.in.skip(System.in.available());
			
			
			Scanner teclado = new Scanner (System.in);
			
			switch (opcion) {
				case 'C' : case 'c':
					System.out.println("Ha seleccionado Cargar archivo");
				break;
				case 'G' : case 'g':
					System.out.println("Ha seleccionado Grabar archivo");
				break;
				case 'I' : case 'i':
					System.out.println("Ha seleccionado Imprimir archivo");
				break;
				case 'S' : case 's':
					System.out.println("Ha seleccionado Salir del programa");
				break;
				default:
					System.out.println("Opci�n no v�lida");
					}			
				}
			catch(Exception e){
				}
	}
}
import java.util.Scanner;

public class CrearMenu {
	
	static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
	static int select = -1; //opción elegida del usuario
	static int num1 = 0; //Variables
	static int num2 = 0; //Variables
	
	public static void main(String[] args) {
		
		//Mientras la opción elegida sea 0, preguntamos al usuario
		while(select != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
				System.out.println("Elige opción:\n" +
						"1.- Sumar\n" +
						"2.- Restar\n" +
						"3.- Multiplicar\n" +
						"4.- Dividir\n" +
						"0.- Salir");
				
				System.out.println("");
					
				//Recoger una variable por consola
				System.out.print("Opcion numero: ");
				select = Integer.parseInt(scanner.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(select){
					
				case 1: 
					pideNumeros();
					System.out.println(num1+" + "+num2+" = "+(num1+num2));
					break;
				case 2: 
					pideNumeros();
					System.out.println(num1+" - "+num2+" = "+(num1-num2));
					break;
				case 3: 
					pideNumeros();
					System.out.println(num1+" * "+num2+" = "+(num1*num2));
					break;
				case 4: 
					pideNumeros();
					System.out.println(num1+" / "+num2+" = "+(num1/num2));
					break;
				case 0: 
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
				
				System.out.println(""); //Mostrar un salto de línea en Java
				
			}catch(Exception e){
				System.out.println("Uoop! Error!");
			}
		}

	}
	
	//Método para recoger variables por consola
	public static void pideNumeros(){
		System.out.print("Introduce número 1: ");
		num1 = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Introduce número 2: ");
		num2 = Integer.parseInt(scanner.nextLine());

		//Mostrar un salto de línea en Java
		System.out.println(""); 
	}

}
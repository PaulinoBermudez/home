import java.util.Scanner;
public class DosMenus {
	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		read = new Scanner (System.in);
		
		int Seleccion = 0; //Primer Menu del switch

	 	do {
			System.out.println("1.Cuenta Corriente");
			System.out.println("2.Cuenta de Ahorro");
			System.out.println("3.Salir");
			System.out.println("");
	        System.out.print("Ingrese Opción: ");
			Seleccion = read.nextInt();
	
			switch (Seleccion){		
				case 1:
					int CuentaCorriente = 0;
					
				do {
					System.out.println("Ingreso a su Cuenta Corriente");
					System.out.println("Que va a Realizar...");
					System.out.println("1.Abonar.");
					System.out.println("2.Cargar");
					System.out.println("3.Mostrar Saldo.");
					System.out.println("4.Volver Atras.");
					System.out.println("");
	                System.out.print("Ingrese Opción: ");
					CuentaCorriente = read.nextInt();
					
					switch (CuentaCorriente){
						case 1:
							System.out.println("Selecciono Abonar.");
							break;
						case 2:
							System.out.println("Selecciono Cargar.");
							break;
						case 3:
							System.out.println("Selecciono Mostrar Saldo.");
							break;
						default:
							System.out.println("Selecciono Volver Atras.");
					}
			
				}while (CuentaCorriente != 4);
						break;
				
				case 2:	
					int CuentaAhorro = 0;
					System.out.println("Ingreso a su Cuenta de Ahorro");
	
				do {	
					System.out.println("Que va a Realizar...");
					System.out.println("1.Abonar.");
					System.out.println("2.Cargar");
					System.out.println("3.Mostrar Saldo.");
					System.out.println("4.Volver Atras.");
	     			System.out.println("");
	                System.out.print("Ingrese Opción: ");
					CuentaAhorro = read.nextInt();
					
					switch (CuentaAhorro){
						case 1:
							System.out.println("Selecciono Abonar.");
							break;
						case 2:
							System.out.println("Selecciono Cargar.");
							break;
						case 3:
							System.out.println("Selecciono Mostrar Saldo.");
							break;
						default:
							System.out.println("Volver Atras.");
							break;
					}
				}while (CuentaAhorro !=4);
			}
		}while (Seleccion !=3);
	}
}
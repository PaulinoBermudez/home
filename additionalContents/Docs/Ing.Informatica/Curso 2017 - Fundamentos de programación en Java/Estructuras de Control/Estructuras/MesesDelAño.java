/*
 * Programa que nos devuelve el mes del a�o,
 * Tenemos que introducir el n�mero del mes
 * y nos devuelve el mes en letras.
 *
 */

import java.util.Scanner;

class MesesDelA�o{
	public static void main (String[] args) {
		int mes;
		Scanner teclado = new Scanner (System.in);
		System.out.print("mes: ");
		mes = teclado.nextInt();
		switch(mes){
			case 1:
				System.out.println("Enero");
				break;
			case 2:
				System.out.println("Febrero");
				break;				
			case 3:
				System.out.println("Marzo");
				break;
			case 4:
				System.out.println("Abril");
				break;
			case 5:
				System.out.println("Mayo");
				break;				
			case 6:
				System.out.println("Junio");
				break;
			case 7:
				System.out.println("Julio");
				break;
			case 8:
				System.out.println("Agosto");
				break;				
			case 9:
				System.out.println("Septiembre");
				break;
			case 10:
				System.out.println("Octubre");
				break;
			case 11:
				System.out.println("Noviembre");
				break;				
			case 12:
				System.out.println("Diciembre");
				break;
			default:
				System.out.println("Mes no v�lido");
				break;				
		}
	}
}
/*
 * Escriba un método, de nombre escribeOrdenadosDosNúmeros,
 * que reciba por parámetro dos números reales y los
 * escriba de menor a mayor.
 *
 */

class escribeOrdenadosDosNumeros{
	static void escribeOrdenadosDosNumeros(double a,double b){
		if (a<b){System.out.println(a+ "  " +b);
		}else{System.out.println(b+ "  " +a);
			}
	}
	public static void main(String args[]){
		escribeOrdenadosDosNumeros (455.9, 86.8);
	}
}
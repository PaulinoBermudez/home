public class Polimorfismo{
	
	public static void main(String[] args){
		
		Figura figura1 = new Circulo();
		figura1.area();
		figura1.perimetro();
		
		System.out.println("");
		
		figura1 = new Cuadrado();
		figura1.area();
		figura1.perimetro();
    }
}

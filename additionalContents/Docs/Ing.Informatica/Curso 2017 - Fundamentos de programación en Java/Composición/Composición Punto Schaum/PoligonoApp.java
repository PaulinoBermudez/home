
public class PoligonoApp{
	public static void main(String args[]){
		
		Punto[] vert = {new Punto(0,0), new Punto(2,0), new Punto(2,2), new Punto(0,2)};
		Poligono miPoligono = new Poligono(vert);
		
		System.out.println(miPoligono);
		System.out.println("Perimetro: " + miPoligono.perimetro());
		miPoligono.trasladar(4,-3);
		
		System.out.println(miPoligono);
		System.out.println("Perimetro: " + miPoligono.perimetro());
		miPoligono.escalar(3, 0.5);
		
		System.out.println(miPoligono);
		System. out. println("Perimetro: " + miPoligono.perimetro());
    }
}


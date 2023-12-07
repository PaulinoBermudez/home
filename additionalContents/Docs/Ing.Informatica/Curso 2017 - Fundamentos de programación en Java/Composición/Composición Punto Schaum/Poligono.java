public class Poligono{
	
	private Punto[] vertices;
	
	public Poligono(Punto[] valor){
		if (valor.length < 3){
			throw new IllegalArgumentException();
		}
		vertices = valor;
	}
	
	public void escalar(double x, double y){
		double valX, valY;
		
		for (Punto p : vertices){
			valX = p.getX();
			valY = p.getY();
			p.setX(valX * x);
			p.setY(valY * y);
		}
	}
	
	public void trasladar(double x, double y){
		double valX, valY;
		
		for (Punto p : vertices){
			valX = p.getX();
			valY = p.getY();
			p.setX(valX + x);
			p.setY(valY + y);
		}
	}
	
	public int numVertices(){
		return vertices.length;
	}
	
	
	public double perimetro(){
		double acumulador = 0;
		
		for (int i = 0; i < vertices.length - 1; i++) {
			acumulador += vertices[i].distancia(vertices[i + 1]);
		}
		acumulador += vertices[0].distancia(vertices[vertices.length - 1]);
		return acumulador;
	}

	public String toString(){
		String cadena="";
		
		for (Punto p : vertices){
			cadena += p + "\n";
		}
		return cadena;
	}
}

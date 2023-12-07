public class Punto{
	
	private double x;
	private double y;
	
	public Punto(double valorX, double valorY){
		
		x = valorX;
		y = valorY;
	}
	
	public Punto(){
		this(0,0);
	}
	
	public void setX(double valor){
		x = valor;
	}
	
	public void setY(double valor){
		y = valor;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double distancia(Punto p){
		double distanciaX = p.getX() - x;
		double distanciaY = p.getY() - y;
		return Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);
	
	}
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
/**
 * @(#)Cuadrado.java
 *
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/6/15
 */

public class Cuadrado extends FiguraGeometrica {
	
	public Cuadrado(double valor1) {
		super(valor1);
	}

	@Override
 	public double getArea() {
		return Math.pow(this.valor1, 2);
 	}

	@Override
	public double getPerimetro() {
		return this.valor1*4;
	}
}
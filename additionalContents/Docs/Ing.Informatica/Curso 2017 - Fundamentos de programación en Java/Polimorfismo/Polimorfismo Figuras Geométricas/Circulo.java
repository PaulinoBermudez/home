/**
 * @(#)Circulo.java
 *
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/6/15
 */

public class Circulo extends FiguraGeometrica {
	
	public Circulo(double valor1) {
		super(valor1);
 	}
 	
 	@Override
 	public double getArea() {
 		return Math.PI*Math.pow(this.valor1, 2);
 	}

 	@Override
 	public double getPerimetro() {
  		return Math.PI*this.valor1;
 	}
}
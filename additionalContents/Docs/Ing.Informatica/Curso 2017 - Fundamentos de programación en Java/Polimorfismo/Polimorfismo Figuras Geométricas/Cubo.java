/**
 * @(#)Cubo.java
 *
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/6/15
 */

public class Cubo extends Cuadrado {
	
	public Cubo(double valor1) {
		super(valor1);
 	}

 	public double getArea() {
  		return Math.pow(this.valor1, 3);
 	} 
}
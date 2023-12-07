/**
 * @(#)FiguraGeometricaApp.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/15
 */

public class FiguraGeometricaApp{
	
	public static void main(String[] args){
		
		FiguraGeometrica figura;
		
		figura = new Circulo(5);
		System.out.println(figura.getClass());
		System.out.println("Area: "+figura.getArea());
		System.out.println("Perimetro: "+figura.getPerimetro());
		System.out.println();
		
		figura = new Cuadrado(5);
		System.out.println(figura.getClass());
		System.out.println("Area: "+figura.getArea());
		System.out.println("Perimetro: "+figura.getPerimetro());
		System.out.println();
		
		figura = new Rectangulo(5,2);
		System.out.println(figura.getClass());
		System.out.println("Area: "+figura.getArea());
		System.out.println("Perimetro: "+figura.getPerimetro());
		System.out.println();
		
		figura = new Triangulo(5,2);
		System.out.println(figura.getClass());
		System.out.println("Area: "+figura.getArea());
		System.out.println("Perimetro: "+figura.getPerimetro());
		System.out.println();
		
		figura = new Cubo(5);
		System.out.println(figura.getClass());
		System.out.println("Area: "+figura.getArea());
		System.out.println("Perimetro: "+figura.getPerimetro());
		System.out.println();
 	}
}
/**
 * @(#)Punto.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/22
 */


import java.lang.Math;

public class Punto{
	
	protected double x;
	protected double y;

    public Punto (double x, double y){
         this.x = x;
         this.y = y;
    }

     // Devuelve la distancia al eje de coordenadas
     public double distancia(){
     	
     	return Math.sqrt(Math.pow(x,2.0)+Math.pow(y,2.0));
     }
}
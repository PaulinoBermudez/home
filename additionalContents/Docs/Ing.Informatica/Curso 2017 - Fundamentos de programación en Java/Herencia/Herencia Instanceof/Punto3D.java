/**
 * @(#)Punto3D.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/22
 */


import java.lang.Math;

public class Punto3D extends Punto{
	
	private double z;

    public Punto3D (double x, double y, double z){
    	super(x,y);
    	this.z = z;
     }

     // Devuelve la distancia al eje de coordenadas
     public double distancia(){
     	
     	return Math.sqrt(Math.pow(x,2.0)+Math.pow(y,2.0)+Math.pow(z,2.0));
     }
}
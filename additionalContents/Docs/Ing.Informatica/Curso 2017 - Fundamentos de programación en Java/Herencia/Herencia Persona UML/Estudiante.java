/**
 * @(#)Estudiante.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */


public class Estudiante extends Persona{
	
	private String carrera;
	private int legajo;

    public Estudiante(){
    }
    
    public String getCarrera(){
    	return carrera;
    }
    
    public void setCarrera(String carrera){
    	this.carrera = carrera;
    }
    
    public int getLegajo(){
    	return legajo;
    }
    
    public void setLegajo(int legajo){
    	this.legajo = legajo;
    }
}
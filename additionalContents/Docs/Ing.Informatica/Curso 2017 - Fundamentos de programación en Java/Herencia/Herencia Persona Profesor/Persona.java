/**
 * @(#)Persona.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */

public class Persona{
	
	private String nombre;
	private String apellidos;
	private int edad;

    public Persona (String nombre, String apellidos, int edad) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    

    public String getNombre(){
    	return nombre;
    }
    
    public void setNombre(String nombre){
    	this.nombre = nombre;
    }
    
    public String getApellidos(){
    	return apellidos;
    }
    
    public void setApellidos(String apellidos){
    	this.apellidos = apellidos;
    }
    
    public int getEdad(){
    	return edad;
    }
    
    public void setEdad(int edad){
    	this.edad = edad;
    }
}
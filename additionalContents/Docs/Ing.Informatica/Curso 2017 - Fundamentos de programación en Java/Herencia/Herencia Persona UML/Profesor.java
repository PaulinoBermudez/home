/**
 * @(#)Profesor.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */


public class Profesor extends Persona{
	
	private String materia;
	private String cargo;

    public Profesor(){
    }
    
    public String getMateria(){
    	return materia;
    }
    
    public void setMateria(String materia){
    	this.materia = materia;
    }
    
    public String getCargo(){
    	return cargo;
    }
    
    public void setCargo(String cargo){
    	this.cargo = cargo;
    }
}
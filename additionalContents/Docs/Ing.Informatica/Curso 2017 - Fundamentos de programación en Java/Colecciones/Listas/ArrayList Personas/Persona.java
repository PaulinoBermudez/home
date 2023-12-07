/**
 * @(#)Persona.java
 *
 *
 * @author 
 * @version 1.00 2016/2/25
 */


public class Persona{
	private String id;
	private String nombres;
	private String apellidos;
	
	public Persona(){
		//inicializamos variables
		id = "";
		nombres = "";
		apellidos = "";
	}
	public void setId(String id){
		this.id = id;
	}
	public void setNombres(String nombres){
		this.nombres = nombres;
	}
	public void setApellidos(String apellidos){
		this.apellidos = apellidos;
	}
	public String getId(){
		return this.id;
	}
	public String getNombres(){
		return this.nombres;
	}
	public String getApellidos(){
		return this.apellidos;
	}
}
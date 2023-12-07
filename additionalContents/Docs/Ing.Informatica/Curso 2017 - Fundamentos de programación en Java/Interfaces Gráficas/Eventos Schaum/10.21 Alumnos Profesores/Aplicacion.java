import java.util.ArrayList;

/**
 * @(#)Aplicacion.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/25
 */
//import java.util.List;

public class Aplicacion {
	
	private ArrayList<Alumno> listaAlumno;
	private ArrayList<Profesor> listaProfesor;

	public Aplicacion (){
		
		this.listaAlumno = new ArrayList<Alumno>();
		this.listaProfesor = new ArrayList<Profesor>();
	}
	
	public void agregarAlumno (Alumno alumno){
		listaAlumno.add(alumno);
	}
	
	public ArrayList <Alumno> dameAlumnos(){
		return listaAlumno;
	}
	
	public void agregarProfesor (Profesor profesor){
		listaProfesor.add(profesor);
	}
	
	public ArrayList <Profesor> dameProfesores(){
		return listaProfesor;
	}
	
}
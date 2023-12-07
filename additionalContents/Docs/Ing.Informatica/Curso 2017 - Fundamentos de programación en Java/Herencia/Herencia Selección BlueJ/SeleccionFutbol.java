/**
 * @(#)SeleccionFutbol.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */
 
public class SeleccionFutbol{

	protected int id;
	protected String Nombre;
	protected String Apellidos;
	protected int Edad;

	public SeleccionFutbol(int id, String nombre, String apellidos, int edad) {
		this.id = id;
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.Edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public void Concentrarse() {
		System.out.println("Concentrarse");
	}

	public void Viajar() {
		System.out.println("Viajar");
	}

}

/**
 * @(#)Entrenador.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */

public class Entrenador extends SeleccionFutbol {

	private String idFederacion;

	public Entrenador(int id, String nombre, String apellidos, int edad, String idFederacion){
		super(id, nombre, apellidos, edad);
		this.idFederacion = idFederacion;
	}

	public String getIdFederacion() {
		return idFederacion;
	}

	public void setIdFederacion(String idFederacion) {
		this.idFederacion = idFederacion;
	}

	public void dirigirPartido() {
		System.out.println("Dirige un partido");
	}

	public void dirigirEntrenamiento() {
		System.out.println("Dirige un entrenamiento");
	}

}

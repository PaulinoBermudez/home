/**
 * @(#)JugadorSeleccion.java
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/6/10
 */

class JugadorSeleccion {

	private int dorsal;
	private String nombre;
	private String demarcacion;

	public JugadorSeleccion(int dorsal, String nombre, String demarcacion) {
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.demarcacion = demarcacion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDemarcacion() {
		return demarcacion;
	}

	public void setDemarcacion(String demarcacion) {
		this.demarcacion = demarcacion;
	}
	
	@Override
	public String toString() {
		return this.dorsal+"  --  "+this.nombre+"  --  "+this.demarcacion;
	}
}
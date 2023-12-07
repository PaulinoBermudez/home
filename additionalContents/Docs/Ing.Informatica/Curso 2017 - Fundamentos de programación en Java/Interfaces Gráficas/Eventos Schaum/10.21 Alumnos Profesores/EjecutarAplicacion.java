/**
 * @(#)EjecutarAplicacion.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/25
 */

public class EjecutarAplicacion {
	
	public static void main (String args []){		
		Aplicacion aplicacion = new Aplicacion ();
		InterfazGrafica ventana = new InterfazGrafica(aplicacion);
	}
}
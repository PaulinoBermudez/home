/* @(#)Piloto.java
 */
/**
 *
 * @author 
 * http://totaki.com/poesiabinaria
 */

public class Piloto{
	
    private String nombre;
    private String escuderia;
    private String nacimiento;
    private double puntos;

    public Piloto(String nombre, String escuderia, String nacimiento, double puntos){
		this.nombre=nombre;
		this.escuderia=escuderia;
		this.nacimiento=nacimiento;
		this.puntos=puntos;
    }

    public String getNombre(){
    	return nombre;
    }

    public String getEscuderia(){
    	return escuderia;
    }

    public String toString(){
    	return nombre+" ["+puntos+"] ("+escuderia+") Nacimiento: "+nacimiento;
    }
}

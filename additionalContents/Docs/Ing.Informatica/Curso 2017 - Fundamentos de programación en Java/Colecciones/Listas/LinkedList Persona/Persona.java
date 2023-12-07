/**
 * @(#)Persona.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/22
 */

public class Persona{
	
    public int idPersona;
    public String nombre;
    public int altura;

    public Persona(int idPersona, String nombre, int altura) {

        this.idPersona = idPersona;
        this.nombre = nombre;
        this.altura = altura;
	}

    @Override
    public String toString() {

        return "Persona-> ID: "+idPersona+" Nombre: "+nombre+" Altura: "+altura+"\n";
    }
}
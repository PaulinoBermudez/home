/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2016/10/21
 */


 //Código de la clase Persona ejemplo aprenderaprogramar.com

public class Persona {

    private String nombre;
    private String apellidos;
    private int edad;

    public Persona() {
    	nombre = ""; 
    	apellidos = ""; 
    	edad = 0; 
    }

    public Persona (String nombre, String apellidos, int edad) {

        this.nombre = nombre; 
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {
    	return nombre;
    }

    public String getApellidos () {
    	return apellidos;
    }

    public int getEdad() {
    	return edad;
    }

} //Cierre de la clase
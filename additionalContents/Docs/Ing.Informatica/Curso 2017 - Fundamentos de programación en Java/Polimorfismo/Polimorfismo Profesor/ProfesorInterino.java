/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2016/10/21
 */


 import java.util.Calendar; //Ejemplo aprenderaprogramar.com

public class ProfesorInterino extends Profesor {

    private Calendar FechaComienzoInterinidad;

    public ProfesorInterino(Calendar fechaComienzaInterinidad) {

        super();

        FechaComienzoInterinidad = fechaComienzaInterinidad;
    }

    public ProfesorInterino (String nombre, String apellidos, int edad, Calendar fechaComienzaInterinidad) {

        super(nombre, apellidos, edad);

        FechaComienzoInterinidad = fechaComienzaInterinidad;
    }

    public Calendar getFechaComienzoInterinidad () {
    	return FechaComienzoInterinidad;
    }

    public void mostrarDatos() {
    	System.out.println("Datos ProfesorInterino. Comienzo interinidad: " +
    	FechaComienzoInterinidad.getTime().toString() );
    }

} //Cierre de la clase
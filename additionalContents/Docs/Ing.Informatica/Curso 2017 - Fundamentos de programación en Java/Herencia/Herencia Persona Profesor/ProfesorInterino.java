/**
 * @(#)ProfesorInterino.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */

import java.util.Calendar;

public class ProfesorInterino extends Profesor {

    private Calendar fechaComienzoInterinidad;

   /* public ProfesorInterino(Calendar fechaInicioInterinidad) {

        super();

        fechaComienzoInterinidad = fechaInicioInterinidad;
    }*/

    public ProfesorInterino(String nombre, String apellidos, int edad, Calendar fechaInicioInterinidad) {

        super(nombre, apellidos, edad);

        fechaComienzoInterinidad = fechaInicioInterinidad;
    }

    public Calendar getFechaComienzoInterinidad () {
    	return fechaComienzoInterinidad;
    }
}

/**
 * @(#)Estudiante.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */

public class Estudiante extends Persona {

    private String carrera;
    private int expediente;

    public Estudiante(String nombre, int edad, String carrera, int expediente) {
        super(nombre, edad);
        this.carrera = carrera;
        this.expediente = expediente;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }
}

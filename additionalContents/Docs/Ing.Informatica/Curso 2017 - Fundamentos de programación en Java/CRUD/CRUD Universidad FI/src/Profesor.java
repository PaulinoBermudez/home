
/**
 * @(#)Profesor.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2016/2/19
 */

public class Profesor {

    private String nombre;
    private String apellidos;
    private int dni;

    public Profesor(String nombre, String apellidos, int dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getDni() {
        return dni;
    }

    /**
     * Metodo que imprime la informacion sobre un Profesor.
     *
     */
    public void mostrarInfoProfesor() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellidos: " + getApellidos());
        System.out.println("dni: " + getDni());
        System.out.println();
    }

    public String toString() {
        String mensaje = "\nNombre: " + nombre
                + "\nApellidos: " + apellidos
                + "\nDNI: " + dni;
        return mensaje;
    }
}

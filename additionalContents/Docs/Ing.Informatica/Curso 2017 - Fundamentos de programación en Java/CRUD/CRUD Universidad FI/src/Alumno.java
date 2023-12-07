
/**
 * @(#)Alumno.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2016/2/19
 */

public class Alumno {

    private String nombre;
    private String apellidos;
    private int telefonoContacto;
    private String direccion;

    public Alumno(String nombre,
            String apellidos,
            int telefonoContacto,
            String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefonoContacto = telefonoContacto;
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo que imprime la informacion sobre un Alumno.
     *
     */
    public void mostrarInfoAlumno() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellidos: " + getApellidos());
        System.out.println("Telefono Contacto: " + getTelefonoContacto());
        System.out.println("Direccion: " + getDireccion());
        System.out.println();
    }

    public void mostrarInfoAlumno2() {
        System.out.printf("Nombre: %s, Telefono Contacto: %d \n", getNombre(), getTelefonoContacto());
        System.out.println();
    }

    public String toString() {
        String mensaje = "\nNombre: " + nombre
                + "\nApellidos: " + apellidos
                + "\nTelefono: " + telefonoContacto
                + "\nDireccion: " + direccion;
        return mensaje;
    }
}

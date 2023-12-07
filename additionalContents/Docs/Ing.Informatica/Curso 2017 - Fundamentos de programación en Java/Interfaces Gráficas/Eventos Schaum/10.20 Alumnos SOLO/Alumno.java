
/**
 * @(#)Alumno.java
 *
 *
 * @author
 * @version 1.00 2017/4/25
 */

public class Alumno {

    private String nombre;
    private String apellidos;
    private int annoDeNacimiento;
    private Horario horario;

    public Alumno(String nombre, String apellidos, int annoDeNacimiento, Horario horario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.annoDeNacimiento = annoDeNacimiento;
        this.horario = horario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setannoDeNacimiento(int annoDeNacimiento) {
        this.annoDeNacimiento = annoDeNacimiento;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getNombre() {
        return (this.nombre);
    }

    public String getApellidos() {
        return (this.apellidos);
    }

    public int getannoDeNacimiento() {
        return (this.annoDeNacimiento);
    }

    public Horario getHorario() {
        return (this.horario);
    }

    public String toString() {
        String mensaje = "\nNombre: " + nombre
                + "\nApellidos: " + apellidos
                + "\nNacimiento: " + annoDeNacimiento
                + "\nHorario: " + horario;
        return mensaje;
    }
}

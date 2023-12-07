package Modelo;

public class Alumno {

    private String nombre;
    private int telefono;

    public Alumno(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}

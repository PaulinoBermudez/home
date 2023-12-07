package Modelo;

/**
 *
 * @author Toni
 */
public class Persona {

    private int dni;
    private String nombrePersona;
    private int edadPersona;
    private String profesionPersona;
    private int telefonoPersona;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the nombrePersona
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     * @param nombrePersona the nombrePersona to set
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    /**
     * @return the edadPersona
     */
    public int getEdadPersona() {
        return edadPersona;
    }

    /**
     * @param edadPersona the edadPersona to set
     */
    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    /**
     * @return the profesionPersona
     */
    public String getProfesionPersona() {
        return profesionPersona;
    }

    /**
     * @param profesionPersona the profesionPersona to set
     */
    public void setProfesionPersona(String profesionPersona) {
        this.profesionPersona = profesionPersona;
    }

    /**
     * @return the telefonoPersona
     */
    public int getTelefonoPersona() {
        return telefonoPersona;
    }

    /**
     * @param telefonoPersona the telefonoPersona to set
     */
    public void setTelefonoPersona(int telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }
}


/**
 * @(#)Vehiculos.java
 *
 * @author Antonio Rivero
 * @version 1.00 2017/7/6
 *
 * Creamos la clase Vehiculo
 */

public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    public Vehiculo(String matricula,
            String marca,
            String modelo,
            String color,
            double tarifa) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = false;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

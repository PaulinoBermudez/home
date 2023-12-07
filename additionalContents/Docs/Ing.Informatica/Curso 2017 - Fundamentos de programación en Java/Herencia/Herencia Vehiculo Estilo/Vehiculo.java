
/**
 * @(#)Vehiculo.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/10
 */

public class Vehiculo {

    protected String matricula;
    protected String marca;
    protected String modelo;
    protected String color;
    protected double tarifa = 0.0;
    protected boolean esDisponible;

    public Vehiculo(String matricula,
            String marca,
            String modelo,
            String color,
            double tarifa,
            boolean esDisponible) {

        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.esDisponible = esDisponible;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String imprimirInfo() {
    	
    	String disponible = "";
    	
    	// Covertimos el booleano a String para el toString		
        if (esDisponible) {
            disponible = "Disponible";
        } else {
            disponible = "No Disponible";
        }
    	
    	
        return    " \tMatricula: " + this.matricula
        		+ " \tMarca: " + this.marca
                + " \tModelo: " + this.modelo
                + " \tColor: " + this.color
                + " \tTarifa: " + this.tarifa
                + " \tDisponible: " + disponible;
    }

}

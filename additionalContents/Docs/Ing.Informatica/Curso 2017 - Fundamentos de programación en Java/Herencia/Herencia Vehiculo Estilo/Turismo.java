
/**
 * @(#)Turismo.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/10
 */
public class Turismo extends Vehiculo {

    private int puertas;
    private boolean marchaAutomatica;

    public Turismo(String matricula,
            String marca,
            String modelo,
            String color,
            double tarifa,
            boolean disponible,
            int puertas,
            boolean marchaAutomatica) {

        super(matricula, marca, modelo, color, tarifa, disponible);
        this.puertas = puertas;
        this.marchaAutomatica = marchaAutomatica;
    }

    public int getPuertas() {
        return this.puertas;
    }

    public boolean getMarchaAutomatica() {
        return this.marchaAutomatica;
    }

    public String imprimirInfo() {
        
        String marchaAutomatica = "";
        
        // Covertimos el booleano a String para el toString		
        if (getMarchaAutomatica()) {
            marchaAutomatica = "Marcha Automatica";
        } else {
            marchaAutomatica = "Manual";
        }
        
        return super.imprimirInfo()
                + " \tPuertas: " + this.puertas
                + " \tMarcha automatica: " + marchaAutomatica;
    }
}

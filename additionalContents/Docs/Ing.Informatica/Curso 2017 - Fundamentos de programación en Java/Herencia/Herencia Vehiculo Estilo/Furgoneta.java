
/**
 * @(#)Furgoneta.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/10
 */
public class Furgoneta extends Vehiculo {

    private int carga;
    private int volumen;

    public Furgoneta(String matricula,
            String marca,
            String modelo,
            String color,
            double tarifa,
            boolean disponible,
            int carga,
            int volumen) {

        super(matricula, marca, modelo, color, tarifa, disponible);
        this.carga = carga;
        this.volumen = volumen;
    }

    public int getCarga() {
        return this.carga;
    }

    public int getVolumen() {
        return this.volumen;
    }

    public String imprimirInfo() {
        return super.imprimirInfo()
                + " \tCarga (kg): " + this.carga
                + " \tVolumen (m3): " + this.volumen;
    }
}

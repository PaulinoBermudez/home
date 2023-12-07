
/**
 * @(#)Deportivo.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/10
 */
public class Deportivo extends Vehiculo {

    private int cilindrada;

    public Deportivo(String matricula,
            String marca,
            String modelo,
            String color,
            double tarifa,
            boolean disponible,
            int cilindrada) {

        super(matricula, marca, modelo, color, tarifa, disponible);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return this.cilindrada;
    }

    public String imprimirInfo() {
        return super.imprimirInfo() + " \tCilindrada (cm3): " + cilindrada;
    }
}

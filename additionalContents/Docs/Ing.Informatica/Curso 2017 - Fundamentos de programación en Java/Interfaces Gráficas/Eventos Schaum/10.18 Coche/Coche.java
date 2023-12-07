
import java.util.Formatter;

/**
 * @(#)Coche.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/11
 */
public class Coche {

    private String modelo;
    private String color;
    private boolean esMetalizado;
    private String matricula;
    private TipoDeCoche tipo;
    private int annoDeFabricacion;
    private TipoDeSeguro seguro;

    public Coche(String modelo,
            String color,
            boolean esMetalizado,
            String matricula,
            TipoDeCoche tipo,
            int anno,
            TipoDeSeguro seguro) {
        this.modelo = modelo;
        this.color = color;
        this.esMetalizado = esMetalizado;
        this.matricula = matricula;
        this.tipo = tipo;
        this.annoDeFabricacion = anno;
        this.seguro = seguro;
    }

    public String toString() {
        Formatter formato = new Formatter();
        formato.format("- %10s - %8s - %5d- %6s - %7s - metalizada: %5b - %8s",
                modelo, color, annoDeFabricacion, tipo, matricula, esMetalizado, seguro);
        return formato.toString();
    }
}

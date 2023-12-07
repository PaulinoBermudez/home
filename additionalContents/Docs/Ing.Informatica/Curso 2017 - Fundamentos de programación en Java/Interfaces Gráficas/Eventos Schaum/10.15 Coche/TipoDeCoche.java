
/**
 * @(#)TipoDeCoche.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/11
 */

public enum TipoDeCoche {
    MINI, UTILITARIO, FAMILIAR, DEPORTIVO;
    // devuelve el enumerado a partir de su nombre

    public static TipoDeCoche getTipo(String cadena) {

        return Enum.valueOf(TipoDeCoche.class, cadena.toUpperCase());
    }
}

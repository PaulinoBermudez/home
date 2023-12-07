package Modelo;

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
    private boolean metalizado;
    private String matricula;
    private TipoDeCoche tipo;
    private int annoDeFabricacion;
    private TipoDeSeguro seguro;

    public Coche(String modelo,
            String color,
            boolean metalizado,
            String matricula,
            TipoDeCoche tipo,
            int anno,
            TipoDeSeguro seguro) {
        this.modelo = modelo;
        this.color = color;
        this.metalizado = metalizado;
        this.matricula = matricula;
        this.tipo = tipo;
        this.annoDeFabricacion = anno;
        this.seguro = seguro;
    }

    public boolean esMetalizado() {
        return metalizado;
    }

    public TipoDeCoche getTipo() {
        return tipo;
    }

    public TipoDeSeguro getSeguro() {
        return seguro;
    }

    @Override
    public String toString() {

        String metalizado = "";
        String tipo = "";
        String seguro = "";

        // Covertimos el booleano a String para el toString		
        if (esMetalizado()) {
            metalizado = "Metalizada";
        } else {
            metalizado = "No Metalizada";
        }

        // Covertimos el Enumerado a String para el toString
        if (getTipo() == TipoDeCoche.DEPORTIVO) {
            tipo = "Deportivo";
        } else if (getTipo() == TipoDeCoche.MINI) {
            tipo = "Mini";
        } else if (getTipo() == TipoDeCoche.UTILITARIO) {
            tipo = "Utilitario";
        } else {
            tipo = " Familiar";
        }

        // Covertimos el Enumerado a String para el toString
        if (getSeguro() == TipoDeSeguro.A_TERCEROS) {
            seguro = "A terceros";
        } else {
            seguro = "Todo Riesgo";
        }

        return "Coche: " + "Modelo: " + modelo + ", Color: " + color
                + ", Pintura: " + metalizado + ", Matrícula: " + matricula
                + ", Tipo: " + tipo + ", Año de fabricacion: " + annoDeFabricacion
                + ", Seguro: " + seguro;
    }// FIN DE toString

}//Coche

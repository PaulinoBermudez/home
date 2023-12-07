
import java.io.IOException;

/**
 * Excepciones.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2014/4/17
 */

public class Excepciones {

    public static void main(String[] args) throws IOException {

        int resultado;
        int num1 = 7;
        int num2 = 0;

        try {
            resultado = (num1 / num2);

            System.out.println(resultado);
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre 0");
        } catch (Exception e) {
            System.out.println("Otro Error");
        }
    }
}


/**
 * Excepcion.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2014/4/17
 */

public class Excepcion {

    public static void main(String args[]) {
        try {
            int a = 0;
            System.out.println("a = " + a);
            int b = 42 / a; //Se produce el error
        } catch (ArithmeticException e) { //Se captura la excepción
            System.out.println("No dividas por 0 (" + e + ")");
        }
        System.out.println("La ejecuciÓn sigue ...");
    } //Y sigue la ejecución fuera
}

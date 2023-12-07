
/**
 * ExcepcionArray2.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2014/4/17
 */
public class ExcepcionArray2 {

    public static void main(String args[]) {
        int i;
        int valor = 0;
        String cadenas[] = {"Cadena 1", "Cadena 2", "Cadena 3", "Cadena 4"};
        try {
            for (i = 0; i <= 4; i++) {
                System.out.println(cadenas[i]);
                valor = i / 0;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nError: Fuera del Indice del array\n");
        } catch (Exception e) {
            // Captura cualquier otra excepcion
            System.out.println(e.toString());
        } finally {
            System.out.println("Esto se imprime siempre.");
        }
    }
}

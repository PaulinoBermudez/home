
/**
 * ExcepcionArray.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2014/4/17
 */
 
public class ExcepcionArray {

    public static void main(String args[]) {

        int i = 0;
        String cadenas[] = {"Cadena 1", "Cadena 2", "Cadena 3", "Cadena 4"};

        try {
            for (i = 0; i <= 4; i++) {
                System.out.println(cadenas[i]);
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

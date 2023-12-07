
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @(#)EntradaDatosTeclado.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

public class EntradaDatosTeclado {

    private String nombre;
    private int diaNacimiento;
    private int mesNacimiento;
    private int anioNacimiento;

    public void Datos() {

        try {

            Scanner entradaTeclado = new Scanner(System.in);
            System.out.print("¿Como te llamas? ");
            nombre = entradaTeclado.nextLine();

            System.out.print("¿Que dia naciste? ");
            diaNacimiento = entradaTeclado.nextInt();

            System.out.print("¿En que mes? ");
            mesNacimiento = entradaTeclado.nextInt();

            System.out.print("¿En que año? ");
            anioNacimiento = entradaTeclado.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Error de datos, volver a intentar");
            Datos();
        }
        System.out.println("");

        System.out.println("Hola: " + nombre + ", naciste el "
                + diaNacimiento + "/" + mesNacimiento + "/" + anioNacimiento);
        System.out.println("");

        System.out.println("Imprimimos con printf");
        System.out.printf("Hola: %s, naciste el dia: %d, del mes: %d, y Año: %d, \n",
                nombre, diaNacimiento, mesNacimiento, anioNacimiento);
        System.out.println("");
    }
}


import java.util.Scanner;


/**
 * @(#)Fibonacci.java
 * Declaramos la clase principal
 *
 * @author Antonio Rivero
 * @version 1.00 2015/5/15
 */

public class FibonacciApp {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int op;

        Fibonacci fibonacci = new Fibonacci();

        do {
            System.out.print("");
            System.out.println("Menu");
            System.out.println("");
            System.out.println("Opciones");
            System.out.println("");
            System.out.println("1 - Fibonacci Iterativo.");
            System.out.println("2 - Fibonacci Recursivo.");
            System.out.println("3 - Salir.");
            System.out.println("\n");
            System.out.print("Elija la opcion que desee: ");

            op = leer.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Fibonacci Iterativo. ");
                    fibonacci.FibonacciIterativo();
                    break;
                case 2:
                    System.out.println("Fibonacci Recursivo.");
                    fibonacci.FibonacciRecursivo();
                    break;
                case 3:
                    System.out.println("Salir");
                    break;
            }
        } while (op != 3);
    }
}

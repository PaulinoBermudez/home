
import java.util.Scanner;

/*
 * Programa que calcula la sucesi�n de Fibonacci.
 * Se utiliza se utiliza un algoritmo iterativo.
 * El algoritmo iterativo requiere de un tiempo de orden n.
 */
public class Fibonacci {

    private Scanner teclado = new Scanner(System.in);
    private int fibiter;
    private int fibrecu;

    public void FibonacciIterativo() {
        System.out.print("Introduzca el numero: ");
        fibiter = teclado.nextInt();
        teclado.nextLine(); // para limpiar el buffer del teclado

        int N = fibiter;
        int f = 0;
        int g = 1;

        double timeInicial = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            f = f + g;
            g = f - g;

            System.out.print(f);
            double timeFinal = System.currentTimeMillis();
            System.out.println("\tTiempo: " + (timeFinal - timeInicial) / 1000 + "  s.");
        }

    }

    /*
 * Programa que calcula la sucesi�n de Fibonacci.
 * Se utiliza se utiliza un algoritmo Recursivo.
 * Si utilizamos directamente la definici�n obtendremos
 * un algoritmo con un coste exponencial.
 * El principal problema es que calcular�a varias veces los mismos valores,
 * para evitar esto existe otra opci�n dada por el algoritmo iterativo,
 * que requiere de un tiempo de orden n.
     */
    public void FibonacciRecursivo() {

        System.out.print("Introduzca el numero: ");
        fibrecu = teclado.nextInt();
        teclado.nextLine(); // para limpiar el buffer del teclado

        int N = fibrecu;
        int n = 0;

        double timeInicial = System.currentTimeMillis();
        //int N = Integer.parseInt(args[0]);
        for (int i = 1; i <= N; i++) {

            System.out.print(i + ": " + fib(i));

            //System.out.println();
            double timeFinal = System.currentTimeMillis();
            System.out.println("\tTiempo: " + (timeFinal - timeInicial) / 1000 + "  s.");

        }
    }

    private int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}

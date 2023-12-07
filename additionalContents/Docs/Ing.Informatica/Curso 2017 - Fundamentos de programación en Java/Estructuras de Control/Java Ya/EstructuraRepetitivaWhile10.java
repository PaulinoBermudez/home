import java.util.Scanner;

public class EstructuraRepetitivaWhile10 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int valor,x,suma1,suma2;
        x=1;
        suma1=0;
        suma2=0;
        System.out.println("Primer lista");
        while (x<=15) {
            System.out.print("Ingrese valor:");
            valor=teclado.nextInt();
            suma1=suma1 + valor;
            x=x + 1;
        }
        System.out.println("Segunda lista");
        x=1;
        while (x<=15) {
            System.out.print("Ingrese valor:");
            valor=teclado.nextInt();
            suma2=suma2 + valor;
            x=x + 1;
        }
        if (suma1>suma2) {
            System.out.print("Lista 1 mayor.");
        } else {
            if (suma2>suma1) {
                System.out.print("Lista2 mayor.");
            } else {
                System.out.print("Listas iguales.");
            }
        }
    }
}

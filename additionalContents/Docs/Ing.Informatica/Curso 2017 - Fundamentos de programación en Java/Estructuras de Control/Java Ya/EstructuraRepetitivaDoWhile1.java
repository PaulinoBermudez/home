import java.util.Scanner;

public class EstructuraRepetitivaDoWhile1 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int valor;
        do {
            System.out.print("Ingrese un valor entre 0 y 999 (0 finaliza):");
            valor=teclado.nextInt();
            if (valor>=100) {
                System.out.println("Tiene 3 d�gitos.");
            } else {
                if (valor>=10) {
                    System.out.println("Tiene 2 d�gitos.");
                } else {
                    System.out.println("Tiene 1 d�gito.");
                }
            }
        } while (valor!=0);
    }
}

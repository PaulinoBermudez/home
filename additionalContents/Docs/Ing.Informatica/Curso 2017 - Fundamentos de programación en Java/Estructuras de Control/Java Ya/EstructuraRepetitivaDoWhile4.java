import java.util.Scanner;

public class EstructuraRepetitivaDoWhile4 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int suma,valor;
        suma=0;
        do {
            System.out.print("Ingrese un valor:");
            valor=teclado.nextInt();
            if (valor!=9999) {
                suma=suma+valor;
            }
        }while (valor!=9999);
        System.out.print("El valor acumulado es ");
        System.out.println(suma);
        if (suma==0) {
            System.out.println("El valor acumulado es cero.");
        } else {
            if (suma>0) {
                System.out.println("El valor acumulado es positivo.");
            } else {
                System.out.println("El valor acumulado es negativo");
            }
        }
    }
}

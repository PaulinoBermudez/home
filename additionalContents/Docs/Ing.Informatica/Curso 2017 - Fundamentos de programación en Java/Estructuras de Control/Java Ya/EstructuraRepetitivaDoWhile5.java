import java.util.Scanner;

public class EstructuraRepetitivaDoWhile5 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int cuenta;
        float saldo,suma;
        suma=0;
        do {
            System.out.print("Ingrese número de cuenta:");
            cuenta=teclado.nextInt();
            if (cuenta>=0) {
                System.out.print("Ingrese saldo:");
                saldo=teclado.nextFloat();
                if (saldo>0) {
                    System.out.println("Saldo Acreedor.");
                    suma=suma+saldo;
                } else {
                    if (saldo<0) {
                        System.out.println("Saldo Deudor.");
                    } else {
                        System.out.println("Saldo Nulo.");
                    }
                }
            }
        } while(cuenta>=0);
        System.out.print("Total de saldos Acreedores:");
        System.out.print(suma);
    }
}

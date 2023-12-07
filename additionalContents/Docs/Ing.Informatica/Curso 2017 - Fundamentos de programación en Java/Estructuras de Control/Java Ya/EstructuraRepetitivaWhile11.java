import java.util.Scanner;

public class EstructuraRepetitivaWhile11 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int n,x,valor,pares,impares;
        x=1;
        pares=0;
        impares=0;
        System.out.print("Cuantos números ingresará:");
        n=teclado.nextInt();
        while (x<=n) {
            System.out.print("Ingrese el valor:");
            valor=teclado.nextInt();
            if (valor%2==0) {
                pares=pares + 1;
            } else {
                impares=impares + 1;
            }
            x=x + 1;
        }
        System.out.print("Cantadad de pares:");
        System.out.println(pares);
        System.out.print("Cantidad de impares:");
        System.out.print(impares);
    }
}

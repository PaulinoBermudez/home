import java.util.Scanner;

public class EstructuraRepetitivaFor7 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int f,valor,suma;
        suma=0;
        for(f=1;f<=10;f++) {
            System.out.print("Ingrese un valor:");
            valor=teclado.nextInt();
            if (f>5) {
                suma=suma+valor;
            }
        }
        System.out.print("La suma de los últimos 5 valores es:");
        System.out.print(suma);
    }
}

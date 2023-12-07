import java.util.Scanner;

public class EstructuraRepetitivaFor5 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int cantidad,n,f,valor;
        cantidad=0;
        System.out.print("Cuantos valores ingresará:");
        n=teclado.nextInt();
        for(f=1;f<=n;f++) {
            System.out.print("Ingrese el valor:");
            valor=teclado.nextInt();
            if (valor>=1000) {
                cantidad=cantidad+1;
            }
        }
        System.out.print("La cantidad de valores ingresados mayores o iguales a 1000 son:");
        System.out.print(cantidad);
    }
}

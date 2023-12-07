import java.util.Scanner;

public class EstructuraRepetitivaFor4 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int mul3,mul5,valor,f;
        mul3=0;
        mul5=0;
        for(f=1;f<=10;f++) {
            System.out.print("Ingrese un valor:");
            valor=teclado.nextInt();
            if (valor%3==0) {
                mul3=mul3+1;
            } 
            if (valor%5==0) {
                mul5=mul5+1;
            }
        }
        System.out.print("Cantidad de valores ingresados múltiplos de 3:");
        System.out.println(mul3);
        System.out.print("Cantidad de valores ingresados múltiplos de 5:");
        System.out.print(mul5);
    }
}

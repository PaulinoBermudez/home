import java.util.Scanner;

public class EstructuraCondicionalAnidada2 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int num1,num2,num3;
        System.out.print("Ingrese primer valor:");
        num1=teclado.nextInt();
        System.out.print("Ingrese segunda valor:");
        num2=teclado.nextInt();
        System.out.print("Ingrese tercer valor:");
        num3=teclado.nextInt();
        if (num1>num2) {
            if (num1>num3) {
                System.out.print(num1);
            } else {
                System.out.println(num3);
            }
        } else {
            if (num2>num3) {
                System.out.print(num2);
            } else {
                System.out.print(num3);
            }
        }
    }
}

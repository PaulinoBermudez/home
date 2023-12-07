import java.util.Scanner;

public class CondicionesCompuestas6 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int num1,num2,num3;
        System.out.print("Ingrese primer valor:");
        num1=teclado.nextInt();
        System.out.print("Ingrese segundo valor:");
        num2=teclado.nextInt();
        System.out.print("Ingrese tercer valor:");
        num3=teclado.nextInt();
        if (num1<10 || num2<10 || num3<10) {
            System.out.print("Alguno de los números es menor a diez");
        }
    }
}

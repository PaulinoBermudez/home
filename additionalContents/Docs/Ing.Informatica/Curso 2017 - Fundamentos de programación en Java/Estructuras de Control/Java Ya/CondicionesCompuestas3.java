import java.util.Scanner;

public class CondicionesCompuestas3 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int dia,mes,a�o;
        System.out.print("Ingrese nro de d�a:");
        dia=teclado.nextInt();
        System.out.print("Ingrese nro de mes:");
        mes=teclado.nextInt();
        System.out.print("Ingrese nro de a�o:");
        a�o=teclado.nextInt();
        if (mes==12 && dia==25) {
            System.out.print("La fecha ingresada corresponde a navidad.");
        }
    }
}

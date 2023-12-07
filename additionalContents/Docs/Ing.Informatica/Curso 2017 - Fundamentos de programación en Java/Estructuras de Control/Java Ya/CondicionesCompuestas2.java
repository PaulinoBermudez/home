import java.util.Scanner;

public class CondicionesCompuestas2 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int dia,mes,año;
        System.out.print("Ingrese nro de día:");
        dia=teclado.nextInt();
        System.out.print("Ingrese nro de mes:");
        mes=teclado.nextInt();
        System.out.print("Ingrese nro de año:");
        año=teclado.nextInt();
        if (mes==1 || mes==2 || mes==3) {
            System.out.print("Corresponde al primer trimestre");
        }
    }
}

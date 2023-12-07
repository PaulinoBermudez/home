import java.util.Scanner;

public class EstructuraRepetitivaFor3 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int aprobados,suspensos,f,nota;
        aprobados=0;
        suspensos=0;
        for(f=1;f<=10;f++) {
            System.out.print("Ingrese la nota:");
            nota=teclado.nextInt();
            if (nota>=7) {
                aprobados=aprobados+1;
            } else {
            	suspensos=suspensos+1;
            }
        }
        System.out.print("Cantidad de aprobados:");
        System.out.println(aprobados);
        System.out.print("Cantidad de suspensos:");
        System.out.print(suspensos);
    }
}

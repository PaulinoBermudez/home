import java.util.Scanner;

public class EstructuraCondicionalAnidada4 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int num;
        System.out.print("Ingrese un valor de hasta tres d�gitos positivo:");
        num=teclado.nextInt();
        if (num<10) {
	    System.out.print("Tiene un d�gito");
        }
        else {
            if (num<100) {
                System.out.print("Tiene dos d�gitos");
            } else {
                if (num<1000) {
                    System.out.print("Tiene tres d�gitos");
                } else {
                    System.out.print("Error en la entrada de datos.");
                }
            }
        }
    } 
}

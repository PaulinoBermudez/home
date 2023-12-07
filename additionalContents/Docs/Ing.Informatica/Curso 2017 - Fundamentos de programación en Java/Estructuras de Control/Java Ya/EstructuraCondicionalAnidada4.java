import java.util.Scanner;

public class EstructuraCondicionalAnidada4 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int num;
        System.out.print("Ingrese un valor de hasta tres dígitos positivo:");
        num=teclado.nextInt();
        if (num<10) {
	    System.out.print("Tiene un dígito");
        }
        else {
            if (num<100) {
                System.out.print("Tiene dos dígitos");
            } else {
                if (num<1000) {
                    System.out.print("Tiene tres dígitos");
                } else {
                    System.out.print("Error en la entrada de datos.");
                }
            }
        }
    } 
}

import java.util.Scanner;

public class EstructuraCondicionalCompuesta3 {
    public static void main(String[] args) {
    	Scanner teclado=new Scanner(System.in);
    	int num;
    	System.out.print("Ingrese un valor entero de 1 o 2 d�gitos:");
    	num=teclado.nextInt();
    	if (num<10) {
    	    System.out.print("Tiene un d�gito");
    	} else {
    	    System.out.print("Tiene dos d�gitos");
    	}
    }
}

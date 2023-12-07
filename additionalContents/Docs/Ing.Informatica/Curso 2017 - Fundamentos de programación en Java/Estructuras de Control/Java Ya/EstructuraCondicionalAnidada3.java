import java.util.Scanner;

public class EstructuraCondicionalAnidada3 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int num;
        System.out.print("Ingrese un valor:");
        num=teclado.nextInt();
        if (num==0) {
	    System.out.print("Se ingresó el cero");
	} else {
	    if (num>0) {
	        System.out.print("Se ingresó un valor positivo");
	    } else {
	        System.out.print("Se ingresó un valor negativo");
	    }
	}
    } 
}

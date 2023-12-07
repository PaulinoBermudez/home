import java.util.Scanner;

public class EstructuraCondicionalCompuesta1 {
    public static void main(String[] args) {
    	Scanner teclado=new Scanner(System.in);
    	int num1,num2;
    	System.out.print("Ingrese primer valor:");
    	num1=teclado.nextInt();
    	System.out.print("Ingrese segundo valor:");
    	num2=teclado.nextInt();
    	if (num1>num2) {
    		System.out.print(num1);
    	} else {
    		System.out.print(num2);
    	}
    }
}
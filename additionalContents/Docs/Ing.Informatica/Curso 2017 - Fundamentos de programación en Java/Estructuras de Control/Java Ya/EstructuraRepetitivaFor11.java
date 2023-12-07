import java.util.Scanner;

public class EstructuraRepetitivaFor11 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int f,valor,negativos,positivos,mult15,sumapares;
        negativos=0;
        positivos=0;
        mult15=0;
        sumapares=0;
        for(f=1;f<=10;f++) {
            System.out.print("Ingrese valor:");
            valor=teclado.nextInt();
            if (valor<0) {
                negativos++;
            } else {
            	if (valor>0) {
            		positivos++;
            	}
            }
            if (valor%15==0) {
            	mult15++;
            }
            if (valor%2==0) {
            	sumapares=sumapares+valor;
            }
        }
        System.out.print("Cantidad de valores negativos:");
        System.out.println(negativos);
        System.out.print("Cantidad de valores positivos:");
        System.out.println(positivos);
        System.out.print("Cantidad de valores múltiplos de 15:");
        System.out.println(mult15);
        System.out.print("Suma de los valores pares:");
        System.out.println(sumapares);        
    }
}


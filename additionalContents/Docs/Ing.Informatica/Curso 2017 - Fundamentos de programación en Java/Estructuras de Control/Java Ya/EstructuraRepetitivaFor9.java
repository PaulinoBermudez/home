import java.util.Scanner;

public class EstructuraRepetitivaFor9 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int f,lado1,lado2,lado3,cant1,cant2,cant3,n;
        cant1=0;
        cant2=0;
        cant3=0;
        System.out.print("Ingrese la cantidad de triángulos:");
        n=teclado.nextInt();
        for(f=1;f<=n;f++) {
           System.out.print("Ingrese lado 1:");
           lado1=teclado.nextInt();
           System.out.print("Ingrese lado 2:");
           lado2=teclado.nextInt();
           System.out.print("Ingrese lado 3:");
           lado3=teclado.nextInt();
           if (lado1==lado2 && lado1==lado3) {
               System.out.println("Es un triángulo equilatero.");
               cant1++;
           } else {
               if (lado1==lado2 || lado1==lado3 || lado2==lado3) {
                   System.out.println("Es un triángulo isósceles.");
                   cant2++;
               }  else {
            	   cant3++;
                   System.out.println("Es un triángulo escaleno.");
               }
           }
        }
        System.out.print("Cantidad de triángulos equilateros:");
        System.out.println(cant1);
        System.out.print("Cantidad de triángulos isósceles:");
        System.out.println(cant2);
        System.out.print("Cantidad de triángulos escalenos:");
        System.out.println(cant3);
        if (cant1<cant2 && cant1<cant3) {
            System.out.print("Hay menor cantidad de triángulos equilateros.");
        } else {
            if (cant2<cant3) {
                System.out.print("Han menor cantidad de triángulos isósceles");	
            } else {
                System.out.print("Han menor cantidad de triángulos escalenos");	                
            }
        }    
    }
}

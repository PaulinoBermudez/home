import java.util.Scanner;

public class EstructuraRepetitivaFor9 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int f,lado1,lado2,lado3,cant1,cant2,cant3,n;
        cant1=0;
        cant2=0;
        cant3=0;
        System.out.print("Ingrese la cantidad de tri�ngulos:");
        n=teclado.nextInt();
        for(f=1;f<=n;f++) {
           System.out.print("Ingrese lado 1:");
           lado1=teclado.nextInt();
           System.out.print("Ingrese lado 2:");
           lado2=teclado.nextInt();
           System.out.print("Ingrese lado 3:");
           lado3=teclado.nextInt();
           if (lado1==lado2 && lado1==lado3) {
               System.out.println("Es un tri�ngulo equilatero.");
               cant1++;
           } else {
               if (lado1==lado2 || lado1==lado3 || lado2==lado3) {
                   System.out.println("Es un tri�ngulo is�sceles.");
                   cant2++;
               }  else {
            	   cant3++;
                   System.out.println("Es un tri�ngulo escaleno.");
               }
           }
        }
        System.out.print("Cantidad de tri�ngulos equilateros:");
        System.out.println(cant1);
        System.out.print("Cantidad de tri�ngulos is�sceles:");
        System.out.println(cant2);
        System.out.print("Cantidad de tri�ngulos escalenos:");
        System.out.println(cant3);
        if (cant1<cant2 && cant1<cant3) {
            System.out.print("Hay menor cantidad de tri�ngulos equilateros.");
        } else {
            if (cant2<cant3) {
                System.out.print("Han menor cantidad de tri�ngulos is�sceles");	
            } else {
                System.out.print("Han menor cantidad de tri�ngulos escalenos");	                
            }
        }    
    }
}

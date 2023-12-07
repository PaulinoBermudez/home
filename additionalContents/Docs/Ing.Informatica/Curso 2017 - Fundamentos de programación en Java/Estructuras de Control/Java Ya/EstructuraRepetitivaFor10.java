import java.util.Scanner;

public class EstructuraRepetitivaFor10 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int n,f,x,y,cant1,cant2,cant3,cant4;
        cant1=0;
        cant2=0;
        cant3=0;
        cant4=0;
        System.out.print("Cantidad de puntos:");
        n=teclado.nextInt();
        for(f=1;f<=n;f++) {
            System.out.print("Ingrese coordenada x:");
            x=teclado.nextInt();
            System.out.print("Ingrese coordenada y:");
            y=teclado.nextInt();
            if (x>0 && y>0) {
                cant1++;
            } else {
                if (x<0 && y>0) {
                    cant2++;
                } else {
                    if (x<0 && y<0) {
                        cant3++;
                    } else {
                        if (x>0 && y<0) {
                        	cant4++;
                        }
                    }
                }
            }
        }
        System.out.print("Cantidad de puntos en el primer cuadrante:");
        System.out.println(cant1);
        System.out.print("Cantidad de puntos en el segundo cuadrante:");
        System.out.println(cant2);
        System.out.print("Cantidad de puntos en el tercer cuadrante:");
        System.out.println(cant3);
        System.out.print("Cantidad de puntos en el cuarto cuadrante:");
        System.out.println(cant4);
    }
}


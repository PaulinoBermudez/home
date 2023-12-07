import java.util.Scanner;

public class EstructuraRepetitivaFor12 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int f,edad,suma1,suma2,suma3,pro1,pro2,pro3;
        suma1=0;
        suma2=0;
        suma3=0;
        for(f=1;f<=50;f++) {
            System.out.print("Ingrese edad:");
            edad=teclado.nextInt();
            suma1=suma1+edad;
        }
        pro1=suma1/50;
        System.out.print("Promedio de edades del turno mañana:");
        System.out.println(pro1);
        for(f=1;f<=60;f++) {
            System.out.print("Ingrese edad:");
            edad=teclado.nextInt();
            suma2=suma2+edad;
        }
        pro2=suma2/60;
        System.out.print("Promedio de edades del turno tarde:");
        System.out.println(pro2);
        for(f=1;f<=110;f++) {
            System.out.print("Ingrese edad:");
            edad=teclado.nextInt();
            suma3=suma3+edad;
        }
        pro3=suma3/110;
        System.out.print("Promedio de edades del turno noche:");
        System.out.println(pro3);
        if (pro1<pro2 && pro1<pro3) {
          System.out.print("El turno mañana tiene un promedio menor de edades.");
        } else {
            if (pro2<pro3) {
            System.out.print("El turno tarde tiene un promedio menor de edades.");
            } else {
            System.out.print("El turno noche tiene un promedio menor de edades.");
            }
        }
    }
}

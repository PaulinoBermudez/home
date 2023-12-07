import java.util.Scanner;

public class EstructuraRepetitivaFor6 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int base,altura,superficie,cantidad,f,n;
        cantidad=0;
        System.out.print("Cuantos triángulos procesará:");
        n=teclado.nextInt();
        for(f=1;f<=n;f++) {
            System.out.print("Ingrese el valor de la base:");
            base=teclado.nextInt();
            System.out.print("Ingrese el valor de la altura:");
            altura=teclado.nextInt();
            superficie=base*altura/2;
            System.out.print("La superficie es:");
            System.out.println(superficie);
            if (superficie>12) {
                cantidad=cantidad+1;
            }
        }
  System.out.print("La cantidad de triángulos con superficie superior a 12 son:");
        System.out.print(cantidad);
    }
}

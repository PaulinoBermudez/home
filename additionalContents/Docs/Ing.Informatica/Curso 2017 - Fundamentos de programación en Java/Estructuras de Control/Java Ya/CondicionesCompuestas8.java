import java.util.Scanner;

public class CondicionesCompuestas8 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        float sueldo;
        int antiguedad;
        System.out.print("Ingrese sueldo del empleado:");
        sueldo=teclado.nextFloat();
        System.out.print("Ingrese su antiguedad en años:");
        antiguedad=teclado.nextInt();
        if (sueldo<500 && antiguedad>10) {
            float aumento=sueldo * 0.20f;
            float sueldoTotal=sueldo+aumento;
            System.out.print("Sueldo a pagar:");
            System.out.print(sueldoTotal);
        } else {
            if (sueldo<500) {
                float aumento=sueldo * 0.05f;
                float sueldoTotal=sueldo+aumento;
                System.out.print("Sueldo a pagar:");
                System.out.print(sueldoTotal);            
            } else {
            	System.out.print("Sueldo a pagar:");
                System.out.print(sueldo);
            }
        }
    }
}    

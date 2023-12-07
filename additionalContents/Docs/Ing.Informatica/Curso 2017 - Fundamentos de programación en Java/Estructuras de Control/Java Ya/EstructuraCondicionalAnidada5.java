import java.util.Scanner;

public class EstructuraCondicionalAnidada5 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int totalPreguntas,totalCorrectas;
        System.out.print("Ingrese la cantidad total de preguntas del examen:");
        totalPreguntas=teclado.nextInt();
        System.out.print("Ingrese la cantidad total de preguntas contestadas correctamente:");
        totalCorrectas=teclado.nextInt();
        int porcentaje=totalCorrectas * 100 / totalPreguntas;
        if (porcentaje>=90) {
            System.out.print("Nivel máximo");
        } else {
            if (porcentaje>=75) {
                System.out.print("Nivel medio");
            } else {
                if (porcentaje>=50) {
                    System.out.print("Nivel regular");
                } else {
                    System.out.print("Fuera de nivel");
                }
            }
        }
    } 
}

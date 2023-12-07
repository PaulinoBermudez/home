package Vista;

import java.util.Scanner;

public class MenuProfesor {

    private int opcionProfesor;

    public int getOpcionProfesor() {
        return opcionProfesor;
    }

    public void menuProfesor() {
        // Muestro el menu de opciones y recojo la escogida
        System.out.println("");
        System.out.println("GESTION DE PROFESORES");
        System.out.println("=================");
        System.out.println("¿Que desea?:");
        System.out.println("1 Crear Profesor.");
        System.out.println("2 Actualizar Profesor");
        System.out.println("3 Eliminar Profesor");
        System.out.println("4 Leer datos");
        System.out.println("5 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Por favor, introduzca el numero de la opcion deseada:");
        opcionProfesor = teclado.nextInt();
        System.out.println("");
    }
}

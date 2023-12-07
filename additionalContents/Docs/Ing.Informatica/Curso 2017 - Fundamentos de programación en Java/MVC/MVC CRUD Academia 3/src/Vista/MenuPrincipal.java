package Vista;

import java.util.Scanner;

public class MenuPrincipal {

    private int opcionPrincipal;

    public int getOpcionPrincipal() {
        return opcionPrincipal;
    }

    public void menuPrincipal() {
        // Muestro el menu de opciones y recojo la escogida
        System.out.println("");
        System.out.println("MENU PRINCIPAL");
        System.out.println("=================");
        System.out.println("Seleccionar Opción:");
        System.out.println("1 Gestionar Alumnos.");
        System.out.println("2 Gestionar Profesores");
        System.out.println("3 Salir de la aplicacion");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Por favor, introduzca el numero de la opcion deseada:");
        opcionPrincipal = teclado.nextInt();
        System.out.println("");
    }
}

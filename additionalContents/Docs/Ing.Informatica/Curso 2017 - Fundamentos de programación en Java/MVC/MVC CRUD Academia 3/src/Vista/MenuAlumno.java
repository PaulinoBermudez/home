package Vista;

import java.util.Scanner;

public class MenuAlumno {

    private int opcionAlumno;

    public int getOpcionAlumno() {
        return opcionAlumno;
    }

    public void menuAlumno() {
        // Muestro el menu de opciones y recojo la escogida
        System.out.println("");
        System.out.println("GESTION DE ALUMNOS");
        System.out.println("=================");
        System.out.println("¿Que desea?:");
        System.out.println("1 Crear Alumno.");
        System.out.println("2 Actualizar Alumno");
        System.out.println("3 Eliminar Alumno");
        System.out.println("4 Leer datos");
        System.out.println("5 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Por favor, introduzca el numero de la opcion deseada:");
        opcionAlumno = teclado.nextInt();
        System.out.println("");
    }
}

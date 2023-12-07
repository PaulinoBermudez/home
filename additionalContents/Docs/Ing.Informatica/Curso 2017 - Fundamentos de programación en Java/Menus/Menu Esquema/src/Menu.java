
import java.util.Scanner;

/**
 *
 * @author Antonio Rivero Cuesta
 */
public class Menu {

    private int opcionPrincipal;
    private int opcion1;
    private int opcion2;
    private int opcion3;
    private int opcion4;

    public void gestionMenuPrincipal() {
        do {
            menuPrincipal();
            switch (opcionPrincipal) {
                case 1:
                    gestionClase1();
                    break;
                case 2:
                    gestionClase2();
                    break;
                case 3:
                    gestionClase3();
                    break;
                case 4:
                    gestionClase4();
                    break;
                case 5:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcionPrincipal != 5);
    }

    public void menuPrincipal() {
        System.out.println("");
        System.out.println("Menu Principal");
        System.out.println("=================");
        System.out.println("Seleccionar Opción:");
        System.out.println("1 Opción 1.");
        System.out.println("2 Opción 2.");
        System.out.println("3 Opción 3.");
        System.out.println("4 Opción 4.");
        System.out.println("5 Salir de la aplicacion");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el número de la opción deseada: ");
        opcionPrincipal = teclado.nextInt();
        System.out.println("");
    }

    public void gestionClase1() {
        Clase1 clase1 = new Clase1();
        do {
            menuClase1();
            switch (opcion1) {
                case 1:
                    clase1.metodo1();
                    break;
                case 2:
                    clase1.metodo2();
                    break;
                case 3:
                    clase1.metodo3();
                    break;
                case 4:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcion1 != 4);
    }

    public void menuClase1() {
        System.out.println("");
        System.out.println("Gestión de menú Clase 1");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 Metodo 1.");
        System.out.println("2 Metodo 2.");
        System.out.println("3 Metodo 3.");
        System.out.println("4 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el número de la opción deseada: ");
        opcion1 = teclado.nextInt();
        System.out.println("");
    }

    public void gestionClase2() {
        Clase2 clase2 = new Clase2();
        do {
            menuClase2();
            switch (opcion2) {
                case 1:
                    clase2.metodo1();
                    break;
                case 2:
                    clase2.metodo2();
                    break;
                case 3:
                    clase2.metodo3();
                    break;
                case 4:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcion2 != 4);
    }

    public void menuClase2() {
        System.out.println("");
        System.out.println("Gestión de menú Clase 2");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 Metodo 1.");
        System.out.println("2 Metodo 2.");
        System.out.println("3 Metodo 3.");
        System.out.println("4 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el número de la opción deseada: ");
        opcion2 = teclado.nextInt();
        System.out.println("");
    }

    public void gestionClase3() {
        Clase3 clase3 = new Clase3();
        do {
            menuClase3();
            switch (opcion3) {
                case 1:
                    clase3.metodo1();
                    break;
                case 2:
                    clase3.metodo2();
                    break;
                case 3:
                    clase3.metodo3();
                    break;
                case 4:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcion3 != 4);
    }

    public void menuClase3() {
        System.out.println("");
        System.out.println("Gestión de menú Clase 3");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 Metodo 1.");
        System.out.println("2 Metodo 2.");
        System.out.println("3 Metodo 3.");
        System.out.println("4 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el número de la opción deseada: ");
        opcion3 = teclado.nextInt();
        System.out.println("");
    }

    public void gestionClase4() {
        Clase4 clase4 = new Clase4();
        do {
            menuClase4();
            switch (opcion4) {
                case 1:
                    clase4.metodo1();
                    break;
                case 2:
                    clase4.metodo2();
                    break;
                case 3:
                    clase4.metodo3();
                    break;
                case 4:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcion4 != 4);
    }

    public void menuClase4() {
        System.out.println("");
        System.out.println("Gestión de menú Clase 4");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 Metodo 1.");
        System.out.println("2 Metodo 2.");
        System.out.println("3 Metodo 3.");
        System.out.println("4 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el número de la opción deseada: ");
        opcion4 = teclado.nextInt();
        System.out.println("");
    }
}

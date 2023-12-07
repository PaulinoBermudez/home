
import java.util.Scanner;

/**
 *
 * @author Toni
 */
public class Menu {

    private ProfesorDao pdao = new ProfesorDao();
    private AlumnoDao adao = new AlumnoDao();
    private int opcionPrincipal;
    private int opcionAlumno;
    private int opcionProfesor;

    public void gestionMenuPrincipal() {
        do { // Repito la siguiente ejecucion mientras el usuario no marque la opcion de salir del programa
            menuPrincipal();
            switch (opcionPrincipal) {
                case 1:
                    gestionMenuAlumno();
                    break;
                case 2:
                    gestionMenuProfesor();
                    break;
                case 3:
                    System.out.println("Salir");
                    break;
                // En cualquier otro caso, muestro un mensaje pidiendo que se introduzca una opcion contemplada en el menu
                default:
                    System.out.println("Por favor, introduzca una opcion valida.");
                    break;
            }
        } while (opcionPrincipal != 3);
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

    public void gestionMenuAlumno() {
        do {
            menuAlumno();
            switch (opcionAlumno) {
                case 1:
                    adao.Crear();
                    break;
                case 2:
                    adao.Actualizar();
                    break;
                case 3:
                    adao.Eliminar();
                    break;
                case 4:
                    adao.Leer();
                    break;
                case 5:
                    System.out.println("Volver");
                    break;
                // En cualquier otro caso, muestro un mensaje pidiendo que se introduzca una opcion contemplada en el menu
                default:
                    System.out.println("Por favor, introduzca una opcion valida.");
                    break;
            }
        } while (opcionAlumno != 5);
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

    public void gestionMenuProfesor() {
        do {
            menuProfesor();
            switch (opcionProfesor) {
                case 1:
                    pdao.Crear();
                    break;
                case 2:
                    pdao.Actualizar();
                    break;
                case 3:
                    pdao.Eliminar();
                    break;
                case 4:
                    pdao.Leer();
                    break;
                case 5:
                    System.out.println("Volver");
                    break;
                // En cualquier otro caso, muestro un mensaje pidiendo que se introduzca una opcion contemplada en el menu
                default:
                    System.out.println("Por favor, introduzca una opcion valida.");
                    break;
            }
        } while (opcionProfesor != 5);
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

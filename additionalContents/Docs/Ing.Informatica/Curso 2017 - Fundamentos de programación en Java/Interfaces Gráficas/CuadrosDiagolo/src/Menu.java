
import java.util.Scanner;

/**
 *
 * @author Antonio Rivero Cuesta
 */
public class Menu {

    MessageDialog md = new MessageDialog();
    ConfirmDialog cd = new ConfirmDialog();
    InputDialog id = new InputDialog();
    OptionDialog od = new OptionDialog();

    private int opcionPrincipal;
    private int opcionMessageDialog;
    private int opcionConfirmDialog;
    private int opcionInputDialog;
    private int opcionOptionDialog;

    public void gestionMenuPrincipal() {
        do {
            menuPrincipal();
            switch (opcionPrincipal) {
                case 1:
                    gestionMessageDialog();
                    break;
                case 2:
                    gestionConfirmDialog();
                    break;
                case 3:
                    gestionInputDialog();
                    break;
                case 4:
                    gestionOptionDialog();
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
        System.out.println("Menu Principal Cuadros de Diálogo");
        System.out.println("=================");
        System.out.println("Seleccionar Opción:");
        System.out.println("1 Opción MessageDialog.");
        System.out.println("2 Opción ConfirmDialog.");
        System.out.println("3 Opción InputDialog.");
        System.out.println("4 Opción OptionDialog.");
        System.out.println("5 Salir de la aplicacion");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el numero de la opción deseada: ");
        opcionPrincipal = teclado.nextInt();
        System.out.println("");
    }

    public void gestionMessageDialog() {
        do {
            menuMessageDialog();
            switch (opcionMessageDialog) {
                case 1:
                    md.MensajeDos();
                    break;
                case 2:
                    md.MensajeCuatro();
                    break;
                case 3:
                    md.VentanaDialogo();
                    break;
                case 4:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcionMessageDialog != 4);
    }

    public void menuMessageDialog() {
        System.out.println("");
        System.out.println("Gestión de menú MessageDialog");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 DOS - Mensaje Dos.");
        System.out.println("2 CUATRO - Mensaje Cuatro");
        System.out.println("3 CINCO - Ventana Dialogo");
        System.out.println("4 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el numero de la opción deseada: ");
        opcionMessageDialog = teclado.nextInt();
        System.out.println("");
    }

    public void gestionConfirmDialog() {
        do {
            menuConfirmDialog();
            switch (opcionConfirmDialog) {
                case 1:
                    cd.Confirmado();
                    break;
                case 2:
                    cd.EjecutarAplicacion();
                    break;
                case 3:
                    cd.CursoJava();
                    break;
                case 4:
                    cd.JuegoEstrategia();
                    break;
                case 5:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcionConfirmDialog != 5);
    }

    public void menuConfirmDialog() {
        System.out.println("");
        System.out.println("Gestión de menú ConfirmDialog");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 DOS - Confirmado.");
        System.out.println("2 CUATRO - Ejecutar Aplicacion");
        System.out.println("3 CINCO - Curso Java UNED");
        System.out.println("4 SEIS - Juegos Estrategia");
        System.out.println("5 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el numero de la opción deseada: ");
        opcionConfirmDialog = teclado.nextInt();
        System.out.println("");
    }

    public void gestionInputDialog() {
        do {
            menuInputDialog();
            switch (opcionInputDialog) {
                case 1:
                    id.UnParametro();
                    break;
                case 2:
                    id.EscribeNombre();
                    break;
                case 3:
                    id.EscribirTexto();
                    break;
                case 4:
                    id.CajaTexto();
                    break;
                case 5:
                    id.IntroducirDato();
                    break;
                case 6:
                    id.ComboMecanico();
                    break;
                case 7:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcionInputDialog != 7);
    }

    public void menuInputDialog() {
        System.out.println("");
        System.out.println("Gestión de menú InputDialog");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 UNO - Un Parametro");
        System.out.println("2 DOS - Escribe Nombre");
        System.out.println("3 DOS - Escribir Texto");
        System.out.println("4 TRES - Caja Texto");
        System.out.println("5 CUATRO - Introducir Dato");
        System.out.println("6 SIETE - Combo Mecanico");
        System.out.println("7 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el numero de la opción deseada: ");
        opcionInputDialog = teclado.nextInt();
        System.out.println("");
    }

    public void gestionOptionDialog() {
        do {
            menuOptionDialog();
            switch (opcionOptionDialog) {
                case 1:
                    od.Opciones();
                    break;
                case 2:
                    od.Options();
                    break;
                case 3:
                    od.Alumno();
                    break;
                case 4:
                    od.Medidas();
                    break;
                case 5:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcionOptionDialog != 5);
    }

    public void menuOptionDialog() {
        System.out.println("");
        System.out.println("Gestión de menú OptionDialog");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 OCHO - Opciones.");
        System.out.println("2 OCHO - Options.");
        System.out.println("3 OCHO - Alumno.");
        System.out.println("4 OCHO - Medidas.");
        System.out.println("5 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el numero de la opción deseada: ");
        opcionOptionDialog = teclado.nextInt();
        System.out.println("");
    }
}

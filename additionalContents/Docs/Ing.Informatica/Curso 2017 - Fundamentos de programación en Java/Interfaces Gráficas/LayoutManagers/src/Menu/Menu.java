package Menu;

import Modelo.BorderLayoutEjemplo;
import Modelo.BoxLayoutEjemplo;
import Modelo.FlowLayoutEjemplo;
import Modelo.GridLayoutEjemplo;
import Vista.VistaLayout;
import java.util.Scanner;

/**
 *
 * @author Antonio Rivero Cuesta
 */
public class Menu {

    private final BorderLayoutEjemplo border = new BorderLayoutEjemplo();
    private final BoxLayoutEjemplo box = new BoxLayoutEjemplo();
    private final FlowLayoutEjemplo flow = new FlowLayoutEjemplo();
    private final GridLayoutEjemplo grid = new GridLayoutEjemplo();

    private int opcionPrincipal;
    private int opcionBorderLayout;
    private int opcionBoxLayout;
    private int opcionFlowLayout;
    private int opcionGridLayout;

    public void gestionMenuPrincipal() {
        do {
            menuPrincipal();
            switch (opcionPrincipal) {
                case 1:
                    gestionBorderLayout();
                    break;
                case 2:
                    gestionBoxLayout();
                    break;
                case 3:
                    gestionFlowLayout();
                    break;
                case 4:
                    gestionGridLayout();
                    break;
                case 5:
                    VistaLayout vista = new VistaLayout();
                    vista.setVisible(true);
                    vista.setLocationRelativeTo(null);
                    break;
                case 6:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcionPrincipal != 6);
    }

    public void menuPrincipal() {
        System.out.println("");
        System.out.println("Menu Principal Layout Managers");
        System.out.println("=================");
        System.out.println("Seleccionar Opción:");
        System.out.println("1 Opción BorderLayout.");
        System.out.println("2 Opción BoxLayout.");
        System.out.println("3 Opción FlowLayout.");
        System.out.println("4 Opción GridLayout.");
        System.out.println("5 Interface Gráfica.");
        System.out.println("6 Salir de la aplicacion");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el número de la opción deseada: ");
        opcionPrincipal = teclado.nextInt();
        System.out.println("");
    }

    public void gestionBorderLayout() {
        do {
            menuBorderLayout();
            switch (opcionBorderLayout) {
                case 1:
                    border.BorderLayout1();
                    break;
                case 2:
                    border.BorderLayout2();
                    break;
                case 3:
                    border.BorderLayout3();
                    break;
                case 4:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcionBorderLayout != 4);
    }

    public void menuBorderLayout() {
        System.out.println("");
        System.out.println("Gestión de menú BorderLayout");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 BorderLayout 1.");
        System.out.println("2 BorderLayout 2.");
        System.out.println("3 BorderLayout 3.");
        System.out.println("4 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el número de la opción deseada: ");
        opcionBorderLayout = teclado.nextInt();
        System.out.println("");
    }

    public void gestionBoxLayout() {
        do {
            menuBoxLayout();
            switch (opcionBoxLayout) {
                case 1:
                    box.BoxLayout1();
                    break;
                case 2:
                    box.BoxLayout2();
                    break;
                case 3:
                    box.BoxLayout3();
                    break;
                case 4:
                    //cd.JuegoEstrategia();
                    break;
                case 5:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcionBoxLayout != 5);
    }

    public void menuBoxLayout() {
        System.out.println("");
        System.out.println("Gestión de menú BoxLayout");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 BoxLayout 1.");
        System.out.println("2 BoxLayout 2.");
        System.out.println("3 BoxLayout 3.");
        System.out.println("4 xxxxxx");
        System.out.println("5 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el número de la opción deseada: ");
        opcionBoxLayout = teclado.nextInt();
        System.out.println("");
    }

    public void gestionFlowLayout() {
        do {
            menuFlowLayout();
            switch (opcionFlowLayout) {
                case 1:
                    flow.FlowLayout1();
                    break;
                case 2:
                    flow.FlowLayout2();
                    break;
                case 3:
                    //id.EscribirTexto();
                    break;
                case 4:
                    //id.CajaTexto();
                    break;
                case 5:
                    //id.IntroducirDato();
                    break;
                case 6:
                    //id.ComboMecanico();
                    break;
                case 7:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcionFlowLayout != 7);
    }

    public void menuFlowLayout() {
        System.out.println("");
        System.out.println("Gestión de menú FlowLayout");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 FlowLayout 1.");
        System.out.println("2 FlowLayout 2.");
        System.out.println("3 xxxxxx");
        System.out.println("4 xxxxxx");
        System.out.println("5 xxxxxx");
        System.out.println("6 xxxxxx");
        System.out.println("7 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el número de la opción deseada: ");
        opcionFlowLayout = teclado.nextInt();
        System.out.println("");
    }

    public void gestionGridLayout() {
        do {
            menuGridLayout();
            switch (opcionGridLayout) {
                case 1:
                    grid.GridLayout1();
                    break;
                case 2:
                    grid.GridLayout2();
                    break;
                case 3:
                    grid.GridLayout3();
                    break;
                case 4:
                    System.out.println("GridLayout 4");
                    break;
                case 5:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Introducir una opción válida.");
                    break;
            }
        } while (opcionGridLayout != 5);
    }

    public void menuGridLayout() {
        System.out.println("");
        System.out.println("Gestión de menú GridLayout");
        System.out.println("=================");
        System.out.println("Opciones");
        System.out.println("1 GridLayout 1.");
        System.out.println("2 GridLayout 2.");
        System.out.println("3 GridLayout 3.");
        System.out.println("4 xxxx.");
        System.out.println("5 Volver al Menu Principal");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introducir el número de la opción deseada: ");
        opcionGridLayout = teclado.nextInt();
        System.out.println("");
    }
}

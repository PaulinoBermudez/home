
import java.util.Scanner;

/**
 *
 * @author Toni
 */
public class Menu {

    Scanner teclado = new Scanner(System.in);
    ProfesorDao pdao = new ProfesorDao();
    private int opcionProfesor;

    public void gestionMenuPrincipal() {
        do {
            menuPrincipal();
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
                    System.out.println("Saliendo ... ");
                    System.exit(0);// Salimos de la aplicación
            }
        } while (opcionProfesor != 5);
    }

    public void menuPrincipal() {
        System.out.println("Elija una opción: ");
        System.out.println("1.Crear");
        System.out.println("2.Actualizar");
        System.out.println("3.Eliminar");
        System.out.println("4.Leer datos");
        System.out.println("5.Salir");
        System.out.print("Introducir la opción deseada: ");
        opcionProfesor = teclado.nextInt();
    }
}

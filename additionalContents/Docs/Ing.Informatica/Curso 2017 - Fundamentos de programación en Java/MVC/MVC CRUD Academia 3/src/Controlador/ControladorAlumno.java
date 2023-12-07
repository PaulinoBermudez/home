package Controlador;

import Modelo.Alumno;
import Modelo.AlumnoDAO;
import Vista.MenuAlumno;
import java.util.Scanner;

public class ControladorAlumno {

    private final Scanner teclado = new Scanner(System.in);
    private final ControladorPrincipal cPrincipal;
    private MenuAlumno ma = new MenuAlumno();
    private AlumnoDAO adao = new AlumnoDAO();

    public ControladorAlumno(ControladorPrincipal cPrincipal) {
        this.cPrincipal = cPrincipal;
    }

    public void gestionMenuAlumno() {
        do {
            ma.menuAlumno();
            switch (ma.getOpcionAlumno()) {
                case 1:
                    Crear();
                    break;
                case 2:
                    Actualizar();
                    break;
                case 3:
                    Eliminar();
                    break;
                case 4:
                    Leer();
                    break;
                case 5:
                    System.out.println("Volver");
                    break;
                // En cualquier otro caso, muestro un mensaje pidiendo que se introduzca una opcion contemplada en el menu
                default:
                    System.out.println("Por favor, introduzca una opcion valida.");
                    break;
            }
        } while (ma.getOpcionAlumno() != 5);
    }

    // Pedimos los datos para Crear un Alumno
    public void Crear() {
        System.out.print("Introduzca el nombre del Alumno: ");
        String nombre = teclado.nextLine();
        System.out.print("Introduzca el número de teléfono: ");
        int telefono = teclado.nextInt();
        teclado.nextLine(); // para limpiar el buffer del teclado
        Alumno alumno = new Alumno(nombre, telefono);
        adao.Crear(alumno);
    }// FIN METODO Crear

    // Método para Actualizar los datos del Objeto
    public void Actualizar() {
        // Pedimos por teclado el número de ID del registro a modificar
        System.out.print("Introduzca el ID de la fila a modificar: ");
        int n = teclado.nextInt();
        // Pedimos por teclado el Resto de datos para modificar el registro
        System.out.print("Introduzca el nuevo Alumno: ");
        String nombre = teclado.nextLine();
        System.out.print("Introduzca el nuevo teléfono: ");
        int telefono = teclado.nextInt();
        teclado.nextLine(); // para limpiar el buffer del teclado
        Alumno alumno = new Alumno(nombre, telefono);
        adao.Actualizar(n, alumno);
    }// FIN METODO ACTUALIZAR

    // Método para Eliminar los datos del Objeto
    public void Eliminar() {
        // Introducimos el ID del registro a eliminar
        System.out.print("Introduzca el ID de la fila a eliminar: ");
        int n = teclado.nextInt();
        teclado.nextLine(); // para limpiar el buffer del teclado
        adao.Eliminar(n);
    }// FIN METODO Eliminar

    // Método para Leer los datos del Objeto
    public void Leer() {
        adao.Leer();
    }// FIN METODO Leer
}

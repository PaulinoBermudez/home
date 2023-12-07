package Controlador;

import Modelo.Profesor;
import Modelo.ProfesorDAO;
import Vista.MenuProfesor;
import java.util.Scanner;

public class ControladorProfesor {

    private final Scanner teclado = new Scanner(System.in);
    private final ControladorPrincipal cPrincipal;
    private MenuProfesor mp = new MenuProfesor();
    private ProfesorDAO pdao = new ProfesorDAO();

    public ControladorProfesor(ControladorPrincipal cPrincipal) {
        this.cPrincipal = cPrincipal;
    }

    public void gestionMenuProfesor() {
        do {
            mp.menuProfesor();
            switch (mp.getOpcionProfesor()) {
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
        } while (mp.getOpcionProfesor() != 5);
    }

    // Pedimos los datos para Crear un Profesor
    public void Crear() {
        System.out.print("Introduzca el nombre del Profesor: ");
        String nombre = teclado.nextLine();
        System.out.print("Introduzca el nombre de la asignatura: ");
        String asignatura = teclado.nextLine();
        Profesor profesor = new Profesor(nombre, asignatura);
        pdao.Crear(profesor);
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
        String asignatura = teclado.nextLine();
        Profesor profesor = new Profesor(nombre, asignatura);
        pdao.Actualizar(n, profesor);

    }// FIN METODO ACTUALIZAR

    // Método para Eliminar los datos del Objeto
    public void Eliminar() {
        // Introducimos el ID del registro a eliminar
        System.out.print("Introduzca el ID de la fila a eliminar: ");
        int n = teclado.nextInt();
        teclado.nextLine(); // para limpiar el buffer del teclado
        pdao.Eliminar(n);
    }// FIN METODO Eliminar

    // Método para Leer los datos del Objeto
    public void Leer() {
        pdao.Leer();
    }// FIN METODO Leer

}

package Controlador;

import Vista.MenuPrincipal;

public class ControladorPrincipal {

    private final MenuPrincipal mp;
    private final ControladorAlumno cAlumno;
    private final ControladorProfesor cProfesor;

    public ControladorPrincipal() {
        this.mp = new MenuPrincipal();
        this.cAlumno = new ControladorAlumno(this);
        this.cProfesor = new ControladorProfesor(this);
    }

    public void gestionMenuPrincipal() {
        do { // Repito la siguiente ejecucion mientras el usuario no marque la opcion de salir del programa
            mp.menuPrincipal();
            switch (mp.getOpcionPrincipal()) {
                case 1:
                    cAlumno.gestionMenuAlumno();
                    break;
                case 2:
                    cProfesor.gestionMenuProfesor();
                    break;
                case 3:
                    System.out.println("Salir");
                    break;
                // En cualquier otro caso, muestro un mensaje pidiendo que se introduzca una opcion contemplada en el menu
                default:
                    System.out.println("Por favor, introduzca una opcion valida.");
                    break;
            }
        } while (mp.getOpcionPrincipal() != 3);
    }
}

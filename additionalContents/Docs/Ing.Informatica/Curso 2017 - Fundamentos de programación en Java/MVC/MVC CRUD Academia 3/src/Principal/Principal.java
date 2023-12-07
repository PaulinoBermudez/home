package Principal;

import Controlador.ControladorPrincipal;

/**
 * CRUD esta palabra es un acronimo del habla inglesa que quiere decir: Create.
 * Read. Update. Delete.
 *
 * En Español es crear, leer, actualizar, eliminar. Se refiere a los registros
 * de una base de datos.
 *
 */
public class Principal {

    public static void main(String[] args) {
        ControladorPrincipal cPrincipal = new ControladorPrincipal();
        cPrincipal.gestionMenuPrincipal();
    }
}

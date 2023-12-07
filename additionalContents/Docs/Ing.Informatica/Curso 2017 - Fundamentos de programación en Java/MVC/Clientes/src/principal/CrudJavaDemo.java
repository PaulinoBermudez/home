package principal;

import controlador.ControllerCliente;
import modelo.Cliente;

public class CrudJavaDemo {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("1717213183", "Elivar", "Largo");

        // controlador
        ControllerCliente controller = new ControllerCliente();

        // guarda un cliente a través del controlador
        controller.registrar(cliente);

        // ver clientes
        controller.verClientes();

        // editar un cliente por medio del id
        cliente.setId(1);
        cliente.setNombre("Santiago");
        controller.actualizar(cliente);

        // eliminar un cliente por medio del id
        cliente.setId(1);
        controller.eliminar(cliente);
    }
}
package vista;

import java.util.List;

import modelo.Cliente;

public class ViewCliente {

    public void verCliente(Cliente cliente) {
        System.out.println("Datos del Cliente: " + cliente);
    }

    public void verClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("Datos del Cliente: " + cliente);
        }
    }
}

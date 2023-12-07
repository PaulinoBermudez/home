package idao;

import java.util.List;

import modelo.Cliente;

public interface IClienteDao {

    public String agregar(Cliente cliente);

    public List<Cliente> listar();

    public int actualizar(Cliente cliente);

    public int eliminar(String dni);
}
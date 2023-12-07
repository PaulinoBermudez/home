package idao;

import java.util.List;

import modelo.Cliente;

public interface IClienteDao {

    public boolean registrar(Cliente cliente);

    public List<Cliente> obtener();

    public boolean actualizar(Cliente cliente);

    public boolean eliminar(Cliente cliente);
}
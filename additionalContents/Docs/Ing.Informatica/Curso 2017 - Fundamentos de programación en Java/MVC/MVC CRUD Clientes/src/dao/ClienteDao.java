package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import idao.IClienteDao;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class ClienteDao implements IClienteDao {

    private Conexion conexion;

    @Override
    public String agregar(Cliente cliente) {
        String rptaRegistro = null;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO cliente values (NULL,'" + cliente.getDni() + "','" + cliente.getNombre() + "','" + cliente.getApellidos() + "')";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            rptaRegistro = "Registro Correcto.";
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDao método registrar");
            e.printStackTrace();
        }
        return rptaRegistro;
    }

    @Override
    public ArrayList<Cliente> listar() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM CLIENTE ORDER BY ID";
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellidos(rs.getString(4));
                listaCliente.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDao, método Listar");
            e.printStackTrace();
        }
        return listaCliente;
    }

    @Override
    public int actualizar(Cliente cliente) {
        int filAfectadas = 0;
        Connection connect = null;
        Statement stm = null;
        String sql = "UPDATE CLIENTE SET dni='" + cliente.getDni() + "', nombre='" + cliente.getNombre() + "', apellido='" + cliente.getApellidos() + "'" + " WHERE dni=" + cliente.getDni();
        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            // Ejecutamos la sentencia SQL
            filAfectadas = stm.executeUpdate(sql);
            if (filAfectadas == 1) {
                System.out.println("Registro modificado con éxito");
            } else {
                System.out.println("Error al modificar el registro");
            }
            // Cerramos las conexiones
            stm.close();
            connect.close();
        } catch (SQLException e) {
        }
        return filAfectadas;
    }

    public int eliminar(String dni) {
        int filAfectadas = 0;
        try {
            // Cargamos la conexión
            Connection con = conexion.conectar();
            String sql = "DELETE FROM cliente WHERE dni = " + dni;
            // Ejecutamos la sentencia SQL
            Statement stm = con.createStatement();
            int confirmar = stm.executeUpdate(sql);
            if (confirmar == 1) {
                System.out.println("Registro eliminado con éxito...");
            } else {
                System.out.println("Registro no eliminado...");
            }
            // Cerramos las conexiones
            stm.close();
            con.close();
        } catch (SQLException e) {
        }
        return filAfectadas;
    }

    /*
    METODO PARA BUSCAR EL cliente POR SU DNI EN LOS CAMPOS 
     */
    public Cliente buscar(String dni) {
        Cliente cliente = null;
        try {
            Connection con = conexion.conectar();
            // Creamos la sentencia SQL
            String sql = "SELECT * FROM cliente WHERE dni = '" + dni + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            cliente = new Cliente();
            cliente.setId(rs.getInt(1));
            cliente.setDni(rs.getString(2));
            cliente.setNombre(rs.getString(3));
            cliente.setApellidos(rs.getString(4));
            // Cerramos las conexiones
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
        }
        return cliente;
    }

    /*
    METODO PARA BUSCAR LOS clientes POR APELLIDO
     */
    public ArrayList<Cliente> buscarCliente(String apellido) {
        ArrayList listaCliente = new ArrayList();
        Cliente cliente;
        try {
            Connection con = conexion.conectar();
            // Creamos la sentencia SQL
            String sql = "SELECT * FROM cliente WHERE apellido LIKE '" + apellido + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setApellidos(rs.getString(4));
                listaCliente.add(cliente);
            }
            // Cerramos las conexiones
            st.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe un cliente con este apellido");
        }
        return listaCliente;
    }

    /*
    METODO PARA BUSCAR LOS clientes POR DNI
     */
    public ArrayList<Cliente> buscarClienteDNI(String dni) {
        ArrayList listaCliente = new ArrayList();
        Cliente cliente;
        try {
            Connection con = conexion.conectar();
            // Creamos la sentencia SQL
            String sql = "SELECT * FROM cliente WHERE dni LIKE '" + dni + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setApellidos(rs.getString(4));
                listaCliente.add(cliente);
            }
            // Cerramos las conexiones
            st.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe un cliente con este DNI");
        }
        return listaCliente;
    }

}

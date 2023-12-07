
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProfesorDAO {
    
    private Conexion conexion;

    public ProfesorDAO() {
        conexion = new Conexion();
    }

    public String agregarProfesor(Profesor profesor) {
        String rptaRegistro = null;
        try {
            // Cargamos la conexión
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "INSERT INTO profesores (dni,nombre,apellidos,fechaN,direccion) "
                    + "values ('" + profesor.getDni()
                    + "','" + profesor.getNombre()
                    + "','" + profesor.getApellidos()
                    + "','" + profesor.getFechaN()
                    + "','" + profesor.getDireccion() + "')";
            // Ejecutamos la sentencia SQL
            Statement st = con.createStatement();
            int numFAfectas = st.executeUpdate(sql);
            // Cerramos las conexiones
            st.close();
            con.close();
            System.out.println("Insertado con Exito!!");
            if (numFAfectas > 0) {
                rptaRegistro = "Registro Correcto.";
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase ProfesorDAO, Metodo agregarProfesor");
        }
        return rptaRegistro;
    }

    /*
    METODO PARA LISTAR Profesores
     */
    public ArrayList<Profesor> listarProfesores() {
        ArrayList listaProfesor = new ArrayList();
        Profesor profesor;
        try {
            Connection con = conexion.getConexion();
            Statement st = con.createStatement();
            String sql = "SELECT * from profesores";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                profesor = new Profesor();
                profesor.setDni(rs.getString(1));
                profesor.setNombre(rs.getString(2));
                profesor.setApellidos(rs.getString(3));
                profesor.setFechaN(rs.getString(4));
                profesor.setDireccion(rs.getString(5));
                listaProfesor.add(profesor);
            }
        } catch (SQLException e) {
        }
        return listaProfesor;
    }

    /*
    METODO PARA BORRAR REGISTROS
     */
    public int eliminarProfesor(String dni) {
        int filAfectadas = 0;

        try {
            // Cargamos la conexión
            Connection con = conexion.getConexion();
            String sql = "DELETE FROM profesores WHERE dni = " + dni;
            // Ejecutamos la sentencia SQL
            Statement st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                System.out.println("Registro eliminado con éxito");
            } else {
                System.out.println("Registro no eliminado");
            }
            // Cerramos las conexiones
            st.close();
            con.close();
        } catch (SQLException e) {
        }
        return filAfectadas;
    }
    
    /*
    METODO PARA EDITAR REGISTRO
     */
    public int editarProfesor(Profesor profesor) {
        int filAfectadas = 0;
        try {
            // Cargamos la conexión
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "UPDATE profesores SET "
                    + "dni = '" + profesor.getDni()
                    + "',nombre = '" + profesor.getNombre()
                    + "',apellidos = '" + profesor.getApellidos()
                    + "',fechaN = '" + profesor.getFechaN()
                    + "',direccion = '" + profesor.getDireccion()
                    + "' Where dni = " + profesor.getDni() + "";

            // Ejecutamos la sentencia SQL
            Statement st = con.createStatement();
            filAfectadas = st.executeUpdate(sql);
            if (filAfectadas == 1) {
                System.out.println("Registro modificado con éxito");
            } else {
                System.out.println("Error al modificar el registro");
            }
            // Cerramos las conexiones
            st.close();
            con.close();
        } catch (SQLException e) {
        }
        return filAfectadas;
    }

    /*
    METODO PARA BUSCAR LOS ALUMNOS POR APELLIDO
     */
    public ArrayList<Profesor> buscarProfesorApellido(String apellido) {
        ArrayList listaProfesor = new ArrayList();
        Profesor profesor;
        try {
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "SELECT * FROM profesores WHERE apellidos LIKE '" + apellido + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                profesor = new Profesor();
                profesor.setDni(rs.getString(1));
                profesor.setNombre(rs.getString(2));
                profesor.setApellidos(rs.getString(3));
                profesor.setFechaN(rs.getString(4));
                profesor.setDireccion(rs.getString(5));
                listaProfesor.add(profesor);
            }
            // Cerramos las conexiones
            st.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
        }
        return listaProfesor;
    }

    /*
    METODO PARA BUSCAR LOS ALUMNOS POR DNI
     */
    public ArrayList<Profesor> buscarProfesorDNI(String dni) {
        ArrayList listaProfesor = new ArrayList();
        Profesor profesor;
        try {
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "SELECT * FROM profesores WHERE dni LIKE '" + dni + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                profesor = new Profesor();
                profesor.setDni(rs.getString(1));
                profesor.setNombre(rs.getString(2));
                profesor.setApellidos(rs.getString(3));
                profesor.setFechaN(rs.getString(4));
                profesor.setDireccion(rs.getString(5));
                listaProfesor.add(profesor);
            }
            // Cerramos las conexiones
            st.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe un Alumno con este DNI");
        }
        return listaProfesor;
    }

    /*
    METODO PARA BUSCAR EL ALUMNO POR SU DNI EN LOS CAMPOS 
     */
    public Profesor buscar(String dni) {
        Profesor profesor = null;
        try {
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "SELECT * FROM profesores WHERE dni = '" + dni + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            profesor = new Profesor();
            profesor.setDni(rs.getString(1));
            profesor.setNombre(rs.getString(2));
            profesor.setApellidos(rs.getString(3));
            profesor.setFechaN(rs.getString(4));
            profesor.setDireccion(rs.getString(5));
            // Cerramos las conexiones
            st.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
        }
        return profesor;
    }
    
}

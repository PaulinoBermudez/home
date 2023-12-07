package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement; // Realiza cualquier acción sobre la base de datos 
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlumnoDAO {

    private Conexion conexion;

    public AlumnoDAO() {
        conexion = new Conexion();
    }

    /*
        METODO PARA AGREGAR REGISTRO
     */
    public String agregarAlumno2(String dni, String nombre, String apellidos, String fechaN, String direccion) {
        String rptaRegistro = null;
        try {
            // Cargamos la conexión
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "INSERT INTO alumnos (dni,nombre,apellidos,fechaN,direccion) values ('" + dni + "','" + nombre + "','" + apellidos + "','" + fechaN + "','" + direccion + "')";
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
            System.out.println("Error: Clase AlumnoDAO, Metodo agregarAlumno");
        }
        return rptaRegistro;
    }

    public String agregarAlumno(Alumno alumno) {
        String rptaRegistro = null;
        try {
            // Cargamos la conexión
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "INSERT INTO alumnos (dni,nombre,apellidos,fechaN,direccion) "
                    + "values ('" + alumno.getDni()
                    + "','" + alumno.getNombre()
                    + "','" + alumno.getApellidos()
                    + "','" + alumno.getFechaN()
                    + "','" + alumno.getDireccion() + "')";
            // Ejecutamos la sentencia SQL
            Statement st = con.createStatement();
            int numFAfectas = st.executeUpdate(sql);
            // Cerramos las conexiones
            st.close();
            con.close();
            System.out.println("Insertado con Exito");
            if (numFAfectas > 0) {
                rptaRegistro = "Registro Correcto.";
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase AlumnoDAO, Metodo agregarAlumno");
        }
        return rptaRegistro;
    }

    /*
    METODO PARA LISTAR Alumnos
     */
    public ArrayList<Alumno> listarAlumnos() {
        ArrayList listaAlumno = new ArrayList();
        Alumno alumno;
        try {
            Connection con = conexion.getConexion();
            Statement st = con.createStatement();
            String sql = "SELECT * from alumnos";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                alumno = new Alumno();
                alumno.setDni(rs.getString(1));
                alumno.setNombre(rs.getString(2));
                alumno.setApellidos(rs.getString(3));
                alumno.setFechaN(rs.getString(4));
                alumno.setDireccion(rs.getString(5));
                listaAlumno.add(alumno);
            }
        } catch (SQLException e) {
        }
        return listaAlumno;
    }

    /*
    METODO PARA BORRAR REGISTROS
     */
    public int eliminarAlumno(String dni) {
        int filAfectadas = 0;

        try {
            // Cargamos la conexión
            Connection con = conexion.getConexion();
            String sql = "DELETE FROM alumnos WHERE dni = " + dni;
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
    public int editarAlumno(Alumno alumno) {
        int filAfectadas = 0;
        try {
            // Cargamos la conexión
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "UPDATE alumnos SET "
                    + "dni = '" + alumno.getDni()
                    + "',nombre = '" + alumno.getNombre()
                    + "',apellidos = '" + alumno.getApellidos()
                    + "',fechaN = '" + alumno.getFechaN()
                    + "',direccion = '" + alumno.getDireccion()
                    + "' Where dni = " + alumno.getDni() + "";

            // Ejecutamos la sentencia SQL
            Statement st = con.createStatement();
            filAfectadas = st.executeUpdate(sql);
            // Valor Devuelto:
            // Un valor int que indica el numero de filas afectadas o
            // 0 si se usa una instruccion DDL.
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
    public ArrayList<Alumno> buscarAlumnoApellido(String apellido) {
        ArrayList listaAlumnos = new ArrayList();
        Alumno alumno;
        try {
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "SELECT * FROM alumnos WHERE apellidos LIKE '" + apellido + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                alumno = new Alumno();
                alumno.setDni(rs.getString(1));
                alumno.setNombre(rs.getString(2));
                alumno.setApellidos(rs.getString(3));
                alumno.setFechaN(rs.getString(4));
                alumno.setDireccion(rs.getString(5));
                listaAlumnos.add(alumno);
            }
            // Cerramos las conexiones
            st.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
        }
        return listaAlumnos;
    }

    /*
    METODO PARA BUSCAR LOS ALUMNOS POR DNI
     */
    public ArrayList<Alumno> buscarAlumnoDNI(String dni) {
        ArrayList listaAlumnos = new ArrayList();
        Alumno alumno;
        try {
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "SELECT * FROM alumnos WHERE dni LIKE '" + dni + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                alumno = new Alumno();
                alumno.setDni(rs.getString(1));
                alumno.setNombre(rs.getString(2));
                alumno.setApellidos(rs.getString(3));
                alumno.setFechaN(rs.getString(4));
                alumno.setDireccion(rs.getString(5));
                listaAlumnos.add(alumno);
            }
            // Cerramos las conexiones
            st.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No existe un Alumno con este DNI");
        }
        return listaAlumnos;
    }

    /*
    METODO PARA BUSCAR EL ALUMNO POR SU DNI EN LOS CAMPOS 
     */
    public Alumno buscar(String dni) {
        Alumno alumno = null;
        try {
            Connection con = conexion.getConexion();
            // Creamos la sentencia SQL
            String sql = "SELECT * FROM alumnos WHERE dni = '" + dni + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            alumno = new Alumno();
            alumno.setDni(rs.getString(1));
            alumno.setNombre(rs.getString(2));
            alumno.setApellidos(rs.getString(3));
            alumno.setFechaN(rs.getString(4));
            alumno.setDireccion(rs.getString(5));
            // Cerramos las conexiones
            st.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
        }
        return alumno;
    }
}

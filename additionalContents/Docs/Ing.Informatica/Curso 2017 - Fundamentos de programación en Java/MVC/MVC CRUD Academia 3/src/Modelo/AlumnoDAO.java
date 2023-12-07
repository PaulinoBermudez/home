package Modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AlumnoDAO {

    private Conexion conexion;

    public void Crear(Alumno alumno) {
        // Cargamos la conexión
        Connection con = conexion.getConnection();
        Statement st;
        // Creamos la sentencia SQL
        String sql = "INSERT INTO alumnos (nombre,telefono) VALUES ('" + alumno.getNombre() + "','" + alumno.getTelefono() + "')";
        // Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            // Cerramos las conexiones
            st.close();
            con.close();
            System.out.println("Insertado con éxito!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Registro el Alumno");
        }
    }

    public void Actualizar(int n, Alumno alumno) {
        // Cargamos la conexión
        Connection con = conexion.getConnection();
        Statement st;
        // Creamos la sentencia SQL
        String sql = "UPDATE alumnos SET nombre ='" + alumno.getNombre() + "', telefono ='" + alumno.getTelefono() + "' Where ID = " + n + "";
        // Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                System.out.println("Registro modificado con éxito...");
            } else {
                System.out.println("Error al modificar el registro...");
            }
            // Cerramos las conexiones
            st.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Actualizó el Alumno");
        }
    }

    public void Eliminar(int n) {
        // Cargamos la conexión
        Connection con = conexion.getConnection();
        Statement st;
        // Creamos la sentencia SQL
        String sql = "DELETE FROM alumnos WHERE id = " + n;
        // Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
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
            JOptionPane.showMessageDialog(null, "No se Eliminó el Alumno");
        }
    }

    public void Leer() {
        // Cargamos la conexión
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        // Creamos la sentencia SQL
        String sql = "SELECT * FROM alumnos";
        // Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            // Mostramos los datos de los registros
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Teléfono: " + rs.getInt(3));
                System.out.println("********************************** ");
            }
            // Cerramos las conexiones
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a los datos");
        }
    }
}

package Modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProfesorDAO {

    private final Scanner teclado = new Scanner(System.in);
    private Conexion conexion;

    public void Crear(Profesor profesor) {
        // Cargamos la conexión
        Connection con = conexion.getConnection();
        Statement st;
        // Creamos la sentencia SQL
        String sql = "INSERT INTO profesores (nombre,asignatura) VALUES ('" + profesor.getNombre() + "','" + profesor.getAsignatura() + "')";
        // Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            // Cerramos las conexiones
            st.close();
            con.close();
            System.out.println("Insertado con éxito!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Registro el Profesor");
        }
    }

    public void Actualizar(int n, Profesor profesor) {
        // Cargamos la conexión
        Connection con = conexion.getConnection();
        Statement st;
        // Creamos la sentencia SQL
        String sql = "update profesores set nombre ='" + profesor.getNombre() + "', asignatura ='" + profesor.getAsignatura() + "' Where ID = " + n + "";
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
            JOptionPane.showMessageDialog(null, "No se Actualizó el Profesor");
        }
    }

    public void Eliminar(int n) {
        // Cargamos la conexión
        Connection con = conexion.getConnection();
        Statement st;
        // Creamos la sentencia SQL
        String sql = "delete from profesores where id = " + n;
        // Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                System.out.println("Registro eliminado con éxito...");
            } else {
                System.out.println("Registro no eliminado...");
            }
            // Cerramos las conexiones
            st.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Eliminó el Profesor");
        }
    }

    public void Leer() {
        // Cargamos la conexión
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        // Creamos la sentencia SQL
        String sql = "SELECT * FROM profesores";
        // Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            // Mostramos los datos de los registros
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Asignatura: " + rs.getString(3));
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

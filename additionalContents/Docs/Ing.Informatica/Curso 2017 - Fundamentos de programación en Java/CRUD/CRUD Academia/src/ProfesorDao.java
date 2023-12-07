
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Toni
 */
public class ProfesorDao {

    private Scanner teclado = new Scanner(System.in);
    private String nombre = "";
    private String asignatura = "";
    private Conexion conexion;

    public void Crear() {
        // Cargamos la conexión
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        // Pedimos los datos para agregar
        System.out.print("Introduzca el nombre del Profesor: ");
        nombre = teclado.next();
        System.out.print("Introduzca la asignatura: ");
        asignatura = teclado.next();
        // Creamos la sentencia SQL
        String sql = "INSERT INTO profesores (nombre,asignatura) VALUES ('" + nombre + "','" + asignatura + "')";
        // Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            // Cerramos las conexiones
            st.close();
            con.close();
            System.out.println("Insertado con éxito!!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void Actualizar() {
        // Cargamos la conexión
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        // Pedimos por teclado el número de ID del registro a modificar
        System.out.print("Introduzca el ID de la fila a modificar: ");
        int n = teclado.nextInt();
        // Pedimos por teclado el Resto de datos para modificar el registro
        System.out.print("Introduzca el nuevo Profesor: ");
        nombre = teclado.next();
        System.out.print("Introduzca la nueva asignatura: ");
        asignatura = teclado.next();
        // Creamos la sentencia SQL
        String sql = "update profesores set nombre ='" + nombre + "', asignatura ='" + asignatura + "' Where ID = " + n + "";
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
            e.printStackTrace();
        }
    }

    public void Eliminar() {
        // Cargamos la conexión
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        // Introducimos el ID del registro a eliminar
        System.out.print("Introduzca el ID de la fila a eliminar: ");
        int n = teclado.nextInt();
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
            e.printStackTrace();
        }
    }

    public void Leer() {
        // Cargamos la conexión
        conexion = new Conexion();
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
            e.printStackTrace();
        }
    }
}

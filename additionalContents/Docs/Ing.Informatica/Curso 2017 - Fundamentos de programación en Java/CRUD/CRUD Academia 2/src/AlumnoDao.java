
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Toni
 */
public class AlumnoDao {

    private Scanner teclado = new Scanner(System.in);
    private String nombre = "";
    private int telefono = 0;
    private Conexion conexion;

    public void Crear() {
        // Cargamos la conexión
        Connection con = conexion.getConnection();
        Statement st;
        // Pedimos los datos para agregar
        System.out.print("Introduzca el nombre del Alumno: ");
        nombre = teclado.next();
        System.out.print("Introduzca el número de teléfono: ");
        telefono = teclado.nextInt();
        teclado.nextLine(); // para limpiar el buffer del teclado
        // Creamos la sentencia SQL
        String sql = "INSERT INTO alumnos (nombre,telefono) VALUES ('" + nombre + "','" + telefono + "')";
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
            JOptionPane.showMessageDialog(null, "No se Registro el Alumno");
        }
    }

    public void Actualizar() {
        // Cargamos la conexión
        Connection con = conexion.getConnection();
        Statement st;
        // Pedimos por teclado el número de ID del registro a modificar
        System.out.print("Introduzca el ID de la fila a modificar: ");
        int n = teclado.nextInt();
        // Pedimos por teclado el Resto de datos para modificar el registro
        System.out.print("Introduzca el nuevo Alumno: ");
        nombre = teclado.next();
        System.out.print("Introduzca el nuevo teléfono: ");
        telefono = teclado.nextInt();
        teclado.nextLine(); // para limpiar el buffer del teclado
        // Creamos la sentencia SQL
        String sql = "UPDATE alumnos SET nombre ='" + nombre + "', telefono ='" + telefono + "' Where ID = " + n + "";
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
        Connection con = conexion.getConnection();
        Statement st;
        // Introducimos el ID del registro a eliminar
        System.out.print("Introduzca el ID de la fila a eliminar: ");
        int n = teclado.nextInt();
        teclado.nextLine(); // para limpiar el buffer del teclado
        // Creamos la sentencia SQL
        String sql = "DELETE FROM alumnos WHERE id = " + n;
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
            e.printStackTrace();
        }
    }
}


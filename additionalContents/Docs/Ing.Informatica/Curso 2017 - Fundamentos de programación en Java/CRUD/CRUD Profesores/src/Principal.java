
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * CRUD esta palabra es un acronimo del habla inglesa que quiere decir
 * Create. 
 * Read. 
 * Update. 
 * Delete. 
 *
 * En Espa�ol es crear, leer, actualizar, eliminar.
 * Se refiere a los registros de una base de datos.
 *
 */
 
public class Principal {

    private static Scanner teclado = new Scanner(System.in);
    private static String nombre = "";
    private static String asignatura = "";
    private static int opcion;
    private static Conexion conexion;

    public static void main(String[] args) {

        do {
            System.out.println("Elija una opción: ");
            System.out.println("1.Crear");
            System.out.println("2.Actualizar");
            System.out.println("3.Eliminar");
            System.out.println("4.Leer datos");
            System.out.println("5.Salir");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    Crear();
                    break;
                case 2:
                    Actualizar();
                    break;
                case 3:
                    Eliminar();
                    break;
                case 4:
                    Leer();
                    break;
                case 5:
                    System.out.println("Saliendo ... ");
                    System.exit(0);// Salimos de la aplicación
            }
        } while (opcion != 5);
    }

    public static void Crear() {
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
        String sql = "insert into profesores (nombre,asignatura) values ('" + nombre + "','" + asignatura + "')";
        // Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            // Cerramos las conexiones
            con.close();
            st.close();
            System.out.println("Insertado con éxito!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Actualizar() {
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
        System.out.print("Introduzca el nuevo asignatura: ");
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

    public static void Eliminar() {
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

    public static void Leer() {
        // Cargamos la conexión
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        // Creamos la sentencia SQL
        String sql = "select * from profesores";
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
            con.close();
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static String servidor = "jdbc:mysql://localhost/academia";
    private static String user = "root"; // Nombre de usuario por defecto
    private static String pass = ""; // Clave por defecto
    private static String driver = "com.mysql.jdbc.Driver";
    private static Connection conexion;

    public Conexion() {

        try {
            Class.forName(driver);//Levanto el driver
            conexion = DriverManager.getConnection(servidor, user, pass); // establexco la conexión
            System.out.println("Conexion realizada con exito");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexion fallida");
        }
    }

    public Connection getConnection() {
        return conexion; // Devuelvo el objeto Conecction

    }
}
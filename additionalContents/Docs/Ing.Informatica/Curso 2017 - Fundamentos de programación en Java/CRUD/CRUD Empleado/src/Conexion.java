import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static String servidor = "jdbc:mysql://localhost/empresa";
    private static String user = "root";
    private static String pass = "";
    private static String driver = "com.mysql.jdbc.Driver";
    private static Connection conexion;

    public Conexion() {

        try {
            Class.forName(driver);//Levanto el driver
            conexion = DriverManager.getConnection(servidor, user, pass);
            System.out.println("Conexion realizada con exito");
        } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Conexion fallida");
            }
    }
        
    public Connection getConnection() {
        return conexion;
    }
}
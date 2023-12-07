package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Toni
 */
public class Conexion {

    /**
     * Parametros de conexion
     */
    static String servidor = "persona";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + servidor;

    Connection connection = null;


    public Conexion() {
        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexion
            connection = DriverManager.getConnection(url, login, password);

            if (connection != null) {
                System.out.println("Conexion a base de datos " + servidor + " OK\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Permite retornar la conexión
     */
    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
    }
}

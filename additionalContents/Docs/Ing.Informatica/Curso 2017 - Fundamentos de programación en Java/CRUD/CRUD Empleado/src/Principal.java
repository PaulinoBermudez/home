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
    private static String departamento = "";
    private static int opcion;
    private static Conexion conexion;

    public static void main(String[] args) {

        do {
            System.out.println("Elija una opcion: ");
            System.out.println("1.Insertar");
            System.out.println("2.Modificar");
            System.out.println("3.Borrar");
            System.out.println("4.Mostrar datos");
            System.out.println("5.Salir");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    insertar();
                    break;
                case 2:
                    modificar();
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    mostrar();
                    break;
                case 5:
                    System.out.println("Saliendo ... ");
                    System.exit(0);// Salimos de la aplicacion
            }
        } while (opcion != 5);
    }

    public static void insertar() {

        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        System.out.println("Introduzca el nombre del empleado:");
        nombre = teclado.next();
        System.out.println("Introduzca el departamento:");
        departamento = teclado.next();
        String sql = "insert into empleados (nombre,departamento) values ('" + nombre + "','" + departamento + "')";

        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            con.close();
            st.close();
            System.out.println("insertado con éxito!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modificar() {

        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        System.out.println("Introduzca el ID de la fila a modificar: ");
        int n = teclado.nextInt();
        System.out.println("Introduzca el nuevo nombre: ");
        nombre = teclado.next();
        System.out.println("Introduzca el nuevo departamento: ");
        departamento = teclado.next();
        String sql = "update empleados set nombre='" + nombre + "', departamento='" + departamento + "' Where ID = " + n + "";
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                System.out.println("Registro modificado con éxito .... ");
            } else {
                System.out.println("Error al modificar el registro ...");
            }
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminar() {

        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        System.out.println("Introduzca el ID de la fila a eliminar: ");
        int n = teclado.nextInt();

        String sql = "delete from empleados where id = " + n;

        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                System.out.println("Registro eliminado con éxito...");
            } else {
                System.out.println("Registro no eliminado...");
            }

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mostrar() {
        conexion = new Conexion();

        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;

        String sql = "select * from empleados";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID:" + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Departamento: " + rs.getString(3));
                System.out.println("********************************** ");
            }
            con.close();
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
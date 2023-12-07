package modelo;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumnoDAO {
	
    Conexion conexion;
    
    public AlumnoDAO(){
        conexion = new Conexion();
    }
    
    public String agregarAlumno(String dni, String nombre, String apellidos, String fechaN, String direccion){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call sp_agregarAlumno(?,?,?,?,?)}");
            cs.setString(1, dni);
            cs.setString(2, nombre);
            cs.setString(3, apellidos);
            cs.setString(4, fechaN);
            cs.setString(5, direccion);
            
            int numFAfectas = cs.executeUpdate();
            
            if(numFAfectas>0){
                rptaRegistro="Registro exitoso.";
            }
        } catch (Exception e) {
        }
        return rptaRegistro;
    }
    
    public ArrayList<Alumno> listarAlumno(){
        ArrayList listaAlumno = new ArrayList();
        Alumno alumno;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * from alumnos");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                alumno = new Alumno();
                alumno.setDni(rs.getString(1));
                alumno.setNombre(rs.getString(2));
                alumno.setApellidos(rs.getString(3));
                alumno.setFechaN(rs.getString(4));
                alumno.setDireccion(rs.getString(5));
                listaAlumno.add(alumno);
            }
        } catch (Exception e) {
        }
        return listaAlumno;
    }
    
    public int eliminarAlumno(String dni){
        int filAfectadas= 0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call sp_eliminarAlumno(?)}");
            cs.setString(1, dni);
            filAfectadas = cs.executeUpdate();
        } catch (Exception e) {
        }
        
        return filAfectadas;
    }
    
    public int editarAlumno(String dni, String nombre, String apellidos, String fechaN, String direccion){
        int filAfectadas=0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call sp_actualizarAlumno(?,?,?,?,?)}");
            cs.setString(1, dni);
            cs.setString(2, nombre);
            cs.setString(3, apellidos);
            cs.setString(4, fechaN);
            cs.setString(5, direccion);
            filAfectadas = cs.executeUpdate();
        } catch (Exception e) {
        }
        return filAfectadas;  
    }
    
    public ArrayList<Alumno> buscarAlumnoApellido(String apellido){
        ArrayList listaAlumnos = new ArrayList();
        Alumno alumno;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call sp_buscaPxApellidos(?)}");
            cs.setString(1, apellido);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                alumno = new Alumno();
                alumno.setDni(rs.getString(1));
                alumno.setNombre(rs.getString(2));
                alumno.setApellidos(rs.getString(3));
                alumno.setFechaN(rs.getString(4));
                alumno.setDireccion(rs.getString(5));
                listaAlumnos.add(alumno);
            }
        } catch (Exception e) {
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
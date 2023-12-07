/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class PersonaDAO {
    Conexion conexion;
    
    public PersonaDAO(){
        conexion = new Conexion();
    }
    
    public String insertPersona(String dni, String apellidos, String nombres, String fecha, String lugar){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call sp_insertPersona(?,?,?,?,?)}");
            cs.setString(1, dni);
            cs.setString(2, apellidos);
            cs.setString(3, nombres);
            cs.setString(4, fecha);
            cs.setString(5, lugar);
            
            int numFAfectas = cs.executeUpdate();
            
            if(numFAfectas>0){
                rptaRegistro="Registro exitoso.";
            }
        } catch (Exception e) {
        }
        return rptaRegistro;
    }
    
    public ArrayList<Persona> listPersona(){
        ArrayList listaPersona = new ArrayList();
        Persona persona;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("select * from persona");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                persona = new Persona();
                persona.setDni(rs.getString(1));
                persona.setApellidos(rs.getString(2));
                persona.setNombres(rs.getString(3));
                persona.setFechaN(rs.getString(4));
                persona.setLugarN(rs.getString(5));
                listaPersona.add(persona);
            }
        } catch (Exception e) {
        }
        return listaPersona;
    }
    
    public int deletePersona(String dni){
        int filAfectadas= 0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call sp_deletePersona(?)}");
            cs.setString(1, dni);
            filAfectadas = cs.executeUpdate();
        } catch (Exception e) {
        }
        
        return filAfectadas;
    }
    
    public int editPersona(String dni, String apellidos, String nombres,String fecha, String lugar){
        int filAfectadas=0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call sp_editPersona(?,?,?,?,?)}");
            cs.setString(1, dni);
            cs.setString(2, apellidos);
            cs.setString(3, nombres);
            cs.setString(4, fecha);
            cs.setString(5, lugar);
            filAfectadas = cs.executeUpdate();
        } catch (Exception e) {
        }
        return filAfectadas;  
    }
    
    public ArrayList<Persona> buscaPersona(String apellido){
        ArrayList listaPersona = new ArrayList();
        Persona persona;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call sp_buscaPxApellidos(?)}");
            cs.setString(1, apellido);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                persona = new Persona();
                persona.setDni(rs.getString(1));
                persona.setApellidos(rs.getString(2));
                persona.setNombres(rs.getString(3));
                persona.setFechaN(rs.getString(4));
                persona.setLugarN(rs.getString(5));
                listaPersona.add(persona);
            }
        } catch (Exception e) {
        }
        return listaPersona;
    }
}

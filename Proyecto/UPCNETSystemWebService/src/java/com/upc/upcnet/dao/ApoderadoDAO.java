/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.dao;

import com.upc.upcnet.BD.AccesoDB;
import com.upc.upcnet.entidades.Apoderado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidwesker
 */
public class ApoderadoDAO {

    public List<Apoderado> getApoderados() {
        List<Apoderado> apoderados = new ArrayList<>();
        Connection con = null;
        try {
            con = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDApoderado,Pass ,Nombre, Apellido, DNI, Edad, Correo,Direccion, Condicion FROM Apoderado");
            PreparedStatement ps = con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Apoderado a = new Apoderado();
                a.setIDApoderado(rs.getString("IDApoderado"));
                a.setPass(rs.getString("Pass"));
                a.setNombre(rs.getString("Nombre"));
                a.setApellido(rs.getString("Apellido"));
                a.setDNI(rs.getInt("DNI"));
                a.setEdad(rs.getInt("Edad"));
                a.setCorreo(rs.getString("Correo"));
                a.setDireccion(rs.getString("Direccion"));
                a.setCondicion(rs.getString("Condicion"));

                apoderados.add(a);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
            }
        }
        return apoderados;
    }
    public List<Apoderado> getApoderadoById(String _idApoderado){
         List<Apoderado> apoderados = new ArrayList<>();
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDApoderado, Nombre, Apellido, DNI, Edad, Correo, Direccion, Condicion, Pass FROM Apoderado WHERE IDApoderado = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idApoderado);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Apoderado a = new Apoderado();
                a.setIDApoderado(rs.getString("IDApoderado"));
                a.setNombre(rs.getString("Nombre"));
                a.setApellido(rs.getString("Apellido"));
                a.setDNI(rs.getInt("DNI"));
                a.setEdad(rs.getInt("Edad"));
                a.setCorreo(rs.getString("Correo"));
                a.setDireccion(rs.getString("Direccion"));
                a.setCondicion(rs.getString("Condicion"));
                a.setPass(rs.getString("Pass"));
                
                apoderados.add(a);
            }
        }catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }catch(Exception e){
            throw new RuntimeException("No se tiene acceso al servidor");
        }finally{
            try{
                if(cn != null)
                    cn.close();
            }catch(Exception ex){}
        }
        return apoderados;
    }
    public void setApoderado(Apoderado objApoderado){
        Connection cn = null;        
        try{
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Apoderado WHERE IDApoderado = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objApoderado.getIDApoderado());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                throw new SQLException("El codigo del Apoderado ya existe");
            
            query = new StringBuilder();
            query.append("INSERT INTO Apoderado(IDApoderado,Pass ,Nombre, Apellido, DNI, Edad, Correo,Direccion, Condicion) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objApoderado.getIDApoderado());
            ps.setString(2, objApoderado.getPass());
            ps.setString(3, objApoderado.getNombre());
            ps.setString(4, objApoderado.getApellido());
            ps.setInt(5, objApoderado.getDNI());
            ps.setInt(6, objApoderado.getEdad());
            ps.setString(7, objApoderado.getCorreo());
            ps.setString(8, objApoderado.getDireccion());
            ps.setString(9, objApoderado.getCondicion());
            ps.executeUpdate();
            cn.commit();
            
        }catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }catch(Exception e){
            throw new RuntimeException("No se tiene acceso al servidor");
        }finally{
            try{
                if(cn != null)
                    cn.close();
            }catch(Exception ex){}
        }
    }
    
    public void editApoderado(Apoderado objApoderado){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Apoderado SET Nombre = ?,Pass=?, Apellido = ?, DNI = ?, Edad = ?, Correo = ?, Direccion = ?,Condicion=? WHERE IDApoderado= ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objApoderado.getNombre());
            ps.setString(2, objApoderado.getPass());
            ps.setString(3, objApoderado.getApellido());
            ps.setInt(4, objApoderado.getDNI());
            ps.setInt(5, objApoderado.getEdad());
            ps.setString(6, objApoderado.getCorreo());
            ps.setString(7, objApoderado.getDireccion());
            ps.setString(8, objApoderado.getCondicion());
            ps.setString(9, objApoderado.getIDApoderado());
            int realizado = ps.executeUpdate();
            cn.commit();
            if(realizado == 0)
                throw  new SQLException("Apoderado no existe!");            
        }catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }catch(Exception e){
            throw new RuntimeException("No se tiene acceso al servidor");
        }finally{
            try{
                if(cn != null)
                    cn.close();
            }catch(Exception ex){}
        }
    }
    public boolean validarLoginApoderado(String _idApoderado, String _pass){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Apoderado WHERE IDApoderado = ? AND Pass = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idApoderado);
            ps.setString(2, _pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return true;
            else
                return false;        
            
        }catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }catch(Exception e){
            throw new RuntimeException("No se tiene acceso al servidor");
        }finally{
            try{
                if(cn != null)
                    cn.close();
            }catch(Exception ex){}
        }       
    }
    
}

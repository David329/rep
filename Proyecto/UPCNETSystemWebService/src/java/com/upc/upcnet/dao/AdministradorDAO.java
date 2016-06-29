/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.dao;

import com.upc.upcnet.BD.AccesoDB;
import com.upc.upcnet.entidades.Administrador;
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
public class AdministradorDAO {
    //IDAdministrador,Pass,Nombre,Apellido,Correo;
    
    public List<Administrador> getAdministrador() {
        List<Administrador> administradores = new ArrayList<>();
        Connection con = null;
        try {
            con = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDAdministrador,Pass ,Nombre, Apellido, Correo FROM Administrador");
            PreparedStatement ps = con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Administrador a = new Administrador();
                a.setIDAdministrador(rs.getString("IDAdministrador"));
                a.setPass(rs.getString("Pass"));
                a.setNombre(rs.getString("Nombre"));
                a.setApellido(rs.getString("Apellido"));
                a.setCorreo(rs.getString("Correo"));
                
                administradores.add(a);
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
        return administradores;
    }
    
    public List<Administrador> getAdministradoresById(String _idAdministrador){
         List<Administrador> administradores = new ArrayList<>();
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDAdministrador,Pass ,Nombre, Apellido, Correo FROM Administrador WHERE IDAdministrador = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idAdministrador);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Administrador a = new Administrador();
                a.setIDAdministrador(rs.getString("IDAdministrador"));
                a.setPass(rs.getString("Pass"));
                a.setNombre(rs.getString("Nombre"));
                a.setApellido(rs.getString("Apellido"));
                a.setCorreo(rs.getString("Correo"));
                
                administradores.add(a);
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
        return administradores;
    }
    
    public void setAdministrador(String _idAdministrador,String _pass,String _nombre, String _apellido, String _correo){
        Connection cn = null;        
        try{
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Administrador WHERE IDAdministrador = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idAdministrador);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                throw new SQLException("El codigo del Administrador ya existe");
            
            query = new StringBuilder();
            query.append("INSERT INTO Administrador(IDAdministrador,Pass ,Nombre, Apellido,Correo) VALUES(?, ?, ?, ?, ?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idAdministrador);
            ps.setString(2, _pass);
            ps.setString(3, _nombre);
            ps.setString(4, _apellido);
            ps.setString(5, _correo);
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
    
    public void editAdministrador(String _idAdministrador,String _pass,String _nombre, String _apellido, String _correo){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Administrador SET Nombre = ?,Pass=?, Apellido = ?, Correo = ? WHERE IDAdministrador= ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _nombre);
            ps.setString(2, _pass);
            ps.setString(3, _apellido);
            ps.setString(4, _correo);
            ps.setString(5, _idAdministrador);
            int realizado = ps.executeUpdate();
            if(realizado == 0)
                throw  new SQLException("Administrador no existe!");            
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
    
    public boolean validarLoginAdminitrador(String _idAdministrador, String _pass){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Administrador WHERE IDAdministrador = ? AND Pass = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idAdministrador);
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

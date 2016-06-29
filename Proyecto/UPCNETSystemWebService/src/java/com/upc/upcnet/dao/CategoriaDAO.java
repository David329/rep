/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.dao;

import com.upc.upcnet.BD.AccesoDB;
import com.upc.upcnet.entidades.Categoria;
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
public class CategoriaDAO {
    
    public List<Categoria> getCategoria() {
        List<Categoria> categorias = new ArrayList<>();
        Connection con = null;
        try {
            con = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDCategoria,Monto FROM Categoria");
            PreparedStatement ps = con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categoria a = new Categoria();
                a.setIdCategoria(rs.getString("IDCategoria"));
                a.setMonto(rs.getFloat("Monto"));

                categorias.add(a);
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
        return categorias;
    }
    
    public void setCategoria(String _idCategoria,String _monto){
        Connection cn = null;        
        try{
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Categoria WHERE IDCategoria = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idCategoria);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                throw new SQLException("El codigo de la Categoria ya existe");
            
            query = new StringBuilder();
            query.append("INSERT INTO Categoria(IDCategoria,Monto) VALUES(?,?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idCategoria);
            ps.setString(2, _monto);
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
    
    public void editCategoria(String _idCategoria,String _monto){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Categoria SET Monto = ? WHERE IDCategoria= ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _monto);
            ps.setString(2, _idCategoria);
            int realizado = ps.executeUpdate();
            if(realizado == 0)
                throw  new SQLException("Categoria no existe!");            
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

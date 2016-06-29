/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.dao;

import com.upc.upcnet.BD.AccesoDB;
import com.upc.upcnet.entidades.Recurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author davidwesker
 */
public class RecursoDAO {

    public List<Recurso> getRecurso() {
        List<Recurso> recursos = new ArrayList<>();
        Connection con = null;
        try {
            con = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("select IDRecurso,NombreRecurso,FechaPedido,CantidadHoras,Reservado,IDAlumno,IDProfesor from Recurso");
            PreparedStatement ps = con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Recurso a = new Recurso();
                a.setIDRecurso(rs.getString("IDRecurso"));
                a.setNombreRecurso(rs.getString("NombreRecurso"));
                a.setFechaPedido(rs.getDate("FechaPedido"));
                a.setCantidadHoras(rs.getInt("CantidadHoras"));
                a.setReservado(rs.getBoolean("Reservado"));
                a.setIDAlumno(rs.getString("IDAlumno"));
                a.setIDProfesor(rs.getString("IDProfesor"));

                recursos.add(a);
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
        return recursos;
    }
    public void setRecurso(Recurso objRecurso){
        Connection cn = null;        
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Recurso WHERE IDRecurso = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objRecurso.getIDRecurso());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                throw new SQLException("El codigo del Recurso ya existe");
            
            query = new StringBuilder();
            query.append("INSERT INTO Recurso(IDRecurso,NombreRecurso,FechaPedido,CantidadHoras,Reservado,IDAlumno,IDProfesor) VALUES(?, ?, ?, ?, ?, ?, ?)");
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");            
            
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objRecurso.getIDRecurso());
            ps.setString(2, objRecurso.getNombreRecurso());
            ps.setDate(3, (java.sql.Date)objRecurso.getFechaPedido());
            ps.setInt(4, objRecurso.getCantidadHoras());
            ps.setBoolean(5,objRecurso.isReservado());
            ps.setString(6, objRecurso.getIDAlumno());
            ps.setString(7, objRecurso.getIDProfesor());
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
    public void editRecurso(Recurso objRecurso){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Recurso SET NombreRecurso = ?, FechaPedido = ?, CantidadHoras = ?, Reservado = ?, IDAlumno = ?, IDProfesor = ? WHERE IDRecurso= ?");
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objRecurso.getNombreRecurso());
            ps.setDate(2, (java.sql.Date) objRecurso.getFechaPedido());
            ps.setInt(3, objRecurso.getCantidadHoras());
            ps.setBoolean(4, objRecurso.isReservado());
            ps.setString(5, objRecurso.getIDAlumno());
            ps.setString(6, objRecurso.getIDProfesor());
            ps.setString(7, objRecurso.getIDRecurso());
            
            int realizado = ps.executeUpdate();
            if(realizado == 0)
                throw  new SQLException("Recurso no existe!");            
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

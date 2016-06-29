/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.dao;

import com.upc.upcnet.BD.AccesoDB;
import com.upc.upcnet.entidades.Curso;
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
public class CursoDAO {
    public List<Curso> getCursos(){
        List<Curso> cursos = new ArrayList<>();
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDCurso, Nombre, CicloDeCurso, MaxInasistencia, IDProfesor FROM Curso");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Curso a = new Curso();
                a.setIdCurso(rs.getString("IDCurso"));
                a.setNombre(rs.getString("Nombre"));
                a.setCicloDeCurso(rs.getInt("CicloDeCurso"));
                a.setMaxInasistencia(rs.getInt("MaxInasistencia"));
                a.setIdProfesor(rs.getString("IDProfesor"));
                
                cursos.add(a);
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
        return cursos;
    }
    
    public List<Curso> getCursosById(String _idCurso){
         List<Curso> cursos = new ArrayList<>();
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDCurso, Nombre, CicloDeCurso, MaxInasistencia, IDProfesor FROM Curso WHERE IDCurso = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idCurso);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Curso a = new Curso();
                a.setIdCurso(rs.getString("IDCurso"));
                a.setNombre(rs.getString("Nombre"));
                a.setCicloDeCurso(rs.getInt("CicloDeCurso"));
                a.setMaxInasistencia(rs.getInt("MaxInasistencia"));
                a.setIdProfesor(rs.getString("IDProfesor"));
                
                cursos.add(a);
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
        return cursos;
    }
    
    public void setCurso(Curso objCurso){
        Connection cn = null;        
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Curso WHERE IDCurso = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objCurso.getIdCurso());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                throw new SQLException("El codigo del curso ya existe");
            
            query = new StringBuilder();
            query.append("INSERT INTO Curso(IDCurso, Nombre, CicloDeCurso, MaxInasistencia, IDProfesor) VALUES(?, ?, ?, ?, ?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objCurso.getIdCurso());
            ps.setString(2,objCurso.getNombre());
            ps.setInt(3, objCurso.getCicloDeCurso());
            ps.setInt(4, objCurso.getMaxInasistencia());
            ps.setString(5, objCurso.getIdProfesor());
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
    
    public void editCurso(Curso objCurso){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Curso SET Nombre = ?,CicloDeCurso = ?, MaxInasistencia = ?, IDProfesor = ? WHERE IDCurso = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1,objCurso.getNombre());
            ps.setInt(2, objCurso.getCicloDeCurso());
            ps.setInt(3, objCurso.getMaxInasistencia());
            ps.setString(4, objCurso.getIdProfesor());
            ps.setString(5, objCurso.getIdCurso());
            int realizado = ps.executeUpdate();
            cn.commit();
            if(realizado == 0)
                throw  new SQLException("Curso no existe!");            
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

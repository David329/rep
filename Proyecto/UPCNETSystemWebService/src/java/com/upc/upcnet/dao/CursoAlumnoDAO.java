/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.dao;

import com.upc.upcnet.BD.AccesoDB;
import com.upc.upcnet.entidades.Curso;
import com.upc.upcnet.entidades.CursoAlumno;
import com.upc.upcnet.entidades.CursoAlumnoReporte;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidwesker
 */
public class CursoAlumnoDAO {
    
    public List<CursoAlumno> getCursoAlumno() {
        List<CursoAlumno> cursoalumnos = new ArrayList<>();
        Connection con = null;
        try {
            con = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDAlumno,IDCurso ,PC1, PC2, EP,EF,Retirado,Inasistencias,Delegado FROM Curso_Alumno");
            PreparedStatement ps = con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CursoAlumno a = new CursoAlumno();
                a.setIdAlumno(rs.getString("IDAlumno"));
                a.setIdCurso(rs.getString("IDCurso"));
                a.setPc1(rs.getDouble("PC1"));
                a.setPc2(rs.getDouble("PC2"));
                a.setEp(rs.getDouble("EP"));
                a.setEf(rs.getDouble("EF"));
                a.setRetirado(rs.getBoolean("Retirado"));
                a.setInasistencias(rs.getInt("Inasistencias"));
                a.setDelegado(rs.getBoolean("Delegado"));
                
                cursoalumnos.add(a);
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
        return cursoalumnos;
    }
    
    public List<CursoAlumno> getCursoAlumnosByIdCurso(String _idCurso){
         List<CursoAlumno> cursoalumnos = new ArrayList<>();
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDAlumno,IDCurso ,PC1, PC2, EP,EF,Retirado,Inasistencias,Delegado FROM Curso_Alumno WHERE IDCurso = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idCurso);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CursoAlumno a = new CursoAlumno();
                a.setIdAlumno(rs.getString("IDAlumno"));
                a.setIdCurso(rs.getString("IDCurso"));
                a.setPc1(rs.getDouble("PC1"));
                a.setPc2(rs.getDouble("PC2"));
                a.setEp(rs.getDouble("EP"));
                a.setEf(rs.getDouble("EF"));
                a.setRetirado(rs.getBoolean("Retirado"));
                a.setInasistencias(rs.getInt("Inasistencias"));
                a.setDelegado(rs.getBoolean("Delegado"));
                
                cursoalumnos.add(a);
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
        return cursoalumnos;
    }
    
    public List<Curso> getCursoByIdAlumno(String _idAlumno){
         List<Curso> cursos = new ArrayList<>();
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT a.IDCurso ,a.CicloDeCurso,a.MaxInasistencia, a.IDProfesor FROM Curso a join Curso_Alumno x on a.IDCurso=x.IDCurso where x.IDAlumno= ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idAlumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Curso a = new Curso();
                a.setIdCurso(rs.getString("IDCurso"));
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
    
    public void setCursoAlumno(CursoAlumno objCursoAlumno){
        Connection cn = null;        
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Curso_Alumno WHERE IDCurso= ? and IDAlumno=?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objCursoAlumno.getIdCurso());
            ps.setString(2, objCursoAlumno.getIdAlumno());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                throw new SQLException("El Curso y Alumno ya existe");
            
            query = new StringBuilder();
            query.append("INSERT INTO Curso_Alumno(IDAlumno,IDCurso ,PC1, PC2, EP,EF,Retirado,Inasistencias,Delegado) VALUES(?, ?, ?, ?, ?,?,?,?,?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objCursoAlumno.getIdAlumno());
            ps.setString(2, objCursoAlumno.getIdCurso());
            ps.setDouble(3, objCursoAlumno.getPc1());
            ps.setDouble(4, objCursoAlumno.getPc2());
            ps.setDouble(5, objCursoAlumno.getEp());
            ps.setDouble(6,objCursoAlumno.getEf());
            ps.setBoolean(7, objCursoAlumno.isRetirado());
            ps.setInt(8, objCursoAlumno.getInasistencias());
            ps.setBoolean(9, objCursoAlumno.isDelegado());
                    
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
    
    public void editCursoAlumno(CursoAlumno objCursoAlumno){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Curso_Alumno SET PC1=?, PC2= ?, EP=?,EF=?,Retirado=?,Inasistencias=?,Delegado WHERE IDCurso=? and IDAlumno= ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setDouble(1, objCursoAlumno.getPc1());
            ps.setDouble(2, objCursoAlumno.getPc2());
            ps.setDouble(3, objCursoAlumno.getEp());
            ps.setDouble(4,objCursoAlumno.getEf());
            ps.setBoolean(5, objCursoAlumno.isRetirado());
            ps.setInt(6, objCursoAlumno.getInasistencias());
            ps.setBoolean(7, objCursoAlumno.isDelegado());
            ps.setString(8, objCursoAlumno.getIdCurso());
            ps.setString(9, objCursoAlumno.getIdAlumno());
            
            int realizado = ps.executeUpdate();
            if(realizado == 0)
                throw  new SQLException("CursoAlumno no existe!");            
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
    
    public List<CursoAlumno> getCursoAlumnoByID(String _idCurso,String _idAlumno){
        List<CursoAlumno> cursoalumnos = new ArrayList<>();
        Connection con = null;
        try {
            con = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDAlumno,IDCurso ,PC1, PC2, EP,EF,Retirado,Inasistencias,Delegado FROM Curso_Alumno where IDAlumno=? and ICurso=?");
            PreparedStatement ps = con.prepareStatement(query.toString());
            ps.setString(1, _idAlumno);
            ps.setString(2, _idCurso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CursoAlumno a = new CursoAlumno();
                a.setIdAlumno(rs.getString("IDAlumno"));
                a.setIdCurso(rs.getString("IDCurso"));
                a.setPc1(rs.getDouble("PC1"));
                a.setPc2(rs.getDouble("PC2"));
                a.setEp(rs.getDouble("EP"));
                a.setEf(rs.getDouble("EF"));
                a.setRetirado(rs.getBoolean("Retirado"));
                a.setInasistencias(rs.getInt("Inasistencias"));
                a.setDelegado(rs.getBoolean("Delegado"));
                
                cursoalumnos.add(a);
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
        return cursoalumnos;
    }
    
    public List<CursoAlumnoReporte> getCursoAlumnoReporte(String idAlumno) {
        List<CursoAlumnoReporte> lista = new ArrayList<>();
        Connection con = null;
        try {
            con = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT c.IDCurso, c.Nombre AS CursoN, p.Nombre AS ProfesorN, cc.PC1, cc.PC2, cc.EP, cc.EF FROM Curso_Alumno cc\n" +
                            "JOIN Alumno a ON a.IDAlumno = cc.IDAlumno\n" +
                            "JOIN Curso c ON c.IDCurso = cc.IDCurso\n" +
                            "JOIN Profesor p ON p.IDProfesor = c.IDProfesor\n" +
                            "WHERE a.IDAlumno = ?");
            PreparedStatement ps = con.prepareStatement(query.toString());
            ps.setString(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CursoAlumnoReporte obj = new CursoAlumnoReporte();
                obj.setIdCurso(rs.getString("IDCurso"));
                obj.setCurso(rs.getString("CursoN"));
                obj.setProfesor(rs.getString("ProfesorN"));
                obj.setPc1(rs.getDouble("PC1"));
                obj.setPc2(rs.getDouble("PC2"));
                obj.setEp(rs.getDouble("EP"));
                obj.setEf(rs.getDouble("EF"));
                
                lista.add(obj);
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
        return lista;
    }
}

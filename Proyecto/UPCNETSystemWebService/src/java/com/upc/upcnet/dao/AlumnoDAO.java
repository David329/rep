/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.dao;

import com.upc.upcnet.entidades.Alumno;
import java.util.ArrayList;
import java.util.List;
import com.upc.upcnet.BD.AccesoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author win7
 */
public class AlumnoDAO {
    
    public List<Alumno> getAlumnos(){
        List<Alumno> alumnos = new ArrayList<>();
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDAlumno, Nombre, Apellido, DNI, Edad, Correo, Direccion, IDCategoria, IDApoderado, Pass FROM Alumno");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getString("IDAlumno"));
                a.setNombre(rs.getString("Nombre"));
                a.setApellido(rs.getString("Apellido"));
                a.setDni(rs.getInt("DNI"));
                a.setEdad(rs.getInt("Edad"));
                a.setCorreo(rs.getString("Correo"));
                a.setDireccion(rs.getString("Direccion"));
                a.setIdCategoria(rs.getString("IDCategoria"));
                a.setIdApoderado(rs.getString("IDApoderado"));
                a.setPass(rs.getString("Pass"));
                
                alumnos.add(a);
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
        return alumnos;
    }
    
    public List<Alumno> getAlumnosById(String _idAlumno){
         List<Alumno> alumnos = new ArrayList<>();
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDAlumno, Nombre, Apellido, DNI, Edad, Correo, Direccion, IDCategoria, IDApoderado, Pass FROM Alumno WHERE IDAlumno = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idAlumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getString("IDAlumno"));
                a.setNombre(rs.getString("Nombre"));
                a.setApellido(rs.getString("Apellido"));
                a.setDni(rs.getInt("DNI"));
                a.setEdad(rs.getInt("Edad"));
                a.setCorreo(rs.getString("Correo"));
                a.setDireccion(rs.getString("Direccion"));
                a.setIdCategoria(rs.getString("IDCategoria"));
                a.setIdApoderado(rs.getString("IDApoderado"));
                a.setPass(rs.getString("Pass"));
                
                alumnos.add(a);
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
        return alumnos;
    }
    
    public void setAlumno(Alumno objAlumno){
        Connection cn = null;        
        try{
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Alumno WHERE IDAlumno = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objAlumno.getIdAlumno());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                throw new SQLException("El codigo del alumno ya existe");
            
            query = new StringBuilder();
            query.append("INSERT INTO Alumno(IDAlumno, Nombre, Apellido, DNI, Edad, Correo, Direccion, IDCategoria, IDApoderado, Pass) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objAlumno.getIdAlumno());
            ps.setString(2, objAlumno.getNombre());
            ps.setString(3, objAlumno.getApellido());
            ps.setInt(4, objAlumno.getDni());
            ps.setInt(5, objAlumno.getEdad());
            ps.setString(6, objAlumno.getCorreo());
            ps.setString(7, objAlumno.getDireccion());
            ps.setString(8, objAlumno.getIdCategoria());
            ps.setString(9, objAlumno.getIdApoderado());
            ps.setString(10, objAlumno.getPass());
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
    
    public void editAlumno(Alumno objAlumno){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Alumno SET Nombre = ?, Apellido = ?, DNI = ?, Edad = ?, Correo = ?, Direccion = ?, IDCategoria = ?, IDApoderado = ?, Pass = ? WHERE IDAlumno = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objAlumno.getNombre());
            ps.setString(2, objAlumno.getApellido());
            ps.setInt(3, objAlumno.getDni());
            ps.setInt(4, objAlumno.getEdad());
            ps.setString(5, objAlumno.getCorreo());
            ps.setString(6, objAlumno.getDireccion());
            ps.setString(7, objAlumno.getIdCategoria());
            ps.setString(8, objAlumno.getIdApoderado());
            ps.setString(9, objAlumno.getPass());
            ps.setString(10, objAlumno.getIdAlumno());
            int realizado = ps.executeUpdate();
            cn.commit();
            if(realizado == 0)
                throw  new SQLException("Alumno no existe!");            
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
    
    public boolean validarLoginAlumno(String _idAlumno, String _pass){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Alumno WHERE IDAlumno = ? AND Pass = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idAlumno);
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

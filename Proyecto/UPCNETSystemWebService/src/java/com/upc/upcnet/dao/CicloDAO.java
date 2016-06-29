/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.dao;

import com.upc.upcnet.BD.AccesoDB;
import com.upc.upcnet.entidades.Ciclo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @a   uthor davidwesker
 */
public class CicloDAO {
    public List<Ciclo> getCiclo() {
        List<Ciclo> ciclos = new ArrayList<>();
        Connection con = null;
        try {
            con = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDCiclo,IDAlumno,Boleta1,Boleta2,Boleta3 from Ciclo");
            PreparedStatement ps = con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ciclo a = new Ciclo();
                a.setIDCiclo(rs.getString("IDCiclo"));
                a.setIDAlumno(rs.getString("IDAlumno"));
                a.setBoleta1(rs.getBoolean("Boleta1"));
                a.setBoleta2(rs.getBoolean("Boleta2"));
                a.setBoleta3(rs.getBoolean("Boleta3"));
                
                ciclos.add(a);
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
        return ciclos;
    }
    public void setCiclo(Ciclo objCiclo){
        Connection cn = null;        
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Ciclo WHERE IDCiclo = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objCiclo.getIDCiclo());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                throw new SQLException("El codigo del Ciclo ya existe");
            
            query = new StringBuilder();
            query.append("INSERT INTO Ciclo(IDCiclo, IDAlumno, Boleta1, Boleta2, Boleta3) VALUES(?, ?, ?, ?, ?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objCiclo.getIDCiclo());
            ps.setString(2, objCiclo.getIDAlumno());
            ps.setBoolean(3, objCiclo.isBoleta1());
            ps.setBoolean(4, objCiclo.isBoleta2());
            ps.setBoolean(5, objCiclo.isBoleta3());
            
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
    public void editCiclo(Ciclo objCiclo){
        Connection cn = null;
        try{
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Ciclo SET IDAlumno = ?, Boleta1 = ?, Boleta2 = ?, Boleta3 = ? WHERE IDCiclo= ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            
            ps.setString(1, objCiclo.getIDAlumno());
            ps.setBoolean(2,objCiclo.isBoleta1());
            ps.setBoolean(3, objCiclo.isBoleta2());
            ps.setBoolean(4, objCiclo.isBoleta3());
            ps.setString(5, objCiclo.getIDCiclo());
            
            int realizado = ps.executeUpdate();
            if(realizado == 0)
                throw  new SQLException("Ciclo no existe!");            
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
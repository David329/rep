/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.dao;

import com.upc.upcnet.entidades.Profesor;
import java.util.ArrayList;
import java.util.List;
import com.upc.upcnet.BD.AccesoDB;
import com.upc.upcnet.entidades.AlumnosEnCurso;
import com.upc.upcnet.entidades.CursoClase;
import com.upc.upcnet.entidades.CursoProfesor;
import com.upc.upcnet.entidades.HorarioProfesor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Petith
 */
public class ProfesorDAO {

    public List<Profesor> getProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDProfesor, Nombre, Apellido, DNI, Edad, Correo, Direccion, Sueldo, Pass FROM Profesor");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Profesor p = new Profesor();
                p.setIdProfesor(rs.getString("IDProfesor"));
                p.setNombre(rs.getString("Nombre"));
                p.setApellido(rs.getString("Apellido"));
                p.setDni(rs.getInt("DNI"));
                p.setEdad(rs.getInt("Edad"));
                p.setCorreo(rs.getString("Correo"));
                p.setDireccion(rs.getString("Direccion"));
                p.setSueldo(rs.getDouble("Sueldo"));
                p.setPass(rs.getString("Pass"));

                profesores.add(p);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
        return profesores;
    }

    public List<Profesor> getProfesorById(String _idProfesor) {
        List<Profesor> profesores = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT IDProfesor, Nombre, Apellido, DNI, Edad, Correo, Direccion, Sueldo, Pass FROM Profesor WHERE IDProfesor = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idProfesor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Profesor p = new Profesor();
                p.setIdProfesor(rs.getString("IDProfesor"));
                p.setNombre(rs.getString("Nombre"));
                p.setApellido(rs.getString("Apellido"));
                p.setDni(rs.getInt("DNI"));
                p.setEdad(rs.getInt("Edad"));
                p.setCorreo(rs.getString("Correo"));
                p.setDireccion(rs.getString("Direccion"));
                p.setSueldo(rs.getDouble("Sueldo"));
                p.setPass(rs.getString("Pass"));

                profesores.add(p);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
        return profesores;
    }

    public void setProfesor(Profesor objProfesor) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Profesor WHERE IDProfesor = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProfesor.getIdProfesor());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new SQLException("El codigo del profesor ya existe");
            }

            query = new StringBuilder();
            query.append("INSERT INTO Profesor(IDProfesor, Nombre, Apellido, DNI, Edad, Correo, Direccion, Sueldo, Pass) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProfesor.getIdProfesor());
            ps.setString(2, objProfesor.getNombre());
            ps.setString(3, objProfesor.getApellido());
            ps.setInt(4, objProfesor.getDni());
            ps.setInt(5, objProfesor.getEdad());
            ps.setString(6, objProfesor.getCorreo());
            ps.setString(7, objProfesor.getDireccion());
            ps.setDouble(8, objProfesor.getSueldo());
            ps.setString(9, objProfesor.getPass());
            ps.executeUpdate();
            cn.commit();

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    public void editProfesor(Profesor objProfesor) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Profesor SET Nombre = ?, Apellido = ?, DNI = ?, Edad = ?, Correo = ?, Direccion = ?, Sueldo = ?, Pass = ? WHERE IDProfesor = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProfesor.getNombre());
            ps.setString(2, objProfesor.getApellido());
            ps.setInt(3, objProfesor.getDni());
            ps.setInt(4, objProfesor.getEdad());
            ps.setString(5, objProfesor.getCorreo());
            ps.setString(6, objProfesor.getDireccion());
            ps.setDouble(7, objProfesor.getSueldo());
            ps.setString(8, objProfesor.getPass());
            ps.setString(9, objProfesor.getIdProfesor());
            int realizado = ps.executeUpdate();
            cn.commit();
            if (realizado == 0) {
                throw new SQLException("Profesor no existe!");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    public boolean validarLogin(String _idProfesor, String _pass) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Profesor WHERE IDProfesor = ? AND Pass = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idProfesor);
            ps.setString(2, _pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    public List<HorarioProfesor> getHorarioProfesor(String _idProfesor) {
        List<HorarioProfesor> horarioProfesor = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT c.IDCurso, c.Nombre, cc.Dia, cc.HoraIni, cc.HoraFin FROM Curso c JOIN Profesor p ON p.IDProfesor = c.IDProfesor JOIN Curso_Clase cc ON cc.IDCurso = c.IDCurso WHERE p.IDProfesor = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idProfesor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HorarioProfesor hp = new HorarioProfesor();
                hp.setIDCurso(rs.getString("IDCurso"));
                hp.setNombre(rs.getString("Nombre"));
                hp.setDia(rs.getString("Dia"));
                hp.setHoraIni(rs.getString("HoraIni"));
                hp.setHoraFin(rs.getString("HoraFin"));

                horarioProfesor.add(hp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
        return horarioProfesor;
    }

    public List<CursoProfesor> getCursoProfesor(String _idProfesor) {
        List<CursoProfesor> cursoProfesor = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT c.IDCurso, c.Nombre, c.CicloDeCurso AS Ciclo FROM Curso c JOIN Profesor p ON p.IDProfesor = c.IDProfesor WHERE p.IDProfesor = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idProfesor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CursoProfesor cp = new CursoProfesor();
                cp.setIDCurso(rs.getString("IDCurso"));
                cp.setNombre(rs.getString("Nombre"));
                cp.setCicloDeCurso(rs.getInt("Ciclo"));

                cursoProfesor.add(cp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
        return cursoProfesor;
    }

    public List<AlumnosEnCurso> getAlumnosEnCurso(String _idCurso) {
        List<AlumnosEnCurso> alumnosEnCurso = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT a.IDAlumno,C.IDCurso, c.Nombre AS CursoN, a.Nombre AS AlumnoNombre, a.Apellido AS AlumnoApellido, ca.PC1, ca.PC2, ca.EP, ca.EF  FROM Curso c JOIN Curso_Alumno ca ON ca.IDCurso = c.IDCurso JOIN Alumno a ON a.IDAlumno = ca.IDAlumno WHERE c.IDCurso = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idCurso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AlumnosEnCurso cp = new AlumnosEnCurso();
                cp.setIDAlumno(rs.getString("IDAlumno"));
                cp.setIDCurso(rs.getString("IDCurso"));
                cp.setNombrec(rs.getString("CursoN"));
                cp.setNombrea(rs.getString("AlumnoNombre"));
                cp.setApellido(rs.getString("AlumnoApellido"));
                cp.setPc1(rs.getDouble("PC1"));
                cp.setPc2(rs.getDouble("PC2"));
                cp.setEp(rs.getDouble("EP"));
                cp.setEf(rs.getDouble("EF"));

                alumnosEnCurso.add(cp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
        return alumnosEnCurso;
    }

    public void setNotaAlumnosEnCurso(AlumnosEnCurso obj) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            PreparedStatement ps = null;
            if (obj.getPc1() > 0) {
                query.append("UPDATE curso_alumno SET PC1 = ? where IDAlumno = ? and IDCurso=?");
                ps = cn.prepareStatement(query.toString());
                ps.setDouble(1, obj.getPc1());
                ps.setString(2, obj.getIDAlumno());
                ps.setString(3, obj.getIDCurso());
            } else if (obj.getPc2() > 0) {
                query.append("UPDATE curso_alumno SET PC2 = ? where IDAlumno = ? and IDCurso=?");
                ps = cn.prepareStatement(query.toString());
                ps.setDouble(1, obj.getPc2());
                ps.setString(2, obj.getIDAlumno());
                ps.setString(3, obj.getIDCurso());
            } else if (obj.getEp() > 0) {
                query.append("UPDATE curso_alumno SET EP = ? where IDAlumno = ? and IDCurso=?");
                ps = cn.prepareStatement(query.toString());
                ps.setDouble(1, obj.getEp());
                ps.setString(2, obj.getIDAlumno());
                ps.setString(3, obj.getIDCurso());
            } else if (obj.getEp() > 0) {
                query.append("UPDATE curso_alumno SET EF = ? where IDAlumno = ? and IDCurso=?");
                ps = cn.prepareStatement(query.toString());
                ps.setDouble(1, obj.getEf());
                ps.setString(2, obj.getIDAlumno());
                ps.setString(3, obj.getIDCurso());
            }

            int realizado = ps.executeUpdate();
            cn.commit();
            if (realizado == 0) {
                throw new SQLException("Alumno no existe!");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
    }
}

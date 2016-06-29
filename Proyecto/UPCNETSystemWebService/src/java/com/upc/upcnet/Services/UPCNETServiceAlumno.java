/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.AlumnoDAO;
import com.upc.upcnet.entidades.Alumno;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Petith
 */
@WebService(serviceName = "UPCNETServiceAlumno")
public class UPCNETServiceAlumno {

    @WebMethod(operationName = "getAlumnos")
    public List<Alumno> getAlumnos() {
       AlumnoDAO objAlumnoDAO=new AlumnoDAO();
        List<Alumno>ListaAlumnos=objAlumnoDAO.getAlumnos();
        
        return ListaAlumnos; 
    }

    @WebMethod(operationName = "setAlumno")
    public void setAlumno(Alumno objAlumno) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.setAlumno(objAlumno);
        
    }

    @WebMethod(operationName = "editAlumno")
    public void editAlumno(Alumno objAlumno) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.editAlumno( objAlumno);
        
    }

    @WebMethod(operationName = "validarLoginAlumno")
    public boolean validarLogin(String _idAlumno, String _pass) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.validarLoginAlumno(_idAlumno, _pass);
    }

    @WebMethod(operationName = "getAlumnoById")
    public Alumno getAlumnoById(String _idAlumno) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        List<Alumno> alumnos = alumnoDAO.getAlumnosById(_idAlumno);
        return alumnos.get(0);
    }   
}

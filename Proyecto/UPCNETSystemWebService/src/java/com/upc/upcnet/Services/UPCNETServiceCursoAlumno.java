/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.CursoAlumnoDAO;
import com.upc.upcnet.entidades.Curso;
import com.upc.upcnet.entidades.CursoAlumno;
import com.upc.upcnet.entidades.CursoAlumnoReporte;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author davidwesker
 */
@WebService(serviceName = "UPCNETServiceCursoAlumno")
public class UPCNETServiceCursoAlumno {

    @WebMethod(operationName = "getCursoAlumno")
    public List<CursoAlumno> getCursoAlumno() {
        CursoAlumnoDAO objCursoAlumnoDAO = new CursoAlumnoDAO();
        List<CursoAlumno> ListaCursoAlumnos = objCursoAlumnoDAO.getCursoAlumno();

        return ListaCursoAlumnos;
    }

    @WebMethod(operationName = "setCursoAlumno")
    public void setCursoAlumno(CursoAlumno objCursoAlumno) {
        CursoAlumnoDAO cursoAlumnoDAO = new CursoAlumnoDAO();
        cursoAlumnoDAO.setCursoAlumno(objCursoAlumno);

    }

    @WebMethod(operationName = "editCursoAlumno")
    public void editCursoAlumno(CursoAlumno objCursoAlumno) {
        CursoAlumnoDAO cursoAlumnoDAO = new CursoAlumnoDAO();
        cursoAlumnoDAO.editCursoAlumno(objCursoAlumno);

    }

    @WebMethod(operationName = "getCursoAlumnoByIdCurso")
    public List<CursoAlumno> getCursoAlumnoByIdCurso(String _idCurso) {
        CursoAlumnoDAO cursoAlumnoDAO = new CursoAlumnoDAO();
        List<CursoAlumno> cursoalumnos = cursoAlumnoDAO.getCursoAlumnosByIdCurso(_idCurso);
        return cursoalumnos;
    }
    
    @WebMethod(operationName = "getCursoByIdAlumno")
    public List<Curso> getCursoByIdAlumno(String _idAlumno) {
        CursoAlumnoDAO cursoAlumnoDAO = new CursoAlumnoDAO();
        List<Curso> cursos = cursoAlumnoDAO.getCursoByIdAlumno(_idAlumno);
        return cursos;
    }
    
    @WebMethod(operationName = "getCursoAlumnoByID")
    public CursoAlumno getCursoAlumnoByID(String _idCurso,String _idAlumno) {
        CursoAlumnoDAO cursoAlumnoDAO = new CursoAlumnoDAO();
        List<CursoAlumno> cursoalumnos = cursoAlumnoDAO.getCursoAlumnoByID(_idCurso,_idAlumno);
        return cursoalumnos.get(0);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCursoAlumnoReporte")
    public List<CursoAlumnoReporte> getCursoAlumnoReporte(@WebParam(name = "idAlumno") String idAlumno) {
       CursoAlumnoDAO cursoAlumnoDAO = new CursoAlumnoDAO();
       List<CursoAlumnoReporte> lista = cursoAlumnoDAO.getCursoAlumnoReporte(idAlumno);
       return lista;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.CursoClaseDAO;
import com.upc.upcnet.entidades.CursoClase;
import com.upc.upcnet.entidades.CursoClaseAlumno;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author davidwesker
 */
@WebService(serviceName = "UPCNETServiceCursoClase")
public class UPCNETServiceCursoClase {

    @WebMethod(operationName = "getCursoClase")
    public List<CursoClase> getCursoClase() {
       CursoClaseDAO objCursoClaseDAO=new CursoClaseDAO();
        List<CursoClase>ListaCursoClases=objCursoClaseDAO.getCursoClase();
        
        return ListaCursoClases; 
    }

    @WebMethod(operationName = "setCursoClase")
    public void setCursoClase(CursoClase objCursoClase) {
        CursoClaseDAO cursoClaseDAO = new CursoClaseDAO();
        cursoClaseDAO.setCursoClase(objCursoClase);
        
    }

    @WebMethod(operationName = "editCursoClase")
    public void editCursoClase(CursoClase objCursoClase) {
        CursoClaseDAO cursoClaseDAO = new CursoClaseDAO();
        cursoClaseDAO.editCursoClase(objCursoClase);
        
    }
    
    @WebMethod(operationName = "getCursoClaseByIdCurso")
    public List<CursoClase> getCursoClaseByIdCurso(String _idCurso) {
        CursoClaseDAO cursoClaseDAO = new CursoClaseDAO();
        List<CursoClase> cursosclase = cursoClaseDAO.getCursoClasesByIdCurso(_idCurso);
        return cursosclase;
    }
    
    @WebMethod(operationName = "getCursoClaseByID")
    public CursoClase getCursoClaseByID(String _idCurso,String _idClase) {
        CursoClaseDAO cursoClaseDAO = new CursoClaseDAO();
        List<CursoClase> cursosclase = cursoClaseDAO.getCursoClaseByID(_idCurso, _idClase);
        return cursosclase.get(0);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCursoClaseAlumno")
    public List<CursoClaseAlumno> getCursoClaseAlumno(@WebParam(name = "idAlumno") String idAlumno) {
        CursoClaseDAO cursoClaseDAO = new CursoClaseDAO();
        List<CursoClaseAlumno> lista = cursoClaseDAO.getCursoClaseAlumno(idAlumno);
        return lista;
    }
    
    
}

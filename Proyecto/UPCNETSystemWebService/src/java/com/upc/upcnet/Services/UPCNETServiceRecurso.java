/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.ApoderadoDAO;
import com.upc.upcnet.dao.RecursoDAO;
import com.upc.upcnet.entidades.Recurso;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author davidwesker
 */
@WebService(serviceName = "UPCNETServiceRecurso")
public class UPCNETServiceRecurso {

    @WebMethod(operationName = "getRecurso")
    public List<Recurso> getRecurso() {

        RecursoDAO objRecursoDAO = new RecursoDAO();
        List<Recurso> ListaRecurso = objRecursoDAO.getRecurso();

        return ListaRecurso;
    }

    @WebMethod(operationName = "setRecurso")
    public void setRecurso(Recurso objRecurso) {

        RecursoDAO objRecursoDAO = new RecursoDAO();
        objRecursoDAO.setRecurso(objRecurso);
    }

    @WebMethod(operationName = "editRecurso")
    public void editRecurso(Recurso objRecurso) {

        RecursoDAO objRecursoDAO = new RecursoDAO();
        objRecursoDAO.editRecurso(objRecurso);
    }
}

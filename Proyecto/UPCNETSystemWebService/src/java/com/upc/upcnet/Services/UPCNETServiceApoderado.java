/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.entidades.Apoderado;
import java.util.List;
import javax.jws.WebMethod;
import com.upc.upcnet.dao.*;
import java.util.ArrayList;
import javax.jws.WebService;
/**
 *
 * @author davidwesker
 */
@WebService(serviceName = "UPCNETServiceApoderado")
public class UPCNETServiceApoderado {
    
    @WebMethod(operationName = "getApoderado")
    public List<Apoderado> getApoderado(){
        
        ApoderadoDAO objApoderadoDAO=new ApoderadoDAO();
        List<Apoderado>ListaApoderado=objApoderadoDAO.getApoderados();
        
        return ListaApoderado;  
    }
    
    @WebMethod(operationName = "setApoderado")
    public void setApoderado(Apoderado objApoderado){
        
        ApoderadoDAO objApoderadoDAO=new ApoderadoDAO();
        objApoderadoDAO.setApoderado(objApoderado);
    }
    
    @WebMethod(operationName = "editApoderado")
    public void editApoderado( Apoderado objApoderado){
        
        ApoderadoDAO objApoderadoDAO=new ApoderadoDAO();
        objApoderadoDAO.editApoderado(objApoderado);
    }
    @WebMethod(operationName = "getApoderadoById")
    public Apoderado getApoderadooById(String _idApoderado) {
        ApoderadoDAO apoderadoDAO = new ApoderadoDAO();
        List<Apoderado> apoderados = apoderadoDAO.getApoderadoById(_idApoderado);
        return apoderados.get(0);
    }
    
    @WebMethod(operationName = "validarLoginApoderado")
    public boolean validarLogin(String _idApoderado, String _pass) {
        ApoderadoDAO apoderadoDAO = new ApoderadoDAO();
        return apoderadoDAO.validarLoginApoderado(_idApoderado, _pass);
    }
}

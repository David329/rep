/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.CicloDAO;
import com.upc.upcnet.entidades.Ciclo;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author davidwesker
 */
@WebService(serviceName = "UPCNETServiceCiclo")
public class UPCNETServiceCiclo {
    
    @WebMethod(operationName = "getCiclo")
    public List<Ciclo> getCiclo(){
        
        CicloDAO objCicloDAO=new CicloDAO();
        List<Ciclo>ListaCiclo=objCicloDAO.getCiclo();
        
        return ListaCiclo;  
    }
    
    @WebMethod(operationName = "setCiclo")
    public void setCiclo(Ciclo objCiclo){
        
        CicloDAO objCicloDAO=new CicloDAO();
        objCicloDAO.setCiclo(objCiclo);
    }
    
    @WebMethod(operationName = "editCiclo")
    public void editCiclo(Ciclo objCiclo){
        
        CicloDAO objCicloDAO=new CicloDAO();
        objCicloDAO.editCiclo(objCiclo);
    }
    
}
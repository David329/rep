/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.CategoriaDAO;
import com.upc.upcnet.entidades.Categoria;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author davidwesker
 */
@WebService(serviceName = "UPCNETServiceCategoria")
public class UPCNETServiceCategoria {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getCategoria")
    public List<Categoria> getCategoria(){
        
        CategoriaDAO objCategoriaDAO=new CategoriaDAO();
        List<Categoria>ListaCategoria=objCategoriaDAO.getCategoria();
        
        return ListaCategoria;  
    }
    
    @WebMethod(operationName = "setCategoria")
    public void setCategoria(String _idCategoria, String _monto){
        
        CategoriaDAO objCategoriaDAO=new CategoriaDAO();
        objCategoriaDAO.setCategoria(_idCategoria, _monto);
    }
    
    @WebMethod(operationName = "editCategoria")
    public void editCategoria(String _idCategoria, String _monto){
        
        CategoriaDAO objCategoriaDAO=new CategoriaDAO();
        objCategoriaDAO.editCategoria(_idCategoria, _monto);
    }
}

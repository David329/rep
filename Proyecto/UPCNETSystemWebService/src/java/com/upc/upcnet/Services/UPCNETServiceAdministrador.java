/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.AdministradorDAO;
import com.upc.upcnet.entidades.Administrador;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author davidwesker
 */
@WebService(serviceName = "UPCNETServiceAdministrador")
public class UPCNETServiceAdministrador {
    
    @WebMethod(operationName = "getAdministrador")
    public List<Administrador> getAdministrador(){
        
        AdministradorDAO objAdministradorDAO=new AdministradorDAO();
        List<Administrador>ListaAdministrador=objAdministradorDAO.getAdministrador();
        
        return ListaAdministrador;  
    }
    
    @WebMethod(operationName = "setAdministrador")
    public void setAdministrador(String _idAdministrador,String _pass, String _nombre, String _apellido, String _correo){
        
        AdministradorDAO objAdministradorDAO=new AdministradorDAO();
        objAdministradorDAO.setAdministrador(_idAdministrador, _pass, _nombre, _apellido, _correo);
    }
    
    @WebMethod(operationName = "editAdministrador")
    public void editAdministrador(String _idAdministrador,String _pass, String _nombre, String _apellido, String _correo){
        
        AdministradorDAO objAdministradorDAO=new AdministradorDAO();
        objAdministradorDAO.editAdministrador(_idAdministrador, _pass, _nombre, _apellido, _correo);
    }
    @WebMethod(operationName = "validarLoginAdministrador")
    public boolean validarLoginAdministrador(String _idAdministrador, String _pass) {
        AdministradorDAO administradorDAO = new AdministradorDAO();
        return administradorDAO.validarLoginAdminitrador(_idAdministrador, _pass);
    }

    @WebMethod(operationName = "getAdministradorById")
    public Administrador getAdministradorById(String _idAdministrador) {
        AdministradorDAO administradorDAO = new AdministradorDAO();
        List<Administrador> administradores = administradorDAO.getAdministradoresById(_idAdministrador);
        return administradores.get(0);
    } 
}

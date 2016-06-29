/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.AdministradorDAO;
import com.upc.upcnet.dao.CursoDAO;
import com.upc.upcnet.entidades.Administrador;
import com.upc.upcnet.entidades.Curso;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davidwesker
 */
public class UPCNETServiceAdministradorTest {
    
    public UPCNETServiceAdministradorTest() {
    }

    
    @Test
    public void testGetAdministrador() {
        System.out.println("TestRetornarTodosLosAdministradores");
        AdministradorDAO objAdministradorDAO=new AdministradorDAO();
        List<Administrador>expResult1=objAdministradorDAO.getAdministrador();
        
        CursoDAO objCursoDAO=new CursoDAO();
        List<Curso>expResult2=objCursoDAO.getCursos();
        assertNotEquals(expResult1, expResult2);
    }
    @Test
    public void testSetAdministrador() {
        System.out.println("TestAgregarAdministrador");
        AdministradorDAO objAdministradorDAO=new AdministradorDAO();
        int expResult1=objAdministradorDAO.getAdministrador().size()+1;
        String id="TAD"+(objAdministradorDAO.getAdministrador().size()+1);
        
        objAdministradorDAO.setAdministrador(id, "a", "David", "Silva","davidsilva3290@gmail.com" );
        int expResult2=objAdministradorDAO.getAdministrador().size();
        assertEquals(expResult1, expResult2);
    }
    @Test
    public void testGetAdministradorById() {
        System.out.println("testGetAdministradorById");
        AdministradorDAO objAdministradorDAO=new AdministradorDAO();
        assertNotNull(objAdministradorDAO.getAdministradoresById("a"));
    }
    @Test
    public void testValidarLoginAdministrador() {
        System.out.println("TestValidarLoginAdministrador");
        AdministradorDAO objAdministradorDAO=new AdministradorDAO();
        assertTrue(objAdministradorDAO.validarLoginAdminitrador("a", "a"));
    }    
}
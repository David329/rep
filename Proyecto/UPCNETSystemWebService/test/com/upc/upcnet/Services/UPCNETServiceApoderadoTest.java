/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.ApoderadoDAO;
import com.upc.upcnet.dao.CursoDAO;
import com.upc.upcnet.entidades.Apoderado;
import com.upc.upcnet.entidades.Curso;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davidwesker
 */
public class UPCNETServiceApoderadoTest {
    
    public UPCNETServiceApoderadoTest() {
    }
    @Test
    public void testGetApoderado() {
        System.out.println("TestRetornarTodosLosApoderados");
        ApoderadoDAO objApoderadoDAO=new ApoderadoDAO();
        List<Apoderado>expResult1=objApoderadoDAO.getApoderados();
        
        CursoDAO objCursoDAO=new CursoDAO();
        List<Curso>expResult2=objCursoDAO.getCursos();
        assertNotEquals(expResult1, expResult2);
    }
    @Test
    public void testSetApoderado() {
        System.out.println("TestAgregarApoderado");
        ApoderadoDAO objApoderadoDAO=new ApoderadoDAO();
        int expResult1=objApoderadoDAO.getApoderados().size()+1;
        String id="TAP"+(objApoderadoDAO.getApoderados().size()+1);
        
        Apoderado objApoderado=new Apoderado();
        objApoderado.setApellido("Silva");
        objApoderado.setNombre("David");
        objApoderado.setCondicion("Padre");
        objApoderado.setCorreo("davidisilva@gmail.com");
        objApoderado.setDNI(72721611);
        objApoderado.setDireccion("Las orquideas");
        objApoderado.setEdad(12);
        objApoderado.setIDApoderado(id);
        objApoderado.setPass("a");
        objApoderadoDAO.setApoderado(objApoderado);
        int expResult2=objApoderadoDAO.getApoderados().size();
        assertEquals(expResult1, expResult2);
    }
    @Test
    public void testGetApoderadoById() {
        System.out.println("TestGetApoderadoById");
        ApoderadoDAO objApoderadoDAO=new ApoderadoDAO();
        String ID="AP101";
        Apoderado obj=objApoderadoDAO.getApoderadoById(ID).get(0);
        String expResult1=obj.getIDApoderado();
        String expResult2=ID;
        assertEquals(expResult1, expResult2);
    }
    @Test
    public void testValidarLoginApoderado() {
        System.out.println("TestValidarLoginApoderado");
        ApoderadoDAO objApoderadoDAO=new ApoderadoDAO();
        assertTrue(objApoderadoDAO.validarLoginApoderado("AP101", "ap101ap"));
    }    
}

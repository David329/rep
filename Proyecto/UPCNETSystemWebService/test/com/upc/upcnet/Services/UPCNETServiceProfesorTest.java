/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.CursoDAO;
import com.upc.upcnet.dao.ProfesorDAO;
import com.upc.upcnet.entidades.Curso;
import com.upc.upcnet.entidades.Profesor;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davidwesker
 */
public class UPCNETServiceProfesorTest {

    public UPCNETServiceProfesorTest() {
    }

    @Test
    public void testGetProfesor() {
        System.out.println("TestRetornarTodosLosProfesores");
        ProfesorDAO objProfesorDAO = new ProfesorDAO();
        List<Profesor> expResult1 = objProfesorDAO.getProfesores();

        CursoDAO objCursoDAO = new CursoDAO();
        List<Curso> expResult2 = objCursoDAO.getCursos();
        assertNotEquals(expResult1, expResult2);
    }

    @Test
    public void testSetProfesor() {
        System.out.println("TestAgregarProfesor");
        ProfesorDAO objProfesorDAO = new ProfesorDAO();
        int expResult1 = objProfesorDAO.getProfesores().size() + 1;
        String id = "TPR" + (objProfesorDAO.getProfesores().size() + 1);
        Profesor objProfesor = new Profesor();
        objProfesor.setApellido("Solano");
        objProfesor.setCorreo("enrique@gmail.com");
        objProfesor.setDireccion("Don Ian 144");
        objProfesor.setDni(72726113);
        objProfesor.setEdad(13);
        objProfesor.setIdProfesor(id);
        objProfesor.setNombre("Pepi");
        objProfesor.setPass("a");
        objProfesor.setSueldo(13.20);

        objProfesorDAO.setProfesor(objProfesor);
        int expResult2 = objProfesorDAO.getProfesores().size();
        assertEquals(expResult1, expResult2);
    }

    @Test
    public void testGetProfesorById() {
        System.out.println("testGetProfesorById");
        ProfesorDAO objProfesorDAO = new ProfesorDAO();
        assertNotNull(objProfesorDAO.getProfesorById("P0001"));
    }

    @Test
    public void testValidarLoginProfesor() {
        System.out.println("TestValidarLoginProfesor");
        ProfesorDAO objProfesorDAO = new ProfesorDAO();
        assertTrue(objProfesorDAO.validarLogin("P0001", "1234"));
    }

    @Test
    public void testGetHorarioProfesor() {
        System.out.println("TestGetHorarioProfesor");
        ProfesorDAO objProfesorDAO = new ProfesorDAO();
        assertNotNull(objProfesorDAO.getHorarioProfesor("P0001"));
    }
    
    @Test
    public void testGetCursoProfesor() {
        System.out.println("TestGetCursoProfesor");
        ProfesorDAO objProfesorDAO = new ProfesorDAO();
        assertNotNull(objProfesorDAO.getCursoProfesor("P0001"));
    }
    
    @Test
    public void testGetAlumnosEnCurso() {
        System.out.println("TestGetAlumnosEnCurso");
        ProfesorDAO objProfesorDAO = new ProfesorDAO();
        assertNotNull(objProfesorDAO.getAlumnosEnCurso("C001"));
    }
}

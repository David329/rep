/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.Services;

import com.upc.upcnet.dao.AlumnoDAO;
import com.upc.upcnet.dao.CursoDAO;
import com.upc.upcnet.entidades.Alumno;
import com.upc.upcnet.entidades.Curso;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davidwesker
 */
public class UPCNETServiceCursoTest {

    public UPCNETServiceCursoTest() {
    }

    @Test
    public void testGetCurso() {
        System.out.println("TestRetornarTodosLosCursos");
        CursoDAO objCursoDAO = new CursoDAO();
        List<Curso> expResult1 = objCursoDAO.getCursos();

        AlumnoDAO objAlumnoDAO = new AlumnoDAO();
        List<Alumno> expResult2 = objAlumnoDAO.getAlumnos();
        assertNotEquals(expResult1, expResult2);
    }

    @Test
    public void testSetCurso() {
        System.out.println("TestAgregarCurso");
        CursoDAO objCursoDAO = new CursoDAO();
        int expResult1 = objCursoDAO.getCursos().size() + 1;
        String id = "TCU" + (objCursoDAO.getCursos().size() + 1);
        Curso objCurso = new Curso();
        objCurso.setCicloDeCurso(1);
        objCurso.setIdCurso(id);
        objCurso.setIdProfesor("P0001");
        objCurso.setMaxInasistencia(12);
        objCursoDAO.setCurso(objCurso);
        int expResult2 = objCursoDAO.getCursos().size();
        assertEquals(expResult1, expResult2);
    }
    @Test
    public void testGetCursoById() {
        System.out.println("testGetCursoById");
        CursoDAO objCursoDAO = new CursoDAO();
        assertNotNull(objCursoDAO.getCursosById("C001"));
    }
}

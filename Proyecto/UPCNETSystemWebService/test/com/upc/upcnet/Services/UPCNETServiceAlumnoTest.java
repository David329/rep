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
public class UPCNETServiceAlumnoTest {

    public UPCNETServiceAlumnoTest() {
    }

    @Test
    public void testGetAlumnos() {
        System.out.println("TestRetornarTodosLosAlumnos");
        AlumnoDAO objAlumnoDAO = new AlumnoDAO();
        List<Alumno> expResult1 = objAlumnoDAO.getAlumnos();

        CursoDAO objCursoDAO = new CursoDAO();
        List<Curso> expResult2 = objCursoDAO.getCursos();
        assertNotEquals(expResult1, expResult2);
    }

    @Test
    public void testSetAlumno() {
        System.out.println("TestAgregarAlumno");
        AlumnoDAO objAlumnoDAO = new AlumnoDAO();
        int expResult1 = objAlumnoDAO.getAlumnos().size() + 1;
        String id = "TAL" + (objAlumnoDAO.getAlumnos().size() + 1);
        Alumno objAlumno = new Alumno();
        objAlumno.setApellido("Maguina");
        objAlumno.setCorreo("david@gmail.com");
        objAlumno.setDireccion("orquideas101");
        objAlumno.setDni(72721611);
        objAlumno.setEdad(12);
        objAlumno.setIdAlumno(id);
        objAlumno.setIdApoderado("AP101");
        objAlumno.setIdCategoria("Q");
        objAlumno.setNombre("Ian");
        objAlumno.setPass("a");

        objAlumnoDAO.setAlumno(objAlumno);
        int expResult2 = objAlumnoDAO.getAlumnos().size();
        assertEquals(expResult1, expResult2);
    }

    @Test
    public void testGetAlumnoById() {
        System.out.println("testGetAlumnoById");
        AlumnoDAO objAlumnoDAO = new AlumnoDAO();
        assertNotNull(objAlumnoDAO.getAlumnosById("a"));
    }

    @Test
    public void testValidarLoginAlumno() {
        System.out.println("TestValidarLoginAlumno");
        AlumnoDAO objAlumnoDAO = new AlumnoDAO();
        boolean asd = objAlumnoDAO.validarLoginAlumno("AL101", "al101al");
        assertTrue(asd);
    }
}

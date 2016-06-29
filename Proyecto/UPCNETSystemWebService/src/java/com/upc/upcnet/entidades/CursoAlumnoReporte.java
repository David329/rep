/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.entidades;

/**
 *
 * @author Petith
 */
public class CursoAlumnoReporte {
    private String idCurso;
    private String curso;
    private String profesor;
    private double pc1;
    private double pc2;
    private double ep;
    private double ef;

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public double getPc1() {
        return pc1;
    }

    public void setPc1(double pc1) {
        this.pc1 = pc1;
    }

    public double getPc2() {
        return pc2;
    }

    public void setPc2(double pc2) {
        this.pc2 = pc2;
    }

    public double getEp() {
        return ep;
    }

    public void setEp(double ep) {
        this.ep = ep;
    }

    public double getEf() {
        return ef;
    }

    public void setEf(double ef) {
        this.ef = ef;
    }
    
    
}

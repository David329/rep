/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.entidades;

/**
 *
 * @author davidwesker
 */
public class AlumnosEnCurso {
    private String IDAlumno;
    private String IDCurso;
    private String nombrec;
    private String nombrea;
    private String apellido;
    private double pc1;
    private double pc2;
    private double ep;
    private double ef;

    public String getIDAlumno() {
        return IDAlumno;
    }

    public void setIDAlumno(String IDAlumno) {
        this.IDAlumno = IDAlumno;
    }
    
    public String getIDCurso() {
        return IDCurso;
    }

    public void setIDCurso(String IDCurso) {
        this.IDCurso = IDCurso;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public String getNombrea() {
        return nombrea;
    }

    public void setNombrea(String nombrea) {
        this.nombrea = nombrea;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

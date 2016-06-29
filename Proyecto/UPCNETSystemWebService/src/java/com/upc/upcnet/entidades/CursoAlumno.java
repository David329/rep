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
public class CursoAlumno {
    private String idAlumno;
    private String idCurso;
    private double pc1;
    private double pc2;
    private double ep;
    private double ef;
    private boolean retirado;
    private int Inasistencias;
    private boolean Delegado;

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
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

    public boolean isRetirado() {
        return retirado;
    }

    public void setRetirado(boolean retirado) {
        this.retirado = retirado;
    }
    

    public int getInasistencias() {
        return Inasistencias;
    }

    public void setInasistencias(int Inasistencias) {
        this.Inasistencias = Inasistencias;
    }

    public boolean isDelegado() {
        return Delegado;
    }

    public void setDelegado(boolean Delegado) {
        this.Delegado = Delegado;
    }
    
}

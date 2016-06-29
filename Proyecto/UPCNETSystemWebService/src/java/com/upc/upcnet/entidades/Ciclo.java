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
public class Ciclo {
    
    private String IDCiclo;
    private String IDAlumno;
    private boolean Boleta1;
    private boolean Boleta2;
    private boolean Boleta3;

    public String getIDCiclo() {
        return IDCiclo;
    }

    public void setIDCiclo(String IDCiclo) {
        this.IDCiclo = IDCiclo;
    }

    public String getIDAlumno() {
        return IDAlumno;
    }

    public void setIDAlumno(String IDAlumno) {
        this.IDAlumno = IDAlumno;
    }

    public boolean isBoleta1() {
        return Boleta1;
    }

    public void setBoleta1(boolean Boleta1) {
        this.Boleta1 = Boleta1;
    }

    public boolean isBoleta2() {
        return Boleta2;
    }

    public void setBoleta2(boolean Boleta2) {
        this.Boleta2 = Boleta2;
    }

    public boolean isBoleta3() {
        return Boleta3;
    }

    public void setBoleta3(boolean Boleta3) {
        this.Boleta3 = Boleta3;
    }
    
    
}

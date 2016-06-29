/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.entidades;

import java.sql.Date;

/**
 *
 * @author davidwesker
 */
public class Recurso {
    private String IDRecurso;
    private String NombreRecurso;
    private String IDAlumno;
    private String IDProfesor;
    private int CantidadHoras;
    private boolean Reservado;
    private Date FechaPedido;

    public String getIDRecurso() {
        return IDRecurso;
    }

    public void setIDRecurso(String IDRecurso) {
        this.IDRecurso = IDRecurso;
    }

    public String getNombreRecurso() {
        return NombreRecurso;
    }

    public void setNombreRecurso(String NombreRecurso) {
        this.NombreRecurso = NombreRecurso;
    }

    public String getIDAlumno() {
        return IDAlumno;
    }

    public void setIDAlumno(String IDAlumno) {
        this.IDAlumno = IDAlumno;
    }

    public String getIDProfesor() {
        return IDProfesor;
    }

    public void setIDProfesor(String IDProfesor) {
        this.IDProfesor = IDProfesor;
    }

    public int getCantidadHoras() {
        return CantidadHoras;
    }

    public void setCantidadHoras(int CantidadHoras) {
        this.CantidadHoras = CantidadHoras;
    }

    public boolean isReservado() {
        return Reservado;
    }

    public void setReservado(boolean Reservado) {
        this.Reservado = Reservado;
    }

    public Date getFechaPedido() {
        return FechaPedido;
    }

    public void setFechaPedido(Date FechaPedido) {
        this.FechaPedido = FechaPedido;
    }
}

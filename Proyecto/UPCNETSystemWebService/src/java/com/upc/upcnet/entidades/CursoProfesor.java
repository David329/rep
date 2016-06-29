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
public class CursoProfesor {
    private String IDCurso;
    private String nombre;
    private int cicloDeCurso;

    public String getIDCurso() {
        return IDCurso;
    }

    public void setIDCurso(String IDCurso) {
        this.IDCurso = IDCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCicloDeCurso() {
        return cicloDeCurso;
    }

    public void setCicloDeCurso(int cicloDeCurso) {
        this.cicloDeCurso = cicloDeCurso;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.upcnet.entidades;

/**
 *
 * @author ALEX
 */
public class Curso {
    private String idCurso;
    private String nombre;
    private int cicloDeCurso;
    private int maxInasistencia;
    private String idProfesor;

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
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

    public int getMaxInasistencia() {
        return maxInasistencia;
    }

    public void setMaxInasistencia(int maxInasistencia) {
        this.maxInasistencia = maxInasistencia;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }
    
    
}

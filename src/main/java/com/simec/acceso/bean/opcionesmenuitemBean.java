/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.acceso.bean;

/**
 *
 * @author ybautistap
 */
public class opcionesmenuitemBean {

    private String descripcion;
    private String recurso;

    public opcionesmenuitemBean() {
    }

    public opcionesmenuitemBean(String descripcion, String recurso) {
        this.descripcion = descripcion;
        this.recurso = recurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

}

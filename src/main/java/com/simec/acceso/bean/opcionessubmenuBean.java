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
public class opcionessubmenuBean {

    private int submenuid;
    private String descripcion;

    public opcionessubmenuBean() {
    }

    public opcionessubmenuBean(int submenuid, String descripcion) {
        this.submenuid = submenuid;
        this.descripcion = descripcion;
    }

    public int getSubmenuid() {
        return submenuid;
    }

    public void setSubmenuid(int submenuid) {
        this.submenuid = submenuid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

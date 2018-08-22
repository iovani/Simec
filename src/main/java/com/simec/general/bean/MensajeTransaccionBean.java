/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.general.bean;

import java.io.Serializable;
/**
 *
 * @author ybautistap
 */
public class MensajeTransaccionBean implements Serializable {
    
     private int numero;
    private String descripcion;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

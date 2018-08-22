/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.acceso.bean;

import javax.servlet.http.HttpSession;

/**
 *
 * @author ybautistap
 */
public class accesoBean {
    
    private String claveusuario; // clave que ingresa el usuario en pantalla
    private String password;// contraseña que ingresa el usuario en pantalla
    private String cadenaencrip;// contraseña encriptada
    private String ip; 
    private String host;
    private String navegadorAgent;//obtiene el agent del navegador desde donde se loguea el usuario
    private String navegador;// navegador desde donde se loguea el usuario
    private HttpSession sesion;// obtiene el HttpSession desde donde se loguea el usuario
    private String idsesion;//id de la sesion sesion obtenida
    private static String mensajevalida; //mensaje que devuelve el store
    private String usuariosesion; // clave del usuario que esta logueado

    public accesoBean() {
    }

    public accesoBean(String claveusuario) {
        this.claveusuario = claveusuario;
    }

    public accesoBean(String claveusuario, String password, String cadenaencrip, String ip, String host, String navegadorAgent, String navegador, HttpSession sesion, String idsesion, String usuariosesion) {
        this.claveusuario = claveusuario;
        this.password = password;
        this.cadenaencrip = cadenaencrip;
        this.ip = ip;
        this.host = host;
        this.navegadorAgent = navegadorAgent;
        this.navegador = navegador;
        this.sesion = sesion;
        this.idsesion = idsesion;
        this.usuariosesion = usuariosesion;
    }
    
    public String getClaveusuario() {
        return claveusuario;
    }

    public void setClaveusuario(String claveusuario) {
        this.claveusuario = claveusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCadenaencrip() {
        return cadenaencrip;
    }

    public void setCadenaencrip(String cadenaencrip) {
        this.cadenaencrip = cadenaencrip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getNavegadorAgent() {
        return navegadorAgent;
    }

    public void setNavegadorAgent(String navegadorAgent) {
        this.navegadorAgent = navegadorAgent;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    public String getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(String idsesion) {
        this.idsesion = idsesion;
    }

    public static String getMensajevalida() {
        return mensajevalida;
    }

    public static void setMensajevalida(String mensajevalida) {
        accesoBean.mensajevalida = mensajevalida;
    }

    public String getUsuariosesion() {
        return usuariosesion;
    }

    public void setUsuariosesion(String usuariosesion) {
        this.usuariosesion = usuariosesion;
    }

    
}

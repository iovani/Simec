/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.acceso.controlador;

import com.simec.acceso.bean.accesoBean;
import com.simec.acceso.servicio.accesoServicio;
import com.simec.general.bean.MensajeTransaccionBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ybautistap
 */
@ManagedBean(name = "loguinController")
@SessionScoped
public class accesoControlador implements Serializable {

    private final accesoBean accesobean = new accesoBean();
    private MensajeTransaccionBean mensaje = new MensajeTransaccionBean();

    public String accesosistemaControlador() throws Exception {

        accesoServicio accesoserv = new accesoServicio();

        String Resultado = "";
        System.out.println("Entor loguin controller");
        try {
            this.ObtenerDatosSesion();
            //Metodo que identica el loguin correcto o fallido
            mensaje = accesoserv.accesosistemaServicio(this.getAccesobean());
            if (mensaje.getNumero() == 0) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.getAccesobean().getClaveusuario());

                this.getAccesobean().setUsuariosesion((String) FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().get("usuario"));
                Resultado = "/entrada/vistaPrincipal.xhtml?faces-redirect=true";
            }

        } catch (SocketException ex) {
            throw ex;
        } catch (UnknownHostException ex) {
            throw ex;
        }
        return Resultado;

    }

    public boolean doVerificarSesion() {
        boolean estado;
        estado = FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario") != null;
        return estado;
    }

    public void cerrarSesion() throws IOException {
        System.out.println("click cerrarSesion");
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("./../entrada/index.xhtml");
        } catch (IOException ex) {
            System.out.println("excepsion cerrar sesion " + ex);
        }
    }

    public String doVerificarUsuario() {
        String Usuario = null;
        Usuario = (String) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario");
        return Usuario;
    }

    public void ObtenerDatosSesion() throws UnknownHostException, SocketException {

        //Encripta la contraseña    
        String md5 = DigestUtils.md5Hex(this.getAccesobean().getClaveusuario() + this.getAccesobean().getPassword());
        this.getAccesobean().setCadenaencrip(DigestUtils.sha1Hex(md5));

        //Cacha los valores para obtener el navegador
        this.getAccesobean().setNavegadorAgent(((HttpServletRequest) FacesContext.getCurrentInstance().
                getExternalContext().getRequest()).getHeader("User-Agent"));

        //Cacha los valores para obtener el Id
        this.getAccesobean().setSesion(((HttpServletRequest) FacesContext.getCurrentInstance().
                getExternalContext().getRequest()).getSession());

        //Obtiene el Id de la sesion
        this.getAccesobean().setIdsesion(this.getAccesobean().getSesion().getId());

        //obtiene el navegador
        System.out.println("getNavegadorAgent  " + this.getAccesobean().getNavegadorAgent());
        this.getAccesobean().setNavegador(this.navegador(this.getAccesobean().getNavegadorAgent()));

        this.ObtenerIp();
    }

    public void ObtenerIp() throws UnknownHostException, SocketException {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                this.getAccesobean().setIp(request.getRemoteAddr());
            }

            InetAddress addr = InetAddress.getByName(request.getRemoteAddr());
            //Obtiene el host del equipo
            this.getAccesobean().setHost(addr.getHostName());

        } catch (UnknownHostException e) {
        }

    }

    public String navegador(String Navegador) {

        boolean isEdge = (Navegador != null && Navegador.indexOf("Edge") != -1);
        boolean isChrome = (Navegador != null && Navegador.indexOf("Chrome") != -1);
        boolean isFirefox = (Navegador != null && Navegador.indexOf("Mozilla") != -1);
        boolean isExplorer = (Navegador != null && Navegador.indexOf("Trident") != -1);

        System.out.println("Navegador  " + Navegador.indexOf("Chrome") + "  " + Navegador.indexOf("Mozilla") + "   " + Navegador.indexOf("Trident") + "   " + Navegador.indexOf("Edge"));

        if (isChrome) {
            Navegador = "Google Chrome";
        } else if (isExplorer) {
            Navegador = "Intenet Explorer";
        } else if (isEdge) {
            Navegador = "Edge";
        } else if (isFirefox) {
            Navegador = "Firefox";
        } else {
            Navegador = "Desconocido";
        }
        return Navegador;
    }

    public accesoBean getAccesobean() {
        return accesobean;
    }

    public MensajeTransaccionBean getMensaje() {
        return mensaje;
    }

}

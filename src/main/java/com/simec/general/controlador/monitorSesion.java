/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.general.controlador;

import com.simec.acceso.controlador.accesoControlador;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
/**
 *
 * @author ybautistap
 */
@ManagedBean(name = "monitorsesion", eager = true)
public class monitorSesion {

    public void onTimeOut() throws IOException {

        accesoControlador acceso = new accesoControlador();
        if (acceso.doVerificarSesion()) {
            FacesContext.getCurrentInstance().getExternalContext()
                    .invalidateSession();
   
            RequestContext.getCurrentInstance().execute("PF('dlgSesion').show();");
        }

    }

    public void paginaInicio() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("./../entrada/index.xhtml");
    }

}

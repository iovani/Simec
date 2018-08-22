/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.acceso.servicio;

import com.simec.acceso.bean.accesoBean;
import com.simec.acceso.dao.accesoDao;
import com.simec.acceso.implement.accesoDaoImplement;
import com.simec.general.bean.MensajeTransaccionBean;

/**
 *
 * @author ybautistap
 */
public class accesoServicio {

    private final accesoDao linkTransacc = new accesoDaoImplement();
    private MensajeTransaccionBean mensaje = new MensajeTransaccionBean();

    public MensajeTransaccionBean accesosistemaServicio(final accesoBean datosAcceso) {
        mensaje = this.linkTransacc.accesosistemaDao(datosAcceso);
        return mensaje;
    }

}

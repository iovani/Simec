/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.acceso.dao;

import com.simec.general.bean.MensajeTransaccionBean;
import com.simec.acceso.bean.accesoBean;
/**
 *
 * @author ybautistap
 */
public interface accesoDao {
    
    public MensajeTransaccionBean accesosistemaDao(final accesoBean datosAcceso);
    
}

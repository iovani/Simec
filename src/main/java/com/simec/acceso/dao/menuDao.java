/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.acceso.dao;

import java.util.List;

import com.simec.acceso.bean.opcionessubmenuBean;
import com.simec.acceso.bean.opcionesmenuitemBean;

/**
 *
 * @author ybautistap
 */
public interface menuDao {
    
    public List<opcionessubmenuBean> opcionesSubMenu();
    public List<opcionesmenuitemBean> opcionesMenuItem(int submenuID);
    
    
}

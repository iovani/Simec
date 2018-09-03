/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.acceso.bean;

import com.simec.acceso.dao.menuDao;
import com.simec.acceso.implement.menuDaoImplement;
import java.util.List;

/**
 *
 * @author ybautistap
 */
public class menuBean {

    private List<opcionessubmenuBean> opcionesSubMenu;
    private List<opcionesmenuitemBean> opcionesMenuItem;
    private boolean menu = false;
    private final boolean verdadero = true;
    private String redirige;

    public List<opcionessubmenuBean> getOpcionesSubMenu() {
        menuDao linkTransac = new menuDaoImplement();
        opcionesSubMenu = linkTransac.opcionesSubMenu();
        return opcionesSubMenu;
    }

    public void setOpcionesSubMenu(List<opcionessubmenuBean> opcionesSubMenu) {
        this.opcionesSubMenu = opcionesSubMenu;
    }

    public List<opcionesmenuitemBean> getOpcionesMenuItem(int submenuID) {
        menuDao linkTransac = new menuDaoImplement();
        opcionesMenuItem = linkTransac.opcionesMenuItem(submenuID);
        return opcionesMenuItem;
    }

    public void setOpcionesMenuItem(List<opcionesmenuitemBean> opcionesMenuItem) {
        this.opcionesMenuItem = opcionesMenuItem;
    }

    public boolean isMenu() {
        return menu;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    public boolean isVerdadero() {
        return verdadero;
    }

    public String getRedirige() {
        return redirige;
    }

    public void setRedirige(String redirige) {
        this.redirige = redirige;
    }

}

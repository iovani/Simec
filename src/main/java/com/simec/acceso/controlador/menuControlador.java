/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.acceso.controlador;

import com.simec.acceso.bean.menuBean;
import com.simec.acceso.bean.opcionessubmenuBean;
import com.simec.acceso.bean.opcionesmenuitemBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author ybautistap
 */
@SessionScoped
@ManagedBean(name = "menuController")
@ViewScoped
public class menuControlador implements Serializable {

    private MenuModel model;
    private menuBean menubean = new menuBean();

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        try {
            for (opcionessubmenuBean op : this.getMenubean().getOpcionesSubMenu()) {

                DefaultSubMenu submenu = new DefaultSubMenu(op.getDescripcion());
                for (opcionesmenuitemBean omi : this.getMenubean().getOpcionesMenuItem(op.getSubmenuid())) {
                    DefaultMenuItem item = new DefaultMenuItem(omi.getDescripcion());
                    item.setCommand("#{menuController.redirigesubMenu}");
                    item.setUpdate("modulos");
                    item.setParam(omi.getDescripcion(), omi.getRecurso());
                    item.setAjax(true);
                    item.setResetValues(true);
                    submenu.addElement(item);
                }

                /*   
                DefaultMenuItem item = new DefaultMenuItem(op.getDescripcion());
                item.setCommand("#{menuController.redirigesubMenu}");
                item.setUpdate("modulos");
                item.setParam(op.getDescripcion(), op.getRecurso());
                item.setAjax(true);
                item.setResetValues(true);
                model.addElement(item);
                 */
                model.addElement(submenu);
   
            }
        } catch (Exception e) {
            System.out.println("Excepcion en controlador menuControlador " + e);
        }

    }

    public void redirigesubMenu(MenuActionEvent event) {
        MenuItem menuItem;
        menuItem = ((MenuActionEvent) event).getMenuItem();
        String ValorSubMenu = (String) menuItem.getValue();
        String href = menuItem.getParams().get(ValorSubMenu).get(0);
        this.getMenubean().setMenu(this.getMenubean().isVerdadero());
        this.getMenubean().setRedirige(href);
    }

    public menuBean getMenubean() {
        return menubean;
    }

    public void setMenubean(menuBean menubean) {
        this.menubean = menubean;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
}

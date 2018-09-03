/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.acceso.implement;

import com.simec.acceso.bean.opcionessubmenuBean;
import com.simec.acceso.bean.opcionesmenuitemBean;
import com.simec.acceso.dao.menuDao;
import com.simec.acceso.controlador.accesoControlador;
import com.simec.general.dao.HibernateConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ybautistap
 */
public class menuDaoImplement implements menuDao {

    HibernateConexion con = new HibernateConexion();
    Connection connection = null;
    CallableStatement st;

    @Override
    public List<opcionessubmenuBean> opcionesSubMenu() {
        List<opcionessubmenuBean> lista = new ArrayList<opcionessubmenuBean>();
        accesoControlador accesoContro = new accesoControlador();
        try {
            connection = con.getConexion();
            ResultSet rs;
            st = connection.prepareCall("call OPCIONESSUBMENUCON(?);");
            st.setString(1,accesoContro.doVerificarUsuario());
            if (st.execute()) {
                rs = st.getResultSet();
                while (rs.next()) {
                   opcionessubmenuBean opsubbean =new opcionessubmenuBean(rs.getInt("submenuID"), rs.getString("Descripcion"));
                   lista.add(opsubbean);
                }
            }  
            //connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (con.getSession() != null) {
                try {
                    con.CerrarConexion();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(accesoDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
        }

        return lista;
    }

    @Override
    public List<opcionesmenuitemBean> opcionesMenuItem(int submenuID) {
        List<opcionesmenuitemBean> lista = new ArrayList<opcionesmenuitemBean>();
        accesoControlador accesoContro = new accesoControlador();
        try {
            connection = con.getConexion();
            ResultSet rs;
            st = connection.prepareCall("call OPCIONESMENUITEMCON(?,?);");
            st.setString(1,accesoContro.doVerificarUsuario());
            st.setInt(2,submenuID);
            
            if (st.execute()) {
                rs = st.getResultSet();
                while (rs.next()) {
                   opcionesmenuitemBean opsubbean =new opcionesmenuitemBean(rs.getString("Descripcion"), rs.getString("Recurso"));
                   lista.add(opsubbean);
                }
            }  
            //connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (con.getSession() != null) {
                try {
                    con.CerrarConexion();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(accesoDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
        }

        return lista;
    }

}

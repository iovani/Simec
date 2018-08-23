/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.acceso.implement;

import com.simec.acceso.dao.accesoDao;
import com.simec.acceso.bean.accesoBean;
import com.simec.general.bean.MensajeTransaccionBean;
import com.simec.general.dao.HibernateConexion;
import com.simec.general.dao.BaseDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ybautistap
 */
public class accesoDaoImplement extends BaseDao implements accesoDao {

    HibernateConexion con = new HibernateConexion();
    Connection connection = null;
    CallableStatement st;

    @Override
    public MensajeTransaccionBean accesosistemaDao(accesoBean datosAcceso) {
        String intento = "";
        ResultSet rs;
        MensajeTransaccionBean mensaje = new MensajeTransaccionBean();
        try {
            connection = con.getConexion();
            st = connection.prepareCall("call ACCESSOSISTEMAPRO(?,?);");
            st.setString("Par_ClaveUsuario", datosAcceso.getClaveusuario());
            st.setString("Par_Password", datosAcceso.getCadenaencrip());

            if (st.execute()) {
                rs = st.getResultSet();
                if (rs.next()) {
                    mensaje.setNumero(rs.getInt("NumErr"));
                    mensaje.setDescripcion(rs.getString("ErrMen"));
                }
                if (mensaje.getNumero() == 0) {
                    intento = "Exitoso";
                    this.registroaccesosistemaDao(datosAcceso, intento);
                } else if (mensaje.getNumero() == 1) {
                    intento = "Fallido";
                    this.registroaccesosistemaDao(datosAcceso, intento);
                }

            }
            if (loggerSIMEC.isDebugEnabled()) {
                loggerSIMEC.debug("This is debug : ACCESSOSISTEMAPRO "+st.toString());
            }
            connection.commit();
            System.out.println("Conectado.! ");
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(accesoDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        return mensaje;
    }

    public void registroaccesosistemaDao(accesoBean datosAcceso, String intento) {

        try {
            st = connection.prepareCall("call REGISTROACCESOALT(?,?,?,?,?,?);");
            st.setString("Par_Navegador", datosAcceso.getNavegador());
            st.setString("Par_NombrePC", datosAcceso.getHost());
            st.setString("Par_Intento", intento);
            st.setString("Par_SesionID", datosAcceso.getIdsesion());
            st.setString("Par_Clave", datosAcceso.getClaveusuario());
            st.setString("Par_DireccionIP", datosAcceso.getIp());

            if (st.execute()) {
                System.out.println("Registro acceso correctamente");
            }
            connection.commit();
        } catch (Exception ex) {
            Logger.getLogger(accesoDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

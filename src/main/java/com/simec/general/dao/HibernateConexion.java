/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.general.dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;

/**
 *
 * @author ybautistap
 */
public class HibernateConexion {

    private Session session = null;
    private Connection connection = null;
    private SessionFactoryImplementor sessionFactoryImplementation = null;
    private ConnectionProvider connectionProvider = null;

    public Connection getConexion() throws SQLException {
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            this.setSession(HibernateUtil.getSessionFactory().openSession());

            //sessionFactoryImplementation = (SessionFactoryImplementor) session.getSessionFactory();
            this.setSessionFactoryImplementation((SessionFactoryImplementor) session.getSessionFactory());

            //connectionProvider = sessionFactoryImplementation.getConnectionProvider();
            this.setConnectionProvider(sessionFactoryImplementation.getConnectionProvider());

            //connection = connectionProvider.getConnection();
            this.setConnection(connectionProvider.getConnection());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return this.getConnection();
    }

    public void CerrarConexion() throws SQLException {
        if (this.getSession() != null) {
            this.getSession().close();
        }
        if (this.getConnection() != null) {
            try {
                this.getConnection().close();
            } catch (SQLException e) {
            }
        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public SessionFactoryImplementor getSessionFactoryImplementation() {
        return sessionFactoryImplementation;
    }

    public void setSessionFactoryImplementation(SessionFactoryImplementor sessionFactoryImplementation) {
        this.sessionFactoryImplementation = sessionFactoryImplementation;
    }

    public ConnectionProvider getConnectionProvider() {
        return connectionProvider;
    }

    public void setConnectionProvider(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

}

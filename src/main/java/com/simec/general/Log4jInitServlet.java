/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simec.general;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
/**
 *
 * @author ybautistap
 */
public class Log4jInitServlet {
    
    Logger loggerSIMEC = Logger.getLogger("SIMEC");

    public void init() {
        try {
            BasicConfigurator.configure();
            
            
            loggerSIMEC.setLevel(Level.INFO);

            PatternLayout layoutAUDITORIA = new PatternLayout("%d %p %C.%M - %m%n");

            RollingFileAppender apenderSIECOG = new RollingFileAppender(layoutAUDITORIA, "C:/Users/ybautistap/Documents/SIMEC.log");

            apenderSIECOG.setMaxFileSize("20000KB");
            apenderSIECOG.setMaxBackupIndex(10);

            loggerSIMEC.addAppender(apenderSIECOG);
            loggerSIMEC.setAdditivity(false);

            loggerSIMEC.info("Cargando Archivo de Propiedades: " + "SIMEC.log");
            loggerSIMEC.info("Cargando Configuracion de Log4J");
            loggerSIMEC.info("Nivel del Log: " + "INFO");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) {

    }
    
}

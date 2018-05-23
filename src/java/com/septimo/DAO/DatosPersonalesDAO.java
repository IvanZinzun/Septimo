/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.septimo.DAO;

import com.septimo.bean.DatosPersonales;
import com.septimo.conexion.DBConnection;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Zinzun
 */
public class DatosPersonalesDAO {
    
    public void registraDatosPersonales(DatosPersonales datosPersonales) {

        SqlSession session = null;

        try {
            session = DBConnection.getSessionFactory().openSession();
            System.out.println("paso 1");
            session.insert("DatosPersonales.insertaDatosPersonales",datosPersonales);
            System.out.println("paso 2");
            session.commit();
            session.close();
            System.out.println("paso 3");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        
    }
    
        public List<DatosPersonales> listaDatosPersonales() {
        
        SqlSession sessionSQL = null;

        List<DatosPersonales> listaDatosPersonales = null;

        try {
              sessionSQL = DBConnection.getSessionFactory().openSession();

            listaDatosPersonales = sessionSQL.selectList("Datos.muestraDatosPersonales");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        finally {
            sessionSQL.close();
        }

        return listaDatosPersonales;
    }
    
}

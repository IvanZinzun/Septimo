package com.septimo.conexion;

import java.io.IOException;
import java.io.Reader;  
 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.ibatis.session.SqlSession;

public class DBConnection {
	private static DBConnection sqlFactory = null;
	private static SqlSessionFactory sessionFactory = null;
 
	private DBConnection() {
 
	}
                         
	private static DBConnection getInstance() {
		String resource = null;
		Reader reader = null;
 
		if(sqlFactory == null) {
			resource = "mybatis_configuration.xml";
            try {
                reader = Resources.getResourceAsReader(resource);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
 
			sqlFactory = new DBConnection();
			sqlFactory.sessionFactory = new SqlSessionFactoryBuilder().build(reader);                        
		}
		return sqlFactory;
	}
        
	public static synchronized SqlSessionFactory getSessionFactory() throws IOException {
		if(sqlFactory == null) {
			getInstance();
		}
		return sessionFactory;
	}

	public static synchronized Connection getConnection() throws IOException, SQLException {
		if(sqlFactory == null) {
			getInstance();
		}

                Connection connection = null;

                
                connection = sessionFactory.getConfiguration().getEnvironment().getDataSource().getConnection();
                              
                return connection;
	}        
        
        
        public static void pruebaConnection(){
        
        try {
            Connection connection = DBConnection.getConnection();
            
            System.out.println("conectado " + connection);
            
            connection.close();
            
            System.out.println("desconectado ");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
            
            
        }
        
        
        public static void main(String[] args) {
        
            //Prueba de sincronización
            SqlSession session = null;
        try {
            session = DBConnection.getSessionFactory().openSession();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
            System.out.println("Sesión abierta : " + session);

            session.close();
            
            System.out.println("Sesión cerrada : " + session);
                      
            DBConnection.pruebaConnection();
            
        }
        
}
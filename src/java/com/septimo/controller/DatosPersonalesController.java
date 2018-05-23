/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.septimo.controller;

import com.septimo.DAO.DatosPersonalesDAO;
import com.septimo.bean.DatosPersonales;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Zinzun
 */
@ManagedBean
@RequestScoped
public class DatosPersonalesController {

    /**
     * Creates a new instance of DatosPersonalesController
     */
    private DatosPersonales datosPersonales;
    private ResultSet resultado;
    private List<DatosPersonales> listaDatosPersonales;
    
    
    public DatosPersonalesController() {
        datosPersonales = new DatosPersonales();
    }

    public void envia() throws SQLException{
        System.out.println("Datos");
        System.out.println("Nombre: " + datosPersonales.getNombre());
        System.out.println("Apellido Paterno: " + datosPersonales.getApellidoPaterno());
        System.out.println("Apellido Materno: " + datosPersonales.getApellidoMaterno());
        DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
        datosPersonalesDAO.registraDatosPersonales(datosPersonales);
        
    }
    
    public void consulta() throws SQLException{
        DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
        listaDatosPersonales = datosPersonalesDAO.listaDatosPersonales();
    }
    
    
    
    /**
     * @return the datosPersonales
     */
    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    /**
     * @param datosPersonales the datosPersonales to set
     */
    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    /**
     * @return the resultado
     */
    public ResultSet getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the listaDatosPersonales
     */
    public List<DatosPersonales> getListaDatosPersonales() {
        return listaDatosPersonales;
    }

    /**
     * @param listaDatosPersonales the listaDatosPersonales to set
     */
    public void setListaDatosPersonales(List<DatosPersonales> listaDatosPersonales) {
        this.listaDatosPersonales = listaDatosPersonales;
    }

    
}

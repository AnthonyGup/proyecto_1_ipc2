/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

/**
 *
 * @author antho
 */
public class Institucion {
    
    private int ID_INSTITUCION; 
    private String UBICACION;
    private String NOMBRE;
    private String DESCRIPCION;
    private boolean estado = true;

    public void setID_INSTITUCION(int ID_INSTITUCION) {
        this.ID_INSTITUCION = ID_INSTITUCION;
    }

    public void setUBICACION(String UBICACION) {
        this.UBICACION = UBICACION;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public int getID_INSTITUCION() {
        return ID_INSTITUCION;
    }

    public String getUBICACION() {
        return UBICACION;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public boolean isEstado() {
        return estado;
    }
    
    
}

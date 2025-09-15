/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author antho
 */
public class Congreso {
    private String ID_CONGRESO;
    private String TITULO;
    private String UBICACION;
    private String DESCRIPCION;
    private String ID_ADMIN;
    private int ID_INSTITUCION;
    private LocalDate FECHA_INICIO;
    private double COMISION;
    private double PRECIO;
    private boolean estado = true;
    
    
    public void setID_CONGRESO(String ID_CONGRESO) {
        this.ID_CONGRESO = ID_CONGRESO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public void setUBICACION(String UBICACION) {
        this.UBICACION = UBICACION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public void setID_ADMIN(String ID_ADMIN) {
        this.ID_ADMIN = ID_ADMIN;
    }

    public void setID_INSTITUCION(int ID_INSTITUCION) {
        this.ID_INSTITUCION = ID_INSTITUCION;
    }

    public void setFECHA_INICIO(LocalDate FECHA_INICIO) {
        this.FECHA_INICIO = FECHA_INICIO;
    }

    public void setCOMISION(double COMISION) {
        this.COMISION = COMISION;
    }

    //Setters de los que no son constantes
    public void setPRECIO(double PRECIO) {
        this.PRECIO = PRECIO;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    //Getters de todos los atributos
    public String getID_CONGRESO() {
        return ID_CONGRESO;
    }

    public String getTITULO() {
        return TITULO;
    }

    public String getUBICACION() {
        return UBICACION;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public String getID_ADMIN() {
        return ID_ADMIN;
    }

    public int getID_INSTITUCION() {
        return ID_INSTITUCION;
    }

    public double getCOMISION() {
        return COMISION;
    }

    public double getPRECIO() {
        return PRECIO;
    }

    public boolean isEstado() {
        return estado;
    }

    public LocalDate getFECHA_INICIO() {
        return FECHA_INICIO;
    }
    
    
}

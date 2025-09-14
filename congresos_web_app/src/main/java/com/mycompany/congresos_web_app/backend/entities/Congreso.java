/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import java.util.Date;

/**
 *
 * @author antho
 */
public class Congreso {
    private final String ID_CONGRESO;
    private final String TITULO;
    private final String UBICACION;
    private final String DESCRIPCION;
    private final String ID_ADMIN;
    private final String ID_INSTITUCION;
    private final Date FECHA_INICIO;
    private final double COMISION;
    private final double PRECIO;
    private boolean estado = true;

    /**
     * Constructor qu einicia todos los atributos quue conforman al congreso
     * @param ID_CONGRESO codigo de identificacion unica del congreso
     * @param TITULO El nombre que llevara el congreso
     * @param UBICACION Lugar donde se llevara a cavo el congreso
     * @param DESCRIPCION Corta descripcion del congreso
     * @param ID_ADMIN Codigo del usuario que administra este congreso
     * @param ID_INSTITUCION Codigo de la institucion a la que pertenece el congreso
     * @param COMISION Comision que cobrara la aplicacion por cada congreso
     * @param PRECIO Precio de cada congreso
     * @param FECHA_INICIO  La fecha en la qu einicia
     */
    public Congreso(String ID_CONGRESO, String TITULO, String UBICACION, String DESCRIPCION, String ID_ADMIN, String ID_INSTITUCION, double COMISION, double PRECIO, Date FECHA_INICIO) {
        this.ID_CONGRESO = ID_CONGRESO;
        this.TITULO = TITULO;
        this.UBICACION = UBICACION;
        this.DESCRIPCION = DESCRIPCION;
        this.ID_ADMIN = ID_ADMIN;
        this.ID_INSTITUCION = ID_INSTITUCION;
        this.COMISION = COMISION;
        this.PRECIO = PRECIO;
        this.FECHA_INICIO = FECHA_INICIO;
    }

    //Setters de los que no son constantes
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

    public String getID_INSTITUCION() {
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

    public Date getFECHA_INICIO() {
        return FECHA_INICIO;
    }
    
    
}

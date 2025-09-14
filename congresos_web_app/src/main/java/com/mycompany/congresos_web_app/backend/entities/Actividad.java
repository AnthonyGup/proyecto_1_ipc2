/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import com.mycompany.congresos_web_app.backend.entities.enums.TipoActividad;
import java.time.LocalTime;

/**
 *
 * @author antho
 */
public class Actividad {
    
    private final String ID_TRABAJO;
    private final String NOMBRE;
    private final String DESCRIPCION;
    private int cupo_maximo;
    private final TipoActividad TIPO;
    private final LocalTime HORA_INICIO;
    private final LocalTime HORA_FIN;
    private final String ID_ENCARGADO;
    private final String ID_CONGRESO;
    private final int ID_SALON;

    public Actividad(String ID_TRABAJO, String NOMBRE, String DESCRIPCION, TipoActividad TIPO, LocalTime HORA_INICIO, LocalTime HORA_FIN, String ID_ENCARGADO, String ID_CONGRESO, int ID_SALON) {
        this.ID_TRABAJO = ID_TRABAJO;
        this.NOMBRE = NOMBRE;
        this.DESCRIPCION = DESCRIPCION;
        this.TIPO = TIPO;
        this.HORA_INICIO = HORA_INICIO;
        this.HORA_FIN = HORA_FIN;
        this.ID_ENCARGADO = ID_ENCARGADO;
        this.ID_CONGRESO = ID_CONGRESO;
        this.ID_SALON = ID_SALON;
    }

    public void setCupo_maximo(int cupo_maximo) {
        this.cupo_maximo = cupo_maximo;
    }

    public String getID_TRABAJO() {
        return ID_TRABAJO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public int getCupo_maximo() {
        return cupo_maximo;
    }

    public TipoActividad getTIPO() {
        return TIPO;
    }

    public LocalTime getHORA_INICIO() {
        return HORA_INICIO;
    }

    public LocalTime getHORA_FIN() {
        return HORA_FIN;
    }

    public String getID_ENCARGADO() {
        return ID_ENCARGADO;
    }

    public String getID_CONGRESO() {
        return ID_CONGRESO;
    }

    public int getID_SALON() {
        return ID_SALON;
    }
    
    
    
}

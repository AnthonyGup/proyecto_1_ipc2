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
    
    private  String ID_TRABAJO;
    private  String NOMBRE;
    private  String DESCRIPCION;
    private int cupo_maximo;
    private  TipoActividad TIPO;
    private  LocalTime HORA_INICIO;
    private  LocalTime HORA_FIN;
    private  String ID_ENCARGADO;
    private  String ID_CONGRESO;
    private  int ID_SALON;

    public void setID_TRABAJO(String ID_TRABAJO) {
        this.ID_TRABAJO = ID_TRABAJO;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public void setTIPO(TipoActividad TIPO) {
        this.TIPO = TIPO;
    }

    public void setHORA_INICIO(LocalTime HORA_INICIO) {
        this.HORA_INICIO = HORA_INICIO;
    }

    public void setHORA_FIN(LocalTime HORA_FIN) {
        this.HORA_FIN = HORA_FIN;
    }

    public void setID_ENCARGADO(String ID_ENCARGADO) {
        this.ID_ENCARGADO = ID_ENCARGADO;
    }

    public void setID_CONGRESO(String ID_CONGRESO) {
        this.ID_CONGRESO = ID_CONGRESO;
    }

    public void setID_SALON(int ID_SALON) {
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import java.time.LocalDate;

/**
 *
 * @author antho
 */
public class Convocatoria {
    
    private int ID_CONVOCATORIA;
    private String TITULO;
    private boolean estado = true;
    private LocalDate FECHA_INICIO; 
    private LocalDate FECHA_FIN;
    private String ID_CONGRESO;

    public void setID_CONVOCATORIA(int ID_CONVOCATORIA) {
        this.ID_CONVOCATORIA = ID_CONVOCATORIA;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public void setFECHA_INICIO(LocalDate FECHA_INICIO) {
        this.FECHA_INICIO = FECHA_INICIO;
    }

    public void setFECHA_FIN(LocalDate FECHA_FIN) {
        this.FECHA_FIN = FECHA_FIN;
    }

    public void setID_CONGRESO(String ID_CONGRESO) {
        this.ID_CONGRESO = ID_CONGRESO;
    }
    
    
    

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getID_CONVOCATORIA() {
        return ID_CONVOCATORIA;
    }

    public String getTITULO() {
        return TITULO;
    }

    public boolean isEstado() {
        return estado;
    }

    public LocalDate getFECHA_INICIO() {
        return FECHA_INICIO;
    }

    public LocalDate getFECHA_FIN() {
        return FECHA_FIN;
    }

    public String getID_CONGRESO() {
        return ID_CONGRESO;
    }
    
    
    
}

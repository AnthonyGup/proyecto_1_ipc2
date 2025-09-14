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
public class Convocatoria {
    
    private final int ID_CONVOCATORIA;
    private final String TITULO;
    private boolean estado = true;
    private final Date FECHA_INICIO; 
    private final Date FECHA_FIN;
    private final String ID_CONGRESO;

    public Convocatoria(int ID_CONVOCATORIA, String TITULO, Date FECHA_INICIO, Date FECHA_FIN, String ID_CONGRESO) {
        this.ID_CONVOCATORIA = ID_CONVOCATORIA;
        this.TITULO = TITULO;
        this.FECHA_INICIO = FECHA_INICIO;
        this.FECHA_FIN = FECHA_FIN;
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

    public Date getFECHA_INICIO() {
        return FECHA_INICIO;
    }

    public Date getFECHA_FIN() {
        return FECHA_FIN;
    }

    public String getID_CONGRESO() {
        return ID_CONGRESO;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import com.mycompany.congresos_web_app.backend.entities.enums.TipoTrabajo;

/**
 *
 * @author antho
 */
public class Trabajo {
    
    private final int ID_TRABAJO;
    private final TipoTrabajo TIPO;
    private final String DESCRIPCION;
    private final String TITULO;
    private boolean estado = true;
    private final String ID_PARTICIPANTE;
    private final int ID_CONVOCATORIA;

    public Trabajo(int ID_TRABAJO, TipoTrabajo TIPO, String DESCRIPCION, String TITULO, String ID_PARTICIPANTE, int ID_CONVOCATORIA) {
        this.ID_TRABAJO = ID_TRABAJO;
        this.TIPO = TIPO;
        this.DESCRIPCION = DESCRIPCION;
        this.TITULO = TITULO;
        this.ID_PARTICIPANTE = ID_PARTICIPANTE;
        this.ID_CONVOCATORIA = ID_CONVOCATORIA;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getID_TRABAJO() {
        return ID_TRABAJO;
    }

    public TipoTrabajo getTIPO() {
        return TIPO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public String getTITULO() {
        return TITULO;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getID_PARTICIPANTE() {
        return ID_PARTICIPANTE;
    }

    public int getID_CONVOCATORIA() {
        return ID_CONVOCATORIA;
    }
    
    
    
}

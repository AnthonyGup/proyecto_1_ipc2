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
    
    private int ID_TRABAJO;
    private TipoTrabajo TIPO;
    private String DESCRIPCION;
    private String TITULO;
    private boolean estado = true;
    private String ID_PARTICIPANTE;
    private int ID_CONVOCATORIA;

    public void setID_TRABAJO(int ID_TRABAJO) {
        this.ID_TRABAJO = ID_TRABAJO;
    }

    public void setTIPO(TipoTrabajo TIPO) {
        this.TIPO = TIPO;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public void setID_PARTICIPANTE(String ID_PARTICIPANTE) {
        this.ID_PARTICIPANTE = ID_PARTICIPANTE;
    }

    public void setID_CONVOCATORIA(int ID_CONVOCATORIA) {
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

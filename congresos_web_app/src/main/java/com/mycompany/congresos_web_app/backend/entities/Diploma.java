/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import com.mycompany.congresos_web_app.backend.entities.enums.TipoDiploma;

/**
 *
 * @author antho
 */
public class Diploma {
    private int ID_DIPLOMA;
    private TipoDiploma TIPO;
    private String DESCRIPCION;
    private String ID_PARTICIPANTE;
    private String ID_CONGRESO;

    public void setID_DIPLOMA(int ID_DIPLOMA) {
        this.ID_DIPLOMA = ID_DIPLOMA;
    }

    public void setTIPO(TipoDiploma TIPO) {
        this.TIPO = TIPO;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public void setID_PARTICIPANTE(String ID_PARTICIPANTE) {
        this.ID_PARTICIPANTE = ID_PARTICIPANTE;
    }

    public void setID_CONGRESO(String ID_CONGRESO) {
        this.ID_CONGRESO = ID_CONGRESO;
    }

    public int getID_DIPLOMA() {
        return ID_DIPLOMA;
    }

    public TipoDiploma getTIPO() {
        return TIPO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public String getID_PARTICIPANTE() {
        return ID_PARTICIPANTE;
    }

    public String getID_CONGRESO() {
        return ID_CONGRESO;
    }
}

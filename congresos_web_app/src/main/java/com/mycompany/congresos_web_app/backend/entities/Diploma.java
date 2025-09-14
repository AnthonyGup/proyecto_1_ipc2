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
    private final int ID_DIPLOMA;
    private final TipoDiploma TIPO;
    private final String DESCRIPCION;
    private final String ID_PARTICIPANTE;
    private final String ID_CONGRESO;

    public Diploma(int ID_DIPLOMA, TipoDiploma TIPO, String DESCRIPCION, String ID_PARTICIPANTE, String ID_CONGRESO) {
        this.ID_DIPLOMA = ID_DIPLOMA;
        this.TIPO = TIPO;
        this.DESCRIPCION = DESCRIPCION;
        this.ID_PARTICIPANTE = ID_PARTICIPANTE;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import java.time.LocalDateTime;

/**
 *
 * @author antho
 */
public class Asistencia {
    
    private int ID_ASISTENCIA;
    private LocalDateTime FECHA_HORA;
    private String ID_ACTIVIDAD;
    private String ID_PARTICIPANTE;

    public void setID_ASISTENCIA(int ID_ASISTENCIA) {
        this.ID_ASISTENCIA = ID_ASISTENCIA;
    }

    public void setFECHA_HORA(LocalDateTime FECHA_HORA) {
        this.FECHA_HORA = FECHA_HORA;
    }

    public void setID_ACTIVIDAD(String ID_ACTIVIDAD) {
        this.ID_ACTIVIDAD = ID_ACTIVIDAD;
    }

    public void setID_PARTICIPANTE(String ID_PARTICIPANTE) {
        this.ID_PARTICIPANTE = ID_PARTICIPANTE;
    }

    public int getID_ASISTENCIA() {
        return ID_ASISTENCIA;
    }

    public LocalDateTime getFECHA_HORA() {
        return FECHA_HORA;
    }

    public String getID_ACTIVIDAD() {
        return ID_ACTIVIDAD;
    }

    public String getID_PARTICIPANTE() {
        return ID_PARTICIPANTE;
    }
    
    
    
}

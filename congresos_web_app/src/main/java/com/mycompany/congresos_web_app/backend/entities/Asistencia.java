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
    
    private final int ID_ASISTENCIA;
    private final LocalDateTime FECHA_HORA;
    private final String ID_ACTIVIDAD;
    private final String ID_PARTICIPANTE;

    public Asistencia(int ID_ASISTENCIA, LocalDateTime FECHA_HORA, String ID_ACTIVIDAD, String ID_PARTICIPANTE) {
        this.ID_ASISTENCIA = ID_ASISTENCIA;
        this.FECHA_HORA = FECHA_HORA;
        this.ID_ACTIVIDAD = ID_ACTIVIDAD;
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

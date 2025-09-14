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
public class Reserva {
    
    private final int ID_RESERVA;
    private final Date FECHA_RESERVA;
    private final String ID_ACTIVIDAD;
    private final String ID_PARTICIPANTE;

    public Reserva(int ID_RESERVA, Date FECHA_RESERVA, String ID_ACTIVIDAD, String ID_PARTICIPANTE) {
        this.ID_RESERVA = ID_RESERVA;
        this.FECHA_RESERVA = FECHA_RESERVA;
        this.ID_ACTIVIDAD = ID_ACTIVIDAD;
        this.ID_PARTICIPANTE = ID_PARTICIPANTE;
    }

    public int getID_RESERVA() {
        return ID_RESERVA;
    }

    public Date getFECHA_RESERVA() {
        return FECHA_RESERVA;
    }

    public String getID_ACTIVIDAD() {
        return ID_ACTIVIDAD;
    }

    public String getID_PARTICIPANTE() {
        return ID_PARTICIPANTE;
    }
    
}

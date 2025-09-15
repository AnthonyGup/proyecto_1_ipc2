/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author antho
 */
public class Reserva {
    
    private int ID_RESERVA;
    private LocalDate FECHA_RESERVA;
    private String ID_ACTIVIDAD;
    private String ID_PARTICIPANTE;

    public void setID_RESERVA(int ID_RESERVA) {
        this.ID_RESERVA = ID_RESERVA;
    }

    public void setFECHA_RESERVA(LocalDate FECHA_RESERVA) {
        this.FECHA_RESERVA = FECHA_RESERVA;
    }

    public void setID_ACTIVIDAD(String ID_ACTIVIDAD) {
        this.ID_ACTIVIDAD = ID_ACTIVIDAD;
    }

    public void setID_PARTICIPANTE(String ID_PARTICIPANTE) {
        this.ID_PARTICIPANTE = ID_PARTICIPANTE;
    }

    public int getID_RESERVA() {
        return ID_RESERVA;
    }

    public LocalDate getFECHA_RESERVA() {
        return FECHA_RESERVA;
    }

    public String getID_ACTIVIDAD() {
        return ID_ACTIVIDAD;
    }

    public String getID_PARTICIPANTE() {
        return ID_PARTICIPANTE;
    }
    
}

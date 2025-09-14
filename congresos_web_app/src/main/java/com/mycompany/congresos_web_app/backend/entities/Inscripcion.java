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
public class Inscripcion {
    private final int ID_INSCRIPCION;
    private final Date FECHA_PAGO;
    private final double MONTO;
    private final String ID_PARTICIPANTE;
    private final String ID_CONGRESO;

    public Inscripcion(int ID_INSCRIPCION, Date FECHA_PAGO, double MONTO, String ID_PARTICIPANTE, String ID_CONGRESO) {
        this.ID_INSCRIPCION = ID_INSCRIPCION;
        this.FECHA_PAGO = FECHA_PAGO;
        this.MONTO = MONTO;
        this.ID_PARTICIPANTE = ID_PARTICIPANTE;
        this.ID_CONGRESO = ID_CONGRESO;
    }

    public int getID_INSCRIPCION() {
        return ID_INSCRIPCION;
    }

    public Date getFECHA_PAGO() {
        return FECHA_PAGO;
    }

    public double getMONTO() {
        return MONTO;
    }

    public String getID_PARTICIPANTE() {
        return ID_PARTICIPANTE;
    }

    public String getID_CONGRESO() {
        return ID_CONGRESO;
    }
    
     
}

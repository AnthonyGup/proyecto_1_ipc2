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
public class Inscripcion {
    private int ID_INSCRIPCION;
    private LocalDate FECHA_PAGO;
    private double MONTO;
    private String ID_PARTICIPANTE;
    private String ID_CONGRESO;

    public void setID_INSCRIPCION(int ID_INSCRIPCION) {
        this.ID_INSCRIPCION = ID_INSCRIPCION;
    }

    public void setFECHA_PAGO(LocalDate FECHA_PAGO) {
        this.FECHA_PAGO = FECHA_PAGO;
    }

    public void setMONTO(double MONTO) {
        this.MONTO = MONTO;
    }

    public void setID_PARTICIPANTE(String ID_PARTICIPANTE) {
        this.ID_PARTICIPANTE = ID_PARTICIPANTE;
    }

    public void setID_CONGRESO(String ID_CONGRESO) {
        this.ID_CONGRESO = ID_CONGRESO;
    }

    
    
    public LocalDate getFECHA_PAGO() {
        return FECHA_PAGO;
    }

    public int getID_INSCRIPCION() {
        return ID_INSCRIPCION;
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

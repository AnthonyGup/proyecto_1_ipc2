/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import com.mycompany.congresos_web_app.backend.entities.enums.TipoUsuario;
import java.time.LocalDate;

/**
 *
 * @author antho
 */
public class Usuario {
    
    private  String CORREO;
    private  String PASSWORD;
    private  TipoUsuario ROL; // ADMIN_SISTEMA, ADMIN_CONGRESO, COMITE, PARTICIPANTE;
    private  LocalDate FECHA_CREACION;
    private double cartera_digital;
    private boolean estado = true; //estado activo
    
    
    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setROL(TipoUsuario ROL) {
        this.ROL = ROL;
    }

    //getters y setters
    public void setFECHA_CREACION(LocalDate FECHA_CREACION) {
        this.FECHA_CREACION = FECHA_CREACION;
    }

    public void setCartera_digital(double cartera_digital) {
        this.cartera_digital = cartera_digital;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCORREO() {
        return CORREO;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public TipoUsuario getROL() {
        return ROL;
    }

    public double getCartera_digital() {
        return cartera_digital;
    }

    public LocalDate getFECHA_CREACION() {
        return FECHA_CREACION;
    }

    public boolean isEstado() {
        return estado;
    }    
    

}

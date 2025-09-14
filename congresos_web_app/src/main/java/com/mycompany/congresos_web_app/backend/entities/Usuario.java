/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import com.mycompany.congresos_web_app.backend.entities.enums.TipoUsuario;
import java.util.Date;

/**
 *
 * @author antho
 */
public class Usuario {
    
    private final String CORREO;
    private final String PASSWORD;
    private final TipoUsuario ROL;
    private final Date FECHA_CREACION;
    private double cartera_digital;
    private boolean estado = true; //estado activo

    /**
     * Este constructor inicia todo aquello que es constante en el usuario
     * @param CORREO correo electronico
     * @param PASSWORD la contrasenia ya cifrada
     * @param ROL el rol que jugara el usuario registrado
     * @param fecha_creacion la fecha de creacion
     */
    public Usuario(String CORREO, String PASSWORD, TipoUsuario ROL, Date fecha_creacion) {
        this.CORREO = CORREO;
        this.PASSWORD = PASSWORD;
        this.ROL = ROL;
        this.FECHA_CREACION = fecha_creacion;
    }

    //getters y setters
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

    public Date getFECHA_CREACION() {
        return FECHA_CREACION;
    }

    public boolean isEstado() {
        return estado;
    }    
    

}

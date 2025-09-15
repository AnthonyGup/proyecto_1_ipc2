/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

/**
 *
 * @author antho
 */
public class Salon {
    private int ID_SALON;
    private String SALON;
    private String UBICACION;
    private int CAPACIDAD;
    private String ID_CONGRESO;

    public void setID_SALON(int ID_SALON) {
        this.ID_SALON = ID_SALON;
    }

    public void setSALON(String SALON) {
        this.SALON = SALON;
    }

    public void setUBICACION(String UBICACION) {
        this.UBICACION = UBICACION;
    }

    public void setCAPACIDAD(int CAPACIDAD) {
        this.CAPACIDAD = CAPACIDAD;
    }

    public void setID_CONGRESO(String ID_CONGRESO) {
        this.ID_CONGRESO = ID_CONGRESO;
    }

    

    public int getID_SALON() {
        return ID_SALON;
    }

    public String getSALON() {
        return SALON;
    }

    public String getUBICACION() {
        return UBICACION;
    }

    public int getCAPACIDAD() {
        return CAPACIDAD;
    }

    public String getID_CONGRESO() {
        return ID_CONGRESO;
    }
    
    
}

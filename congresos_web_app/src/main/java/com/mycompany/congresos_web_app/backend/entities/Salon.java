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
    private final int ID_SALON;
    private final String SALON;
    private final String UBICACION;
    private final int CAPACIDAD;
    private final String ID_CONGRESO;

    public Salon(int ID_SALON, String SALON, String UBICACION, int CAPACIDAD, String ID_CONGRESO) {
        this.ID_SALON = ID_SALON;
        this.SALON = SALON;
        this.UBICACION = UBICACION;
        this.CAPACIDAD = CAPACIDAD;
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

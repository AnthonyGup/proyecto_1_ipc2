/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

/**
 *
 * @author antho
 */
public class Comite {
    private final int ID_COMITE;
    private final String ID_USUARIO;
    private final String ID_CONGRESO;

    public Comite(int ID_COMITE, String ID_USUARIO, String ID_CONGRESO) {
        this.ID_COMITE = ID_COMITE;
        this.ID_USUARIO = ID_USUARIO;
        this.ID_CONGRESO = ID_CONGRESO;
    }

    public int getID_COMITE() {
        return ID_COMITE;
    }

    public String getID_USUARIO() {
        return ID_USUARIO;
    }

    public String getID_CONGRESO() {
        return ID_CONGRESO;
    }
}

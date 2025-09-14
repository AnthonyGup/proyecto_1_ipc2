/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

/**
 *
 * @author antho
 */
public class Institucion {
    
    private final String ID_INSTITUCION; 
    private final String UBICACION;
    private final String NOMBRE;
    private final String DESCRIPCION;
    private boolean estado = true;

    /**
     * Construuctor que inicia los atributos necesarios para la institucion
     * @param ID_INSTITUCION Codigo de identificacion de la institucion
     * @param UBICACION ubicacion de la institucion
     * @param NOMBRE el nombre de la institucion
     * @param DESCRIPCION descripcion corta de la descripcion y su funcionalidad
     */
    public Institucion(String ID_INSTITUCION, String UBICACION, String NOMBRE, String DESCRIPCION) {
        this.ID_INSTITUCION = ID_INSTITUCION;
        this.UBICACION = UBICACION;
        this.NOMBRE = NOMBRE;
        this.DESCRIPCION = DESCRIPCION;
    }

    
    public String getID_INSTITUCION() {
        return ID_INSTITUCION;
    }

    public String getUBICACION() {
        return UBICACION;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public boolean isEstado() {
        return estado;
    }
    
    
}

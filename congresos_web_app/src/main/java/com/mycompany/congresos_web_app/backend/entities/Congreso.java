/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import java.time.LocalDate;

/**
 *
 * @author antho
 */
public class Congreso {
    private String id_congreso;
    private String titulo;
    private String ubicacion;
    private String descripcion;
    private String id_admin;
    private String id_institucion;
    private LocalDate fecha_inicio;
    private double comision;
    private double precio;
    private boolean estado = true;
    private boolean convocatoria = false;

    public boolean isConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(boolean convocatoria) {
        this.convocatoria = convocatoria;
    }
    
    public void setId_congreso(String id_congreso) {
        this.id_congreso = id_congreso;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId_admin(String id_admin) {
        this.id_admin = id_admin;
    }

    public void setId_institucion(String id_institucion) {
        this.id_institucion = id_institucion;
    }
    
    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    //Setters de los que no son constantes
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    //Getters de todos los atributos
    public String getId_congreso() {
        return id_congreso;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getId_admin() {
        return id_admin;
    }

    public String getId_institucion() {
        return id_institucion;
    }
    
    public double getComision() {
        return comision;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }
    
    
}

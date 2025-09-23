/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.entities;

import com.mycompany.congresos_web_app.backend.entities.enums.EstadosActividad;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoActividad;
import java.time.LocalTime;

/**
 *
 * @author antho
 */
public class Actividad {
    
    private String id_actividad;
    private String nombre;
    private String descripcion;
    private int cupo_maximo = 0;
    private TipoActividad tipo; // PONENCIA, TALLER
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    private String id_encargado;
    private String id_congreso;
    private int id_salon;
    private EstadosActividad estado; //APROVADO, RECHAZADO, PENDIENTE

    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupo_maximo() {
        return cupo_maximo;
    }

    public void setCupo_maximo(int cupo_maximo) {
        this.cupo_maximo = cupo_maximo;
    }

    public TipoActividad getTipo() {
        return tipo;
    }

    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getId_encargado() {
        return id_encargado;
    }

    public void setId_encargado(String id_encargado) {
        this.id_encargado = id_encargado;
    }

    public String getId_congreso() {
        return id_congreso;
    }

    public void setId_congreso(String id_congreso) {
        this.id_congreso = id_congreso;
    }

    public int getId_salon() {
        return id_salon;
    }

    public void setId_salon(int id_salon) {
        this.id_salon = id_salon;
    }

    public EstadosActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadosActividad estado) {
        this.estado = estado;
    }
    
}

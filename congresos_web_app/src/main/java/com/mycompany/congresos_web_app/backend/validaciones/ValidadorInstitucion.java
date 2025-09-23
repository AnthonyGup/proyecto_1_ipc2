/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.InstitucionDAO;
import com.mycompany.congresos_web_app.backend.entities.Institucion;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class ValidadorInstitucion extends Validador {

    private final Institucion INSTITUCION = new Institucion();

    public void validarUbicacion(String ubicacion) throws ValidacionException {
        if (esLongitudValida(ubicacion, 200)) {
            INSTITUCION.setUbicacion(ubicacion);
        } else {
            throw new ValidacionException("Ubicacion muy larga");
        }
    }
    
    public void validarNombre(String nombre) throws ValidacionException, SQLException {
        if (!esLongitudValida(nombre, 150)) {
            throw new ValidacionException("Nombre muy largo");
        }
        if (existeEsteRegistro(nombre, new InstitucionDAO())) {
            throw new ValidacionException("Ya existe una institucion con este nombre");
        }
        INSTITUCION.setNombre(nombre);
    }
    
    public void validarDescripcion(String descripcion) throws ValidacionException {
        if (!esLongitudValida(descripcion, 400)) {
            throw new ValidacionException("Descripcion muy larga");
        }
        INSTITUCION.setDescripcion(descripcion);
    }
    
    public void guardarEstado(boolean estado) {
        INSTITUCION.setEstado(estado);
    }
    
    public void crearRegistro() throws SQLException {
        InstitucionDAO dao = new InstitucionDAO();
        
        dao.create(INSTITUCION);
    }

}

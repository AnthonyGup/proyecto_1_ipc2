/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.ConvocatoriaDAO;
import com.mycompany.congresos_web_app.backend.entities.Convocatoria;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author antho
 */
public class ValidadorConvocatoria extends Validador {
    
    private final Convocatoria CONVOCATORIA = new Convocatoria();
    
    public void validarTitulo(String titulo) throws ValidacionException {
        if (!esLongitudValida(titulo, 150)) {
            throw new ValidacionException("Titulo muy largo");
        }
        CONVOCATORIA.setTITULO(titulo);
    }
    
    public void validarEstado(boolean estado) {
        CONVOCATORIA.setEstado(estado);
    }
    
    
    public void validarFechaInicio(LocalDate inicio) throws ValidacionException {
        if (!esFechaValida(inicio)) {
            throw new ValidacionException("Fecha invalida");
        }
        CONVOCATORIA.setFECHA_INICIO(inicio);
    }
    
    public void validarFechaFin(LocalDate fin) throws ValidacionException {
        if (!esFechaValida(fin)) {
            throw new ValidacionException("Fecha invalida");
        }
        CONVOCATORIA.setFECHA_FIN(fin);
    }
    
    @Override
    public void crearRegistro() throws SQLException {
        ConvocatoriaDAO crud = new ConvocatoriaDAO();
        crud.create(CONVOCATORIA);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.ActividadDAO;
import com.mycompany.congresos_web_app.backend.crud.ParticipanteDAO;
import com.mycompany.congresos_web_app.backend.crud.ReservaDAO;
import com.mycompany.congresos_web_app.backend.entities.Reserva;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author antho
 */
public class ValidadorReserva extends Validador {

    private final Reserva RESRVA = new Reserva();
    
    public void validarFecha(LocalDate date) throws ValidacionException {
        if (!esFechaValida(date)) {
            throw new ValidacionException("Fecha incorrecta");
        }
        RESRVA.setFECHA_RESERVA(date);
    }
    
    public void validarActividad(String codigo) throws ValidacionException, SQLException {
        if (!esCodigoValido(codigo, "ACT-", 12)) {
            throw new ValidacionException("Codigo incorrecto");
        }
        if (!existeEsteRegistro(codigo, new ActividadDAO())) {
            throw new ValidacionException("no existe esta actividad");
        }
        RESRVA.setID_ACTIVIDAD(codigo);
    }
    
    public void validarParticipante(String idPersonal) throws ValidacionException, SQLException {
        if (!esLongitudValida(idPersonal, 150)) {
            throw new ValidacionException("Identificacion demasiado largo");
        }
        if (!existeEsteRegistro(idPersonal, new ParticipanteDAO())) {
            throw new ValidacionException("No existe un registro con este id");
        }
        RESRVA.setID_PARTICIPANTE(idPersonal);
    }
    
    @Override
    public void crearRegistro() throws SQLException {
        ReservaDAO crud = new ReservaDAO();
        crud.create(RESRVA);
    }
    
}

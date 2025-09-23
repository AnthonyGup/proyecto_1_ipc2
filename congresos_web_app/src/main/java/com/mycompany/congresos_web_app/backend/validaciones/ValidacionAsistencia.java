/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.ActividadDAO;
import com.mycompany.congresos_web_app.backend.crud.AsistenciaDAO;
import com.mycompany.congresos_web_app.backend.crud.ParticipanteDAO;
import com.mycompany.congresos_web_app.backend.entities.Asistencia;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;

/**
 *
 * @author antho
 */
public class ValidacionAsistencia extends Validador {

    private final Asistencia ASISTENCIA = new Asistencia();
    
    public void validarFechaHora(LocalDateTime fechaHora) throws ValidacionException {
        ASISTENCIA.setFECHA_HORA(fechaHora);
    }
    
    public void validarActiviad(String actividad) throws ValidacionException, SQLException {
        if (!esCodigoValido(actividad, "ACT-", 12)) {
            throw new ValidacionException("Codigo invalido");
        }
        if (!existeEsteRegistro(actividad, new ActividadDAO())) {
            throw new ValidacionException("No exite una activiad con este codigo");
        }
        ASISTENCIA.setID_ACTIVIDAD(actividad);
    }
    
    public void validarParticipante(String participante) throws ValidacionException, SQLException {
        if (!esLongitudValida(participante, 20)) {
            throw new ValidacionException("Codigo muy largo");
        }
        if (!existeEsteRegistro(participante, new ParticipanteDAO())) {
            throw new ValidacionException("No existe un participante con este codigo");
        }
        ASISTENCIA.setID_PARTICIPANTE(participante);
    }
    
    @Override
    public void crearRegistro() throws SQLException {
        AsistenciaDAO crud = new AsistenciaDAO();
        crud.create(ASISTENCIA);
    
    }
    
}

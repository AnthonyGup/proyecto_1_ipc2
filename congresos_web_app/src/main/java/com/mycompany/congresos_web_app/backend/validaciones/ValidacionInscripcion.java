/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.CongresoDAO;
import com.mycompany.congresos_web_app.backend.crud.InscripcionDAO;
import com.mycompany.congresos_web_app.backend.crud.ParticipanteDAO;
import com.mycompany.congresos_web_app.backend.entities.Inscripcion;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author antho
 */
public class ValidacionInscripcion extends Validador {
    
    private final Inscripcion INSCRIPCION = new Inscripcion();
    
    public void validarFecha(LocalDate fecha) throws ValidacionException {
        if (!esFechaValida(fecha)) {
            throw new ValidacionException("Fecha invalida");
        }
        INSCRIPCION.setFECHA_PAGO(fecha);
    }
    
    public void validarMonto(double monto) throws ValidacionException {
        if (!esMontoValido(monto)) {
            throw new ValidacionException("Cantidad invalida");
        }
        INSCRIPCION.setMONTO(monto);
    }
    
    public void validarParticipante(String participante) throws ValidacionException, SQLException {
        if (!esCorreoValido(participante)) {
            throw new ValidacionException("El codigo no es valido");
        }
        if (!existeEsteRegistro(participante, new ParticipanteDAO())) {
            throw new ValidacionException("Este participante no existe");
        }
        INSCRIPCION.setID_PARTICIPANTE(participante);
    }
    
    public void validarCongreso(String congreso) throws SQLException, ValidacionException {
        if (!esCodigoValido(congreso, "CON-", 12)) {
            throw new ValidacionException("Codigo invalido");
        }
        if (!existeEsteRegistro(congreso, new CongresoDAO())) {
            throw new ValidacionException("Este congreso no existe");
        }
        INSCRIPCION.setID_CONGRESO(congreso);
    }
    
    public void crearRegistro() throws SQLException {
        InscripcionDAO crud = new InscripcionDAO();
        
        crud.create(INSCRIPCION);
    }
}

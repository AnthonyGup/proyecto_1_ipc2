/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.CongresoDAO;
import com.mycompany.congresos_web_app.backend.crud.DiplomaDAO;
import com.mycompany.congresos_web_app.backend.crud.ParticipanteDAO;
import com.mycompany.congresos_web_app.backend.entities.Diploma;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoDiploma;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class ValidacionDiploma extends Validador {
    
    private final Diploma DIPLOMA = new Diploma();
    
    public void guardarTipo(String tipo) {
        DIPLOMA.setTIPO(TipoDiploma.valueOf(tipo));
    }
    
    public void validarDescripcion(String descripcion) throws ValidacionException {
        if (!esLongitudValida(descripcion, 200)) {
            throw new ValidacionException("Descripcion muy larga");
        }
        DIPLOMA.setDESCRIPCION(descripcion);
    }
    
    public void validarParticipante(String participante) throws ValidacionException, SQLException {
        if (!esCorreoValido(participante)) {
            throw new ValidacionException("El codigo no es valido");
        }
        if (!existeEsteRegistro(participante, new ParticipanteDAO())) {
            throw new ValidacionException("Este participante no existe");
        }
        DIPLOMA.setID_PARTICIPANTE(participante);
    }
    
    public void validarCongreso(String congreso) throws SQLException, ValidacionException {
        if (!esCodigoValido(congreso, "CON-", 12)) {
            throw new ValidacionException("Codigo invalido");
        }
        if (!existeEsteRegistro(congreso, new CongresoDAO())) {
            throw new ValidacionException("Este congreso no existe");
        }
        DIPLOMA.setID_CONGRESO(congreso);
    }
    
    @Override
    public void crearRegistro() throws SQLException {
        DiplomaDAO diplo = new DiplomaDAO();
        diplo.create(DIPLOMA);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.ConvocatoriaDAO;
import com.mycompany.congresos_web_app.backend.crud.ParticipanteDAO;
import com.mycompany.congresos_web_app.backend.crud.TrabajoDAO;
import com.mycompany.congresos_web_app.backend.entities.Trabajo;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoTrabajo;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class ValidadorTrabajo extends Validador {
    
    private final Trabajo TRABAJO = new Trabajo();
    
    
    public void validarTipo(String tipo) {
       TRABAJO.setTIPO(TipoTrabajo.valueOf(tipo));
    }
    
    public void validarDescripcion(String descripcion) throws ValidacionException {
        if (!esLongitudValida(descripcion, 200)) {
            throw new ValidacionException("Descripcion muy larga");
        } 
        TRABAJO.setDESCRIPCION(descripcion);
    }
    
    public void validarTitulo(String titulo) throws ValidacionException {
        if (!esLongitudValida(titulo, 150)) {
            throw new ValidacionException("Titulo muy largo");
        }
        TRABAJO.setTITULO(titulo);
   }
    
    public void validarEstado(boolean estado) {
        TRABAJO.setEstado(estado);
    }
    
    public void validarParticipante(String id) throws ValidacionException, SQLException {
        if (!esLongitudValida(id, 20)) {
            throw new ValidacionException("Error: codigo muy largo");
        }
        if (!existeEsteRegistro(id, new ParticipanteDAO())) {
            throw new ValidacionException("El participante no existe");
        }
        TRABAJO.setID_PARTICIPANTE(id);
    }
    
    public void validarConvocatoria(int id) throws SQLException, ValidacionException {
        if (!existeEsteRegistro("" + id, new ConvocatoriaDAO())) {
            throw new ValidacionException("No existe una convocatoria con este codigo");
        }
    }
    
    @Override
    public void crearRegistro() throws SQLException {
        TrabajoDAO crud = new TrabajoDAO();
        
        crud.create(TRABAJO);
    }

    
}

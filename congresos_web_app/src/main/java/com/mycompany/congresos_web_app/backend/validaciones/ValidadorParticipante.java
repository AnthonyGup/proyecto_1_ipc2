/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.ParticipanteDAO;
import com.mycompany.congresos_web_app.backend.crud.UsuarioDAO;
import com.mycompany.congresos_web_app.backend.entities.Participante;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class ValidadorParticipante extends Validador {
    
    private final Participante PARTICIPANTE = new Participante();
    
    /**
     * Valida que el id_personal sea correcto
     * @param id identificacion personal del usuario
     * @throws ValidacionException
     * @throws SQLException 
     */
    public void validarId(String id) throws ValidacionException, SQLException {
        if (!esLongitudValida(id, 20)) {
            throw new ValidacionException("El id personal es muy largo");
        }
        if (existeEsteRegistro(id, new ParticipanteDAO())) {
            throw new ValidacionException("Ya existe un usuario con este correo");
        }
        PARTICIPANTE.setID_PERSONAL(id);
    }
    
    /**
     * Valida que los caracteres del telefono no se salgan de lo establecido
     * @param numero el numero de telefono, puede contener solo texto y no numero
     * @throws ValidacionException 
     */
    public void validarTelefono(String numero) throws ValidacionException {
        if (esLongitudValida(numero, 20)) {
            PARTICIPANTE.setTELEFONO(numero);
        } else {
            throw new ValidacionException("El numero es muy grande");
        }
    }

    /**
     * Metodo que verifica que la cantidad de caracteres no exeda lo establecido.
     * @param organizacion el texto que se quiere guardar
     * @throws ValidacionException 
     */
    public void validarOrganizacion(String organizacion) throws ValidacionException {
        if (esLongitudValida(organizacion, 200)) {
            PARTICIPANTE.setORGANIZACION(organizacion);
        } else {
            throw new ValidacionException("El texto es muy largo");
        }
    }
    
    /**
     * Metodo que valida si el nombre es valido
     * @param nombre nombre del participante
     * @throws ValidacionException 
     */
    public void validarNombreCompleto (String nombre) throws ValidacionException {
        if (esLongitudValida(nombre, 200)) {
            PARTICIPANTE.setNOMBRE_COMPLETO(nombre);
        } else {
            throw new ValidacionException("El nombre es muy largo");
        }
    }
    
    /**
     * Metodo que comprueba si el usuario que se busca ya existe en la base de datos
     * @param usuario el id del usuario
     * @throws SQLException
     * @throws ValidacionException 
     */
    public void validarIdUsuario(String usuario) throws SQLException, ValidacionException {
        if (existeEsteRegistro(usuario, new UsuarioDAO())){
            PARTICIPANTE.setID_USUARIO(usuario);
        } else {
            throw new ValidacionException("El usuario no se encontro");
        }
    }
    
    /**
     * Metodo que llama al objeto de acceso y guarda el participante creado en la base de datos
     * @throws SQLException 
     */
    public void crearRegistro() throws SQLException {
        ParticipanteDAO participante = new ParticipanteDAO();
        
        participante.create(PARTICIPANTE);
    }
    
}

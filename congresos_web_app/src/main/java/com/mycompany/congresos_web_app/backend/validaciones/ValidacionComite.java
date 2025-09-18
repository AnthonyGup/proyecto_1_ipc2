/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.ComiteDAO;
import com.mycompany.congresos_web_app.backend.crud.CongresoDAO;
import com.mycompany.congresos_web_app.backend.crud.UsuarioDAO;
import com.mycompany.congresos_web_app.backend.entities.Comite;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class ValidacionComite extends Validador {
    
    private final Comite COMITE = new Comite();
    
    public void validarUsuario(String usuario) throws ValidacionException, SQLException {
        if (!esCorreoValido(usuario)) {
            throw new ValidacionException("Usuario incorrecto");
        }
        if (!existeEsteRegistro(usuario, new UsuarioDAO())) {
            throw new ValidacionException("Este usuario no existe");
        }
        COMITE.setID_USUARIO(usuario);
    }
    
    public void validarCongreso(String congreso) throws ValidacionException, SQLException {
        if (!esCodigoValido(congreso, "CON-", 12)) {
            throw new ValidacionException("Codigo de congreso incorrecto");
        }
        if (!existeEsteRegistro(congreso, new CongresoDAO())) {
            throw new ValidacionException("Este congreso no existe");
        }
        COMITE.setID_CONGRESO(congreso);
    }
    
    @Override
    public void crearRegistro() throws SQLException {
        ComiteDAO comite = new ComiteDAO();
        
        comite.create(COMITE);
    }
    
}

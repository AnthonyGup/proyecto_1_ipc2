/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.UsuarioDAO;
import com.mycompany.congresos_web_app.backend.entities.Usuario;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoUsuario;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Base64;

/**
 *
 * @author antho
 */
public class ValidadorUsuario extends Validador {
    
    private final Usuario usuario = new Usuario();
    
    public void validarCorreo(String correo) throws ValidacionException, SQLException {
        if (!esCorreoValido(correo)) {
            throw new ValidacionException("El correo es invalido");
        }
        if (existeEsteRegistro(correo, new UsuarioDAO())) {
            throw new ValidacionException("El correo: " + correo + " ya existe en la base de datos");
        }
        usuario.setCORREO(correo);
    }
    
    public void guardarEstado(boolean estado) {
        usuario.setEstado(estado);
    }
    
    public void validarFecha(LocalDate fecha) throws ValidacionException {
        if (esFechaValida(fecha)) {
            usuario.setFECHA_CREACION(fecha);
        } else {
            throw new ValidacionException("Fecha invallida");
        }
    }
    
    public void validarPassword(String password) throws ValidacionException {
        String codificado = Base64.getEncoder().encodeToString(password.getBytes());
        
        if (esLongitudValida(codificado, 255)) {
            usuario.setPASSWORD(codificado);
        } else {
            throw new ValidacionException("Contraseña muy larga");
        }
    }
    
    public void validarFondosCartera(double valor) throws ValidacionException {
        if (esMontoValido(valor)) {
            usuario.setCartera_digital(valor);
        } else {
            throw new ValidacionException("Monto a acreditaar es invalido");
        }
    }
    
    public void guardarRol(String rol) {
        usuario.setROL(TipoUsuario.valueOf(rol));
    }
    
    @Override
    public void crearRegistro() throws SQLException {
        UsuarioDAO dao = new UsuarioDAO();
        dao.create(usuario);
    }
}

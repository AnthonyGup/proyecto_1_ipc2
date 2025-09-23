/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.UsuarioDAO;
import com.mycompany.congresos_web_app.backend.encriptado.EncriptadorPassword;
import com.mycompany.congresos_web_app.backend.entities.Usuario;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoUsuario;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author antho
 */
public class ValidadorUsuario extends Validador {
    
    private final Usuario usuario = new Usuario();

    public ValidadorUsuario() {
    }
    
    
    public ValidadorUsuario(String correo, boolean estado, String password, String valor, String rol) throws ValidacionException, SQLException, SQLException {
        validarCorreo(correo);
        validarPassword(password);
        guardarEstado(estado);
        validarFecha(LocalDate.now());
        if (rol.equals("PARTICIPANTE")) {
            validarFondosCartera(Double.parseDouble(valor));
        }
        guardarRol(rol);
    }
    
    
    private void validarCorreo(String correo) throws ValidacionException, SQLException, NullPointerException {
        if (!esCorreoValido(correo)) {
            throw new ValidacionException("El correo es invalido");
        }
        if (existeEsteRegistro(correo, new UsuarioDAO())) {
            throw new ValidacionException("El correo: " + correo + " ya pertenece a un usuario");
        }
        usuario.setCORREO(correo);
    }
    
    public void guardarEstado(boolean estado) {
        usuario.setEstado(estado);
    }
    
    public void validarFecha(LocalDate fecha) throws ValidacionException, NullPointerException {
        usuario.setFECHA_CREACION(fecha);
    }
    
    public void validarPassword(String password) throws ValidacionException, NullPointerException {
        EncriptadorPassword encriptado = new EncriptadorPassword();
        String codificado = encriptado.codificar(password);
        
        if (esLongitudValida(codificado, 255)) {
            usuario.setPASSWORD(codificado);
        } else {
            throw new ValidacionException("Contraseña muy larga");
        }
    }
    
    public void validarFondosCartera(double valor) throws ValidacionException {
        if (!esMontoValido(valor)) {
            throw new ValidacionException("Monto a acreditaar es invalido");
        }
            usuario.setCartera_digital(valor);
    }
    
    public void guardarRol(String rol) throws NullPointerException {
        usuario.setROL(TipoUsuario.valueOf(rol));
    }
    
    @Override
    public void crearRegistro() throws SQLException {
        UsuarioDAO dao = new UsuarioDAO();
        dao.create(usuario);
    }
}

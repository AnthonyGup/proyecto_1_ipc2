/*;

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.ActividadDAO;
import com.mycompany.congresos_web_app.backend.crud.SalonDAO;
import com.mycompany.congresos_web_app.backend.crud.UsuarioDAO;
import com.mycompany.congresos_web_app.backend.entities.Actividad;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoActividad;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;
import java.time.LocalTime;

/**
 *
 * @author antho
 */
public class ValidadorActividad extends Validador {

    private final Actividad ACTIVIDAD = new Actividad();
    
    public void validarCoodigo(String codigo) throws ValidacionException, SQLException {
        if (!esCodigoValido(codigo, "ACT-", 12)) {
            throw new ValidacionException("Codigo incalido");
        }
        if (existeEsteRegistro(codigo, new ActividadDAO())) {
            throw new ValidacionException("Este evento ya existe");
        }
    }
    
    public void validarNombre(String nombre) throws ValidacionException {
        if (!esLongitudValida(nombre, 150)) {
            throw new ValidacionException("Nombre muy largo");
        }
        ACTIVIDAD.setNOMBRE(nombre);
    }
    
    public void validarDescripcion(String descripcion) throws ValidacionException {
        if (!esLongitudValida(descripcion, 500)) {
            throw new ValidacionException("Descripcion muy larga");
        }
        ACTIVIDAD.setDESCRIPCION(descripcion);
    }
    
    public void validarCupoMaximo(int cupo) {
        ACTIVIDAD.setCupo_maximo(cupo);
    }
    
    public void validarTipo(String tipo) {
        ACTIVIDAD.setTIPO(TipoActividad.valueOf(tipo));
    }
    
    public void validarHoraInicioo(LocalTime time) throws ValidacionException {
        if (!esHoraValida(time)) {
            throw new ValidacionException("Hora invalida");
        }
        ACTIVIDAD.setHORA_INICIO(time);
    }
    
    public void validarHoraFin(LocalTime time) throws ValidacionException {
        if (!esHoraValida(time)) {
            throw new ValidacionException("Hora invalida");
        }
        ACTIVIDAD.setHORA_FIN(time);
    }
    
    public void validarEncargado(String encargado) throws ValidacionException, SQLException {
        if (!esCorreoValido(encargado)) {
            throw new ValidacionException("Correo invalido");
        }
        if (!existeEsteRegistro(encargado, new UsuarioDAO())) {
            throw new ValidacionException("Este usuario no existe");
        }
        ACTIVIDAD.setID_ENCARGADO(encargado);
    }
    
    public void validarCongreso(String congreso) throws ValidacionException {
        if (!esCodigoValido(congreso, "CON-", 12)) {
            throw new ValidacionException("Codigo incorrecto");
        }
        ACTIVIDAD.setID_ENCARGADO(congreso);
    }
    
    public void validarSalon(int salon) throws ValidacionException, SQLException {
        if (!existeEsteRegistro("" + salon, new SalonDAO())) {
            throw new ValidacionException("Este salon no existe");
        }
    }
    
    @Override
    public void crearRegistro() throws SQLException {
        ActividadDAO crud = new ActividadDAO();
        crud.create(ACTIVIDAD);
    }
     
}

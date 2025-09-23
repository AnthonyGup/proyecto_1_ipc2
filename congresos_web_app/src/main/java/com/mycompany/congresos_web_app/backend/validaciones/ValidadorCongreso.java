/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.CongresoDAO;
import com.mycompany.congresos_web_app.backend.crud.InstitucionDAO;
import com.mycompany.congresos_web_app.backend.crud.UsuarioDAO;
import com.mycompany.congresos_web_app.backend.entities.Congreso;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author antho
 */
public class ValidadorCongreso extends Validador {
    
    private final Congreso CONGRESO = new Congreso();
    
    
    public void validarID(String id) throws ValidacionException, SQLException {
        if (!esCodigoValido(id, "CON-", 12)) {
            throw new ValidacionException("El codigo no es correcto");
        }
        if (existeEsteRegistro(id, new CongresoDAO())) {
            throw new ValidacionException("Ya existe un registro con este codigo");
        }
        CONGRESO.setId_congreso(id);
    }
    
    public void validarUbicacion(String ubicacion) throws ValidacionException {
        if (!esLongitudValida(ubicacion, 150)) {
            throw  new ValidacionException("La ubicacion es muy larga");
        }
        CONGRESO.setUbicacion(ubicacion);
    }
    
    public void validarTitulo(String titulo) throws ValidacionException {
        if (!esLongitudValida(titulo, 150)) {
            throw new ValidacionException("Titulo muy largo");
        }
        CONGRESO.setTitulo(titulo);
    }
    
    public void validarDescripcion(String descripcion) throws ValidacionException {
        if (!esLongitudValida(descripcion, 400)) {
            throw new ValidacionException("Descripcion muy larga");
        }
        CONGRESO.setDescripcion(descripcion);
    }
    
    public void validarPrecio(double precio) throws ValidacionException {
        if (precio < 35.00) {
            throw new ValidacionException("El precio minimo es de 35");
        }
        if (!esMontoValido(precio)) {
            throw new ValidacionException("Cantidad no valido");
        }
        CONGRESO.setPrecio(precio);
    }
    
    public void validarComision(double comision) throws ValidacionException {
        if (!esMontoValido(comision)) {
            throw new ValidacionException("Comision invalida");
        }
        CONGRESO.setComision(comision);
    }
    
    public void guardarEstado(boolean estado) {
        CONGRESO.setEstado(estado);
    }
    
    public void validarFecha(LocalDate fecha) throws ValidacionException {
        if (!esFechaValida(fecha)) {
            throw new ValidacionException("Fecha incorrecta");
        }
        CONGRESO.setFecha_inicio(fecha);
    }
    
    public void validarInstitucion(String institucion) throws SQLException, ValidacionException {
        if (!existeEsteRegistro("" + institucion, new InstitucionDAO())) {
            throw new ValidacionException("No existe esta institucion");
        }
        CONGRESO.setId_institucion(institucion);
    }
    
    public void validarAdministrador(String id) throws ValidacionException, SQLException {
        if (!existeEsteRegistro(id, new UsuarioDAO())) {
            throw new ValidacionException("no existe un usuario con este codigo");
        }
        CONGRESO.setId_admin(id);
    }
    
    public void validarConvocatoria(boolean estaActiva) {
        CONGRESO.setConvocatoria(estaActiva);
    }
    
    @Override
    public void crearRegistro() throws SQLException {
        
        CongresoDAO crud = new CongresoDAO();
        
        crud.create(CONGRESO);
    }
}

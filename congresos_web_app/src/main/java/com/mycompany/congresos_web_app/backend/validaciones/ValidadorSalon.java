/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.CongresoDAO;
import com.mycompany.congresos_web_app.backend.crud.SalonDAO;
import com.mycompany.congresos_web_app.backend.entities.Salon;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class ValidadorSalon extends Validador {
    
    private final Salon SALON = new Salon();
    
    public void validarNombre(String nombreSalon) throws ValidacionException {
        if (!esLongitudValida(nombreSalon, 50)) {
            throw new ValidacionException("Nombre muy largo");
        }
        SALON.setSALON(nombreSalon);
    }
    
    public void validarUbicacion(String ubicacion) throws ValidacionException {
        if (!esLongitudValida(ubicacion, 150)) {
            throw new ValidacionException("Ubicacion muy larga");
        }
        SALON.setUBICACION(ubicacion);
    }
    
    public void validarCapacidad(int capacidad) {
        SALON.setCAPACIDAD(capacidad);
    }
    
    public void validarCongreso(String congreso) throws SQLException, ValidacionException {
        if (!esCodigoValido(congreso, "CON-", 12)) {
            throw new ValidacionException("Codigo invalido");
        }
        if (!existeEsteRegistro(congreso, new CongresoDAO())) {
            throw new ValidacionException("Este congreso no existe");
        }
        SALON.setID_CONGRESO(congreso);
    }
    
    public void crearRegistro() throws SQLException {
        SalonDAO crud = new SalonDAO();
        crud.create(SALON);
    }
        
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.validaciones;

import com.mycompany.congresos_web_app.backend.crud.Crud;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

/**
 *
 * @author antho
 */
public abstract class Validador {

    protected boolean esCorreoValido(String correo) {
        String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}(\\.[A-Za-z]{2,})?$";
        return correo.matches(patron);
    }

    /**
     * Metodo que comprueba que la longitud y el prefijo del codigo sean los
     * correctos
     *
     * @param texto el codigo a evaluar
     * @param prefijo el prefijo ejmplo: EVT-, CNG-, ACT-...
     * @param cantidad
     * @return true si el codigo esta correcto
     */
    protected boolean esCodigoValido(String texto, String prefijo, int cantidad) {
        if (texto.isBlank()) {
            return false;
        }
        String codigo = "^" + prefijo + "\\d{" + cantidad + "}$";
        return texto.matches(codigo);
    }

    /**
     * Funcion que comprueba si el texto tiene la longitud adecuada
     *
     * @param texto el texto a evaluar
     * @param longitudMaxima la longitud maxima que puede tener ese texto
     * @return true si la longitud no sobrepasa la longitud maxima
     */
    protected boolean esLongitudValida(String texto, int longitudMaxima) {
        return texto.length() <= longitudMaxima;
    }

    /**
     * Funcion que comprueba que la fecha sea valida
     *
     * @param fecha la feecha que introduce el usuario
     * @return truue si la fecha es en el futuro
     */
    protected boolean esFechaValida(LocalDate fecha) {
        LocalDate hoy = LocalDate.now();

        return fecha.isAfter(hoy);
    }

    /**
     * Funcion que comprueba que la hora sea valida
     *
     * @param hora la hora introducida por el usuario
     * @return true si la hora es mayor a la de el instante actual
     */
    protected boolean esHoraValida(LocalTime hora) {
        LocalTime ahora = LocalTime.now();
        return hora.isAfter(ahora);
    }

    /**
     * Comprueba que el DateTime sea correcto
     *
     * @param fecha_hora la fecha y hora introducidas por el usuario
     * @return true si la fecha y hora es en el futuro
     */
    protected boolean esFechaHoraValida(LocalDateTime fecha_hora) {
        LocalDateTime actual = LocalDateTime.now();
        return fecha_hora.isAfter(actual);
    }

    /**
     * Funcion que comprueba si el registro buscado por codigo ya existe en la
     * base de datos
     *
     * @param codigo el codigo por el cual se busca
     * @param tipo el tipo preciso de entidad que queremos buscar
     * @return true si ya hay alguno con ese codigo, false si falla o no existe
     * @throws java.sql.SQLException
     */
    protected boolean existeEsteRegistro(String codigo, Crud tipo) throws SQLException {
        return tipo.readByPk(codigo) != null;
    }

    protected boolean existeEsteRegistroById(String codigo, String id, Crud tipo) throws SQLException {
        return tipo.readByColumn(codigo, id) != null;
    }

    protected boolean esMontoValido(double monto) {
        String texto = String.format(Locale.US, "%.2f", monto);
        double redondeado = Double.parseDouble(texto);
        return Double.compare(monto, redondeado) == 0;
    }

    public abstract void crearRegistro() throws SQLException;

}

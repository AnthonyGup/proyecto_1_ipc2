/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Reserva;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author antho
 */
public class ReservaDAO extends Crud<Reserva> {

    public ReservaDAO() {
        super("reserva_taller", "id_reserva");
    }

    @Override
    public boolean create(Reserva entidad) throws SQLException {
        String sql = "INSERT INTO reserva_taller (fecha_reserva, id_actividad, id_participante) VALUES (?,?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setDate(1, Date.valueOf(entidad.getFECHA_RESERVA()));
        stmt.setString(2, entidad.getID_ACTIVIDAD());
        stmt.setString(3, entidad.getID_PARTICIPANTE());
        
        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    @Override
    public boolean update(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reserva obtenerEntidad(ResultSet rs) throws SQLException {
        Reserva reserva = new Reserva();
        
        reserva.setID_RESERVA(rs.getInt("id_reserva"));
        reserva.setFECHA_RESERVA(rs.getDate("fecha_reserva").toLocalDate());
        reserva.setID_ACTIVIDAD(rs.getString("id_actividad"));
        reserva.setID_PARTICIPANTE("id_participante");
        
        return reserva;
    }
}

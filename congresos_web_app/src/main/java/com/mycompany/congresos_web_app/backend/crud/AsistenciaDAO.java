/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Asistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author antho
 */
public class AsistenciaDAO extends Crud<Asistencia>{

    public AsistenciaDAO()  {
        super("asistencia", "id_asistencia");
    }

    @Override
    public boolean create(Asistencia entidad) throws SQLException {
        String sql = "INSERT INTO asistencia (fecha_hora, id_actividad, id_participante) VALUES (?,?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setTimestamp(1, Timestamp.valueOf(entidad.getFECHA_HORA()));
        stmt.setString(2, entidad.getID_ACTIVIDAD());
        stmt.setString(3, entidad.getID_PARTICIPANTE());
        
        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    

    @Override
    public Asistencia obtenerEntidad(ResultSet rs) throws SQLException {
        Asistencia asistencia = new Asistencia();
        
        asistencia.setID_ASISTENCIA(rs.getInt("id_asistencia"));
        asistencia.setFECHA_HORA(rs.getTimestamp("fecha_hora").toLocalDateTime());
        asistencia.setID_ACTIVIDAD(rs.getString("id_actividad"));
        asistencia.setID_PARTICIPANTE(rs.getString("id_participante"));
        
        return asistencia;
    }
    
}

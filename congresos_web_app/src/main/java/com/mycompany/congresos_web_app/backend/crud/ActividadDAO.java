/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Actividad;
import com.mycompany.congresos_web_app.backend.entities.enums.EstadosActividad;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoActividad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author antho
 */
public class ActividadDAO extends Crud<Actividad> {

    public ActividadDAO() {
        super("actividad", "id_actividad");
    }

    @Override
    public boolean create(Actividad entidad) throws SQLException {
        String sql = "INSERT INTO actividad (id_actividad, nombre, descripcion, cupo_maximo, tipo, hora_inicio, hora_fin, id_encargado, id_congreso, id_salon, estado) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setString(1, entidad.getId_actividad());
        stmt.setString(2, entidad.getNombre());
        stmt.setString(3, entidad.getDescripcion());
        stmt.setInt(4, entidad.getCupo_maximo());
        stmt.setString(5, entidad.getTipo().name());
        stmt.setTime(6, Time.valueOf(entidad.getHora_inicio()));
        stmt.setTime(7, Time.valueOf(entidad.getHora_fin()));
        stmt.setString(8, entidad.getId_encargado());
        stmt.setString(9, entidad.getId_congreso());
        stmt.setInt(10, entidad.getId_salon());
        stmt.setString(10, entidad.getEstado().name());
        
        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    @Override
    public boolean update(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Actividad obtenerEntidad(ResultSet rs) throws SQLException {
        Actividad actividad = new Actividad();
        
        actividad.setId_actividad(rs.getString("id_actividad"));
        actividad.setNombre(rs.getString("nombre"));
        actividad.setDescripcion(rs.getString("descripcion"));
        actividad.setCupo_maximo(rs.getInt("cupo_maximo"));
        actividad.setTipo(TipoActividad.valueOf(rs.getString("tipo")));
        actividad.setHora_inicio(rs.getTime("hora_inicio").toLocalTime());
        actividad.setHora_fin(rs.getTime("hora_fin").toLocalTime());
        actividad.setId_encargado(rs.getString("id_encargado"));
        actividad.setId_congreso(rs.getString("id_congreso"));
        actividad.setId_salon(rs.getInt("id_salon"));
        actividad.setEstado(EstadosActividad.valueOf(rs.getString("estado")));
        
        return actividad;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Actividad;
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
        String sql = "INSERT INTO actividad (id_actividad, nombre, descripcion, cupo_maximo, tipo, hora_inicio, hora_fin, id_encargado, id_congreso, id_salon) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setString(1, entidad.getId_actividad());
        stmt.setString(2, entidad.getNOMBRE());
        stmt.setString(3, entidad.getDESCRIPCION());
        stmt.setInt(4, entidad.getCupo_maximo());
        stmt.setString(5, entidad.getTIPO().name());
        stmt.setTime(6, Time.valueOf(entidad.getHORA_INICIO()));
        stmt.setTime(7, Time.valueOf(entidad.getHORA_FIN()));
        stmt.setString(8, entidad.getID_ENCARGADO());
        stmt.setString(9, entidad.getID_CONGRESO());
        stmt.setInt(10, entidad.getID_SALON());
        
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
        actividad.setNOMBRE(rs.getString("nombre"));
        actividad.setDESCRIPCION(rs.getString("descripcion"));
        actividad.setCupo_maximo(rs.getInt("cupo_maximo"));
        actividad.setTIPO(TipoActividad.valueOf(rs.getString("tipo")));
        actividad.setHORA_INICIO(rs.getTime("hora_inicio").toLocalTime());
        actividad.setHORA_FIN(rs.getTime("hora_fin").toLocalTime());
        actividad.setID_ENCARGADO(rs.getString("id_encargado"));
        actividad.setID_CONGRESO(rs.getString("id_congreso"));
        actividad.setID_SALON(rs.getInt("id_salon"));
        
        return actividad;
    }
    
}

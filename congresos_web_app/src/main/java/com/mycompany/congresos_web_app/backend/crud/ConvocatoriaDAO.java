/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Convocatoria;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class ConvocatoriaDAO extends Crud<Convocatoria> {

    public ConvocatoriaDAO() {
        super("convocatoria", "id_convocatoria");
    }
    
    @Override
    public boolean create(Convocatoria entidad) throws SQLException {
        String sql = "INSERT INTO convocatoria (titulo, estado, fecha_inicio, fecha_fin, id_congreso) VALUES (?,?,?,?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setString(1, entidad.getTITULO());
        stmt.setBoolean(2, entidad.isEstado());
        stmt.setDate(3, Date.valueOf(entidad.getFECHA_INICIO()));
        stmt.setDate(4, Date.valueOf(entidad.getFECHA_FIN()));
        stmt.setString(5, entidad.getID_CONGRESO());
        
        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    @Override
    public Convocatoria obtenerEntidad(ResultSet rs) throws SQLException {
        Convocatoria convocatoria = new Convocatoria();
        
        convocatoria.setID_CONVOCATORIA(rs.getInt("id_convocatoria"));
        convocatoria.setTITULO(rs.getString("titulo"));
        convocatoria.setEstado(rs.getBoolean("estado"));
        convocatoria.setFECHA_INICIO(rs.getDate("fecha_inicio").toLocalDate());
        convocatoria.setFECHA_FIN(rs.getDate("fecha_fin").toLocalDate());
        convocatoria.setID_CONGRESO(rs.getString("id_congreso"));
        
        return convocatoria;
    }
    
}

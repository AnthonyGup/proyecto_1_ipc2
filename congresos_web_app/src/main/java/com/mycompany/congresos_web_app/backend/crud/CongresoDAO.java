/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Congreso;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class CongresoDAO extends Crud<Congreso> {

    public CongresoDAO() {
        super("congreso", "id_congreso");
    }

    @Override
    public boolean create(Congreso entidad) throws SQLException {
        String sql = "INSERT INTO congreso (id_congreso, ubicacion, titulo, descripcion, precio, comision, estado, convocatoria, fecha_inicio, id_institucion, id_admin) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setString(1, entidad.getId_congreso());
        stmt.setString(2, entidad.getUbicacion());
        stmt.setString(3, entidad.getTitulo());
        stmt.setString(4, entidad.getDescripcion());
        stmt.setDouble(5, entidad.getPrecio());
        stmt.setDouble(6, entidad.getComision());
        stmt.setBoolean(7, entidad.isEstado());
        stmt.setBoolean(8, entidad.isConvocatoria());
        stmt.setDate(9, Date.valueOf(entidad.getFecha_inicio()));
        stmt.setString(10, entidad.getId_institucion());
        stmt.setString(11, entidad.getId_admin());
        
        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }
    
    @Override
    public boolean update(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Congreso obtenerEntidad(ResultSet rs) throws SQLException {
        Congreso congreso = new Congreso();
        
        congreso.setId_congreso(rs.getString("id_congreso"));
        congreso.setUbicacion(rs.getString("ubicacion"));
        congreso.setTitulo(rs.getString("titulo"));
        congreso.setDescripcion(rs.getString("descripcion"));
        congreso.setPrecio(rs.getDouble("precio"));
        congreso.setComision(rs.getDouble("comision"));
        congreso.setEstado(rs.getBoolean("estado"));
        congreso.setFecha_inicio(rs.getDate("fecha_inicio").toLocalDate());
        congreso.setId_institucion(rs.getString("id_institucion"));
        congreso.setId_admin(rs.getString("id_admin"));
        
        return congreso;
    }
    
}

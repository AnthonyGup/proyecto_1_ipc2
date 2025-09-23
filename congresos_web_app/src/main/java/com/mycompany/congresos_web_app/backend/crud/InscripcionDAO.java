/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Inscripcion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class InscripcionDAO extends Crud<Inscripcion> {

    public InscripcionDAO(){
        super("inscripcion", "id_inscripcion");
    }
    
    @Override
    public boolean create(Inscripcion entidad) throws SQLException {
        String sql = "INSERT INTO inscripcion (fecha_pago, monto, id_participante, id_congreso)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setDate(1, Date.valueOf(entidad.getFECHA_PAGO()));
        stmt.setDouble(2, entidad.getMONTO());
        stmt.setString(3, entidad.getID_PARTICIPANTE());
        stmt.setString(3, entidad.getID_CONGRESO());
        
        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    @Override
    public boolean update(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Inscripcion obtenerEntidad(ResultSet rs) throws SQLException {
        Inscripcion inscripcion = new Inscripcion();
        
        inscripcion.setID_INSCRIPCION(rs.getInt("id_inscripcion"));
        inscripcion.setFECHA_PAGO(rs.getDate("fecha_pago").toLocalDate());
        inscripcion.setMONTO(rs.getDouble("monto"));
        inscripcion.setID_PARTICIPANTE(rs.getString("id_participante"));
        inscripcion.setID_CONGRESO(rs.getString("id_congreso"));
        
        return inscripcion;
    }
    
}

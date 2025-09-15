/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.db.DBConnectionSingleton;
import com.mycompany.congresos_web_app.backend.entities.Congreso;
import com.mycompany.congresos_web_app.backend.entities.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antho
 */
public class CongresoDAO implements Crud<Congreso> {

    private final Connection CONNECTION = DBConnectionSingleton.getInstance().getConnection();
    
    @Override
    public boolean create(Congreso entidad) throws SQLException {
        String sql = "INSERT INTO congreso (id_congreso, ubicacion, titulo, descripcion, precio, comision, estado, fecha_inicio, id_institucion, id_admin) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setString(1, entidad.getID_CONGRESO());
        stmt.setString(2, entidad.getUBICACION());
        stmt.setString(3, entidad.getTITULO());
        stmt.setString(4, entidad.getDESCRIPCION());
        stmt.setDouble(5, entidad.getPRECIO());
        stmt.setDouble(6, entidad.getCOMISION());
        stmt.setBoolean(7, entidad.isEstado());
        stmt.setDate(8, Date.valueOf(entidad.getFECHA_INICIO()));
        stmt.setInt(9, entidad.getID_INSTITUCION());
        stmt.setString(10, entidad.getID_ADMIN());
        
        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }
    

    @Override
    public Congreso read(String id) throws SQLException {
        String sql = "SELECT * FROM congreso WHERE id_congreso = ?";

        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return obtenerEntidad(rs);
        }

        return null;
    }

    @Override
    public List<Congreso> readAll(String tabla) throws SQLException {
        List<Congreso> congresos = new ArrayList<>();
        String sql = "SELECT * FROM congreso";

        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            congresos.add(obtenerEntidad(rs));
        }

        return congresos;
    }

    @Override
    public boolean update(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM congreso WHERE id_congreso = ?";
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        stmt.setString(1, id);

        int filasEliminadas = stmt.executeUpdate();
        return filasEliminadas > 0;
    }

    @Override
    public Congreso obtenerEntidad(ResultSet rs) throws SQLException {
        Congreso congreso = new Congreso();
        
        congreso.setID_CONGRESO(rs.getString("id_congreso"));
        congreso.setUBICACION(rs.getString("ubicacion"));
        congreso.setTITULO(rs.getString("titulo"));
        congreso.setDESCRIPCION(rs.getString("descripcion"));
        congreso.setPRECIO(rs.getDouble("precio"));
        congreso.setCOMISION(rs.getDouble("comision"));
        congreso.setEstado(rs.getBoolean("estado"));
        congreso.setFECHA_INICIO(rs.getDate("fecha_inicio").toLocalDate());
        congreso.setID_INSTITUCION(rs.getInt("id_institucion"));
        congreso.setID_ADMIN(rs.getString("id_admin"));
        
        return congreso;
    }
    
}

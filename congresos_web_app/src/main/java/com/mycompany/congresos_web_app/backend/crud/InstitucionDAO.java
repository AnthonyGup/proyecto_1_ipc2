/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.db.DBConnectionSingleton;
import com.mycompany.congresos_web_app.backend.entities.Institucion;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antho
 */
public class InstitucionDAO implements Crud<Institucion> {
    
    private final Connection CONNECTION = DBConnectionSingleton.getInstance().getConnection();

    @Override
    public boolean create(Institucion entidad) throws SQLException {

        String sql = "INSERT INTO institucion (id_institucion, ubicacion, nombre, descripcion, estado) VALUES (?,?,?,?,?)";

        PreparedStatement stmt = CONNECTION.prepareStatement(sql);

        stmt.setInt(1, entidad.getID_INSTITUCION());
        stmt.setString(2, entidad.getUBICACION());
        stmt.setString(3, entidad.getNOMBRE());
        stmt.setString(4, entidad.getDESCRIPCION());
        stmt.setBoolean(5, entidad.isEstado());

        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    @Override
    public Institucion read(String id) throws SQLException {
        String sql = "SELECT * FROM institucion WHERE id_institucion = ?";

        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return obtenerEntidad(rs);
        }

        return null;
    }

    @Override
    public List<Institucion> readAll(String tabla) throws SQLException {
        List<Institucion> institucion = new ArrayList<>();
        String sql = "SELECT * FROM institucion";

        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            institucion.add(obtenerEntidad(rs));
        }

        return institucion;
    }

    @Override
    public boolean update(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM institucion WHERE id_institucion = ?";
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        stmt.setString(1, id);

        int filasEliminadas = stmt.executeUpdate();
        return filasEliminadas > 0;
    }

    @Override
    public Institucion obtenerEntidad(ResultSet rs) throws SQLException {
        Institucion institucion = new Institucion();
        
        institucion.setID_INSTITUCION(rs.getInt("id_institucion"));
        institucion.setUBICACION(rs.getString("ubicacion"));
        institucion.setNOMBRE(rs.getString("nombre"));
        institucion.setDESCRIPCION(rs.getString("descripcion"));
        institucion.setEstado(rs.getBoolean("estado"));

        return institucion;
    }
}

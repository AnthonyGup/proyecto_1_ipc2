/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Institucion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class InstitucionDAO extends Crud<Institucion> {

    public InstitucionDAO() {
        super("institucion", "id_institucion");
    }
    
    @Override
    public boolean create(Institucion entidad) throws SQLException {

        String sql = "INSERT INTO institucion (ubicacion, nombre, descripcion, estado) VALUES (?,?,?,?)";

        PreparedStatement stmt = CONNECTION.prepareStatement(sql);

        stmt.setString(1, entidad.getUBICACION());
        stmt.setString(2, entidad.getNOMBRE());
        stmt.setString(3, entidad.getDESCRIPCION());
        stmt.setBoolean(4, entidad.isEstado());

        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    @Override
    public boolean update(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

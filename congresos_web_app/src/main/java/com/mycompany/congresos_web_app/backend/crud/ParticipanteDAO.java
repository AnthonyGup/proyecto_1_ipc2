/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.db.DBConnectionSingleton;
import com.mycompany.congresos_web_app.backend.entities.Participante;
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
public class ParticipanteDAO implements Crud<Participante> {

    private final Connection CONNECTION = DBConnectionSingleton.getInstance().getConnection();
    
    @Override
    public boolean create(Participante entidad) throws SQLException {
        String sql = "INSERT INTO participante (id_personal, telefono, organizacion, nombre_completo, id_usuario) VALUES (?,?,?,?,?)";

        PreparedStatement stmt = CONNECTION.prepareStatement(sql);

        stmt.setString(1, entidad.getID_PERSONAL());
        stmt.setString(2, entidad.getTELEFONO());
        stmt.setString(3, entidad.getORGANIZACION());
        stmt.setString(4, entidad.getNOMBRE_COMPLETO());
        stmt.setString(5, entidad.getID_USUARIO());

        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    @Override
    public Participante read(String id) throws SQLException {
        String sql = "SELECT * FROM participante WHERE id_personal = ?";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return obtenerEntidad(rs);
        }

        return null;
    }

    @Override
    public List<Participante> readAll(String tabla) throws SQLException {
        List<Participante> participantes = new ArrayList<>();
        String sql = "SELECT * FROM participante";

        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            participantes.add(obtenerEntidad(rs));
        }

        return participantes;
    }

    @Override
    public boolean update(String id) throws SQLException {
        String sql = "DELETE FROM participante WHERE id_personal = ?";
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        stmt.setString(1, id);

        int filasEliminadas = stmt.executeUpdate();
        return filasEliminadas > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Participante obtenerEntidad(ResultSet rs) throws SQLException {
        Participante participante = new Participante();
        
        participante.setID_PERSONAL(rs.getString("id_personal"));
        participante.setTELEFONO(rs.getString("telefono"));
        participante.setORGANIZACION(rs.getString("organizacion"));
        participante.setNOMBRE_COMPLETO(rs.getString("nombre_completo"));
        participante.setID_USUARIO(rs.getString("id_usuario"));
        
        return participante;
    }

}

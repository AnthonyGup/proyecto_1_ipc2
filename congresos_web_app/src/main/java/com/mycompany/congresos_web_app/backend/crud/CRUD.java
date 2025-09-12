package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.daos.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class CRUD {
    
    private final Connection CONNECTION;
    
    public CRUD(Connection connection) {
        this.CONNECTION = connection;
    }

    public DAO getById(String id, String apartado, String tabla) {
        
        DAO entity = null;
        String sql = "SELECT * FROM ? WHERE ? = ?";

        try (PreparedStatement stmt = CONNECTION.prepareStatement(sql)) {

            stmt.setString(1, tabla);
            stmt.setString(2, apartado);
            stmt.setString(3, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                entity.setItems(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // o usa un logger si prefieres
        }

        return entity;

    }

}

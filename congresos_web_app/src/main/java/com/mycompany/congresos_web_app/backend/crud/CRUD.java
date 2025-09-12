package com.mycompany.congresos_web_app.backend.crud;

import static jakarta.mail.Flags.Flag.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class CRUD<T> {

    private T contenido;
    private final Connection CONNECTION;
    
    public CRUD(Connection connection) {
        this.CONNECTION = connection;
    }

    public T getById(String id, String apartado, String tabla) {
        
        T objeto = null;
        String sql = "SELECT * FROM ? WHERE ? = ?";

        try (PreparedStatement stmt = CONNECTION.prepareStatement(sql)) {

            stmt.setString(1, tabla);
            stmt.setString(2, apartado);
            stmt.setString(3, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
            }

        } catch (SQLException e) {
            e.printStackTrace(); // o usa un logger si prefieres
        }

        return objeto;

    }

}

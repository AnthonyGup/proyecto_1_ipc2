/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Comite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class ComiteDAO extends Crud<Comite> {

    public ComiteDAO() {
        super("comite_cientifico", "id_comite");
    }
    
    @Override
    public boolean create(Comite entidad) throws SQLException {
        String sql = "INSERT INTO comite_cientifico (id_usuario, id_congreso) VALUES (?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        stmt.setString(1, entidad.getID_USUARIO());
        stmt.setString(2, entidad.getID_CONGRESO());
        
        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    @Override
    public boolean update(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Comite obtenerEntidad(ResultSet rs) throws SQLException {
        Comite comite = new Comite();
        
        comite.setID_COMITE(rs.getInt("id_comite"));
        comite.setID_USUARIO(rs.getString("id_usuario"));
        comite.setID_CONGRESO(rs.getString("id_congreso"));
        
        return comite;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Salon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class SalonDAO extends Crud<Salon> {

    public SalonDAO() {
        super("salon", "id_salon");
    }

    @Override
    public boolean create(Salon entidad) throws SQLException {
        String sql = "INSERT INTO salon (salon, ubicacion, capacidad, id_congreso) VALUES (?,?,?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setString(1, entidad.getSALON());
        stmt.setString(2, entidad.getUBICACION());
        stmt.setInt(3, entidad.getCAPACIDAD());
        stmt.setString(4, entidad.getID_CONGRESO());
        
        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

   

    @Override
    public Salon obtenerEntidad(ResultSet rs) throws SQLException {
        Salon salon = new Salon();
        
        salon.setID_SALON(rs.getInt("id_salon"));
        salon.setSALON(rs.getString("salon"));
        salon.setUBICACION(rs.getString("ubicacion"));
        salon.setCAPACIDAD(rs.getInt("capacidad"));
        salon.setID_CONGRESO(rs.getString("id_congreso"));
    
        return salon;
    }
    
}

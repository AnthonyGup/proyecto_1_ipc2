/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Diploma;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoDiploma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class DiplomaDAO extends Crud<Diploma> {

    public DiplomaDAO() {
        super("diploma", "id_diploma");
    }

    @Override
    public boolean create(Diploma entidad) throws SQLException {
        String sql = "INSERT INTO usuario (tipo, descripcion, id_participante, id_congreso) VALUES (?,?,?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setString(1, entidad.getTIPO().name());
        stmt.setString(2, entidad.getDESCRIPCION());
        stmt.setString(3, entidad.getID_PARTICIPANTE());
        stmt.setString(4, entidad.getID_CONGRESO());
        
        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    
    @Override
    public Diploma obtenerEntidad(ResultSet rs) throws SQLException {
        Diploma diploma = new Diploma();
        
        diploma.setID_DIPLOMA(rs.getInt("id_diploma"));
        diploma.setTIPO(TipoDiploma.valueOf(rs.getString("tipo")));
        diploma.setDESCRIPCION(rs.getString("descripcion"));
        diploma.setID_PARTICIPANTE(rs.getString("id_participante"));
        diploma.setID_CONGRESO(rs.getString("id_congreso"));
        
        return diploma;
    }
    
}

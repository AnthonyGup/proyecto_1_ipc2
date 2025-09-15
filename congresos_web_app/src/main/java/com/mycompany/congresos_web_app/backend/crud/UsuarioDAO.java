/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Usuario;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoUsuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class UsuarioDAO extends Crud<Usuario> {

    public UsuarioDAO() {
        super("usuario", "correo");
    }
    
    @Override
    public boolean create(Usuario entidad) throws SQLException {
        String sql = "INSERT INTO usuario (correo, estado, fecha_creacion, password, cartera_digital, rol) VALUES (?,?,?,?,?,?)";

        PreparedStatement stmt = CONNECTION.prepareStatement(sql);

        stmt.setString(1, entidad.getCORREO());
        stmt.setBoolean(2, entidad.isEstado());
        stmt.setDate(3, Date.valueOf(entidad.getFECHA_CREACION()));
        stmt.setString(4, entidad.getPASSWORD());
        stmt.setDouble(5, entidad.getCartera_digital());
        stmt.setString(6, entidad.getROL().name());

        int filasCreadas = stmt.executeUpdate();
        return filasCreadas > 0;
    }

    @Override
    public boolean update(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario obtenerEntidad(ResultSet rs) throws SQLException {

        Usuario usuario = new Usuario();
        usuario.setCORREO(rs.getString("correo"));
        usuario.setEstado(rs.getBoolean("estado"));
        usuario.setFECHA_CREACION(rs.getDate("fecha_creacion").toLocalDate());
        usuario.setPASSWORD(rs.getString("password"));
        usuario.setCartera_digital(rs.getDouble("cartera_digital"));
        usuario.setROL(TipoUsuario.valueOf(rs.getString("rol"))); // Enum

        return usuario;
    }

}

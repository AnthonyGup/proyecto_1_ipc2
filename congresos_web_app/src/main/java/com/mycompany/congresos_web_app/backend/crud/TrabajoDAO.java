
package com.mycompany.congresos_web_app.backend.crud;

import com.mycompany.congresos_web_app.backend.entities.Trabajo;
import com.mycompany.congresos_web_app.backend.entities.enums.TipoTrabajo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class TrabajoDAO extends Crud<Trabajo>{

    public TrabajoDAO() {
        super("trabajo", "id_trabajo");
    }

    @Override
    public boolean create(Trabajo entidad) throws SQLException {
        String sql = "INSERT INTO trabajo (tipo, descripcion, titulo, esado, id_participante, id_convocatoria) VALUES (?,?,?,?,?,?)";
        
        PreparedStatement stmt = CONNECTION.prepareStatement(sql);
        
        stmt.setString(1, entidad.getTIPO().name());
        stmt.setString(2, entidad.getDESCRIPCION());
        stmt.setString(3, entidad.getTITULO());
        stmt.setBoolean(4, entidad.isEstado());
        stmt.setString(5, entidad.getID_PARTICIPANTE());
        stmt.setInt(6, entidad.getID_CONVOCATORIA());
        
        int filasCreadas = stmt.executeUpdate();
        
        return filasCreadas > 0;
    }

    

    @Override
    public Trabajo obtenerEntidad(ResultSet rs) throws SQLException {
        Trabajo trabajo = new Trabajo();
        
        trabajo.setID_TRABAJO(rs.getInt("id_trabajo"));
        trabajo.setTIPO(TipoTrabajo.valueOf(rs.getString("tipo")));
        trabajo.setDESCRIPCION(rs.getString("descripcion"));
        trabajo.setTITULO(rs.getString("titulo"));
        trabajo.setEstado(rs.getBoolean("estado"));
        trabajo.setID_PARTICIPANTE(rs.getString("id_participante"));
        trabajo.setID_CONVOCATORIA(rs.getInt("id_convocatoria"));
        
        return trabajo;
    }
    
}

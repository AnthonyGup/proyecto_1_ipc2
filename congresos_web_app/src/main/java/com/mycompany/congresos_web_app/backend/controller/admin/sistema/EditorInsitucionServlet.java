/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.admin.sistema;

import com.mycompany.congresos_web_app.backend.crud.InstitucionDAO;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import com.mycompany.congresos_web_app.backend.validaciones.ValidadorInstitucion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antho
 */
@WebServlet(name = "EditorInsitucionServlet", urlPatterns = {"/EditorInsitucionServlet"})
public class EditorInsitucionServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            actualizarInstitucion(request);
            request.setAttribute("mensaje", "Actualizacion exitosa");
        } catch (ValidacionException ex) {
            request.setAttribute("error", ex.getMessage());
        } catch (SQLException ex) {
            request.setAttribute("mensaje", ex.getMessage());
        }
        request.getRequestDispatcher("/Admin-sistema/institucion-editar.jsp").forward(request, response);
    }
    
    private void actualizarInstitucion(HttpServletRequest reequest) throws ValidacionException, SQLException {
        ValidadorInstitucion val = new ValidadorInstitucion();
        InstitucionDAO dao = new InstitucionDAO();
        
        //Obtenemos todos los valores a cambiar
        String nombre = reequest.getParameter("institucion");
        String ubicacion = reequest.getParameter("ubicacion");
        String descripcion = reequest.getParameter("descripcion");
        String estadoParam = reequest.getParameter("estado");
        boolean estado = estadoParam != null;
        
        //Validr valores, si algo falla lanza una excepcion
        val.validarUbicacion(ubicacion);
        val.validarDescripcion(descripcion);
        
        //actualizar todo
        dao.update(nombre, "ubicacion", ubicacion, "string");
        dao.update(nombre, "descripcion", descripcion, "string");
        dao.update(nombre, "estado", estado, "boolean");
    }

}

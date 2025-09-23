/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.admin.sistema;

import com.mycompany.congresos_web_app.backend.crud.InstitucionDAO;
import com.mycompany.congresos_web_app.backend.entities.Institucion;
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
@WebServlet(name = "CreadorInstitucionServlet", urlPatterns = {"/CreadorInstitucionServlet"})
public class CreadorInstitucionServlet extends HttpServlet {

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
            crearInstitucion(request);
            request.setAttribute("mensaje", "Institucion creada con exito");
            request.getRequestDispatcher("/Admin-sistema/institucion-crear.jsp").forward(request, response);
        } catch (ValidacionException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("/Admin-sistema/institucion-crear.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("error", "Error en la base de datos");
            request.getRequestDispatcher("/Admin-sistema/institucion-crear.jsp").forward(request, response);
        }
    }

    private void crearInstitucion(HttpServletRequest request) throws ValidacionException, SQLException {
        String nombre = request.getParameter("nombre");
        String ubicacion = request.getParameter("ubicacion");
        String descripcion = request.getParameter("descripcion");
        String activoParam = request.getParameter("activo");
        boolean estado = activoParam != null;

        ValidadorInstitucion val = new ValidadorInstitucion(nombre, ubicacion, descripcion, estado);
        val.crearRegistro();
    }
}

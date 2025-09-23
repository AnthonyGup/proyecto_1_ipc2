/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.buscadores;

import com.mycompany.congresos_web_app.backend.crud.InstitucionDAO;
import com.mycompany.congresos_web_app.backend.entities.Institucion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
@WebServlet(name = "PasarInstitucion", urlPatterns = {"/PasarInstitucion"})
public class PasarInstitucion extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        InstitucionDAO crud = new InstitucionDAO();
        Institucion institucion;
        try {
            institucion = crud.readByPk(nombre);
            if (institucion != null) {
                request.setAttribute("institucion", institucion);
                request.getRequestDispatcher("/Admin-sistema/editar-institucion.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "No se encontró el congreso.");
                request.getRequestDispatcher("/Admin-sistema/institucion-editar.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("error", "Error en la base de datos.");
            request.getRequestDispatcher("/Admin-sistema/institucion-editar.jsp").forward(request, response);
        }


    }
}

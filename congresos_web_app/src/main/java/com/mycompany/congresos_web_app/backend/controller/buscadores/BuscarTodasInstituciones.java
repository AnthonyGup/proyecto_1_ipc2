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
import java.util.List;

/**
 *
 * @author antho
 */
@WebServlet(name = "BuscarTodasInstituciones", urlPatterns = {"/BuscarTodasInstituciones"})
public class BuscarTodasInstituciones extends HttpServlet {

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

        try {
            InstitucionDAO crud = new InstitucionDAO();
            List<Institucion> instituciones = crud.readAll();
            if (instituciones != null) {
                request.setAttribute("instituciones", instituciones);
                request.getRequestDispatcher("/Admin-sistema/institucion-editar.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("error", "A ocurrido un error en la base de datos");
            request.getRequestDispatcher("/Admin-sistema/institucion-editar.jsp").forward(request, response);
        }
    }
}

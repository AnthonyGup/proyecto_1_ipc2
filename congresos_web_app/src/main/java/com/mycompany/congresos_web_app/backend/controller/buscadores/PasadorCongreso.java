/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.buscadores;

import com.mycompany.congresos_web_app.backend.crud.CongresoDAO;
import com.mycompany.congresos_web_app.backend.entities.Congreso;
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
@WebServlet(name = "PasadorCongreso", urlPatterns = {"/PasadorCongreso"})
public class PasadorCongreso extends HttpServlet {

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
            CongresoDAO crud = new CongresoDAO();
            Congreso congreso = crud.readByPk(request.getParameter("nombre"));
            if (congreso != null) {
                request.setAttribute("congreso", congreso);
                request.getRequestDispatcher("/Admin-congresos/editor-congresos.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "No se encontró el congreso.");
                request.getRequestDispatcher("/Admin-congresos/cargador-congresos.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("error", "Error enla base de datos");
            request.getRequestDispatcher("/Admin-congresos/cargador-congresos.jsp").forward(request, response);
        }
    }
}

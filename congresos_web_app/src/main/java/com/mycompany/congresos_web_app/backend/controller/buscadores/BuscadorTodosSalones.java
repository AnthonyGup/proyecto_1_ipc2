/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.buscadores;

import com.mycompany.congresos_web_app.backend.crud.SalonDAO;
import com.mycompany.congresos_web_app.backend.entities.Salon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antho
 */
@WebServlet(name = "BuscadorTodosSalones", urlPatterns = {"/BuscadorTodosSalones"})
public class BuscadorTodosSalones extends HttpServlet {

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
            SalonDAO dao = new SalonDAO();
            List<Salon> salones = dao.readAll();
            if (salones != null) {
                request.setAttribute("salones", salones);
                request.getRequestDispatcher("/Admin-congresos/cargador-salones.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Salon no encontrado");
                request.getRequestDispatcher("/Admin-congresos/cargador-salones.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("error", "Error en la base de datos");
            request.getRequestDispatcher("/Admin-congresos/cargador-salones.jsp").forward(request, response);
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.admin.congresos;

import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import com.mycompany.congresos_web_app.backend.validaciones.ValidacionAsistencia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antho
 */
@WebServlet(name = "RegistradorAsistenciasServlet", urlPatterns = {"/RegistradorAsistenciasServlet"})
public class RegistradorAsistenciasServlet extends HttpServlet {

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
            crearAsistencia(request);
            request.setAttribute("mensaje", "Asistencia registrada");
        } catch (ValidacionException ex) {
            request.setAttribute("error", ex.getMessage());
        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
        }
        request.getRequestDispatcher("/Admin-congresos/registrador-asistencias.jsp").forward(request, response);
    }
    
    private void crearAsistencia(HttpServletRequest request) throws ValidacionException, SQLException {
        //obtenemos
        String id_activiad = request.getParameter("id_actividad");
        String id_participante = request.getParameter("id_participante");
        
        //Validamos
        ValidacionAsistencia val = new ValidacionAsistencia();
        val.validarParticipante(id_participante);
        val.validarActiviad(id_activiad);
        val.validarFechaHora(LocalDateTime.now());
        val.crearRegistro();
        
    }
}

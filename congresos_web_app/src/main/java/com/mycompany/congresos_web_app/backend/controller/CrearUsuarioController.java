/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller;

import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import com.mycompany.congresos_web_app.backend.validaciones.ValidadorParticipante;
import com.mycompany.congresos_web_app.backend.validaciones.ValidadorUsuario;
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
@WebServlet(name = "CrearUsuarioController", urlPatterns = {"/CrearUsuarioController"})
public class CrearUsuarioController extends HttpServlet {

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
            crearUsuario(request);
            if (request.getParameter("tipo").equals("PARTICIPANTE")) {
                crearParticipante(request);
                request.getSession().setAttribute("mensaje", "Participante creado exitosamente");
                response.sendRedirect(request.getContextPath() + "/Loggin/loggin.jsp");
                return;
            }

            request.getSession().setAttribute("mensaje", "Usuario creado exitosamente");
            response.sendRedirect(request.getContextPath() + "/Loggin/loggin.jsp");
        } catch (ValidacionException e) {
            request.setAttribute("error", "Error de validación: " + e.getMessage());
            request.getRequestDispatcher("/Loggin/registro.jsp").forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("/Loggin/registro.jsp").forward(request, response);
        }
    }

    private void crearParticipante(HttpServletRequest request) throws ValidacionException, SQLException {
        String id_personal = request.getParameter("id_personal");
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String organizacion = request.getParameter("organizacion");
        String correo = request.getParameter("email");
        
        ValidadorParticipante validador = new ValidadorParticipante(
                id_personal, 
                nombre, 
                telefono, 
                organizacion, 
                correo
        );
        validador.crearRegistro();
    }

    private void crearUsuario(HttpServletRequest request) throws ValidacionException, SQLException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String monto = request.getParameter("cartera");
        String cartera = monto.replace(",", ".");
        String tipo = request.getParameter("tipo");

        ValidadorUsuario validador = new ValidadorUsuario(
                email,
                true,
                password,
                cartera,
                tipo
        );
        validador.crearRegistro();
    }
}

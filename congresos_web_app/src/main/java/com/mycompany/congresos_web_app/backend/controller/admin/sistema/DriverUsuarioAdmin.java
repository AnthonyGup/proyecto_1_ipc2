/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.admin.sistema;

import com.mycompany.congresos_web_app.backend.crud.UsuarioDAO;
import com.mycompany.congresos_web_app.backend.entities.Usuario;
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
@WebServlet(name = "DriverUsuarioAdmin", urlPatterns = {"/DriverUsuarioAdmin"})
public class DriverUsuarioAdmin extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");

        UsuarioDAO dao = new UsuarioDAO();
        try {
            Usuario user = dao.readByPk(correo);
            if (user != null) {
                request.setAttribute("usuario", user);
                request.setAttribute("tipoLegible", user.getROL().name());
                request.getRequestDispatcher("/Admin-sistema/usuario.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            request.getSession().setAttribute("error", "Usuario no encontrado");
            request.getRequestDispatcher("/Admin-sistema/usuario.jsp").forward(request, response);
        }
    }
}

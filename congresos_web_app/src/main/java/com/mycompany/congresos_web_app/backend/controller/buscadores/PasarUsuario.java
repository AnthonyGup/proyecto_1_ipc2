/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.buscadores;

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
@WebServlet(name = "PasarUsuario", urlPatterns = {"/PasarUsuario"})
public class PasarUsuario extends HttpServlet {

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
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.readByPk(request.getParameter("correo"));
            if (usuario != null) {
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("/Admin-congresos/editor-usuarios.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("error", "Error en la base de datos");
            request.getRequestDispatcher("/Admin-congresos/editor-usuarios.jsp").forward(request, response);
        }
    }

}

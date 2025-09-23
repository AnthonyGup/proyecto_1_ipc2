/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.admin.sistema;

import com.mycompany.congresos_web_app.backend.crud.UsuarioDAO;
import com.mycompany.congresos_web_app.backend.validaciones.ValidadorUsuario;
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
@WebServlet(name = "EditorUsuariosServlet", urlPatterns = {"/EditorUsuariosServlet"})
public class ActualizadorUsuariosServlet extends HttpServlet {

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
            actualizarUsuario(request);
            request.setAttribute("mensaje", "Actualizacion exitosa");
        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
        }
        request.getRequestDispatcher("/Admin-sistema/usuario.jsp").forward(request, response);
    }
    
    private void actualizarUsuario(HttpServletRequest request) throws SQLException {
        UsuarioDAO dao = new UsuarioDAO();
        
        //obtenemos cosas a editar
        String correo = request.getParameter("usuario");
        String estadoParam = request.getParameter("activo");
        String tipo = request.getParameter("tipo");
        boolean estado = estadoParam != null;
        
        //actualizamos
        
        dao.update(correo, "estado", estado, "boolean");
        dao.update(correo, "rol", tipo, "string");
    }

}

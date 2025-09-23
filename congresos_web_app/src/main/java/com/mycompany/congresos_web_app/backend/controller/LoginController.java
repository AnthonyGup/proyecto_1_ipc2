/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller;

import com.mycompany.congresos_web_app.backend.crud.ParticipanteDAO;
import com.mycompany.congresos_web_app.backend.crud.UsuarioDAO;
import com.mycompany.congresos_web_app.backend.encriptado.EncriptadorPassword;
import com.mycompany.congresos_web_app.backend.entities.Participante;
import com.mycompany.congresos_web_app.backend.entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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
        String correo = request.getParameter("email");
        String password = request.getParameter("password");
        EncriptadorPassword encriptador = new EncriptadorPassword();

        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.readByPk(correo);
            if (usuario != null && password.equals(encriptador.decodificar(usuario.getPASSWORD()))) {
                ParticipanteDAO crud = new ParticipanteDAO();
                Participante participante = crud.readByColumn(usuario.getCORREO(), "id_usuario");
                
                HttpSession session = request.getSession(true);
                
                if (participante != null) {
                    session.setAttribute("participante", participante);
                }
                
                
                session.setAttribute("user", usuario);
                request.getRequestDispatcher("/").forward(request, response);
            } else {
                request.getSession().setAttribute("error", "Contraseña incorrecta, intentalo de nuevo");
                request.getRequestDispatcher("/Loggin/loggin.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            request.getSession().setAttribute("error", "No se encontro un usuario con" + correo);
            request.getRequestDispatcher("/Loggin/loggin.jsp").forward(request, response);
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.admin.sistema;

import com.mycompany.congresos_web_app.backend.crud.CongresoDAO;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import com.mycompany.congresos_web_app.backend.validaciones.ValidadorCongreso;
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
@WebServlet(name = "ActualizadorComisionServlet", urlPatterns = {"/ActualizadorComisionServlet"})
public class ActualizadorComisionServlet extends HttpServlet {

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
            actualizarCongreso(request);
            request.setAttribute("mensaje", "Actualizacion exitosa!");
            request.getRequestDispatcher("/Admin-sistema/comision.jsp").forward(request, response);
        } catch (ValidacionException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("/Admin-sistema/comision.jsp").forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "Error en la base de datos");
            ex.printStackTrace();
            request.getRequestDispatcher("/Admin-sistema/comision.jsp").forward(request, response);
        }
    }
    
    private void actualizarCongreso(HttpServletRequest request) throws ValidacionException, SQLException {
        double valor = Double.parseDouble(request.getParameter("comision"));
        String codigo = request.getParameter("evento");
        
        ValidadorCongreso val = new ValidadorCongreso();
        CongresoDAO dao = new CongresoDAO();
        val.validarComision(valor);
        dao.update(codigo, "comision", valor, "double");
    }

}

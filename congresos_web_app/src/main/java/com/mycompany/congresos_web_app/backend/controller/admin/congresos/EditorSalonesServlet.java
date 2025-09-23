/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.admin.congresos;

import com.mycompany.congresos_web_app.backend.crud.SalonDAO;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import com.mycompany.congresos_web_app.backend.validaciones.ValidadorSalon;
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
@WebServlet(name = "EditorSalonesServlet", urlPatterns = {"/EditorSalonesServlet"})
public class EditorSalonesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
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
            actualizarSalon(request);
            request.setAttribute("mensaje", "Cambios guardados exitosamente");
        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
        } catch (ValidacionException ex) {
            request.setAttribute("error", ex.getMessage());
        }
        request.getRequestDispatcher("/Admin-congresos/editor-salones.jsp").forward(request, response);
    }
    
    private void actualizarSalon(HttpServletRequest request) throws SQLException, ValidacionException {
        //obtener valores
        String id_salon = request.getParameter("id_salon");
        String salon = request.getParameter("salon");
        String ubicacion = request.getParameter("ubicacion");
        String capacidadParam = request.getParameter("capacidad");
        int capacidad = Integer.parseInt(capacidadParam);
        String id_congreso = request.getParameter("id_congreso");
        
        //validar
        ValidadorSalon val = new ValidadorSalon();
        val.validarNombre(salon);
        val.validarUbicacion(ubicacion);
        val.validarCapacidad(capacidad);
        val.validarCongreso(id_congreso);
        
        //actuualizar
        SalonDAO dao = new SalonDAO();
        dao.update(id_salon, "salon", salon, "string");
        dao.update(id_salon, "ubicacion", ubicacion, "string");
        dao.update(id_salon, "capacidad", capacidad, "int");
        dao.update(id_salon, "id_congreso", id_congreso, "string");
    }
}

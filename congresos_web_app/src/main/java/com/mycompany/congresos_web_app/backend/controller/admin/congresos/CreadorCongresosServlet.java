/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.admin.congresos;

import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import com.mycompany.congresos_web_app.backend.validaciones.ValidadorCongreso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antho
 */
@WebServlet(name = "CreadorCongresosServlet", urlPatterns = {"/CreadorCongresosServlet"})
public class CreadorCongresosServlet extends HttpServlet {
    
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
            request.setAttribute("mensaje", "Congreso creado exitosamente");
        } catch (ValidacionException ex) {
            request.setAttribute("mensaje", ex.getMessage());
        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
        }
    }
    
    private void crearUsuario(HttpServletRequest request) throws ValidacionException, SQLException {
        //Obtener valores
        String id_congreso = request.getParameter("idCongreso");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String ubicacion = request.getParameter("ubicacion");
        String fechaParam = request.getParameter("fechaInicio");
        LocalDate fecha_inicio = LocalDate.parse(fechaParam);
        String precioParam = request.getParameter("precio");
        double precio = Double.parseDouble(precioParam);
        String id_institucion = request.getParameter("idInstitucion");
        String id_admin = request.getParameter("idAdmin");
        
        //Validar todo
        ValidadorCongreso val = new ValidadorCongreso();
        val.validarID(id_congreso);
        val.validarTitulo(titulo);
        val.validarUbicacion(ubicacion);
        val.validarDescripcion(descripcion);
        val.validarFecha(fecha_inicio);
        val.validarPrecio(precio);
        val.validarInstitucion(id_institucion);
        val.validarAdministrador(id_admin);
        val.crearRegistro();
    }
}

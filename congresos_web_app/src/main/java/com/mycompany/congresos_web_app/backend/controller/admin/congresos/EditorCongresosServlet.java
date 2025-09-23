/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.admin.congresos;

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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antho
 */
@WebServlet(name = "EditorCongresosServlet", urlPatterns = {"/EditorCongresosServlet"})
public class EditorCongresosServlet extends HttpServlet {
  
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
            request.setAttribute("mensaje", "Cambios guardados");
        } catch (ValidacionException ex) {
            request.setAttribute("error", ex.getMessage());
        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
        }
        request.getRequestDispatcher("/Admin-congresos/editor-congresos.jsp").forward(request, response);
    }
    
    private void actualizarCongreso(HttpServletRequest request) throws ValidacionException, SQLException {
        String id = request.getParameter("id_congreso");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String ubicacion = request.getParameter("ubicacion");
        String fechaParam = request.getParameter("fecha_inicio");
        LocalDate fecha_inicio = LocalDate.parse(fechaParam);
        String precioParam = request.getParameter("precio");
        double precio = Double.parseDouble(precioParam);
        String id_institucion = request.getParameter("idInstitucion");
        String id_admin = request.getParameter("id_admin");
        String convocatoriaParam = request.getParameter("convocatoria");
        boolean convocatoria = convocatoriaParam != null;
        
        //Validar
        ValidadorCongreso val = new ValidadorCongreso();
        val.validarTitulo(titulo);
        val.validarUbicacion(ubicacion);
        val.validarDescripcion(descripcion);
        val.validarFecha(fecha_inicio);
        val.validarPrecio(precio);
        val.validarInstitucion(id_institucion);
        val.validarAdministrador(id_admin);
        
        //Actualizar
        CongresoDAO dao = new CongresoDAO();
        dao.update(id, "titulo", titulo, "string");
        dao.update(id, "ubicacion", ubicacion, "string");
        dao.update(id, "descripcion", descripcion, "string");
        dao.update(id, "precio", precio, "double");
        dao.update(id, "fecha_inicio", fecha_inicio, "date");
        dao.update(id, "id_institucion", id_institucion, "string");
        dao.update(id, "id_admin", id_admin, "string");
        dao.update(id, "convocatoria", convocatoria, "boolean");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.controller.admin.congresos;

import com.mycompany.congresos_web_app.backend.crud.InstitucionDAO;
import com.mycompany.congresos_web_app.backend.exceptions.ValidacionException;
import com.mycompany.congresos_web_app.backend.validaciones.ValidadorActividad;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antho
 */
@WebServlet(name = "EditorActividadesServlet", urlPatterns = {"/EditorActividadesServlet"})
public class EditorActividadesServlet extends HttpServlet {

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
            actualizarActiviad(request);
            request.setAttribute("mensaje", "Cambios guardados exitosamente");
        } catch (ValidacionException ex) {
            request.setAttribute("error", ex.getMessage());
        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
        }
        request.getRequestDispatcher("/Admin-congresos/editor-actividades.jsp").forward(request, response);
    }
    
    private void actualizarActiviad(HttpServletRequest request) throws ValidacionException, SQLException {
        //Traemos todo
        String id_activiad = request.getParameter("id_actividad");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String tipo = request.getParameter("tipo");
        String horaInicio = request.getParameter("hora_inicio");
        String horaFin = request.getParameter("hora_fin");
        LocalTime hora_inicio = LocalTime.parse(horaInicio);
        LocalTime hora_fin = LocalTime.parse(horaFin);
        String id_encargado = request.getParameter("id_encargado");
        String id_congreso = request.getParameter("id_congreso");
        String salon = request.getParameter("id_salon");
        int id_salon = Integer.parseInt(salon);
        
        //Validar
        ValidadorActividad val = new ValidadorActividad();
        val.validarCoodigo(id_activiad);
        val.validarNombre(nombre);
        val.validarDescripcion(descripcion);
        val.validarTipo(tipo);
        if (tipo.equals("TALLER")) {
            String cupoParam = request.getParameter("cupo_maximo");
            int cupo_maximo = Integer.parseInt(cupoParam);
            val.validarCupoMaximo(cupo_maximo);
        }
        val.validarHoraInicioo(hora_inicio);
        val.validarHoraFin(hora_fin);
        val.validarEncargado(id_encargado);
        val.validarCongreso(id_congreso);
        val.validarSalon(id_salon);
        
        //Actualizar
        InstitucionDAO dao = new InstitucionDAO();
        dao.update(id_activiad, "nombre", nombre, "string");
        dao.update(id_activiad, "descripcion", descripcion, "string");
        dao.update(id_activiad, "tipo", tipo, "string");
        dao.update(id_activiad, "hora_inicio", hora_inicio, "time");
        dao.update(id_activiad, "hora_fin", hora_fin, "time");
        dao.update(id_activiad, "id_encargado", id_encargado, "string");
        dao.update(id_activiad, "id_congreso", id_congreso, "string");
        dao.update(id_activiad, "id_salon", id_salon, "int");
    }
}

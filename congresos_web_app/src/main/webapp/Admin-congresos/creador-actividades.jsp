<%-- 
    Document   : creador-actividades
    Created on : 22 sept 2025, 23:28:34
    Author     : antho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/Includes/resources.jsp"/>
<jsp:include page="/Mensajes/mensajes.jsp"/>

<body class="bg-dark text-light">
    <jsp:include page="/Includes/header-admin-congresos.jsp"/>

    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-12 col-md-8 col-lg-6">
                <div class="mb-4 p-4 rounded bg-dark border border-secondary shadow-sm">

                    <h4 class="mb-3">Crear nueva actividad</h4>

                    <form action="CreadorActividadesServlet" method="post">

                        <div class="mb-3">
                            <label for="id_actividad" class="form-label">ID actividad</label>
                            <input type="text" id="id_activiadad" name="id_actividad"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;" placeholder="ACT-00000001" maxlength="12"
                                   required>
                        </div>
                        
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" id="nombre" name="nombre"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label for="descripcion" class="form-label">Descripción</label>
                            <textarea id="descripcion" name="descripcion" rows="3"
                                      class="form-control border-secondary"
                                      style="background-color: #121212; color: #f8f9fa;"
                                      required></textarea>
                        </div>

                        <div class="mb-3">
                            <label for="tipo" class="form-label">Tipo de actividad</label>
                            <select id="tipo" name="tipo"
                                    class="form-select border-secondary"
                                    style="background-color: #121212; color: #f8f9fa;"
                                    onchange="mostrarCupo()"
                                    required>
                                <option value="" disabled selected>Selecciona un tipo</option>
                                <option value="PONENCIA">Ponencia</option>
                                <option value="TALLER">Taller</option>
                            </select>
                        </div>

                        <div class="mb-3" id="cupoContainer" style="display: none;">
                            <label for="cupo_maximo" class="form-label">Cupo máximo</label>
                            <input type="number" id="cupo_maximo" name="cupo_maximo" min="1"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;">
                        </div>

                        <div class="mb-3">
                            <label for="hora_inicio" class="form-label">Hora de inicio</label>
                            <input type="time" id="hora_inicio" name="hora_inicio"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label for="hora_fin" class="form-label">Hora de fin</label>
                            <input type="time" id="hora_fin" name="hora_fin"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label for="id_encargado" class="form-label">ID Encargado</label>
                            <input type="text" id="id_encargado" name="id_encargado"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label for="id_congreso" class="form-label">ID Congreso</label>
                            <input type="text" id="id_congreso" name="id_congreso"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label for="id_salon" class="form-label">ID Salón</label>
                            <input type="number" id="id_salon" name="id_salon" min="1"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   required>
                        </div>

                        <input type="hidden" name="estado" value="APROBADO" />

                        <button type="submit" class="btn btn-outline-light px-4">
                            Crear actividad
                        </button>
                    </form>

                </div>
            </div>
        </div>
        <jsp:include page="/Includes/footer.jsp"/>
    </div>

    <script>
        function mostrarCupo() {
            const tipo = document.getElementById("tipo").value;
            const cupoContainer = document.getElementById("cupoContainer");
            cupoContainer.style.display = (tipo === "TALLER") ? "block" : "none";
        }
    </script>
</body>

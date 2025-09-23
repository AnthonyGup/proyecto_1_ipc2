<%-- 
    Document   : creador-congresos
    Created on : 22 sept 2025, 11:11:31
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

                    <h4 class="mb-3">Crear nuevo congreso</h4>

                    <form action="CreadorCongresosServlet" method="post">

                        <!-- ID Congreso -->
                        <div class="mb-3">
                            <label for="idCongreso" class="form-label">ID Congreso</label>
                            <input type="text" id="idCongreso" name="idCongreso"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   placeholder="CON-00000001" maxlength="12" required>
                        </div>

                        <!-- Título -->
                        <div class="mb-3">
                            <label for="titulo" class="form-label">Título</label>
                            <input type="text" id="titulo" name="titulo"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   placeholder="Título del congreso" maxlength="150" required>
                        </div>

                        <!-- Descripción -->
                        <div class="mb-3">
                            <label for="descripcion" class="form-label">Descripción</label>
                            <textarea id="descripcion" name="descripcion" rows="3"
                                      class="form-control border-secondary"
                                      style="background-color: #121212; color: #f8f9fa;"
                                      placeholder="Breve descripción del congreso"></textarea>
                        </div>

                        <!-- Ubicación -->
                        <div class="mb-3">
                            <label for="ubicacion" class="form-label">Ubicación</label>
                            <input type="text" id="ubicacion" name="ubicacion"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   placeholder="Ciudad, país" required>
                        </div>

                        <!-- Fecha de inicio -->
                        <div class="mb-3">
                            <label for="fechaInicio" class="form-label">Fecha de inicio</label>
                            <input type="date" id="fechaInicio" name="fechaInicio"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;" required>
                        </div>

                        <!-- Precio -->
                        <div class="mb-3">
                            <label for="precio" class="form-label">Precio</label>
                            <input type="number" id="precio" name="precio" step="0.01" min="0"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   placeholder="Precio en quetzales" required>
                        </div>

                        <!-- ID Institución -->
                        <div class="mb-3">
                            <label for="idInstitucion" class="form-label">ID Institución</label>
                            <input type="text" id="idInstitucion" name="idInstitucion"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   placeholder="ID de la institución" required>
                        </div>

                        <!-- ID Administrador -->
                        <div class="mb-3">
                            <label for="idAdmin" class="form-label">ID Administrador</label>
                            <input type="text" id="idAdmin" name="idAdmin"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   placeholder="ID del administrador del congreso" required>
                        </div>

                        <!-- Botón -->
                        <button type="submit" class="btn btn-outline-light px-4">
                            Crear Congreso
                        </button>
                    </form>

                </div>
            </div>
        </div>
        <jsp:include page="/Includes/footer.jsp"/>
    </div>
</body>
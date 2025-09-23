<%-- 
    Document   : creador-salones
    Created on : 23 sept 2025, 1:37:22
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

                    <h4 class="mb-3">Crear nuevo salón</h4>

                    <form action="CrearSalonServlet" method="post">

                        <!-- Nombre del salón -->
                        <div class="mb-3">
                            <label for="salon" class="form-label">Nombre del salón</label>
                            <input type="text" id="salon" name="salon"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   required>
                        </div>

                        <!-- Ubicación -->
                        <div class="mb-3">
                            <label for="ubicacion" class="form-label">Ubicación</label>
                            <input type="text" id="ubicacion" name="ubicacion"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   required>
                        </div>

                        <!-- Capacidad -->
                        <div class="mb-3">
                            <label for="capacidad" class="form-label">Capacidad</label>
                            <input type="number" id="capacidad" name="capacidad" min="1"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   required>
                        </div>

                        <!-- ID Congreso -->
                        <div class="mb-3">
                            <label for="id_congreso" class="form-label">ID Congreso</label>
                            <input type="text" id="id_congreso" name="id_congreso"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   pattern="CON-\d{8}" title="Formato requerido: CON-00000001"
                                   required>
                        </div>

                        <!-- Botón -->
                        <button type="submit" class="btn btn-outline-light px-4">
                            Crear salón
                        </button>
                    </form>

                </div>
            </div>
        </div>
    </div>
</body>

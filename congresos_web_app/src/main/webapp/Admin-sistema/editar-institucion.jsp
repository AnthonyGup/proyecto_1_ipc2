<%-- 
    Document   : editar-institucion
    Created on : 22 sept 2025, 22:22:42
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/Includes/resources.jsp"/>
<jsp:include page="/Mensajes/mensajes.jsp"/>

<body class="bg-dark text-light">

    <jsp:include page="/Includes/header-admin-sistema.jsp"/>
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-12 col-md-8 col-lg-6">
                <div class="mb-4 p-4 rounded bg-dark border border-secondary shadow-sm">

                    <h4 class="mb-3">Editar institución</h4>

                    <form action="ActualizarInstitucionServlet?institucion=${institucion.nombre}" method="post">

                        <!-- Nombre (visible como texto plano, no editable) -->
                        <div class="mb-3">
                            <label class="form-label">Nombre</label>
                            <p class="fw-bold mb-0">${institucion.nombre}</p>
                        </div>

                        <!-- Campo oculto para enviar el nombre al servlet -->
                        <input type="hidden" name="nombre" value="${institucion.nombre}" />


                        <div class="mb-3">
                            <label for="ubicacion" class="form-label">Ubicación</label>
                            <input type="text" id="ubicacion" name="ubicacion"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   value="${institucion.ubicacion}" required>
                        </div>

                        <div class="mb-3">
                            <label for="descripcion" class="form-label">Descripción</label>
                            <textarea id="descripcion" name="descripcion" rows="3"
                                      class="form-control border-secondary"
                                      style="background-color: #121212; color: #f8f9fa;"
                                      required>${institucion.descripcion}</textarea>
                        </div>

                        <div class="form-check form-switch mb-3">
                            <input class="form-check-input" type="checkbox" id="estado" name="estado"
                                   ${institucion.estado ? 'checked' : ''}>
                            <label class="form-check-label" for="estado">
                                Institución activa
                            </label>
                        </div>

                        <button type="submit" class="btn btn-outline-light px-4">
                            Guardar cambios
                        </button>
                    </form>

                </div>
            </div>
        </div>
        <jsp:include page="/Includes/footer.jsp"/>
    </div>
</body>
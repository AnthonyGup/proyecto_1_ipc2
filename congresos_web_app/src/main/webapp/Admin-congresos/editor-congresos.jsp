<%-- 
    Document   : editor-congresos
    Created on : 22 sept 2025, 23:13:13
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

                    <h4 class="mb-3">Editar congreso</h4>

                    <form action="ActualizarCongresoServlet" method="post">

                        <div class="mb-3">
                            <label class="form-label">ID Congreso</label>
                            <p class="fw-bold mb-0">${congreso.id_congreso}</p>
                            <input type="hidden" name="id_congreso" value="${congreso.id_congreso}" />
                        </div>

                        <div class="mb-3">
                            <label for="titulo" class="form-label">Título</label>
                            <input type="text" id="titulo" name="titulo"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   value="${congreso.titulo}" required>
                        </div>

                        <div class="mb-3">
                            <label for="ubicacion" class="form-label">Ubicación</label>
                            <input type="text" id="ubicacion" name="ubicacion"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   value="${congreso.ubicacion}" required>
                        </div>

                        <div class="mb-3">
                            <label for="descripcion" class="form-label">Descripción</label>
                            <textarea id="descripcion" name="descripcion" rows="3"
                                      class="form-control border-secondary"
                                      style="background-color: #121212; color: #f8f9fa;"
                                      required>${congreso.descripcion}</textarea>
                        </div>

                        <div class="mb-3">
                            <label for="precio" class="form-label">Precio (Q)</label>
                            <input type="number" step="0.01" id="precio" name="precio"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   value="${congreso.precio}" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Comisión</label>
                            <p class="mb-0">Q${congreso.comision}</p>
                        </div>

                        <div class="mb-3">
                            <label for="fecha_inicio" class="form-label">Fecha de inicio</label>
                            <input type="date" id="fecha_inicio" name="fecha_inicio"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   value="${congreso.fecha_inicio}" required>
                        </div>

                        <div class="mb-3">
                            <label for="id_institucion" class="form-label">Institución</label>
                            <input type="text" id="id_institucion" name="id_institucion"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   value="${congreso.id_institucion}" required>
                        </div>

                        <div class="mb-3">
                            <label for="id_admin" class="form-label">Administrador</label>
                            <input type="text" id="id_admin" name="id_admin"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   value="${congreso.id_admin}" required>
                        </div>

                        <div class="form-check form-switch mb-3">
                            <input class="form-check-input" type="checkbox" id="convocatoria" name="convocatoria"
                                   ${congreso.convocatoria ? 'checked' : ''}>
                            <label class="form-check-label" for="convocatoria">
                                Convocatoria abierta
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

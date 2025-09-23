<%-- 
    Document   : usuario
    Created on : 22 sept 2025, 1:51:32
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

                    <h4 class="mb-3">Buscar usuario</h4>

                    <!-- Formulario de búsqueda -->
                    <form action="${pageContext.request.contextPath}/DriverUsuarioAdmin" method="get">
                        <div class="mb-3">
                            <label for="correo" class="form-label">Correo electrónico</label>
                            <input type="email" id="correo" name="correo"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   placeholder="usuario@ejemplo.com" maxlength="150" required>
                        </div>

                        <button type="submit" class="btn btn-outline-light px-4">
                            Buscar
                        </button>
                    </form>

                    <!-- Card con resultado -->
                    <c:if test="${not empty usuario}">
                        <div class="card bg-dark text-light border-secondary shadow-sm mt-4" style="background-color: rgba(255,255,255,0.05);">
                            <div class="card-body">
                                <h5 class="card-title fw-bold">${usuario.CORREO}</h5>
                                <p class="card-text">
                                    <strong>Tipo de usuario:</strong> ${tipoLegible}<br>
                                    <strong>Estado actual:</strong>
                                    <c:choose>
                                        <c:when test="${usuario.estado}">Activo</c:when>
                                        <c:otherwise> Desactivado</c:otherwise>
                                    </c:choose>
                                </p>

                                <!-- Formulario para editar estado y tipo -->
                                <form action="ActualizarUsuarioServlet" method="post">
                                    <input type="hidden" name="id" value="${usuario.CORREO}" />

                                    <!-- Estado -->
                                    <div class="form-check form-switch mb-3">
                                        <input class="form-check-input" type="checkbox" name="activo"
                                               ${usuario.estado ? 'checked' : ''}>
                                        <label class="form-check-label text-light">Activo</label>
                                    </div>

                                    <!-- Tipo de usuario -->
                                    <div class="mb-3">
                                        <label for="tipo" class="form-label">Tipo de usuario</label>
                                        <select id="tipo" name="tipo"
                                                class="form-select bg-dark text-light border-secondary">
                                            <option value="COMITE" ${tipoLegible == 'COMITE' ? 'selected' : ''}>COMITE</option>
                                            <option value="ADMIN_CONGRESO" ${tipoLegible == 'ADMIN_CONGRESO' ? 'selected' : ''}>ADMIN_CONGRESO</option>
                                        </select>
                                    </div>

                                    <button type="submit" class="btn btn-outline-light">
                                        Guardar cambios
                                    </button>
                                </form>
                            </div>
                        </div>
                    </c:if>

                </div>
            </div>
        </div>
        <jsp:include page="/Includes/footer.jsp"/>
    </div>
</body>

<%-- 
    Document   : editor-usuarios
    Created on : 23 sept 2025, 2:25:03
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
            <div class="col-12 col-md-6 col-lg-5">
                <div class="mb-4 p-4 rounded bg-dark border border-secondary shadow-sm">

                    <h4 class="mb-3">Editar tipo de usuario</h4>

                    <form action="ActualizarUsuarioServlet" method="post">

                        <!-- Correo -->
                        <div class="mb-3">
                            <label class="form-label">Correo electrónico</label>
                            <p class="fw-bold mb-0">${usuario.CORREO}</p>
                            <input type="hidden" name="correo" value="${usuario.CORREO}" />
                        </div>

                        <c:if test="${usuario.ROL != 'ADMIN_SISTEMA'}">
                            <div class="mb-3">
                                <label for="rol" class="form-label">Nuevo tipo de usuario</label>
                                <select id="rol" name="rol"
                                        class="form-select border-secondary"
                                        style="background-color: #121212; color: #f8f9fa;" required>
                                    <c:if test="${usuario.ROL != 'PARTICIPANTE'}">
                                        <option value="PARTICIPANTE">Participante</option>
                                    </c:if>
                                    <c:if test="${usuario.ROL != 'ADMIN_CONGRESO'}">
                                        <option value="ADMIN_CONGRESO">Administrador de congreso</option>
                                    </c:if>
                                    <c:if test="${usuario.ROL != 'COMITE'}">
                                        <option value="COMITE">Comité cientifico</option>
                                    </c:if>
                                </select>
                            </div>
                        </c:if>

                        <c:if test="${usuario.ROL == 'ADMIN_SISTEMA'}">
                            <div class="alert alert-warning text-center">
                                Los usuarios con rol <strong>ADMIN_SISTEMA</strong> no pueden ser modificados.
                            </div>
                        </c:if>

                        <button type="submit" class="btn btn-outline-light px-4"
                                <c:if test="${usuario.ROL == 'ADMIN_SISTEMA'}">disabled</c:if>>
                            Guardar cambios
                        </button>
                    </form>

                </div>
            </div>
        </div>
    </div>
</body>
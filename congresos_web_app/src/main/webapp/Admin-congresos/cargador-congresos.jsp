<%-- 
    Document   : cargador-congresos
    Created on : 22 sept 2025, 16:24:21
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/Includes/resources.jsp"/>
<jsp:include page="/Mensajes/mensajes.jsp"/>

<body class="bg-dark text-light">

    <jsp:include page="/Includes/header-admin-congresos.jsp"/>
    <div class="container py-5">
        <h4 class="mb-4">Listado de congresos</h4>

        <c:if test="${empty congresos}">
            <div class="alert alert-warning text-center">
                No se encontraron congresos registrados.
            </div>
        </c:if>

        <c:forEach var="congreso" items="${congresos}">
            <div class="card bg-dark text-light border-secondary shadow-sm mb-4" style="background-color: rgba(255,255,255,0.05);">
                <div class="card-body">
                    <h5 class="card-title fw-bold">${congreso.titulo}</h5>
                    <p class="card-text">
                        <strong>ID Congreso:</strong> ${congreso.id_congreso}<br>
                        <strong>Ubicación:</strong> ${congreso.ubicacion}<br>
                        <strong>Descripción:</strong> ${congreso.descripcion}<br>
                        <strong>Fecha de inicio:</strong> ${congreso.fecha_inicio}<br>
                        <strong>Precio:</strong> Q${congreso.precio}<br>
                        <strong>Comisión:</strong> Q${congreso.comision}<br>
                        <strong>ID Institución:</strong> ${congreso.id_institucion}<br>
                        <strong>ID Administrador:</strong> ${congreso.id_admin}<br>
                        <strong>Estado:</strong>
                        <c:choose>
                            <c:when test="${congreso.estado}">Activo</c:when>
                            <c:otherwise>Inactivo</c:otherwise>
                        </c:choose><br>
                        <strong>Convocatoria:</strong>
                        <c:choose>
                            <c:when test="${congreso.convocatoria}">Abierta</c:when>
                            <c:otherwise>Cerrada</c:otherwise>
                        </c:choose>
                    </p>
                    <a href="${pageContext.request.contextPath}/PasadorCongreso?nombre=${congreso.id_congreso}"
                       class="btn btn-outline-light btn-sm">
                        Editar
                    </a>
                </div>
            </div>
        </c:forEach>
        <jsp:include page="/Includes/footer.jsp"/>
    </div>
</body>
<%-- 
    Document   : cargador-actividades
    Created on : 23 sept 2025, 0:07:17
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/Includes/resources.jsp"/>
<jsp:include page="/Mensajes/mensajes.jsp"/>

<body class="bg-dark text-light">
    <jsp:include page="/Includes/header-admin-congresos.jsp"/>

    <div class="container py-5">
        <h4 class="mb-4">Listado de actividades</h4>

        <c:forEach var="actividad" items="${actividades}">
            <div class="card bg-dark text-light border-secondary shadow-sm mb-4" style="background-color: rgba(255,255,255,0.05);">
                <div class="card-body">
                    <h5 class="card-title fw-bold">${actividad.nombre}</h5>
                    <p class="card-text">
                        <strong>ID Actividad:</strong> ${actividad.id_actividad}<br>
                        <strong>Descripción:</strong> ${actividad.descripcion}<br>
                        <strong>Tipo:</strong> ${actividad.tipo}<br>
                        <strong>Hora inicio:</strong> ${actividad.hora_inicio}<br>
                        <strong>Hora fin:</strong> ${actividad.hora_fin}<br>
                        <strong>ID Encargado:</strong> ${actividad.id_encargado}<br>
                        <strong>ID Congreso:</strong> ${actividad.id_congreso}<br>
                        <strong>ID Salón:</strong> ${actividad.id_salon}<br>
                        <strong>Estado:</strong>
                        <c:choose>
                            <c:when test="${actividad.estado == 'APROVADO'}">Aprovado</c:when>
                            <c:when test="${actividad.estado == 'RECHAZADO'}">Rechazado</c:when>
                            <c:otherwise>Pendiente</c:otherwise>
                        </c:choose>
                        <br>
                        <c:if test="${actividad.tipo == 'TALLER'}">
                            <strong>Cupo máximo:</strong> ${actividad.cupo_maximo}<br>
                        </c:if>
                    </p>

                    <a href="${pageContext.request.contextPath}/PasadorActividad?actividad=${actividad.id_actividad}"
                       class="btn btn-outline-light btn-sm">
                        Editar
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</body>

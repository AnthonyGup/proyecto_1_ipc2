<%-- 
    Document   : institucion-editar
    Created on : 22 sept 2025, 1:12:08
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/Includes/resources.jsp"/>
<jsp:include page="/Mensajes/mensajes.jsp"/>

<body class="bg-dark text-light">

    <jsp:include page="/Includes/header-admin-sistema.jsp"/>
    <div class="container py-5">
        <h4 class="mb-4">Listado de instituciones</h4>

        <c:if test="${empty instituciones}">
            <div class="alert alert-warning text-center">
                No se encontraron instituciones registradas.
            </div>
        </c:if>

        <c:forEach var="institucion" items="${instituciones}">
            <div class="card bg-dark text-light border-secondary shadow-sm mb-4" style="background-color: rgba(255,255,255,0.05);">
                <div class="card-body">
                    <h5 class="card-title fw-bold">${institucion.nombre}</h5>
                    <p class="card-text">
                        <strong>Ubicación:</strong> ${institucion.ubicacion}<br>
                        <strong>Descripción:</strong> ${institucion.descripcion}<br>
                        <strong>Estado:</strong>
                        <c:choose>
                            <c:when test="${institucion.estado}">Activa</c:when>
                            <c:otherwise>Inactiva</c:otherwise>
                        </c:choose>
                    </p>

                    <a href="${pageContext.request.contextPath}/PasarInstitucion?nombre=${institucion.nombre}"
                       class="btn btn-outline-light btn-sm">
                        Editar
                    </a>
                </div>
            </div>
        </c:forEach>
        <jsp:include page="/Includes/footer.jsp"/>
    </div>
</body>
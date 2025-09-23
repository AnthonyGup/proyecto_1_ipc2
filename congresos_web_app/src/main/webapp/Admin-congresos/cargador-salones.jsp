<%-- 
    Document   : Cargador-salones
    Created on : 23 sept 2025, 1:41:37
    Author     : antho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/Includes/resources.jsp"/>
<jsp:include page="/Mensajes/mensajes.jsp"/>

<body class="bg-dark text-light">
    <jsp:include page="/Includes/header-admin-congresos.jsp"/>

    <div class="container py-5">
        <h4 class="mb-4">Listado de salones</h4>

        <c:if test="${empty salones}">
            <div class="alert alert-warning text-center">
                No se encontraron salones registrados.
            </div>
        </c:if>

        <c:forEach var="salon" items="${salones}">
            <div class="card bg-dark text-light border-secondary shadow-sm mb-4" style="background-color: rgba(255,255,255,0.05);">
                <div class="card-body">
                    <h5 class="card-title fw-bold">${salon.SALON}</h5>
                    <p class="card-text">
                        <strong>ID Salón:</strong> ${salon.ID_SALON}<br>
                        <strong>Ubicación:</strong> ${salon.UBICACION}<br>
                        <strong>Capacidad:</strong> ${salon.CAPACIDAD}<br>
                        <strong>ID Congreso:</strong> ${salon.ID_CONGRESO}
                    </p>

                    <a href="${pageContext.request.contextPath}/PasarSalon?salon=${salon.ID_SALON}"
                       class="btn btn-outline-light btn-sm">
                        Editar
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
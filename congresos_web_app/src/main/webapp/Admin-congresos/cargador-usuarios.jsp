<%-- 
    Document   : cargar-usuarios
    Created on : 23 sept 2025, 2:08:24
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/Includes/resources.jsp"/>
<jsp:include page="/Mensajes/mensajes.jsp"/>

<body class="bg-dark text-light">
    <jsp:include page="/Includes/header-admin-congresos.jsp"/>

    <div class="container py-5">
        <h4 class="mb-4">Listado de usuarios</h4>

        <c:forEach var="usuario" items="${usuarios}">
            <div class="card bg-dark text-light border-secondary shadow-sm mb-3" style="background-color: rgba(255,255,255,0.05);">
                <div class="card-body">
                    <h5 class="card-title fw-bold">${usuario.CORREO}</h5>
                    <p class="card-text">
                        <strong>Tipo de usuario:</strong>
                        <c:choose>
                            <c:when test="${usuario.ROL == 'ADMIN_SISTEMA'}">Administrador del sistema</c:when>
                            <c:when test="${usuario.ROL == 'ADMIN_CONGRESO'}">Administrador de congreso</c:when>
                            <c:when test="${usuario.ROL == 'COMITE'}">Comité organizador</c:when>
                            <c:otherwise>Participante</c:otherwise>
                        </c:choose>
                    </p>

                    <a href="${pageContext.request.contextPath}/PasarUsuario?correo=${usuario.CORREO}"
                       class="btn btn-outline-light btn-sm">
                        Editar
                    </a>
                </div>
            </div>
        </c:forEach>
        <jsp:include page="/Includes/footer.jsp"/>
    </div>
</body>

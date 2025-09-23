<%-- 
    Document   : main-participante
    Created on : 21 sept 2025, 1:11:30
    Author     : antho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/Includes/resources.jsp"/>


<body class="bg-dark text-light">
    <div class="container-fluid bg-dark text-light py-3 shadow-sm border-bottom border-secondary">
        <div class="container">
            <h3 class="mb-3">Información de sesión</h5>
            <ul class="list-unstyled mb-0">
                <li>
                    <strong>Correo:</strong>
                    <span class="px-2 py-1 rounded" style="background-color: rgba(255, 255, 255, 0.1);">
                        ${sessionScope.user.CORREO}
                    </span>
                </li>
                <p></p>
                <li>
                    <strong>Tipo de usuario:</strong>
                    <span class="px-2 py-1 rounded" style="background-color: rgba(255, 255, 255, 0.1);">
                        ${sessionScope.user.ROL}
                    </span>
                </li>
                <p></p>
                <li>
                    <strong>Cartera digital:</strong>
                    <span class="px-2 py-1 rounded" style="background-color: rgba(255, 255, 255, 0.1);">
                        ${sessionScope.user.cartera_digital}
                    </span>
                </li>
                <p></p>
            </ul>
        </div>
        <div class="container">
            <h3 class="mb-3">Información del participante</h5>
            <ul class="list-unstyled mb-0">

                <li class="mb-2">
                    <strong>ID Personal:</strong>
                    <span class="px-2 py-1 rounded" style="background-color: rgba(255,255,255,0.1);">
                        ${sessionScope.participante.ID_PERSONAL}
                    </span>
                </li>

                <li class="mb-2">
                    <strong>Nombre completo:</strong>
                    <span class="px-2 py-1 rounded" style="background-color: rgba(255,255,255,0.1);">
                        ${sessionScope.participante.NOMBRE_COMPLETO}
                    </span>
                </li>

                <li class="mb-2">
                    <strong>Teléfono:</strong>
                    <span class="px-2 py-1 rounded" style="background-color: rgba(255,255,255,0.1);">
                        ${sessionScope.participante.TELEFONO}
                    </span>
                </li>

                <li class="mb-2">
                    <strong>Organización:</strong>
                    <span class="px-2 py-1 rounded" style="background-color: rgba(255,255,255,0.1);">
                        ${sessionScope.participante.ORGANIZACION}
                    </span>
                </li>
            </ul>
        </div>
        <jsp:include page="/Includes/footer.jsp"/>      
    </div>
</body>


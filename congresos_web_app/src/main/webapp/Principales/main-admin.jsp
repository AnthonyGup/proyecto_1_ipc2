<%-- 
    Document   : main-admin
    Created on : 21 sept 2025, 1:11:54
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/Includes/resources.jsp"/>


<body class="bg-dark text-light">

    <div class="container-fluid bg-dark text-light py-3 shadow-sm border-bottom border-secondary">
        <div class="container">
            <h5 class="mb-3">Información de sesión</h5>
            <ul class="list-unstyled mb-0">
                <li>
                    <strong>Correo:</strong>
                    <span class="px-2 py-1 rounded" style="background-color: rgba(255, 255, 255, 0.1);">
                        ${user.CORREO}
                    </span>
                </li>
                <p></p>
                <li>
                    <strong>Tipo de usuario:</strong>
                    <span class="px-2 py-1 rounded" style="background-color: rgba(255, 255, 255, 0.1);">
                        ${user.ROL}
                    </span>
                </li>
            </ul>
        </div>
    </div>
    <jsp:include page="/Includes/footer.jsp"/>
</body>


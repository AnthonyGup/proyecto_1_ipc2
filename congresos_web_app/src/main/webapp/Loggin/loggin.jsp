<%-- 
    Document   : loggin
    Created on : 19 sept 2025, 23:18:26
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/Includes/resources.jsp"/>

<body class="bg-dark text-light">
    <div class="d-flex justify-content-center align-items-center min-vh-100">
        <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5">
            <jsp:include page="/Mensajes/mensajes.jsp"/>
            <form action="${pageContext.request.contextPath}/LoginController" method="post" class="p-4 rounded shadow bg-secondary">
                <h4 class="mb-4 text-center text-white">Iniciar sesión</h4>

                <div class="mb-3">
                    <label for="email" class="form-label text-white">Correo electrónico</label>
                    <input type="email" class="form-control" id="email" name="email" required placeholder="usuario@ejemplo.com">
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label text-white">Contraseña</label>
                    <input type="password" class="form-control" id="password" name="password" required placeholder="*****">
                </div>

                <div class="d-flex justify-content-between align-items-center mt-4">
                    <button type="submit" class="btn btn-light">Ingresar</button>
                    <a href="${pageContext.request.contextPath}/Loggin/registro.jsp" class="btn btn-outline-light">Crear cuenta</a>
                </div>
            </form>
            <jsp:include page="/Includes/footer.jsp"/>
        </div>
    </div>
</body>

<%-- 
    Document   : registrador-asistencias
    Created on : 23 sept 2025, 2:42:50
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

                    <h4 class="mb-3">Registrar asistencia</h4>

                    <form action="RegistrarAsistenciaServlet" method="post">

                        <div class="mb-3">
                            <label for="id_actividad" class="form-label">ID Actividad</label>
                            <input type="text" id="id_actividad" name="id_actividad"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   pattern="ACT-\\d{8}" title="Formato requerido: ACT-00000001"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label for="id_participante" class="form-label">ID Participante</label>
                            <input type="text" id="id_participante" name="id_participante"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa;"
                                   required>
                        </div>

                        <button type="submit" class="btn btn-outline-light px-4">
                            Registrar asistencia
                        </button>
                    </form>

                </div>
            </div>
        </div>
        <jsp:include page="/Includes/footer.jsp"/>
    </div>
</body>

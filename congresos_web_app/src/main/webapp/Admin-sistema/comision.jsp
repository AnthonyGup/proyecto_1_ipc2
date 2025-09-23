<%-- 
    Document   : comision
    Created on : 21 sept 2025, 23:27:41
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/Mensajes/mensajes.jsp"/>
<jsp:include page="/Includes/resources.jsp"/>

<body class="bg-dark text-light">

    <jsp:include page="/Includes/header-admin-sistema.jsp"/>

    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-12 col-md-8 col-lg-6">

                <div class="mb-4 p-4 rounded bg-dark border border-secondary shadow-sm">

                    <h4 class="mb-3">Buscar Congreso</h4>

                    <form action="${pageContext.request.contextPath}/BuscadorCongresosServlet" method="post">
                        <div class="mb-3">
                            <label for="codigoCongreso" class="form-label">Código del Congreso</label>
                            <input type="text" id="codigoCongreso" name="codigoCongreso"
                                   class="form-control border-secondary"
                                   style="background-color: #121212; color: #f8f9fa; ::placeholder {
                                       color: #f8f9fa;
                                   }"
                                   placeholder="CON-00000001" maxlength="12" required
                                   pattern="CON-[0-9]{8}">

                            <small class="form-text text-muted">Formato requerido: EVT-00000001</small>
                        </div>

                        <button type="submit" class="btn btn-outline-light px-4">
                            Buscar
                        </button>
                    </form>


                    <c:if test="${not empty evento}">
                        <div class="card bg-dark text-light border-secondary mt-4 shadow-sm">
                            <div class="card-header bg-secondary text-light">
                                Código: ${evento.id_congreso}
                            </div>
                            <div class="card-body">
                                <h5 class="card-title">${evento.titulo}</h5>
                                <p class="card-text">
                                    Precio: Q${evento.precio}
                                </p>

                                <form action="ActualizadorComisionServlet?evento=${evento.id_congreso}" method="post" class="mt-3">
                                    <input type="hidden" name="codigoEvento" value="${evento.id_congreso}"/>

                                    <div class="mb-3">
                                        <label for="comision" class="form-label">Comisión organizadora (%)</label>
                                        <input type="number" id="comision" name="comision"
                                               class="form-control bg-dark text-light border-secondary"
                                               value="${evento.comision}" required
                                               step="0.01" min="0" max="100"
                                               placeholder="Ej. 15.75"/>
                                        <small class="form-text text-muted">Ingresa un valor decimal entre 0 y 100</small>
                                    </div>

                                    <button type="submit" class="btn btn-outline-light">
                                        Guardar comisión
                                    </button>
                                </form>
                            </div>
                        </div>
                    </c:if>

                </div>
            </div>
        </div>
        <jsp:include page="/Includes/footer.jsp"/>
    </div>
</body>



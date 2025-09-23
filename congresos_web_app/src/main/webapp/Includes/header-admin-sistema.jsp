<%-- 
    Document   : header-admin-sistema
    Created on : 21 sept 2025, 18:58:35
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Encabezado fijo superior -->
<nav class="navbar navbar-expand-lg bg-dark text-light border-bottom border-secondary shadow-sm">
    <div class="container-fluid">
        <a class="navbar-brand text-light fw-bold" href="${pageContext.request.contextPath}/">Congresos webapp</a>

        <button class="navbar-toggler text-light" type="button" data-bs-toggle="collapse" data-bs-target="#navbarOpciones">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarOpciones">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item mx-2">
                    <a class="nav-link text-light px-3 py-2 rounded" style="background-color: rgba(255,255,255,0.1);" href="${pageContext.request.contextPath}/Admin-sistema/comision.jsp">Comisiones</a>
                </li>
                <li class="nav-item dropdown mx-2">
                    <a class="nav-link dropdown-toggle text-light px-3 py-2 rounded" href="#" role="button" data-bs-toggle="dropdown"
                       style="background-color: rgba(255,255,255,0.1);">
                        Instituciones
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark shadow">
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Admin-sistema/institucion-crear.jsp">
                                Crear Institución
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/BuscarTodasInstituciones">
                                Editar Institución
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link text-light px-3 py-2 rounded"
                       href="${pageContext.request.contextPath}/Admin-sistema/usuario.jsp"style="background-color: rgba(255,255,255,0.1);">
                        Usuarios
                    </a>
                </li>

                <li class="nav-item mx-2">
                    <a class="nav-link text-light px-3 py-2 rounded" style="background-color: rgba(255,255,255,0.1);" href="${pageContext.request.contextPath}/reportes.jsp">Reportes</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


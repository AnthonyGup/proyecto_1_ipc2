<%-- 
    Document   : header-comite
    Created on : 23 sept 2025, 4:17:26
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
                    <a class="nav-link text-light px-3 py-2 rounded"
                       style="background-color: rgba(255,255,255,0.1);"
                       href="${pageContext.request.contextPath}/Participante/reservar-taller.jsp">
                        Reservar taller
                    </a>
                </li>

                <li class="nav-item mx-2">
                    <a class="nav-link text-light px-3 py-2 rounded"
                       style="background-color: rgba(255,255,255,0.1);"
                       href="${pageContext.request.contextPath}/Participante/proponer-trabajo.jsp">
                        Revisar trabajos
                    </a>
                </li>

                <li class="nav-item dropdown mx-2">
                    <a class="nav-link dropdown-toggle text-light px-3 py-2 rounded" href="#" role="button" data-bs-toggle="dropdown"
                       style="background-color: rgba(255,255,255,0.1);">
                        Congresos
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark shadow">
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Participante/inscribirse-congreso.jsp">
                                Inscribirse a congreso
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Participante/mis-congresos.jsp">
                                Ver mis congresos
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item mx-2">
                    <a class="nav-link text-light px-3 py-2 rounded"
                       style="background-color: rgba(255,255,255,0.1);"
                       href="${pageContext.request.contextPath}/Participante/agregar-fondos.jsp">
                        Agregar fondos
                    </a>
                </li>

                <li class="nav-item mx-2">
                    <a class="nav-link text-light px-3 py-2 rounded"
                       style="background-color: rgba(255,255,255,0.1);"
                       href="${pageContext.request.contextPath}/Participante/reportes.jsp">
                        Reportes
                    </a>
                </li>

            </ul>
        </div>
    </div>
</nav>

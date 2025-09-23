<%-- 
    Document   : header-admin-congresos
    Created on : 22 sept 2025, 11:01:57
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg bg-dark text-light border-bottom border-secondary shadow-sm">
    <div class="container-fluid">
        <a class="navbar-brand text-light fw-bold" href="${pageContext.request.contextPath}/">Congresos webapp</a>

        <button class="navbar-toggler text-light" type="button" data-bs-toggle="collapse" data-bs-target="#navbarOpciones">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarOpciones">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

                <li class="nav-item dropdown mx-2">
                    <a class="nav-link dropdown-toggle text-light px-3 py-2 rounded" href="#" role="button" data-bs-toggle="dropdown"
                       style="background-color: rgba(255,255,255,0.1);">
                        Congresos
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark shadow">
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Admin-congresos/creador-congresos.jsp">
                                Crear Congreso
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/BuscadorTodosCongresos" method="get">
                                Editar Congreso
                            </a>
                        </li>
                    </ul>
                </li>
                
                <li class="nav-item dropdown mx-2">
                    <a class="nav-link dropdown-toggle text-light px-3 py-2 rounded" href="#" role="button" data-bs-toggle="dropdown"
                       style="background-color: rgba(255,255,255,0.1);">
                        Actividades
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark shadow">
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Admin-congresos/creador-actividades.jsp">
                                Crear Actividades
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/BuscadorTodasActividades" method="get">
                                Editar Actividades
                            </a>
                        </li>
                    </ul>
                </li>
                
                <li class="nav-item dropdown mx-2">
                    <a class="nav-link dropdown-toggle text-light px-3 py-2 rounded" href="#" role="button" data-bs-toggle="dropdown"
                       style="background-color: rgba(255,255,255,0.1);">
                        Salones
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark shadow">
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Admin-congresos/creador-salones.jsp">
                                Crear Salones
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/BuscadorTodosSalones" method="get">
                                Editar Salones
                            </a>
                        </li>
                    </ul>
                </li>


                <li class="nav-item mx-2">
                    <a class="nav-link text-light px-3 py-2 rounded"
                       href="${pageContext.request.contextPath}/BuscadorTodosUsuarios"
                       style="background-color: rgba(255,255,255,0.1);">
                        Comite cientifico
                    </a>
                </li>
                
                
                <li class="nav-item mx-2">
                    <a class="nav-link text-light px-3 py-2 rounded"
                       href="${pageContext.request.contextPath}/Admin-congresos/registrador-asistencias.jsp"
                       style="background-color: rgba(255,255,255,0.1);">
                        Asistencias
                    </a>
                </li>

                <li class="nav-item mx-2">
                    <a class="nav-link text-light px-3 py-2 rounded"
                       href="${pageContext.request.contextPath}/reportes.jsp"
                       style="background-color: rgba(255,255,255,0.1);">
                        Reportes
                    </a>
                </li>

            </ul>
        </div>
    </div>
</nav>

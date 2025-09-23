<%-- 
    Document   : index
    Created on : 8 sept 2025, 10:49:30
    Author     : antho
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <c:if test="${sessionScope.user == null}">
                <jsp:include page="/Loggin/loggin.jsp"/>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <c:if test="${sessionScope.user.ROL == 'ADMIN_SISTEMA'}">
                    <jsp:include page="/Includes/header-admin-sistema.jsp"/>
                    <jsp:include page="/Principales/main-admin.jsp"/>
                </c:if>
                <c:if test="${sessionScope.user.ROL == 'ADMIN_CONGRESO'}">
                    <jsp:include page="/Includes/header-admin-congresos.jsp"/>
                    <jsp:include page="/Principales/main-admin.jsp"/>
                </c:if>
                <c:if test="${sessionScope.user.ROL == 'COMITE'}">
                    <jsp:include page="/Includes/header-comite.jsp"/>
                    <jsp:include page="Principales/main-participante.jsp"/>
                </c:if>
                <c:if test="${sessionScope.user.ROL == 'PARTICIPANTE'}">
                    <jsp:include page="/Includes/header-participante.jsp"/>
                    <jsp:include page="/Principales/main-participante.jsp"/>
                </c:if>
            </c:if>
        </div>
    </body>
</html>

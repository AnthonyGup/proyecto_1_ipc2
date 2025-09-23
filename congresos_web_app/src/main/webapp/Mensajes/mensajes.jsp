<%-- 
    Document   : mensajes
    Created on : 21 sept 2025, 2:07:41
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty error}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <c:out value="${error}" />
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <c:remove var="error" scope="session" />
</c:if>

<c:if test="${not empty mensaje}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <c:out value="${mensaje}" />
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <c:remove var="mensaje" scope="session" />
</c:if>


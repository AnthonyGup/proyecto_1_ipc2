<%-- 
    Document   : footer
    Created on : 19 sept 2025, 20:18:05
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="d-flex flex-column flex-sm-row justify-content-between py-4 my-4 border-top">
    <p>© 2025 Code ‘n Bugs. All rights reserved.</p> 
    <ul class="list-unstyled d-flex"> 
        <li class="ms-3">
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit" class="btn btn-outline-secondary btn-sm">Cerrar sesión</button>
            </form>
        </li>
    </ul>
</div>
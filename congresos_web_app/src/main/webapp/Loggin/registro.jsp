<%-- 
    Document   : registro
    Created on : 20 sept 2025, 0:32:35
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/Includes/resources.jsp"/>
<body class="bg-dark text-light">
    <div class="d-flex justify-content-center align-items-center min-vh-100">
        <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5">
            <jsp:include page="/Mensajes/mensajes.jsp"/>

            <div class="d-flex justify-content-start mb-3">
                <a href="${pageContext.servletContext.contextPath}/Loggin/loggin.jsp"
                   class="btn btn-outline-light px-3 py-2"
                   style="min-width: 40px; text-align: center;" title="Regresar al login">
                    &larr;
                </a>
            </div>

            <form class="needs-validation" method="POST" action="${pageContext.servletContext.contextPath}/CrearUsuarioController">
                <h4 class="mb-4 text-center text-white">Registrar usuario</h4>

                <div class="mb-3">
                    <label for="foto" class="form-label text-white">Fotografía</label>
                    <input type="file" class="form-control" name="foto" accept="image/*">
                </div>

                <div class="col-12">
                    <label for="email" class="form-label">Email <span class="text-body-secondary">(Optional)</span></label> 
                    <input type="email" class="form-control" name="email" placeholder="you@example.com">
                    <div class="invalid-feedback">Please enter a valid email address for shipping updates.</div> 
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label text-white">Contraseña</label>
                    <input type="password" class="form-control" name="password" required placeholder="••••••••">
                    <div class="invalid-feedback">
                        La contraseña es obligatoria.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="tipo" class="form-label text-white">Tipo de usuario</label>
                    <select class="form-select" id="tipo" name="tipo" required>
                        <option value="" disabled selected>Selecciona un tipo</option>
                        <option value="ADMIN_SISTEMA">Administrador del sistema</option>
                        <option value="PARTICIPANTE">Participante</option>
                    </select>
                    <div class="invalid-feedback">
                        Selecciona un tipo de usuario.
                    </div>
                </div>

                <div id="participanteFields" class="mt-4" style="display: none;">
                    <h5 class="mb-3 text-white">Datos del participante</h5>

                    <div class="mb-3">
                        <label for="nombre" class="form-label text-white">Nombre completo</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ej. Anthony López">
                    </div>

                    <div class="mb-3">
                        <label for="id_personal" class="form-label text-white">ID personal</label>
                        <input type="text" class="form-control" id="id_personal" name="id_personal">
                    </div>

                    <div class="mb-3">
                        <label for="telefono" class="form-label text-white">Teléfono</label>
                        <input type="text" class="form-control" id="telefono" name="telefono" placeholder="+50212345678">
                    </div>

                    <div class="mb-3">
                        <label for="organizacion" class="form-label text-white">Organización</label>
                        <input type="text" class="form-control" id="organizacion" name="organizacion">
                    </div>

                    <div class="mb-3">
                        <label for="cartera" class="form-label text-white">Fondos</label>
                        <input type="number" class="form-control" id="cartera" name="cartera" min="0" step="0.01" placeholder="0.00">
                    </div>
                </div>

                <div class="d-grid mt-4">
                    <button type="submit" class="btn btn-light">Registrarse</button>
                </div>
            </form>
        </div>
    </div>
                
    <script>
        const tipoSelect = document.getElementById("tipo");
        const participanteFields = document.getElementById("participanteFields");

        function actualizarCampos() {
            const isParticipante = tipoSelect.value === "PARTICIPANTE";
            participanteFields.style.display = isParticipante ? "block" : "none";

            const campos = participanteFields.querySelectorAll("input, select");
            campos.forEach(campo => {
                if (isParticipante) {
                    campo.setAttribute("required", "required");
                } else {
                    campo.removeAttribute("required");
                }
            });
        }

        tipoSelect.addEventListener("change", actualizarCampos);
        window.addEventListener("DOMContentLoaded", actualizarCampos);
    </script>
</body>
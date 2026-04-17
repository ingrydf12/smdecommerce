<%-- 
    Document   : principal
    Created on : 16 de abr. de 2026, 16:45:17
    Author     : INGRYD
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <title>Principal</title>
</head>
<body>
    <%
        // Proteção: redireciona se não estiver logado
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            response.sendRedirect("Inicio");
            return;
        }
    %>

    <h2>Bem-vindo, <%= usuario.getLogin() %>!</h2>
    <a href="LogoutServlet">Sair</a>
</body>
</html>
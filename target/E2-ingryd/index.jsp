<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>

    <% if (request.getAttribute("mensagem") != null) { %>
        <p style="color: red;"> <%= request.getAttribute("mensagem") %> </p>
    <% } %>

    <form action="LoginServlet" method="post">
        <label>Login:</label><br>
        <input type="text" name="login"><br><br>

        <label>Senha:</label><br>
        <input type="password" name="senha"><br><br>

        <button type="submit">Entrar</button>
    </form>
</body>
</html>
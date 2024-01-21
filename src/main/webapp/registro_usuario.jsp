<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario</title>
</head>
<body>
    <h2>Registro de Usuario</h2>
    <form action="RegistroUsuarioServlet" method="POST">
        Nombre de Usuario: <input type="text" name="nombreUsuario" required><br>
        Contraseña:        <input type="password" name="password" required><br>
        <input type="submit" value="Registrar">
    </form>
</body>
</html>

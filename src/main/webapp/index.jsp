<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
</head>
<body>
    <h2>Bienvenido</h2>
    
   <form action="LoginServlet" method="POST">
        <label>Usuario:</label>
        <input type="text" name="usuario" required><br>
        
        <label>Contraseña:</label>
        <input type="password" name="contrasena" required><br>
        
        <input type="submit" value="Entrar">
    </form>

    <p>¿No estás registrado? <a href="registro_usuario.jsp">Haz clic aquí</a> para registrarte.</p>
    
    <!-- Agrega aquí los demás formularios o enlaces que desees -->
    
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Mascota</title>
</head>
<body>
    <h2>Registro de Mascota</h2>
    <form action="RegistroMascotaServlet" method="POST">
        Rut del Dueño: <input type="text" name="rutDueno" required><br>
        Tipo de Mascota: <input type="text" name="tipoMascota" required><br>
        Edad: <input type="text" name="edad" required><br>
        Nombre de la Mascota: <input type="text" name="nombreMascota" required><br>
        <input type="submit" value="Registrar">
    </form>
</body>
</html>

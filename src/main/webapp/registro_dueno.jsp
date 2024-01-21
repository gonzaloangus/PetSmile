<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Dueño</title>
</head>
<body>
    <h2>Registro de Dueño</h2>
    <form action="RegistroDuenoServlet" method="post">
        Rut: <input type="text" name="rut" required><br>
        Nombre: <input type="text" name="nombre" required><br>
        Apellido: <input type="text" name="apellido" required><br>
        Dirección: <input type="text" name="direccion" required><br>
        Correo: <input type="email" name="correo" required><br>
        Teléfono: <input type="text" name="telefono" required><br>
        Nombre de la Mascota: <input type="text" name="nombreMascota" required><br>
        <input type="submit" value="Registrar">
    </form>
</body>
</html>

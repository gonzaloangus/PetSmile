<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Agenda</title>
</head>
<body>
<h2>Agendar Cita</h2>

<form action="AgendaServlet" method="post">
    <label>ID de la Mascota:</label>
    <input type="text" name="idMascota" required><br>

    <label>Rut del Dueño:</label>
    <input type="text" name="rutDueño" required><br>

    <label>Nombre de la Mascota:</label>
    <input type="text" name="nombreMascota" required><br>

    <label>Fecha:</label>
    <input type="text" name="fecha" required><br>
    
    <label>Hora:</label>
    <input type="text" name="hora" required><br>   

    <input type="submit" value="Agendar Cita">
</form>
</body>
</html>

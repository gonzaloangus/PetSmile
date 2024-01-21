package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Dueño;
import utils.Conexion;

@WebServlet("/RegistroDuenoServlet")
public class RegistroDuenoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String nombreMascota = request.getParameter("nombreMascota");

        Dueño dueno = new Dueño();
        dueno.setRut(rut);
        dueno.setNombre(nombre);
        dueno.setApellido(apellido);
        dueno.setDireccion(direccion);
        dueno.setCorreo(correo);
        dueno.setTelefono(telefono);
        dueno.setNombreMascota(nombreMascota);

        if (registrarDueño(dueno)) {
            response.sendRedirect("registro_exitoso.jsp");
        } else {
            response.sendRedirect("registro_fallido.jsp");
        }
    }

    private boolean registrarDueño(Dueño dueño) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = new Conexion().getConnection();
            String sql = "INSERT INTO dueño (rut, nombre, apellido, direccion, correo, telefono, nombreMascota) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,dueño.getRut());
            ps.setString(2,dueño.getNombre());
            ps.setString(3,dueño.getApellido());
            ps.setString(4,dueño.getDireccion());
            ps.setString(5,dueño.getCorreo());
            ps.setString(6,dueño.getTelefono());
            ps.setString(7,dueño.getNombreMascota());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos (PreparedStatement y Connection)
        }
    }
}

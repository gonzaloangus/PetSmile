package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Mascota;
import utils.Conexion;

@WebServlet("/RegistroMascotaServlet")
public class RegistroMascotaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rutDueno = request.getParameter("rutDueno");
        String tipoMascota = request.getParameter("tipoMascota");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String nombreMascota = request.getParameter("nombreMascota");

        Mascota mascota = new Mascota();
        mascota.setRutDueno(rutDueno);
        mascota.setTipoMascota(tipoMascota);
        mascota.setEdad(edad);
        mascota.setNombreMascota(nombreMascota);

        if (registrarMascota(mascota)) {
            response.sendRedirect("registro_exitoso.jsp");
        } else {
            response.sendRedirect("registro_fallido.jsp");
        }
    }

    private boolean registrarMascota(Mascota mascota) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = new Conexion().getConnection();
            String sql = "INSERT INTO mascota (rutDueno, tipoMascota, edad, nombreMascota) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, mascota.getRutDueno());
            ps.setString(2, mascota.getTipoMascota());
            ps.setInt(3, mascota.getEdad());
            ps.setString(4, mascota.getNombreMascota());
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

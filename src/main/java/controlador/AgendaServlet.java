package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Agenda;
import utils.Conexion;

@WebServlet("/AgendaServlet")
public class AgendaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AgendaServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idMascota = Integer.parseInt(request.getParameter("idMascota"));
        String rutDueno = request.getParameter("rutDueno");
        String nombreMascota = request.getParameter("nombreMascota");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");

        Agenda cita = new Agenda();
        cita.setIdMascota(idMascota);
        cita.setRutDueno(rutDueno);
        cita.setNombreMascota(nombreMascota);
        cita.setFecha(fecha);
        cita.setHora(hora);

        if (registrarCita(cita)) {
            response.sendRedirect("registro_exitoso.jsp");
        } else {
            response.sendRedirect("registro_fallido.jsp");
        }
    }


    private boolean registrarCita(Agenda cita) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = new Conexion().getConnection();
            String sql = "INSERT INTO agenda (idMascota, rutDueno, nombreMascota, hora, fecha) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, cita.getIdMascota());
            ps.setString(2, cita.getRutDueno());
            ps.setString(3, cita.getNombreMascota());
            ps.setString(4, cita.getHora());
            ps.setString(5, cita.getFecha());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos (PreparedStatement y Connection) si es necesario
        }
    }


}

package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import utils.Conexion;

@WebServlet("/RegistroUsuarioServlet")
public class RegistroUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(password);

        if (registrarUsuario(usuario)) {
            response.sendRedirect("registro_exitoso.jsp");
        } else {
            response.sendRedirect("registro_fallido.jsp");
        }
    }

    private boolean registrarUsuario(Usuario usuario) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = new Conexion().getConnection();
            String sql = "INSERT INTO usuario (nombreUsuario, password) VALUES (?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getPassword());
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

package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import utils.Conexion;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        if (validarUsuario(usuario, contrasena)) {
            // Usuario válido, redireccionar al menú
            RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.jsp");
            dispatcher.forward(request, response);
        } else {
            // Usuario inválido, redireccionar a la página de error
            RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario_contraseña_fallido.jsp");
            dispatcher.forward(request, response);
        }
    }

    private boolean validarUsuario(String usuario, String contrasena) {
        Connection con;
        Conexion cn = new Conexion();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM usuario WHERE nombreUsuario = ? AND password = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();

            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String url;
    private String user;
    private String password;

    public Conexion() {
        this.url = "jdbc:mysql://localhost:3306/clinica?serverTimezone=UTC";
        this.user = "root";
        this.password = "12345";
    }

    // Constructor para pruebas unitarias
    public Conexion(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el controlador JDBC: " + e.getMessage());
        }
    }
}

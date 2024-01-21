package jUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import utils.Conexion;

public class ConexionTest {

	@Test
    public void testConexionExitosa() {
        Conexion conexion = new Conexion("jdbc:mysql://localhost:3306/clinica?serverTimezone=UTC", "root", "12345");

        try (Connection con = conexion.getConnection()) {
            assertNotNull(con);
        } catch (SQLException e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }
	
	@Test
	public void testConexionFallida() {
	    Conexion conexion = new Conexion("jdbc:mysql://localhost:3307/clinica?serverTimezone=UTC", "root", "12345");

	    try (Connection con = conexion.getConnection()) {
	        fail("Se esperaba una excepción pero la conexión tuvo éxito.");
	    } catch (SQLException e) {
	        // Excepción esperada
	    }
	}

	
}

package automatedTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IngresoUsuarioStepsTest {

    private WebDriver driver;

    // Puedes inicializar tu WebDriver en el método Given
    @Given("que tengo datos válidos en la base de datos")
    public void tengo_datos_validos_en_la_base_de_datos() {
    	System.setProperty("webdriver.chrome.driver", "C:\\IntegracionContinua\\ReservaHora\\chromedriver.exe");
    	driver = new ChromeDriver();


    }

    @When("ingreso el nombre de usuario {string} y la contraseña {string}")
    public void ingreso_el_nombre_de_usuario_y_la_contraseña(String username, String password) {
        driver.get("http://localhost:8081/ReservaHora/");

        WebElement usernameField = driver.findElement(By.name("nombreUsuario"));
        WebElement passwordField = driver.findElement(By.name("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        passwordField.submit();
    }

    @When("ingreso un nombre de usuario incorrecto y una contraseña incorrecta")
    public void ingreso_datos_erroneos() {
        driver.get("http://localhost:8081/ReservaHora/");

        WebElement usernameField = driver.findElement(By.name("nombreUsuario"));
        WebElement passwordField = driver.findElement(By.name("password"));

        // Ingresa datos incorrectos
        usernameField.sendKeys("usuario_invalido");
        passwordField.sendKeys("contraseña_invalida");

        passwordField.submit();
    }

    
    
    @Then("debería ser redirigido a la página principal")
    public void deberia_ser_redirigido_a_la_pagina_principal() {

        String expectedUrl = "http://localhost:8081/ReservaHora/registro_exitoso.jsp";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

        driver.quit();
    }

    @Then("debería ver un mensaje de error en la página de inicio de sesión")
    public void deberia_ver_mensaje_error_inicio_sesion() {
        WebElement errorMessage = driver.findElement(By.className("error-message"));
        assertTrue(errorMessage.isDisplayed());

        driver.quit();
    }
}

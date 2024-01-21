package automatedTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;

public class RegistroHoraMedicaStepsTest {

    private WebDriver driver;

    @Given("que estoy en la página de registro de hora médica")
    public void estoy_en_pagina_registro_hora_medica() {
        System.setProperty("webdriver.chrome.driver", "C:\\IntegracionContinua\\ReservaHora\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://localhost:8081/ReservaHora/formulario_agenda.jsp");
    }

    @When("intento registrar una hora médica sin proporcionar la información requerida")
    public void intento_registrar_hora_medica_sin_info() {
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
    }

    @When("ingreso la información requerida para la hora médica veterinaria")
    public void ingreso_info_requerida_hora_medica() {
        WebElement idMascotaField = driver.findElement(By.name("idMascota"));
        WebElement rutDuenoField = driver.findElement(By.name("rutDueño"));
        WebElement nombreMascotaField = driver.findElement(By.name("nombreMascota"));
        WebElement fechaField = driver.findElement(By.name("fecha"));
        WebElement horaField = driver.findElement(By.name("hora"));

        idMascotaField.sendKeys("123");
        rutDuenoField.sendKeys("12345678-9");
        nombreMascotaField.sendKeys("MascotaEjemplo");
        fechaField.sendKeys("2022-01-01");
        horaField.sendKeys("10:00");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
    }

    @Then("debería ver un mensaje de confirmación")
    public void deberia_ver_mensaje_confirmacion() {
        WebElement confirmationMessage = driver.findElement(By.className("confirmation-message"));
        assertTrue(confirmationMessage.isDisplayed());

        driver.quit();
    }

    @Then("debería ver un mensaje de error indicando los campos obligatorios")
    public void deberia_ver_mensaje_error_campos_obligatorios() {
        WebElement errorMessage = driver.findElement(By.className("error-message"));
        assertTrue(errorMessage.isDisplayed());

        driver.quit();
    }
}

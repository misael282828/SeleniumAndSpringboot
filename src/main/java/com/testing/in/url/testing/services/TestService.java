package com.testing.in.url.testing.services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class TestService {

    public String runTest(String suite) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            if ("smoke".equalsIgnoreCase(suite)) {
                driver.get("https://www.google.com");
                
                // Crear una instancia de WebDriverWait para manejar esperas explícitas
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Realizar la primera búsqueda: "plátanos maduros"
                performSearch(driver, wait, "plátanos maduros");

                // Realizar la segunda búsqueda: "plátanos verdes"
                performSearch(driver, wait, "plátanos verdes");

                // Realizar la tercera búsqueda: "manzanas amarillas"
                performSearch(driver, wait, "manzanas amarillas");

                return "Test de búsqueda ejecutado correctamente.";
            } else {
                return "Suite de pruebas no reconocida.";
            }
        } catch (Exception e) {
            return "Error durante la ejecución de la prueba: " + e.getMessage();
        } finally {
            driver.quit();
        }
    }

    private void performSearch(WebDriver driver, WebDriverWait wait, String query) {
        // Esperar a que el cuadro de búsqueda esté disponible y escribir el término
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.clear(); // Limpiar el cuadro de búsqueda
        searchBox.sendKeys(query);

        // Enviar el formulario de búsqueda
        searchBox.submit();

        // Esperar a que los resultados de la búsqueda se carguen
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
    }
}

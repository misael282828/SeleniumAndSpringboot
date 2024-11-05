# Proyecto de Pruebas Automáticas con Spring Boot y Selenium

Este proyecto usa **Spring Boot** para crear una API REST que ejecuta pruebas automáticas en un navegador mediante **Selenium WebDriver**. Al enviar una solicitud HTTP con un parámetro específico, se ejecutan las pruebas configuradas, como la búsqueda en Google, y se devuelve el resultado.

## Tecnologías

- **Java 17**
- **Spring Boot 3.3.5**
- **Selenium WebDriver**
- **WebDriverManager**

## Ejemplo de Uso

1. Descarga y despliega el proyecto.
2. Valida el puerto en el que se está ejecutando Spring Boot (por defecto, `localhost:<puerto>/`).ejemplo http://localhost:8080/run-tests?suite=smoke
3. Envía una solicitud HTTP con el parámetro del controlador para ejecutar la prueba.
4. El navegador ejecutará la prueba y devolverá el resultado.

Este proyecto es útil para **QA Automation** y pruebas de interfaz web.
puedes desplegar este proyecto en un servidor como openshitf para ejecutar tus pruebas sin problemas (tal ves usando Docker)

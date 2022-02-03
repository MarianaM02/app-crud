# App CRUD
Este es un proyecto de ejemplo usando Maven y JDBC.

## web.xml
Crear el archivo en /app-crud/src/main/webapp/WEB-INF/web.xml y completar con los datos de la base de datos:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
    <display-name>CRUD Artículos con JSP y Servlet </display-name>
    <context-param>
        <param-name>jdbcURL</param-name>
        <param-value>jdbc:mysql://localhost:3306/ [nombre-DB] ?useSSL=false&amp;serverTimezone=UTC</param-value>
    </context-param>
    <context-param>
        <param-name>jdbcUsername</param-name>
        <param-value> [nombre-de-usuario] </param-value>
    </context-param>
    <context-param>
        <param-name>jdbcPassword</param-name>
        <param-value> [contraseña] </param-value>
    </context-param>
</web-app>
```

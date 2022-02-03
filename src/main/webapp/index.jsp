<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css" MEDIA=screen>
<title>Artículos Java Web JSP y Servlet</title>
</head>
<body>
<h1>Administrar Artículos</h1>
<table border="1" width="25%" align="center" class="flat-table flat-table-1">
    <tr>
        <td align="center"><a href="adminArticulo?action=nuevo">Nuevo</a></td>
    </tr>
    <tr>
        <td align="center"><a href="adminArticulo?action=mostrar">Mostrar</a></td>
    </tr>
</table>

<h1>Administrar Ventas</h1>
<table border="1" width="25%" align="center" class="flat-table flat-table-3">
    <tr>
        <td align="center"><a href="adminVentas?action=nuevo">Nuevo</a></td>
    </tr>
    <tr>
        <td align="center"><a href="adminVentas?action=mostrar">Mostrar</a></td>
    </tr>
</table>
    
</body>
</html>
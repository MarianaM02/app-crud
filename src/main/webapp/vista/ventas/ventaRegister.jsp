<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css" MEDIA=screen>
<title>Registrar Venta</title>
</head>
<body>
	<h1>Registrar Venta</h1>
	<a href="adminVentas?action=index">Ir al menú</a>
	<form action="adminVentas?action=register" method="post">
		<table border="1" align="center" class="flat-table flat-table-3">
			<tbody>
				<tr>
					<td><a>Id Artículo:</a></td>
					<td><input type="text" name="id_articulo" /></td>
				</tr>
				<tr>
					<td><a>Cantidad:</a></td>
					<td><input type="text" name="cantidad" /></td>
				</tr>
				<tr>
					<td><a>Cliente:</a></td>
					<td><input type="text" name="cliente" /></td>
				</tr>
			</tbody>
		</table>
		<table border="0" align="center" >
			<tr>
				<td><input type="submit" value="Agregar" name="agregar"></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css" MEDIA=screen>
<title>Actualizar Venta</title>
</head>
<body>
	<h1>Actualizar Venta</h1>
	<a href="adminVenta?action=index">Ir al menú</a>
	<form action="adminVentas?action=editar" method="post">

		<table border="1" align="center" class="flat-table flat-table-3">
			<tbody>
				<tr>
					<td><a>Id:</a></td>
					<td><input type="text" name="id"
						value="<c:out value="${venta.id}"></c:out>"></td>
				</tr>
				<tr>
					<td><a>Id Artículo:</a></td>
					<td><input type="text" name="id_articulo"
						value='<c:out value="${venta.articulo.id}"></c:out>'></td>
				</tr>
				<tr>
					<td><a>Cantidad:</a></td>
					<td><input type="text" name="cantidad"
						value='<c:out value="${venta.cantidad}"></c:out>'></td>
				</tr>
				<tr>
					<td><a>Cliente:</a></td>
					<td><input type="text" name="cliente"
						value='<c:out value="${venta.cliente}"></c:out>'></td>
				</tr>
			</tbody>
		</table>
		<table border="0" align="center">
			<tr>
				<td><input type="submit" name="registrar" value="Guardar"></td>
			</tr>
		</table>
	</form>

</body>
</html>
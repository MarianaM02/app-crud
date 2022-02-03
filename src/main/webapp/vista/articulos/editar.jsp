<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css" MEDIA=screen>
<title>Actualizar Artículo</title>
</head>
<body>
	<h1>Actualizar Artículo</h1>
	<a href="adminArticulo?action=index">Ir al menú</a>
	<form action="adminArticulo?action=editar" method="post">

		<table border="1" align="center" class="flat-table flat-table-1">
			<tbody>
				<tr>
					<td><label>Id</label></td>
					<td><input type="text" name="id"
						value="<c:out value="${articulo.id}"></c:out>"></td>
				</tr>
				<tr>
					<td><a>Código:</a></td>
					<td><input type="text" name="codigo"
						value='<c:out value="${articulo.codigo}"></c:out>' /></td>
				</tr>
				<tr>
					<td><a>Nombre:</a></td>
					<td><input type="text" name="nombre"
						value='<c:out value="${articulo.nombre}"></c:out>'></td>
				</tr>
				<tr>
					<td><a>Descripción:</a></td>
					<td><input type="text" name="descripcion"
						value='<c:out value="${articulo.descripcion}"></c:out>'></td>
				</tr>
				<tr>
					<td><a>Cantidad:</a></td>
					<td><input type="text" name="cantidad"
						value='<c:out value="${articulo.existencia}"></c:out>'></td>
				</tr>
				<tr>
					<td><a>Precio:</a></td>
					<td><input type="text" name="precio"
						value='<c:out value="${articulo.precio}"></c:out>'></td>
				</tr>
			</tbody>
		</table>
		<table border="0" align="center" >
			<tr>
				<td><input type="submit" name="registrar" value="Guardar"></td>
			</tr>
		</table>
	</form>

</body>
</html>
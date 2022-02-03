<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css" MEDIA=screen>
<script defer src="https://kit.fontawesome.com/efd9785ce3.js"
	crossorigin="anonymous"></script>
<script defer src="script.js"></script>
<title>Administrar Artículos</title>
</head>
<body>
	<h1>Lista Artículos</h1>
	<table>
		<tr>
			<td><a href="adminArticulo?action=index">Ir al menú</a></td>
		</tr>
	</table>

	<table border="1" align="center" width="90%"
		class="flat-table flat-table-1">
		<thead>
			<tr>
				<td>ID</td>
				<td>CODIGO</td>
				<td>NOMBRE</td>
				<td>DESCRPICION</td>
				<td>EXISTENCIA</td>
				<td>PRECIO</td>
				<td colspan=2>ACCIONES</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="articulo" items="${lista}">
				<tr>
					<td><c:out value="${articulo.id}" /></td>
					<td><c:out value="${articulo.codigo}" /></td>
					<td><c:out value="${articulo.nombre}" /></td>
					<td><c:out value="${articulo.descripcion}" /></td>
					<td><c:out value="${articulo.existencia}" /></td>
					<c:set var="precio" value="${articulo.precio}" />
					<td><fmt:formatNumber value="${precio}" type="currency" /></td>
					<td><a
						href="adminArticulo?action=showedit&id=<c:out value="${articulo.id}"/>">
							<i class="fas fa-edit mx-1"></i>
					</a></td>
					<td><a onclick="checkIt()"
						href="adminArticulo?action=eliminar&id=<c:out value="${articulo.id}"/>"><i
							class="fa fa-trash mx-1"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
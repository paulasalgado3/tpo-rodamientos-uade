<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comparar Precios</title>
</head>
<body>
<form action="./CompararServlet" method="post">

	<!-- Cod10	caract 1	SFK	Argentina-->
	<h1>Ingrese los parametros de busqueda de un rodamiento</h1>
	<table>
		<tr>
			<td>Codigo</td>
			<td><input type="text" name="codigo"/></td>
		</tr>
		<tr>
			<td>Marcas</td>
			<td><input type="text" name="marcas"/> Ingrese separado por , (ej: skf, ico)</td>
		</tr>
		<tr>
			<td>Pais de origen</td>
			<td><input type="text" name="paisOrigen"/></td>
		</tr>
		<tr>
			<td>Caracteristicas</td>
			<td><input type="text" name="caracteristicas"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Enviar"/></td>
		</tr>
	</table>

</form>
</body>
</html>
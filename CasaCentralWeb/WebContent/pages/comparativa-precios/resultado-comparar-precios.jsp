<%@page import="modelo.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado - Comparar Precios</title>
</head>
<body>
	<%List<Item> items = (List<Item>)request.getAttribute("items"); %>
	<table>
		<tr>
		<%for(Item i : items){ %>
			<td>
			<%="Rodamiento: " + i.getRodamiento().getCodigo()+ " " + i.getRodamiento().getMarca()+ "  Precio: " + i.getPrecio()%>
			</td>
		<%}%>
		</tr>
	</table>
<br/>
</body>
</html>
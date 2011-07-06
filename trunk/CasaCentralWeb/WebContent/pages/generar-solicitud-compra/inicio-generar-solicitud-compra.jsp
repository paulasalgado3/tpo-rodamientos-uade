<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="modelo.Item"%>
 <%@page import="java.util.List"%>
 <%@page import="service.ItemService"%>
 <%@page import="service.impl.ItemServiceImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generar Solicitud Compra</title>
</head>
<body>


	<%ItemService itemServiceImpl = new ItemServiceImpl(); 
	
	List<Item> items = itemServiceImpl.findAll();%>
	<form action="../../GenerarSolicitudCompraServlet" method="post">
	<h1>Ingrese los datos para generar una solicitud de pedido</h1>
	DNI:<Input type="text" name="dni"><br>
		<table>
			<%for(Item i: items){%>
			<tr>
				<td><input type="checkbox" name="items" value="<%=i.getId()%>"/></td>
				<td><%=i.toString()%></td>
			</tr>
			<%}%>
		</table>
		<input type="submit" value="Enviar"/>
	</form>
<br/><br/>
	<a href="/CasaCentralWeb/index.html">Volver</a>


</body>
</html>


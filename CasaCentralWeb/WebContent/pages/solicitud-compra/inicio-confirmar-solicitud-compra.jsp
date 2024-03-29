<%@page import="service.impl.SolicitudCompraServiceImpl"%>
<%@page import="service.SolicitudCompraService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="modelo.SolicitudCompra"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmacion de Solicitudes de Compra</title>
</head>
<body>
	
	<%SolicitudCompraService solicitudCompraService = new SolicitudCompraServiceImpl(); 
	List<SolicitudCompra> solicitudesCompra = solicitudCompraService.obtenerNoConfirmadas();%>
	<form action="../../ConfirmarServlet" method="post">
		<table>
			<%for(SolicitudCompra sc : solicitudesCompra){%>
			<tr>
				<td><%=sc.getId()%></td>
				<td><input type="checkbox" name="solicitudesCompra" value="<%=sc.getId()%>"/></td>
			</tr>
			<%}%>
		</table>
		<%if(!solicitudesCompra.isEmpty()){ %>
			<input type="submit" value="Confirmar"/>
		<%} else{%>No hay solicitudes pendientes de confirmacion.<%} %>
	</form>
	<br/><br/>
	<a href="/CasaCentralWeb/index.html">Volver</a>
</body>
</html>
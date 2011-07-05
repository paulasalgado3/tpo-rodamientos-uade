<%@page import="modelo.Item"%>
<%@page import="java.util.Set"%>
<%@page import="modelo.SolicitudCompra"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado - Generar Solicitud Compra</title>
</head>
<body>
	<%Set<SolicitudCompra> solicitudes = (Set<SolicitudCompra>)request.getAttribute("solicitudes"); %>
	<table>
	<%for(SolicitudCompra i : solicitudes){ %>
		<tr>		
			<td>
			<%="Cliente: " + i.getCli()+ " Cotizacion Asociada: " + i.getId_cotizacion()%>
				<td>
				Items Comprados:<br/>
				<% for(Item ii: i.getItems()){%>
				<%="Rodamiento: " + ii.getRodamiento().getCodigo()+ " Cantidad:"+ ii.getCantidad()%>
				<%}%>
	
				</td>		
			</td>
		</tr>
	<%}%>
	</table>
<br/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="modelo.Item"%>
 <%@page import="service.impl.ItemServiceImpl"%>
 <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%ItemServiceImpl itemServiceImpl = new ItemServiceImpl(); 
	
	List<Item> items = itemServiceImpl.findAll();%>
	<form action="./ConfirmarServlet" method="post">
		<table>
			<%for(Item i: items){%>
			<tr>
				<td><%=i.toString()%></td>
				<td><input type="checkbox" name="items" value="<%=i.toString()%>"/></td>
			</tr>
			<%}%>
		</table>
		<input type="submit" value="Enviar"/>
	</form>



</body>
</html>


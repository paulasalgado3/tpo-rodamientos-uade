<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Por favor, indique el archivo XML fuente para cargar las listas de precios:</h3>
<form action="../../LevantarXMLServlet" METHOD=POST ENCTYPE="multipart/form-data">
	<input type="file" name ="files">
	<br/>
	<p align="center"><input type="submit" name ="subm"> </p>

</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
 <jsp:useBean id="catalogo" scope="request" class="model.Catalogo"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>amministrazione</title>
</head>
<body>
ciao admin

<jsp:getProperty property="visualizzaamministratore" name="catalogo"/>

<a href="inserisciLibro.jsp">inserisci un libro</a>

</body>
</html>
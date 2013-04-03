<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<jsp:useBean id="op" class="model.Catalogo" scope="request" />
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>visualizza i libri</title>
</head>
<body>
<p>Catalogo dei libri</p>
<jsp:getProperty name="op" property="visualizzalibri"/>

</body>
</html>
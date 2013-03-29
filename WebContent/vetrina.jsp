<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <jsp:useBean id="carrello" scope="session" class="model.Carrello"/>
 <jsp:useBean id="operazioni" scope="request" class="model.Catalogo"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vetrina</title>
</head>
<body>
<form action="/Libreria2/Controller" name="compra" method="post">

<jsp:getProperty property="selezionalibro" name="operazioni"/>

<input type="hidden" name="operazione" value="aggiungialcarrello">

<input type="submit" name="submit" value="aggiungi al carrello">
</form>

<center>
<p><jsp:include page="carrello.jsp" flush="true"></jsp:include></p>
</center>

<a href="Controller?operazione=logout">logout</a>
</body>
</html>
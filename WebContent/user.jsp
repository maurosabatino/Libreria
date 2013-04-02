<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>utente</title>
</head>
<body>


<div class="sidebar1">
<p><jsp:include page="login.jsp" flush="true"></jsp:include></p>
</div>
operazioni disponibili: 
<a href="Controller?operazione=visualizzaLibri">visulizza libri</a>
<a href="vetrina.jsp">compra un libro</a>
<a href="prenotazione.jsp"> visualizza le tue prenotazioni</a>
</body>
</html>
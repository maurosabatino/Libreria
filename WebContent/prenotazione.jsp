<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html >
<% Utente user = (Utente) session.getAttribute("utente");
   if (user==null){%>
<jsp:forward page="/index.jsp" /> 
<%}%>
 
 <jsp:useBean id="carrello" scope="session" class="model.Carrello"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>prenotazione</title>
<link rel="stylesheet" type="text/css" href="default.css"/>
</head>
<body>

<div class="container">

	<div class="header">
		<div class="title">
			<h1>Libreria</h1>
			Progetto di tecnologie web
		</div>
		<div class="clearer">
			<span></span>
		</div>
	</div>
	<div class="navigation">
		<jsp:include page="cerca.jsp" flush="true"></jsp:include>
		<div class="clearer">
			<span></span>
		</div>

	</div>
	<div class="main"> <!-- inizio main  -->
		<div class="content"> <!-- inizio content -->
			<h1>Ecco le tue prenotazioni</h1>
			<p><jsp:getProperty property="visualizzaprenotazioni" name="carrello"/></p>
	</div>
		<div class="sidenav">
			<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
		</div>
		<div class="clearer">
			<span></span>
		</div>
	
</div>
<div class="footer">
		Progetto di tecnologie web Dario Leo Mauro sabatino
		<div class="clearer">
			<span></span>
		</div>
	</div>
</div>
</body>
</html>
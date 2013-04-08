<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Carrello"%>
<!DOCTYPE html>
 <jsp:useBean id="carrello" scope="session" class="model.Carrello"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>carrello</title>
<link rel="stylesheet" type="text/css" href="default.css">
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
	<div class="main">
		<form action="/Libreria2/Controller" name="compra" method="post">
			<jsp:getProperty property="visualizzacarrello" name="carrello"/>
			<p>il totale è: <jsp:getProperty property="totale" name="carrello"/></p>
			<input type="hidden" name="operazione" value="compra">
			<p><input type="submit" name ="submit" value="compra"></p>
		</form>
		<button onclick="top.location.href = 'user.jsp'">ritorna al catalogo</button>
		<div class="sidenav">
			<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
		</div>
		<div class="clearer">
			<span></span>
		</div>

	</div><!-- fine main -->
</div>

</body>
</html>
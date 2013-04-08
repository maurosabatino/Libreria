<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica</title>
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
			<form action="/Libreria2/Controller" name="insertForm" method="POST">
				<p>id del libro che vuoi modificare:<input type="text" name="id" ></p>
				<p>titolo:<input type="text" name="titolo"></p>
				<p>autore:<input type="text" name="autore"></p>
				<p>prezzo:<input type="text" name="prezzo">
				<input type="hidden" name="operazione" value="modificalibro">
				<p><input type="submit" name ="submit" value="OK"></p>
			</form>
		</div>
		<div class="sidenav">
			<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
		</div>
		<div class="clearer">
			<span></span>
		</div>

	</div><!-- fine main -->


	<div class="footer">
		Progetto di tecnologie web Dario Leo Mauro sabatino
		<div class="clearer">
			<span></span>
		</div>
	</div>

</div>
</body>
</html>
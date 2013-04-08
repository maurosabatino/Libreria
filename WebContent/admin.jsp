<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
 <jsp:useBean id="catalogo" scope="request" class="model.Catalogo"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>amministrazione</title>
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
			<h1>ecco il catalogo</h1>
			<p><jsp:getProperty property="visualizzaamministratore" name="catalogo"/></p>
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
		
	</div>

</div>

</body>
</html>
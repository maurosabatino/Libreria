<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<jsp:useBean id="op" class="model.Catalogo" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>utente</title>
<link rel="stylesheet" type="text/css" href="default.css" media="screen"/>
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
		<div class="content">
		<jsp:getProperty property="selezionalibro" name="op"/>
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
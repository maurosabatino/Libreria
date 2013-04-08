<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html>
 <jsp:useBean id="catalogo" scope="request" class="model.Catalogo"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>visualizza cerca</title>
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
<%Utente utente = (Utente)session.getAttribute("utente");
if(utente!=null){
	String ruolo=utente.getRuolo();	
		if(ruolo.equals("user")){
%>
	<div class="main"> <!-- inizio main  -->
		<div class="content"> <!-- inizio content -->
		<p><jsp:getProperty property="visualizzasearchuser" name="catalogo"/></p>
<%}else if(ruolo.equals("admin")){ %>
		<div class="main"> <!-- inizio main  -->
		<div class="content"> <!-- inizio content -->
		<p><jsp:getProperty property="visualizzasearchadmin" name="catalogo"/></p>
<%}
}else{%>
		<div class="main"> <!-- inizio main  -->
		<div class="content"> <!-- inizio content -->
		<p><jsp:getProperty property="visualizzasearch" name="catalogo"/></p>
<%} %>
		</div>
		<div class="sidenav">
			<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
		</div>
		<div class="clearer">
			<span></span>
		</div>

	<!-- fine main -->
	</div>
</div>
</body>
</html>
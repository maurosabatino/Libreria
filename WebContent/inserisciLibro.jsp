<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html>
<% Utente user = (Utente) session.getAttribute("utente");
   if (user==null){%>
<jsp:forward page="/index.jsp" /> 
<%return;}else if(user.getRuolo().equals("user")){ %>
<jsp:forward page="/index.jsp" /> 

<%return;} %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento</title>
<link rel="stylesheet" type="text/css" href="default.css"/>

<script language="JavaScript">
function verificaInserisci(modulo)
{
	if (modulo.titolo.value == "") {
		alert("Campo -titolo- mancante.\nModulo non spedito.");
		modulo.titolo.focus();
		return false;
	}
	if (modulo.autore.value == "") {
		alert("Campo -autore- mancante.\nModulo non spedito.");
		modulo.autore.focus();
		return false;
	}
	if (modulo.prezzo.value == "") {
		alert("Campo -prezzo- mancante.\nModulo non spedito.");
		modulo.prezzo.focus();
		return false;
	}


return true;
}
</script>

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
		<form action="/Libreria2/Controller" onSubmit="return verificaInserisci(this);"name="dati" method="POST">
			<p>titolo:<input type="text" name="titolo"></p>
			<p>autore:<input type="text" name="autore"></p>
			<p>prezzo:<input type="text" name="prezzo">
			<input type="hidden" name="operazione" value="inserisciLibro">
		<input type="submit" name ="submit" value="OK">
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
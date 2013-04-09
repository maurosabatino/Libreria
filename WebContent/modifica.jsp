<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html>
<% Utente user = (Utente) session.getAttribute("utente");
   if (user==null){%>
<jsp:forward page="/index.jsp" /> 
<%}else if(user.getRuolo().equals("user")){ %>
<jsp:forward page="/index.jsp" /> 
<%} %>
<html>
<head>
<title>Inserimento</title>
<link rel="stylesheet" type="text/css" href="default.css"/>
<script language="JavaScript">
function verificaModifica(modulo)
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
			<form action="/Libreria2/Controller" name="insertForm" onSubmit="return verificaModifica(this);" method="POST">
				<%int id = Integer.parseInt(request.getParameter("id"));
					Catalogo catalogo=new Catalogo();
					Libro libro=catalogo.cercaLibro(id);
				%>
				<p>titolo:<input type="text" name="titolo" value="<%=libro.getTitolo() %>"></p>
				<p>autore:<input type="text" name="autore" value="<%=libro.getAutore() %>"></p>
				<p>prezzo:<input type="text" name="prezzo" value="<%=libro.getPrezzo() %>">
				<input type="hidden" name="id" value=<%=id %>>
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
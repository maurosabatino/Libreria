<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="default.css" media="screen"/>
<title>Barra laterale</title>
</head>

<%Utente utente = (Utente)session.getAttribute("utente");
if(utente!=null){
	String ruolo=utente.getRuolo();	
		if(ruolo.equals("user")){
%>
<h1><jsp:include page="login.jsp" flush="true"></jsp:include></h1>
<h1><a href="user.jsp">Catalogo dei libri</a></h1>
<h1><a href="carrello.jsp">Visualizza carrello</a></h1>
<h1><a href="prenotazione.jsp">Visualizza prenotazioni</a></h1>
<h1><a href="Controller?operazione=logout">Logout</a></h1>

<%}else if(ruolo.equals("admin")){ %>
<p><jsp:include page="login.jsp" flush="true"></jsp:include></p>
<p><a href="admin.jsp">Pannello amministratore</a></p>
<p><a href="inserisciLibro.jsp">inserisci un libro</a></p>
<p><a href="modifica.jsp">modifca un libro</a></p>
<p><a href="prenotazioni.jsp">Visualizza prenotazioni</a></p>
<p><a href="Controller?operazione=logout">Logout</a></p>
<%}
}else{%>
<p><a href="index.jsp">Index</a></p>
<p><jsp:include page="login.jsp" flush="true"></jsp:include></p>

<%} %>

</html>
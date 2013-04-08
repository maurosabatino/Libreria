<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/default.css" media="screen"/>
<title>Barra laterale</title>
</head>

<%Utente utente = (Utente)session.getAttribute("utente");
if(utente!=null){
	String ruolo=utente.getRuolo();	
		if(ruolo.equals("user")){
%>
<ul>
<h1><jsp:include page="login.jsp" flush="true"></jsp:include></h1>
<h1><a href="user.jsp">Catalogo dei libri</a></h1>
<h1><a href="carrello.jsp">Visualizza carrello</a></h1>
<h1><a href="prenotazione.jsp">Visualizza prenotazioni</a></h1>
<h1><a href="Controller?operazione=logout">Logout</a></h1>
</ul>
<%}else if(ruolo.equals("admin")){ %>
<ul>
<h1><jsp:include page="login.jsp" flush="true"></jsp:include></h1>
<h1><a href="admin.jsp">Pannello amministratore</a></h1>
<h1><a href="inserisciLibro.jsp">inserisci un libro</a></h1>
<h1><a href="modifica.jsp">modifca un libro</a></h1>
<h1><a href="prenotazioni.jsp">Visualizza prenotazioni</a></h1>
<h1><a href="Controller?operazione=logout">Logout</a></h1>
</ul>
<%}
}else{%>
<ul><li><a href="index.jsp">Index</a></li>
<jsp:include page="login.jsp" flush="true"></jsp:include>
</ul>
<%} %>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Barra laterale</title>
</head>
<body>
<%Utente utente = (Utente)session.getAttribute("utente");
if(utente!=null){
	String ruolo=utente.getRuolo();	
		if(ruolo.equals("user")){
%>
<p><jsp:include page="login.jsp" flush="true"></jsp:include></p>
<p><jsp:include page="cerca.jsp" flush="true"></jsp:include></p>
<p><a href="user.jsp">Home user</a></p>
<p><a href="carrello.jsp">Visualizza carrello</a></p>
<p><a href="prenotazione.jsp">Visualizza prenotazioni</a></p>
<p><a href="Controller?operazione=logout">Logout</a></p>

<%}else if(ruolo.equals("admin")){ %>
<p><jsp:include page="login.jsp" flush="true"></jsp:include></p>
<p><a href="admin.jsp">Home admin</a></p>
<p><a href="inserisciLibro.jsp">inserisci un libro</a></p>
<p><a href="modifica.jsp">modifca un libro</a></p>
<p><a href="prenotazioni.jsp">Visualizza prenotazioni</a></p>
<p><jsp:include page="cerca.jsp" flush="true"></jsp:include></p>
<p><a href="Controller?operazione=logout">Logout</a></p>
<%}
}else{%>
<p><jsp:include page="login.jsp" flush="true"></jsp:include></p>
<p><jsp:include page="cerca.jsp" flush="true"></jsp:include></p>

<%} %>
</body>
</html>
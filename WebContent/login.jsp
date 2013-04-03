<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<% Utente utente = (Utente)session.getAttribute("utente");
	if (utente==null){
	
	%>

Login:
<form action="/Libreria2/Controller" name="loginForm" method="POST">
<p>nome utente:<input type="text" name="user"></p>
<p>password:<input type="password" name="password"></p>
<input type="hidden" name="operazione" value="login">
<p><input type="submit" name ="submit" value="Login"></p>
</form>
<%}else {
	String user = utente.getUser();
	String ruolo=utente.getRuolo();
%>
Ciao <%=user%> sei <%=ruolo %>
<a href="Controller?operazione=logout">Esci</a>
<% } %>
</body>
</html>
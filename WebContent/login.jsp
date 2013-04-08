<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" type="text/css" href="css/default.css">
<script type="text/javascript">
function verifica(modulo){
	if(nodulo.user.value==""){
		allert("campo user mancante");
		modulo.nome.focus();
		return false;
	}
	if(nodulo.password.value==""){
		allert("campo password mancante");
		modulo.password.focus();
		return false;
	}
	allert("il modulo è corretto")
	return true;
	
}
</script>
</head>

<% Utente utente = (Utente)session.getAttribute("utente");
	if (utente==null){

	%>

<h1>Login:</h1>

<form action="/Libreria2/Controller" onSubmit="return verifica(this);" name="loginForm" method="POST">
<li>nome utente:</li>
<li><input type="text" name="user"></li>
<li>password:</li>
<li><input type="password" name="password"></li>
<input type="hidden" name="operazione" value="login">
<li><input type="submit" name ="submit" value="Login"></li>
</form>

<%}else {
	String user = utente.getUser();
	String ruolo=utente.getRuolo();
%>
<h1>Ciao <%=user%> sei <%=ruolo %></h1>

<% } %>

</html>
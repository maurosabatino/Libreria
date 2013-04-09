<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<html>
<head>
<script language="JavaScript">
function verificaLogin(modulo)
{
// Controlla la presenza dei campi nome 
if (modulo.user.value == "") {
alert("Campo -user- mancante.\nModulo non spedito.");
modulo.nome.focus();
return false;
}
if (modulo.password.value == "") {
alert("Campo -password- mancante.\nModulo non spedito.");
modulo.password.focus();
return false;
}


return true;
}
</script>
</head>
<% Utente utente = (Utente)session.getAttribute("utente");
	if (utente==null){

	%>
<body>
<form action="/Libreria2/Controller"  name="dati" onSubmit="return verificaLogin(this);" method="POST" >

Nome:
<br> 
<input type="text" name="user" size="30">

password:<br>
 <input type="password" name="password" size="30">

<input type="hidden" name="operazione" value="login">
<br>
<input type="submit" value="Login">
</form>
<%}else {
	String user = utente.getUser();
	String ruolo=utente.getRuolo();
%>
<h1>Ciao <%=user%> sei <%=ruolo %></h1>

<% } %>
</body>
</html>
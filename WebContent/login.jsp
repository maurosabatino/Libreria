<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<% String user = (String)session.getAttribute("username");
   if (user==null){%>

Login:
<form action="/Libreria2/Controller" name="loginForm" method="POST">
<p>nome utente:<input type="text" name="user"></p>
<p>password:<input type="password" name="password"></p>
<input type="hidden" name="operazione" value="login">
<p><input type="submit" name ="submit" value="OK"></p>
</form>
<%}else {%>
Ciao <%=user%>
<a href="Gestore?action=logout"><br><br>Esci</a>
<%} %>
</body>
</html>
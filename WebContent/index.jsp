<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
<p>vuoi fare il login? </p>
Login:
<form action="/Libreria2/Controller" name="loginForm" method="POST">
<p>nome utente:<input type="text" name="user"></p>
<p>password:<input type="password" name="password"></p>
<input type="hidden" name="operazione" value="login">
<p><input type="submit" name ="submit" value="OK"></p>
</form>
<a href="Controller?operazione=visualizzaLibri">visulizza libri</a>
</body>
</html>
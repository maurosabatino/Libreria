<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/Libreria2/Controller" name="loginForm" method="POST">
<p>titolo:<input type="text" name="titolo"></p>
<p>autore:<input type="text" name="autore"></p>
<p>prezzo:<input type="text" name="prezzo">
<input type="hidden" name="operazione" value="inserisciLibro">
<p><input type="submit" name ="submit" value="OK"></p>
</form>
<a href="Controller?operazione=visualizzaLibri">visulizza libri</a>
</body>
</html>
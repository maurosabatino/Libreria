<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cerca</title>
<link rel="stylesheet" type="text/css" href="stile.css">
</head>
<body>
<form action="/Libreria2/Controller" name="searchForm" method="POST">
<p>Cerca:</p>
<p>titolo:<input type="text" name="titolo"></p>
<p>autore:<input type="text" name="autore"></p>
<input type="hidden" name="operazione" value="search">
<p><input type="submit" name ="submit" value="cerca"></p>
</form>

</body>
</html>
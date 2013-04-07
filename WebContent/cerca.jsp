<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cerca</title>
<link rel="stylesheet" type="text/css" href="default.css">
</head>

<form action="/Libreria2/Controller" name="searchForm" method="POST">
<a>titolo:<input type="text" name="titolo"></a>
<a></a>autore:<input type="text" name="autore">
<input type="hidden" name="operazione" value="search">
<a><input type="submit" name ="submit" value="cerca"><a>
</form>

</html>
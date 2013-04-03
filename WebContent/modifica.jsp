<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica</title>
<link rel="stylesheet" type="text/css" href="stile.css">
</head>
<body>
<div id="artcle">
<form action="/Libreria2/Controller" name="insertForm" method="POST">

<p>id del libro che vuoi modificare:<input type="text" name="id" ></p>

<p>titolo:<input type="text" name="titolo"></p>
<p>autore:<input type="text" name="autore"></p>
<p>prezzo:<input type="text" name="prezzo">

<input type="hidden" name="operazione" value="modificalibro">
<p><input type="submit" name ="submit" value="OK"></p>
</form>
</div>
<div id="aside">
<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
</div>
</body>
</html>
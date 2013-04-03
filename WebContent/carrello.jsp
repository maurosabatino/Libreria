<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Carrello"%>
<!DOCTYPE html>
 <jsp:useBean id="carrello" scope="session" class="model.Carrello"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>carrello</title>
<link rel="stylesheet" type="text/css" href="stile.css">
</head>
<body>
<div id="article">
<form action="/Libreria2/Controller" name="compra" method="post">

<jsp:getProperty property="visualizzacarrello" name="carrello"/>
<p>il totale è: <jsp:getProperty property="totale" name="carrello"/></p>
<input type="hidden" name="operazione" value="compra">
<p><input type="submit" name ="submit" value="compra"></p>
</form>
</div>
<div id="aside">
<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
</div>
</body>
</html>
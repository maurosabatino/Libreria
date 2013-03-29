<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Carrello"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <jsp:useBean id="carrello" scope="session" class="model.Carrello"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>carrello</title>
</head>
<body>

<form action="/Libreria2/Controller" name="compra" method="post">
<jsp:getProperty property="visualizzacarrello" name="carrello"/>
<p>il totale è: <jsp:getProperty property="totale" name="carrello"/></p>
<input type="hidden" name="operazione" value="compra">
<p><input type="submit" name ="submit" value="compra"></p>
</form>
</body>
</html>
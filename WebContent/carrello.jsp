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
siamo nel carrello
<jsp:getProperty property="visualizzacarrello" name="carrello"/>
<p>il totale �: <jsp:getProperty property="totale" name="carrello"/></p>
</body>
</html>
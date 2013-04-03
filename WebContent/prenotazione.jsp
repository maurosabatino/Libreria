<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >

 <jsp:useBean id="carrello" scope="session" class="model.Carrello"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>prenotazione</title>
<link rel="stylesheet" type="text/css" href="stile.css">
</head>
<body>
<div id="article">
<jsp:getProperty property="visualizzaprenotazioni" name="carrello"/>
</div>
<div id="aside">
<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<jsp:useBean id="op" class="model.Catalogo" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>utente</title>
<link rel="stylesheet" type="text/css" href="stile.css">
</head>
<body>

<div id="header">
<h1>
Libreria
</h1>
<h2>
Catalogo dei libri
</h2>
</div>
<div id="article">
<jsp:getProperty property="selezionalibro" name="op"/>
</div>
<div id="aside">
<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
</div>
</body>
</html>
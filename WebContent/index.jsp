<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="stile.css">
</head>
<body>

<div id="header">
Libreria
<h2>
Progetto di tecnologie web
</h2>
</div>

<div id="aside">
<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
</div>
<div id="article">
<p><jsp:include page="visualizza.jsp" flush="true"></jsp:include></p>
</div>


<div id="footer">
Progetto di tecnologie web Dario Leo Mauro sabatino
</div>

</body>
</html>
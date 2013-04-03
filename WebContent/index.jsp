<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="stile.css">
</head>
<body>

<div id="header">
<h2>
Libreria
</h2>
</div>

<div id="aside">
<p><jsp:include page="login.jsp" flush="true"></jsp:include></p>
<p><jsp:include page="cerca.jsp" flush="true"></jsp:include></p>
</div>
<div id="article">
<p><jsp:include page="visualizza.jsp" flush="true"></jsp:include></p>
</div>


<div id="footer">
Progetto di tecnologie web Dario Leo Mauro sabatino
</div>

</body>
</html>
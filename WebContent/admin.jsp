<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
 <jsp:useBean id="catalogo" scope="request" class="model.Catalogo"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>amministrazione</title>
<link rel="stylesheet" type="text/css" href="stile.css">
</head>
<body>


<div id="aside">
<p><jsp:include page="barraLaterale.jsp" flush="true"></jsp:include></p>
</div>
 <div id="header"> 
 <h2>Catalogo dei libri</h2> 
<jsp:getProperty property="visualizzaamministratore" name="catalogo"/>
</div> 


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <jsp:useBean id="catalogo" scope="request" class="model.Catalogo"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>visualizza cerca</title>
<link rel="stylesheet" type="text/css" href="stile.css">
</head>
<body>
<jsp:getProperty property="visualizzasearch" name="catalogo"/>
<div id="aside">
<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
</div>
</body>
</html>
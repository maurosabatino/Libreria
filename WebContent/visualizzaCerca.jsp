<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html>
 <jsp:useBean id="catalogo" scope="request" class="model.Catalogo"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>visualizza cerca</title>
<link rel="stylesheet" type="text/css" href="stile.css">
</head>
<body>
<%Utente utente = (Utente)session.getAttribute("utente");
if(utente!=null){
	String ruolo=utente.getRuolo();	
		if(ruolo.equals("user")){
%>
<jsp:getProperty property="visualizzasearchuser" name="catalogo"/>
<%}else if(ruolo.equals("admin")){ %>
<jsp:getProperty property="visualizzasearchadmin" name="catalogo"/>
<%}
}else{%>
<jsp:getProperty property="visualizzasearch" name="catalogo"/>
<%} %>
<div id="aside">
<jsp:include page="barraLaterale.jsp" flush="true"></jsp:include>
</div>
</body>
</html>
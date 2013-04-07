<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<jsp:useBean id="op" class="model.Catalogo" scope="request" />
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>visualizza i libri</title>
<link rel="stylesheet" type="text/css" href="default.css" media="screen"/>
</head>


<jsp:getProperty name="op" property="visualizzalibri"/>


</html>
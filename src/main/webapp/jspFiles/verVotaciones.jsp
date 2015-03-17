<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ver votaciones</title>
</head>
<body>
	<h2>
		<b>Información temas</b>
	</h2>
	<!--<c:set var="vView" scope="request" value="${verVotaciones}" /> -->
	<p>
		<c:forEach var="lista" items="${verVotaciones.numVotosTema}">
				Titulo : <c:out value="${lista.key}" /><br/>
				Votos : <c:out value="${lista.value}" /><br/><br/>
		</c:forEach>
	</p>
	<p>
		<c:forEach var="medias" items="${verVotaciones.mediasVotos}">
				Tipo Nivel Estudios : <c:out value="${medias.key}" /><br/>
				Media votos : <c:out value="${medias.value}" /><br/><br/>
		</c:forEach>
	</p>
	
	<p>
		<a href="home">Volver</a>
	</p>

</body>
</html>
<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Votar</title>
</head>
<body>
	<h2>
		<b> Votar Tema</b>
	</h2>
		<c:set var="tView" scope="request" value="${tema}" />
	
	<form action="votar" method="post">
	<ul>TEMAS:
			<c:forEach var="tema" items="${tView.temas}">
				<li>${tema}</li>
			</c:forEach>
		</ul>
	
		<p>
			Titulo:
		</p>
		<p>
			Descripción:
		</p>
		<p>
			Pregunta:
		</p>
		<p>
			<input type="submit" value="Enviar votación" />
		</p>
	</form>
	<p>
		<a href="home">Volver</a>
	</p>

</body>
</html>
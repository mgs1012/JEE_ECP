<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selecciona tema a votar</title>
</head>
<body>
	<h2>
		<b> Selecciona Tema a votar</b>
	</h2>
	<c:set var="tView" scope="request" value="${seleccionarTema}" />
	<div>${tView.update()}</div>

	<form name="formulario" action="/Votaciones/jsp/seleccionarTema" method="post">
		<p>
			Listado de temas:<select name="nombreDelTema">
				<c:forEach var="temas" items="${tView.listaTemas}">
					<option value="${temas.titulo}">${temas.titulo}</option>
				</c:forEach>
			</select>
		</p>
		<p>
		<input type="submit" value="Seleccionar" />
		</p>
	</form>
	<p>
		<a href="home">Volver</a>
	</p>

</body>
</html>